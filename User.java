package StudentSystemUpdated;

import java.util.ArrayList;

public class User {
    /*
    username:
        1. Unique
        2. Length: 3~15
        3. Format: numbers + letters (Can't be pure numbers)
    password:
        1. Enter twice of password and make sure they are identical.
    workerID:
        1. Length: 18 digits
        2. Can't start with 0
        3. First 17 digits have to be pure numbers, and the last digit can be number / Letter X / Letter x
    phoneNumber:
        1. Length: 10 digits (Canada/American only -- Starts with 1) Ex. +1 314-456-62778
        2. Can't start with 0
        3. Must be pure numbers
     */
    private String username;
    private String password;
    private String workerID;
    private String phoneNumber;
    // Safe to record the arrList address. Prevent from adjusting through outside.
    private ArrayList<User> userList;


    // Initialization
    public User() {}

    public User(String username, String password, String workerID, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.workerID = workerID;
        this.phoneNumber = phoneNumber;
    }

// Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWorkerID() {
        return workerID;
    }

    public void setWorkerID(String workerID) {
        this.workerID = workerID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public ArrayList<User> createUserList(){
        ArrayList<User> userList = new ArrayList<User>();
        this.setUserList(userList);
        return userList;
    }
}
