package com.baizhi.ql.entity;

import java.util.List;

public class Category {
	private String id;
	private String cateName;
	private Integer count;
	private String parentId;
	private Integer levels;
	
	private Category category;
	
	private List<Category> secList;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	
	

	@Override
	public String toString() {
		return "Category [id=" + id + ", cateName=" + cateName + ", count="
				+ count + ", parentId=" + parentId + ", levels=" + levels
				+ ", category=" + category + ", secList=" + secList + "]";
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getCateName() {
		return cateName;
	}




	public void setCateName(String cateName) {
		this.cateName = cateName;
	}




	public Integer getCount() {
		return count;
	}




	public void setCount(Integer count) {
		this.count = count;
	}




	public String getParentId() {
		return parentId;
	}




	public void setParentId(String parentId) {
		this.parentId = parentId;
	}




	public Integer getLevels() {
		return levels;
	}




	public void setLevels(Integer levels) {
		this.levels = levels;
	}




	public Category getCategory() {
		return category;
	}




	public void setCategory(Category category) {
		this.category = category;
	}




	public List<Category> getSecList() {
		return secList;
	}




	public void setSecList(List<Category> secList) {
		this.secList = secList;
	}




	public Category(String id, String cateName, Integer count, String parentId,
			Integer levels) {
		super();
		this.id = id;
		this.cateName = cateName;
		this.count = count;
		this.parentId = parentId;
		this.levels = levels;
	}

	
	
	
}
