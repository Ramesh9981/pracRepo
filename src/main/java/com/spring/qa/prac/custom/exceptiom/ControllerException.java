package com.spring.qa.prac.custom.exceptiom;

public class ControllerException {

	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMsg;

	public ControllerException(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

}
