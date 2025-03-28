package com.example.spring.myapp;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication
public class TestSpringBootApplication {
	
	public static void main(String[] args) {
		System.out.println("java version==>" + System.getProperty("java.version"));
		SpringApplication.run(TestSpringBootApplication.class, args);
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(dataSource);
		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml");
		factory.setMapperLocations(res);
		return factory.getObject();
//		factory.setConfiguration(getDefaultConfig());
//      //바로 요 구간입니다~ 
//      TransactionFactory trn= new JdbcTransactionFactory();
//      trn.newTransaction(dt, null, false);  //트랜젝션 설정에서 기본 auto commit 값을 false로 해 줍니다.
//      factory.setTransactionFactory(trn);
//      return factory.getObject();
		
	}

}
