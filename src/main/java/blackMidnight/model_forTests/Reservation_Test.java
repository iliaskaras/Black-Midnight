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
@Entity (name = "reservation_test")
public class Reservation_Test {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column (name="reservationId")
    private int reservationId;
    @Column (name="customerName")
    private String customerName;
    @Column (name="numberOfSeats")
    private int numberOfSeats;
    @Column (name="storeName")
    private String storeName;
    //@Temporal(javax.persistence.TemporalType.DATE)
    @Column (name="date")
    private String date;
    @Column (name="hour")
    private String hour;
    @Column (name="reservationCode")
    private String reservationCode;
    @Column (name="customerUsername")
    private String customerUsername;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }
    
    
}
