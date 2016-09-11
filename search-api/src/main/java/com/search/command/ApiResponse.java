package com.search.command;

import java.io.Serializable;

/**
 * This is response of every api call.
 * 
 * @param <T>
 *            the generic type
 */
public class ApiResponse<T> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2322145101734338974L;

	/** The status. */
	private int status;

	/** The message. */
	private String message;

	/** The resource. */
	private T resource;

	/**
	 * Instantiates a new api response.
	 */
	public ApiResponse() {
		this.status = ResponseCode.EXCEPTION_OCCURRED;
		this.message = ResponseMessage.EXC_MSG;
	}

	/**
	 * Instantiates a new api response.
	 * 
	 * @param resource
	 *            the resource
	 */
	public ApiResponse(T resource) {
		this.resource = resource;
		if (resource == null) {
			status = ResponseCode.NO_DATA_FOUND;
			message = ResponseMessage.NULL_OBJECT;
		} else {
			status = ResponseCode.SUCCESS;
			message = ResponseMessage.SUCCESS_MSG;
		}
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResource() {
		return resource;
	}

	public void setResource(T resource) {
		this.resource = resource;
	}
}
