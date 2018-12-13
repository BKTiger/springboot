package com.zhangtai.demo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.gridfs.GridFS;
import com.zhangtai.demo.Service.MongodbService;
import com.zhangtai.demo.model.Student;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

	@Autowired
	private MongodbService mongodbService;
	@Autowired
	private GridFsTemplate gridFsTemplate;
	@Autowired
	private GridFSBucket gridFSBucket;
	@RequestMapping("/findAll")
	@ResponseBody
	public List<Student> findAll(){
		List<Student> all = mongodbService.findAll();
		return all;
	}

	@RequestMapping("/upload")
	public String upload(@RequestParam Map<String,Object> param){
		System.out.println("111");
		return "/file";
	}

	@RequestMapping(value = "/upload.json", method = RequestMethod.POST)
	@ResponseBody
	public String uploadStart(@RequestParam("file") MultipartFile[] multipartFiles){
		if(multipartFiles.length>0){
			for (MultipartFile multipartFile:multipartFiles ) {
				String fileName = multipartFile.getOriginalFilename();
				long size = multipartFile.getSize();
				try {
					InputStream InputStream = multipartFile.getInputStream();
					ObjectId objectId = gridFsTemplate.store(InputStream, fileName);
					System.out.println(objectId.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return "/file";
	}

	@RequestMapping(value = "/download.json", method = RequestMethod.GET)
	public String downloadStart(@RequestParam Map<String,Object> param, HttpServletResponse response) throws Exception{
		param.put("fileId","5c127552ac1add365c06f572");
		String fileId = param.get("fileId").toString();
		//根据id查询文件
		GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId)));
		//打开下载流对象
		GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
		//创建gridResources,用户获取流对象
		GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);

		String filename = gridFsResource.getFilename();
		InputStream inputStream = gridFsResource.getInputStream();
		response.setContentType("application/force-download");
		response.setHeader("Content-Disposition", "attachment;fileName=" + filename);
		OutputStream outputStream = response.getOutputStream();
		IOUtils.copy(inputStream,outputStream);
		inputStream.close();
		outputStream.close();
		return null;
	}

}
