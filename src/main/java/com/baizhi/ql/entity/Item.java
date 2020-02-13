package com.baizhi.ql.entity;

public class Item {

	private String id;
	private String bookName;   //图书名
	private String bookSrc;    //图片路径
	private Double price;      //价格
	private Integer count;     //数量
	private Double amount;     //小计
	private String bookId;     //图书id
	private String orderId;    //订单id
	public Item() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookSrc() {
		return bookSrc;
	}
	public void setBookSrc(String bookSrc) {
		this.bookSrc = bookSrc;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", bookName=" + bookName + ", bookSrc="
				+ bookSrc + ", price=" + price + ", count=" + count
				+ ", amount=" + amount + ", bookId=" + bookId + ", orderId="
				+ orderId + "]";
	}
	public Item(String id, String bookName, String bookSrc, Double price,
			Integer count, Double amount, String bookId, String orderId) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.bookSrc = bookSrc;
		this.price = price;
		this.count = count;
		this.amount = amount;
		this.bookId = bookId;
		this.orderId = orderId;
	}
	
}
