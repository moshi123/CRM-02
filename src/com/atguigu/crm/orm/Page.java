package com.atguigu.crm.orm;

import java.util.List;

public class Page<T> {
	private int pageNo;
	private int pageSize=2;
	private int totalElements;
	private List<T> content;
	
	public int getPageNo() {
		if(this.pageNo > this.getTotalPages()){
			this.pageNo=this.getTotalPages();
		}	
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		if(pageNo < 1){
				this.pageNo = 1;
						return;
		}	
		this.pageNo=pageNo;
	}
	
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	public int getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}
	public List<T> getContent() {
		return content;
	}
	public void setContent(List<T> content) {
		this.content = content;
	}
	public int getTotalPages() {
		int totalPages = this.totalElements / this.pageSize;
		if( this.totalElements %this.pageSize != 0){
			totalPages++;
		}
		return totalPages;
	}
	//判断是否存在下一页
	public  boolean isHasNext(){
		return this.getPageNo()<this.getTotalPages();
	}
	
	//到下一页
	public int getNextPage(){
		if(isHasNext()){
			return this.getPageNo()+1;
		}
		return this.getPageNo();
	}
	
	//判断是否存在上一页
	public boolean isHasPrev(){
		
		return this.getPageNo() >1;
	}
	
	//到上一页
	public int getPrevPage(){
		if(isHasPrev()){
			return this.getPageNo()-1;
		}
		return 1;
	}
	
	
	
	
	
}
