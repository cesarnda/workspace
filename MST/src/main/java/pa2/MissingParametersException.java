package edu.harvard.cscie124.exception;

public class MissingParametersException extends Exception{


	private static final long serialVersionUID = 1L;

	public MissingParametersException() {
		super();
	}

	public MissingParametersException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MissingParametersException(String message, Throwable cause) {
		super(message, cause);
	}

	public MissingParametersException(String message) {
		super(message);
	}

	public MissingParametersException(Throwable cause) {
		super(cause);
	}
}
