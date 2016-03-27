package com.atguigu.crm.handlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atguigu.crm.entitys.SalesChance;
import com.atguigu.crm.orm.Page;
import com.atguigu.crm.services.SalesChanceService;
@RequestMapping("/chance")
@Controller
public class SalesChanceHandler {
    @Autowired
	private SalesChanceService salesChanceService;
    
    
    @RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String update(@PathVariable("id") Long id, SalesChance chance, RedirectAttributes attributes){
		//为 id 赋值. 
		chance.setId(id);
		salesChanceService.update(chance);
		attributes.addFlashAttribute("message", "修改机会成功!");
		return "redirect:/chance/list";
	}
    
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String input(@PathVariable("id") Integer id, Map<String, Object> map){
		map.put("chance", salesChanceService.get(id)); 
		return "chance/input";
	}
	
    @RequestMapping(value="/",method=RequestMethod.POST)
    public String save(SalesChance salesChance,RedirectAttributes attributes ){
    	salesChanceService.save(salesChance);
    	System.out.println("list");
    	attributes.addFlashAttribute("message", "新建机会成功");
    	return "redirect:/chance/list";
    }
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id,RedirectAttributes attributes){
    	salesChanceService.delete(id);
    	System.out.println("chanchu");
    	attributes.addFlashAttribute("message", "删除成功");
    	return "redirect:/chance/list";
    }
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String input(Map<String,Object> map){
    	map.put("chance", new SalesChance());
    	System.out.println("list");
    	return "chance/input";
    }
	 
	@RequestMapping("/list")
	public String list(@RequestParam(value="pageNo",required=false)String pageNoStr,Map<String,Object> map){
		int pageNo =1;
		try{
				pageNo=Integer.parseInt(pageNoStr);}
		catch(Exception e){	}
		Page<SalesChance> page = salesChanceService.getPage(pageNo);
		map.put("page",page);
		return "chance/list";
		
	}
	
}
