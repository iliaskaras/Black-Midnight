/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO;

import blackMidnight.model.Reservation;
import blackMidnight.model_forTests.Reservation_Test;
import java.util.List;

/**
 *
 * @author Ilias
 */
public interface IGetReservationHistoryDAO  {
    
    public List<Reservation> getAllReservations(String username);
    public List<Reservation> getReservationsHistoryForSpecificStore(String storeName,String customerUsername);
    public List<Reservation> getOnGoingReservationsHistory();
}
