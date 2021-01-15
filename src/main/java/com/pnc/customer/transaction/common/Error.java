package com.pnc.customer.transaction.common;

import java.io.Serializable;
import java.util.Objects;

/**
 * Used when an API throws an Error, typically with a HTTP error response-code (3xx, 4xx, 5xx)
 */
public class Error implements Serializable, Response {
  private static final long serialVersionUID = 1L;


  private String code;
  private String serviceName;
  private String reason;
  private String message;
  private String status;

  public Error(String message, String reason, String code) {
    this.message = reason;
    this.message = message;
    this.code = code;
  }

  public Error code(String code) {
    this.code = code;
    return this;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Error serviceName(String serviceName) {
    this.serviceName = serviceName;
    return this;
  }
  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  public Error reason(String reason) {
    this.reason = reason;
    return this;
  }
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public Error message(String message) {
    this.message = message;
    return this;
  }


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Error status(String status) {
    this.status = status;
    return this;
  }
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.code, error.code) &&
        Objects.equals(this.serviceName, error.serviceName) &&
        Objects.equals(this.reason, error.reason) &&
        Objects.equals(this.message, error.message) &&
        Objects.equals(this.status, error.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, serviceName, reason, message, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");

    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    serviceName: ").append(toIndentedString(serviceName)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

