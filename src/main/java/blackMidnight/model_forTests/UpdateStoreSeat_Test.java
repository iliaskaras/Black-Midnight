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
@Entity (name = "reservationbydate_test")
public class UpdateStoreSeat_Test {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column (name="reservationDateId")
    private int reservationDateId;
    @Column (name="storeName")
    private String storeName;
    @Column (name="seatsAvailable")
    private int seatsAvailable;
    @Column (name="date")
    private String date;

    public int getReservationDateId() {
        return reservationDateId;
    }

    public void setReservationDateId(int reservationDateId) {
        this.reservationDateId = reservationDateId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
