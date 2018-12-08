package com.zhangtai.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoBootApplicationTests {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void contextLoads() {
		ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://crbcimis.ieforever.com/crbchqimis/portalsAnalysis/getTotalData?portalsNonce=1111&systemcode=PM&privatekey=21b7eb3001&securitykey=24facf4f3524325ac1c1d1bac15e4b56", Map.class);
		Map body = forEntity.getBody();
	}

}
