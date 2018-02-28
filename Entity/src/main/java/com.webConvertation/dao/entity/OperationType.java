package com.webConvertation.dao.entity;


public enum OperationType {
	CONVERT("ImageConvertation"),
	TOGRAYSCALE("ImageToGrayScale");

	private String description;

	private OperationType(String description) {
		this.description = description;
		}

	public String getDescription() {
		return description;
	}

}
