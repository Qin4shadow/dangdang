package com.baizhi.ql.entity;

import java.util.Date;

public class Book {

	private String id;           //not null,
	private String bookName;     //--图书名
	private String author;       //--作者
	private Double price;        //--价格
	private Double ddPrice;      //--当当价
	private String company;      //--出版社
	private Date publishTime;    //--出版时间
	private String publicCount;  //--出版字数
	private String isbn;         //--isbn编码
	private Date printTime;      //--打印时间
	private String printCount;   //--打印字数
	private Integer saleCount;   //--销售量
	private String cateId;       // --所属类别
	private Integer eRecommend;  //--编辑推荐度
	private String src;          //--封面图片路径
	private Integer stock;       //--库存
	private String edition;      //--版次
	private String impression;   //--印次
	private String format;       //--开本
	private String paper;        //--纸张
	private String packaging;    //--包装
	private String pagination;   //--页数
	private String recom;        //--编辑推荐
	private String brief;        //--内容简介
	private String aboutAuthor;  //--作者简介
	private String directory;    //--基本目录
	private String media;        //--媒体评论 
	
	private Category category;   //关系属性
	
	public Book() {
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDdPrice() {
		return ddPrice;
	}

	public void setDdPrice(Double ddPrice) {
		this.ddPrice = ddPrice;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getPublicCount() {
		return publicCount;
	}

	public void setPublicCount(String publicCount) {
		this.publicCount = publicCount;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Date getPrintTime() {
		return printTime;
	}

	public void setPrintTime(Date printTime) {
		this.printTime = printTime;
	}

	public String getPrintCount() {
		return printCount;
	}

	public void setPrintCount(String printCount) {
		this.printCount = printCount;
	}

	public Integer getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
	}

	public String getCateId() {
		return cateId;
	}

	public void setCateId(String cateId) {
		this.cateId = cateId;
	}

	public Integer geteRecommend() {
		return eRecommend;
	}

	public void seteRecommend(Integer eRecommend) {
		this.eRecommend = eRecommend;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getImpression() {
		return impression;
	}

	public void setImpression(String impression) {
		this.impression = impression;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getPaper() {
		return paper;
	}

	public void setPaper(String paper) {
		this.paper = paper;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public String getPagination() {
		return pagination;
	}

	public void setPagination(String pagination) {
		this.pagination = pagination;
	}

	public String getRecom() {
		return recom;
	}

	public void setRecom(String recom) {
		this.recom = recom;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getAboutAuthor() {
		return aboutAuthor;
	}

	public void setAboutAuthor(String aboutAuthor) {
		this.aboutAuthor = aboutAuthor;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", author="
				+ author + ", price=" + price + ", ddPrice=" + ddPrice
				+ ", company=" + company + ", publishTime=" + publishTime
				+ ", publicCount=" + publicCount + ", isbn=" + isbn
				+ ", printTime=" + printTime + ", printCount=" + printCount
				+ ", saleCount=" + saleCount + ", cateId=" + cateId
				+ ", eRecommend=" + eRecommend + ", src=" + src + ", stock="
				+ stock + ", edition=" + edition + ", impression=" + impression
				+ ", format=" + format + ", paper=" + paper + ", packaging="
				+ packaging + ", pagination=" + pagination + ", recom=" + recom
				+ ", brief=" + brief + ", aboutAuthor=" + aboutAuthor
				+ ", directory=" + directory + ", media=" + media
				+ ", category=" + category + "]";
	}

	public Book(String id, String bookName, String author, Double price,
			Double ddPrice, String company, Date publishTime,
			String publicCount, String isbn, Date printTime, String printCount,
			Integer saleCount, String cateId, Integer eRecommend, String src,
			Integer stock, String edition, String impression, String format,
			String paper, String packaging, String pagination, String recom,
			String brief, String aboutAuthor, String directory, String media,
			Category category) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.ddPrice = ddPrice;
		this.company = company;
		this.publishTime = publishTime;
		this.publicCount = publicCount;
		this.isbn = isbn;
		this.printTime = printTime;
		this.printCount = printCount;
		this.saleCount = saleCount;
		this.cateId = cateId;
		this.eRecommend = eRecommend;
		this.src = src;
		this.stock = stock;
		this.edition = edition;
		this.impression = impression;
		this.format = format;
		this.paper = paper;
		this.packaging = packaging;
		this.pagination = pagination;
		this.recom = recom;
		this.brief = brief;
		this.aboutAuthor = aboutAuthor;
		this.directory = directory;
		this.media = media;
		this.category = category;
	}
	

}
