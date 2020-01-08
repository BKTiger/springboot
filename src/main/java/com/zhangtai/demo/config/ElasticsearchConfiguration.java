///**
// * @Project Name:blog-search-service
// * @Package Name:cn.hoofungson.blog.search.service.provider.config.es
// * @Since JDK 1.8
// */
//package com.zhangtai.demo.config;
//
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.util.StringUtils;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//
///**
// * @Description: Elasticsearch配置
// * @Author 胡松 hoofungson@163.com
// * @Date 2019-07-16 11:40
// * @Version V1.0
// */
//@Configuration
//public class ElasticsearchConfiguration {
//
//    @Value("${data.elasticsearch.host}")
//    private String esIp;
//    @Value("${data.elasticsearch.port}")
//    private int port;
//    @Value("${data.elasticsearch.cluster-name}")
//    private String clusterName;
//
//    /**
//     * 配置客户端
//     *
//     * @return
//     * @throws UnknownHostException
//     **/
//    @Bean
//    public TransportClient client() throws UnknownHostException {
//        System.setProperty("es.set.netty.runtime.available.processors","false");
//        Settings settings = Settings.builder()
//                .put("cluster.name", clusterName)
//                .put("client.transport.sniff", false).build();
//        TransportClient transportClient = new PreBuiltTransportClient(settings);
//        if (StringUtils.isEmpty(esIp)) {
//            throw new RuntimeException("从节点未配置！");
//        }
//        InetAddress inetAddress = InetAddress.getByName(esIp);
//        transportClient.addTransportAddress(new TransportAddress(inetAddress, port));
//        return transportClient;
//    }
//
//    /**
//     * 配置Elasticsearch模板
//     *
//     * @return
//     * @throws Exception
//     **/
//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
//        return new ElasticsearchTemplate(client());
//    }
//}
