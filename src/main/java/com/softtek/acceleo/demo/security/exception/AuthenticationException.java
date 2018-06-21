package com.softtek.acceleo.demo.security.exception;

public class AuthenticationException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 22664772316138859L;

	public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
