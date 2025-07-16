package org.manipal.oops.proj.trade.model;

public class User {

    protected String userName ;
    
    protected String userId ;
    
    public User(String userName, String userId) {
        super();
        this.userName = userName;
        this.userId = userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return String.format("User [userName=%s, userId=%s]", userName, userId);
    }
    
}
