package com.atguigu.crm;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.crm.entitys.SalesChance;
import com.atguigu.crm.orm.Page;
import com.atguigu.crm.services.SalesChanceService;

public class ApplicationContextTest {
		private ApplicationContext ac =null;
		private SalesChanceService salesChanceService;
		{
			  ac= new ClassPathXmlApplicationContext("applicationContext.xml");
			  salesChanceService = ac.getBean(SalesChanceService.class);
		}
		
		
		
		@Test
		public void testGetPages(){
			Page<SalesChance> page = salesChanceService.getPage(4);
			System.out.println(page.getTotalElements());
			System.out.println(page.getTotalPages());
			System.out.println(page.getContent());
			
		}
		
		@Test
	  public void test() throws SQLException{
		  ac= new ClassPathXmlApplicationContext("applicationContext.xml");
		  DataSource bean = ac.getBean(DataSource.class);
		  System.out.println(bean.getConnection());
	  }
	
	
}
