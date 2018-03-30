/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Ilias
 */
@Entity (name ="user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column (name="userId")
    private int userID;
    @Column (name="username")
    private String username;
    @Column (name="userFirstName")
    private String userFirstName;
    @Column (name="userLastName")
    private String userLastName;
    @Column (name="phoneNumber")
    private String phoneNumber;
    @Column (name="password")
    private String password;
    @Column (name="usermail")
    private String usermail;
    
    public User() {
    }
    
    

    /**
     * Constructor with parameters
     * @param username username
     * @param userFirstName firstname
     * @param userLastName lastname
     * @param phoneNumber phone number
     * @param password password
     * @param usermail e-mail
     */
    public void registerUser(String username, String userFirstName, String userLastName,
            String phoneNumber, String password, String usermail){
        this.username=username;
        this.userFirstName=userFirstName;
        this.userLastName=userLastName;
        this.phoneNumber=phoneNumber;
        this.password=password;
        this.usermail=usermail;
    }
     public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username){
         this.username=username;
     }   
    public String getUserFirstName(){
        return userFirstName;
    }
    public void setUserFirstName(String userFirstName){
        this.userFirstName=userFirstName;        
    }
    public String getUserLastName(){
        return userLastName;
    }
    public void setUserLastName(String userLastName){
        this.userLastName=userLastName;        
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;        
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;        
    }
    public String getUsermail(){
        return usermail;
    }
    public void setUsermail(String usermail){
        this.usermail=usermail;        
    }
    
    }

    
    

