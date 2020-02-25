package com.laptrinhjavaweb.paging;

import com.laptrinhjavaweb.sort.Sorter;

public class PageRequest implements Pageble{

	
	
	private Integer page;
	private Integer maxPage;
	private Sorter sorter;
	
	public PageRequest(Integer page,Integer maxPage,Sorter sorter ) {
		this.page=page;
		this.maxPage=maxPage;
		this.sorter=sorter;
	}
	
	@Override
	public Integer getPage() {
		
		return this.page;
	}

	@Override
	public Integer getOffset() {
		if(this.page!=null&&this.maxPage!=null) {
			
			return ((this.page-1)*this.maxPage);
		}
		return null;
	}

	@Override
	public Integer getLimit() {
		
		return this.maxPage;
	}



	@Override
	public Sorter getSorter() {
		if(sorter!=null) {
			return this.sorter;
		}
		return null;
	}

}
