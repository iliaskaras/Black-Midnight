/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.model_forTests;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Ilias
 */
@Entity (name ="store_test")
public class Store_Test {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column (name="storeId")
    private int storeId;     // ILIAS.KARATSIN gia na dokimasw to database //
    @Column (name="nameOfStore")
    private String nameOfStore;
    @Column (name="numberOfSeats")
    private int numberOfSeats;
    @Column (name="storeAddress")
    private String storeAddress;
    @Column (name="storeCity")
    private String storeCity;
    @Column (name="storePhone")
    private String storePhone;
    @Column (name="parking")
    private boolean parking;
    @Column (name="openDays")
    private String openDays;
    @Column (name="openHours")
    private String openHours;
    @Column (name="email")
    private String email;
    @Column (name="storeDetails")
    private String storeDetails;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getNameOfStore() {
        return nameOfStore;
    }

    public void setNameOfStore(String nameOfStore) {
        this.nameOfStore = nameOfStore;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStoreCity() {
        return storeCity;
    }

    public void setStoreCity(String storeCity) {
        this.storeCity = storeCity;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public String getOpenDays() {
        return openDays;
    }

    public void setOpenDays(String openDays) {
        this.openDays = openDays;
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStoreDetails() {
        return storeDetails;
    }

    public void setStoreDetails(String storeDetails) {
        this.storeDetails = storeDetails;
    }
    
    
    
    
}
