package org.zealot.web.model;

public class Model {
	private int code;
	private String message;
	private Object data;

	@Override
	public String toString() {
		return "Model [code=" + code + ", message=" + message + ", data=" + data + "]";
	}

	public Model(int code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public Model() {
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}

}
