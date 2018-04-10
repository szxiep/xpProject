package com.cxc.common.exception;


public class ApplicationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApplicationException(String msg) {
		super(msg);
	}

	public ApplicationException(Throwable e) {
		super(e);
	}

	public ApplicationException(String msg, Throwable e) {
		super(msg, e);
	}
}
