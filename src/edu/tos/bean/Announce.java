package edu.tos.bean;

import java.util.Date;

public class Announce {
	private Long announceId;
	private Long adminId;
	private String content;
	private String picPath;
	private Date createOn;
	private Date updateOn;
	private String title;

	public Announce() {
		super();
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public Long getAnnounceId() {
		return announceId;
	}

	public void setAnnounceId(Long announceId) {
		this.announceId = announceId;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public Date getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
}
