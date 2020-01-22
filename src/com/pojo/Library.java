package com.pojo;

import java.io.Serializable;

public class Library implements Serializable{
	private int lid;
	private String catalogue;
	
	
	
	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Library(int lid, String catalogue) {
		super();
		this.lid = lid;
		this.catalogue = catalogue;
	}



	public int getLid() {
		return lid;
	}



	public void setLid(int lid) {
		this.lid = lid;
	}



	public String getCatalogue() {
		return catalogue;
	}



	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}
	
}
