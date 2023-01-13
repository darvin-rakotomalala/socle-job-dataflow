package com.poc.data.commun;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public abstract class BaseDTO {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private boolean isError = false;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private boolean isInfo = false;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private boolean isWarning = false;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String errorUuid;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String errorCode = null;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String errorMessage = null;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String message = null;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer errorHttpCode;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String errorPath;

	public BaseDTO() {
		super();
	}

	public BaseDTO(boolean isError, String errorCode, String errorMessage, String message) {
		super();
		this.isError = isError;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.message = message;
	}
	
	public BaseDTO(boolean isError, boolean isInfo, boolean isWarning, String errorCode, String errorMessage, String message, String errorUuid) {
		super();
		this.isError = isError;
		this.isInfo = isInfo;
		this.isWarning = isWarning;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.message = message;
		this.errorUuid = errorUuid;
	}
	

	public BaseDTO(String errorUuid, String errorMessage, String message) {
		this.errorUuid = errorUuid;
		this.errorMessage = errorMessage;
		this.message = message;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean error) {
		isError = error;
	}
	
	public boolean isInfo() {
		return isInfo;
	}

	public void setInfo(boolean info) {
		isInfo = info;
	}
	
	public boolean isWarning() {
		return isWarning;
	}

	public void setWarning(boolean warning) {
		isWarning = warning;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorUuid() {
		return errorUuid;
	}

	public void setErrorUuid(String errorUuid) {
		this.errorUuid = errorUuid;
	}

	public Integer getErrorHttpCode() {
		return errorHttpCode;
	}

	public void setErrorHttpCode(Integer errorHttpCode) {
		this.errorHttpCode = errorHttpCode;
	}

	public String getErrorPath() {
		return errorPath;
	}

	public void setErrorPath(String errorPath) {
		this.errorPath = errorPath;
	}
}
