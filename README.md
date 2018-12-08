# springboot
各种框架的整合案例
基础框架--使用okhttp
1. 导入jar包
```
<dependency>
			<groupId>com.squareup.okhttp3</groupId>
			<artifactId>okhttp</artifactId>
			<version>3.2.0</version>
		</dependency>
```
2. 在springboot的启动类中配置该bean
```
@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
	}
```
3. 在测试类中使用
```
@Test
	public void contextLoads() {
		ResponseEntity<Map> forEntity = restTemplate.getForEntity(url, Map.class);
		Map body = forEntity.getBody();
	}

```
