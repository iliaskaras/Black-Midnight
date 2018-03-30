/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.model;

/**
 *
 * @author Ilias
 */
public class StoreOwner {
    private int userID;
    private int storeId;

    /**
     * Constructor with parameters
     * @param userID UserID from Users table in database
     * @param storeId storeId from stores table in database
     */
    public StoreOwner(int userID, int storeId) {
        this.userID = userID;
        this.storeId = storeId;
    }

    /**
     * Empty Constructor
     */
    public StoreOwner() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
    
}
