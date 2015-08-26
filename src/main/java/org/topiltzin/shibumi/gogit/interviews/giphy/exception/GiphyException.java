package org.topiltzin.shibumi.gogit.interviews.giphy.exception;

public class GiphyException extends Exception {

	public GiphyException(String message, Exception e) {
		super(message, e);
	}

	public GiphyException(Exception e) {
		super(e);
	}

}
