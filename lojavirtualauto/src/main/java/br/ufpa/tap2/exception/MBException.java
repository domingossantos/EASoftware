package br.ufpa.tap2.exception;



public class MBException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MBException(String msg) {
		super(msg);
		printStackTrace();
	}
}	