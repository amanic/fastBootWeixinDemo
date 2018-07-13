package com.amateur.wanbei.service.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class PageUtil {
	
    @ApiModelProperty("页数默认1")
    private int page = 1;
    @ApiModelProperty("页数大小默认10")
    private int	size = 10;
    @ApiModelProperty("排序字段名")
    private String	sort;
    @ApiModelProperty("排序方式（asc，desc）")
    private String	order;
    
    private int pageDB;
    
    public int getPageDB() {
		return pageDB;
	}
	public void setPageDB(int pageDB) {
		if(page!=1) {
			this.pageDB = (page-1)*size;
		}
		this.pageDB = pageDB;
	}
    
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
    
    
}
