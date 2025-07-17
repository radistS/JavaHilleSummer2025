package com.hilllel.cw_08.enumer;

public class User {
    private String email;
    private UserStatus status;
    private boolean isActive;

    public User(String email) {
        this.email = email;
        this.status = UserStatus.PENDING;
    }

    public String getEmail() {
        return email;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", status=" + status +
                ", isActive=" + isActive +
                '}';
    }
}
