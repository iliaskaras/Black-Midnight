/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO;

import blackMidnight.model.Reservation;
import blackMidnight.model_forTests.Reservation_Test;

/**
 *
 * @author Ilias
 */
public interface ICreateReservationDAO {
    
    
    public boolean writeToFileReservation(Reservation cr);
   // public boolean writeToFileReservationForTest(Reservation_Test cr);
}
