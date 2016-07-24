package com.admin.system.exception;

import org.apache.shiro.authc.CredentialsException;

public class CodeErrorException extends CredentialsException{
	private static final long serialVersionUID = -9079944024632368239L;
	public CodeErrorException() {
		super();
	}

	public CodeErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public CodeErrorException(String message) {
		super(message);
	}

	public CodeErrorException(Throwable cause) {
		super(cause);
	}
}
