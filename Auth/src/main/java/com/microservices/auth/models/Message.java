package com.microservices.auth.models;
import java.util.Objects;

public class Message {
    private String message;
    private int status;

    public Message(String message, int status) {
        this.message = message;
        this.status = status;
    }

    // Getter e Setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Message() {
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Message message(String message) {
        setMessage(message);
        return this;
    }

    public Message status(int status) {
        setStatus(status);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Message)) {
            return false;
        }
        Message message = (Message) o;
        return Objects.equals(message, message.message) && status == message.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, status);
    }

    @Override
    public String toString() {
        return "{" +
            " message='" + getMessage() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }

}