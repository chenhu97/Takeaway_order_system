package edu.tos.bean;

import java.io.Serializable;

public class StoreCat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3670341682855260297L;
	private Long storeCatId;
	private String storeCatName;

	public Long getStoreCatId() {
		return storeCatId;
	}

	public void setStoreCatId(Long storeCatId) {
		this.storeCatId = storeCatId;
	}

	public String getStoreCatName() {
		return storeCatName;
	}

	public void setStoreCatName(String storeCatName) {
		this.storeCatName = storeCatName;
	}

}
