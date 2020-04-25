package com.zhangqi.javaee.IOC;

/**
 * 前端VO
 * 
 * @author feng
 *
 */
public class RespVO {
	public RespVO() {

	}

	public RespVO(String status, String message, Object data) {
		this.message = message;
		this.status = status;
		this.data = data;
	}

	public RespVO(String status, String message) {
		this.message = message;
		this.status = status;
	}

	/**
	 * 状态码
	 */
	private String status;
	/**
	 * 信息内容
	 */
	private String message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 返回数据
	 */
	private Object data;
}
