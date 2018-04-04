package com.aprs.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aprs.entity.Product;
import com.aprs.service.ProductService;
import com.aprs.service.SaleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class saleTest {
	@Resource
	private SaleService saleService;
	
	@Resource
	private ProductService productService;
	
	@Test
	public void test(){
		//saleService.settle();
	}
}
