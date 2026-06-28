package com.dxc.bankingapi.dto;

public class MessageResponse {
  private String message;

    public MessageResponse(String message) {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
