package com.atguigu.crm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.crm.entitys.SalesChance;
import com.atguigu.crm.mappers.SalesChanceMapper;
import com.atguigu.crm.orm.Page;

@Service
public class SalesChanceService {
	@Autowired
	private SalesChanceMapper mapper ;
	@Transactional(readOnly=true)
	public Page<SalesChance> getPage(int pageNo){
		Page<SalesChance> page = new Page<>();
		page.setPageNo(pageNo);
		//1.查询totalElements
		int totalElements = (int) mapper.getTotalElements();
		page.setTotalElements(totalElements);
		//2.查询content
		int firstIndex = (page.getPageNo() - 1) * page.getPageSize() + 1;
		int endIndex = firstIndex + page.getPageSize();
		
		List<SalesChance> list = mapper.getContent(firstIndex, endIndex);
		page.setContent(list);
		
		return page;
		
	}
	@Transactional
	public void delete(Integer id){
		mapper.delete(id);
	}
	@Transactional
	public void save(SalesChance salesChance){
		mapper.insert(salesChance);
		
	}
	@Transactional
	public void update(SalesChance chance) {
		mapper.update(chance);
	}
	@Transactional(readOnly=true)
	public SalesChance get(Integer id){
		return mapper.get(id);
	}
	
	
}
