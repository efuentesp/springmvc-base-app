/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para el manejo de GenericException. 
 */
package com.softtek.acceleo.demo.exception;

/**
 * Clase GenericException.
 * @author PSG.
 *
 */
public class GenericException extends Exception {
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 5487884389115562157L;
	
	public GenericException() {
		super();
	}
	
	public GenericException(String msg) {
		super(msg);
	}
	
	public GenericException(Throwable t) {
		super(t);
	}
	
	public GenericException(String msg, Throwable t) {
		super(msg, t);
	}

}
