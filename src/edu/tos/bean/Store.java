package edu.tos.bean;

import java.util.Date;

public class Store {

	public Store() {

	}

	private Long storeId;
	private String storeName;
	private String storeLogName;
	private String storePass;
	private Long storeCatId;
	private String storeBoss;
	private String address;
	private Long phone;
	private String storePic;
	private Long status;
	private Date createOn;
	private String storeCatName;
	private String announce;

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreLogName() {
		return storeLogName;
	}

	public void setStoreLogName(String storeLogName) {
		this.storeLogName = storeLogName;
	}

	public String getStorePass() {
		return storePass;
	}

	public void setStorePass(String storePass) {
		this.storePass = storePass;
	}

	public Long getStoreCatId() {
		return storeCatId;
	}

	public void setStoreCatId(Long storeCatId) {
		this.storeCatId = storeCatId;
	}

	public String getStoreBoss() {
		return storeBoss;
	}

	public void setStoreBoss(String storeBoss) {
		this.storeBoss = storeBoss;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getStorePic() {
		return storePic;
	}

	public void setStorePic(String storePic) {
		this.storePic = storePic;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public String getStoreCatName() {
		return storeCatName;
	}

	public void setStoreCatName(String storeCatName) {
		this.storeCatName = storeCatName;
	}

	public String getAnnounce() {
		return announce;
	}

	public void setAnnounce(String announce) {
		this.announce = announce;
	}

}
