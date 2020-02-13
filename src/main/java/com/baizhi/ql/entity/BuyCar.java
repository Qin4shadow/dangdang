package com.baizhi.ql.entity;

public class BuyCar {
	private Book book;
	private Integer number; //图书数量
	private String status; //状态 1是存在，0是删除
	private Double subTotal;//小计
	public BuyCar() {
		// TODO Auto-generated constructor stub
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	@Override
	public String toString() {
		return "BuyCar [book=" + book + ", number=" + number + ", status="
				+ status + ", subTotal=" + subTotal + "]";
	}
	public BuyCar(Book book, Integer number, String status, Double subTotal) {
		super();
		this.book = book;
		this.number = number;
		this.status = status;
		this.subTotal = subTotal;
	}
	
	
}
