package StudentSystem;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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

    public static ArrayList<User> createUserList(){
        ArrayList<User> userList = new ArrayList<User>();
        return userList;
    }

// Log in

    // Print out Login commands
    public static void loginCommand(){
        System.out.println("====================Welcome to Student Manipulation System====================");
        System.out.println("Please select your action");
        System.out.println("|      1: Log in        |");
        System.out.println("|      2: Sign up       |");
        System.out.println("|      3: Forget        |");
        System.out.println("|      4: Quit          |");
        System.out.println("-------------------------");
    } // Done

    // Log in main method
    public static boolean login(ArrayList<User> list){
    // record username
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the username");
        String username = sc.next();
        // If username does not exist, please sign up first
        if(unique(list, username)){
            System.out.println("************PLEASE TRY AGAIN************");
            System.out.println(" This username has not been registered. ");
            System.out.println("****************************************");
            return false;
        }
    // record password
        System.out.println("Please enter the password");
        String password = sc.next();
    // check verify code
        while (true) {
            String verifyCode = getCode();
            System.out.println("-----Verify Code-----");
            System.out.println("|       "+verifyCode+"       |");
            System.out.println("---------------------");
            System.out.println("Please enter the verify code");
            String userCode = sc.next();
            if(userCode.equalsIgnoreCase(verifyCode)){
                break;
            }
            else{
                System.out.println("The verify code does not match, please try again");
            }
        }
        User u = new User(username, password, null, null);
    // check username and password is correct
        return checkUserInfo(list, u);
    }

    // check whether the input matches system
    private static boolean checkUserInfo(ArrayList<User> list, User u) {
        for (int i = 0; i < list.size(); i++) {
            if((list.get(i).getUsername().equals(u.getUsername()))&&
                    (list.get(i).getPassword().equals(u.getPassword()))){return true;}
        }
        return false;
    }

    // Get verify code
    private static String getCode() {
        ArrayList<Character> list = new ArrayList<>();
        // Creating list with all letters
        for (int i = 0; i < 26; i++) {
            list.add((char)('a'+i));
            list.add((char)('A'+i));
        }
        // Generating code
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        int locNum = r.nextInt(5);
        // If the number shows at the last digit
        if(locNum==4){
            for (int i = 0; i < 4; i++) {
                sb.append(list.get(r.nextInt(list.size())));
            }
            sb.append(r.nextInt(10));
        }else{
            // If the number is NOT showing at the last digit
            for (int i = 0; i < 4; i++) {
                if(i==locNum){
                    sb.append(r.nextInt(10));
                }
                sb.append(list.get(r.nextInt(list.size())));
            }
        }

        return sb.toString();
    } // Done


// Sign up (Done)
    // Check the format of username
    public static boolean checkUsername(String username){
    int len = username.length();
    // If the length() is 3~15
    if(len<3||len>15){return false;}

    // If the chars in 'a'~'z' 'A'~'Z' '0'~'9'
    for (int i = 0; i < username.length(); i++) {
        char c = username.charAt(i);
        if(!( (c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9') )){return false;}
    }

    // If there is at least one letter
    for (int i = 0; i < username.length(); i++) {
        char c = username.charAt(i);
        if(( (c>='a' && c<='z') || (c>='A' && c<='Z'))){return true;}
    }

    return false;
}

    // Sign up main method
    public static void signUp(ArrayList<User> list){
        Scanner sc = new Scanner(System.in);

    // Username (Done)
        String username;
        // check if the username is in correct format and has not been taken
        while(true){
            System.out.println("Please create your username");
            username = sc.next();
            // Check the format of username (3~15; letters + numbers; at least one letter)
            boolean format = checkUsername(username);
            if(!format){
                System.out.println("***********************************PLEASE TRY AGAIN***********************************");
                System.out.println("1. Your username should be with in 3 to 15 characters consisted of letters and numbers");
                System.out.println("2. Your username should contain at least one letter");
                System.out.println("**************************************************************************************");
                continue;
            }
            // If the username exists in the list (getIndex)
            boolean unique = unique(list, username);
            if(!unique){
                System.out.println("**********PLEASE TRY AGAIN**********");
                System.out.println("    This username has been used.    ");
                System.out.println("************************************");
                continue;
            }
            break;
        }

    // password (Done)
        String password;
        while(true){
            System.out.println("Please set up your password");
            password = sc.next();
            System.out.println("Please enter again your password");
            String passwordVerify = sc.next();
            if(!password.equals(passwordVerify)){
                System.out.println("***************PLEASE TRY AGAIN***************");
                System.out.println("  The passwords you entered are not the same. ");
                System.out.println("**********************************************");
            }
            else{break;}
        }

    // workerID (Ongoing)
        String workerID;
        while(true){
            System.out.println("Please enter your workerID");
            workerID=sc.next();
            if(checkWorkerID(workerID)){
                break;
            }
            else {
                System.out.println("********PLEASE TRY AGAIN********");
                System.out.println("   Your worker ID is invalid    ");
                System.out.println("********************************");
                continue;
            }
        }

    // phoneNumber
        String phoneNumber;
        while(true){
            System.out.println("Please enter your 10 digits phone number (Ex. 4168886666).");
            phoneNumber=sc.next();
            if(checkPhoneNumber(phoneNumber)){
                break;
            }
            else {
                System.out.println("********PLEASE TRY AGAIN********");
                System.out.println("   The format is not correct.   ");
                System.out.println("********************************");
                continue;
            }
        }

    // Review the info and add it into userList
        User u = new User(username, password, workerID, phoneNumber);
        list.add(u);
        System.out.println("Your account has been registered successfully!");
        System.out.println("_______________________________________________");
        System.out.println("----------Please save your login info----------");
        System.out.println("Username: "+ username);
        System.out.println("Password: "+ password);
        System.out.println("Worker ID: "+ workerID);
        System.out.println("Phone number: "+ phoneNumber);
        System.out.println("_______________________________________________");
        System.out.println();
    }

    // Check if phone number is in correct format
    private static boolean checkPhoneNumber(String phoneNumber) {
        // length should be 10 digits
        int len = phoneNumber.length();
        if(len!=10){return false;}
        // can not start with 0
        if(phoneNumber.startsWith("0")){return false;}
        // all digits must be numbers
        for (int i = 0; i < phoneNumber.length(); i++) {
            char c = phoneNumber.charAt(i);
            if(!(c >= '0' && c <= '9')){return false;}
        }
        // If everything looks fine, return true
        return true;
    }

    // Check if WorkerID is in correct format
    private static boolean checkWorkerID(String workerID) {
        // workerID must be at length of 18
        int len = workerID.length();
        if(len!=18){return false;}
        // workerID can not start with 0
        if(workerID.startsWith("0")){return false;}
        // First 17 digits must be numbers
        for (int i = 0; i < workerID.length()-1; i++) {
            char c = workerID.charAt(i);
            if(!(c >= '0' && c <= '9')){return false;}
        }
        // The last digit can be either number, x or X
        char lastDigit = workerID.charAt(len-1);
        if((lastDigit=='x')||(lastDigit=='X')||(lastDigit>='0'&&lastDigit<='9')){
            // If everything looks fine, return true
            return true;
        }
        // Otherwise, return false
        return false;
    }

    // Check string is unique in the UserList
    private static boolean unique(ArrayList<User> list, String str) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getUsername().equals(str)){return false;}
        }
        return true;
    } // Done


// Forget



}
