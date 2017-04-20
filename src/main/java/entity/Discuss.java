package com.zufan.entity;

import java.util.Date;

public class Discuss {

	private Long id;
	private String title;
	private String author;
	private Long authorLink;
	private int resp;
	private Date updateTime;
	private String link;
	private Long flag;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	

	public Long getAuthorLink() {
		return authorLink;
	}
	public void setAuthorLink(Long authorLink) {
		this.authorLink = authorLink;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getResp() {
		return resp;
	}
	public void setResp(int resp) {
		this.resp = resp;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Long getFlag() {
		return flag;
	}
	public void setFlag(Long flag) {
		this.flag = flag;
	}
	
	
}
