/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.DAO;

import blackMidnight.model.Item;
import blackMidnight.model_forTests.Item_Test;

/**
 *
 * @author Ilias
 */
public interface IItemDAO {

    /**
     *
     * @param st The store object to write to file.
     * @return true if file is writen or false if not.
     */
    boolean addItem(Item st);

    boolean addItemForTest(Item_Test st);

    /*      @Override
    public boolean addItem (Item st) {
    Session session = factory.openSession();
    Transaction tx = null;
    boolean result;
    try {
    tx = session.beginTransaction();
    //  result = itemQuantityUpdates.updateSpecificStoreDateReservationSeats(st, factory);
    if (result == false) {
    return false;
    } else {
    session.save(st);
    tx.commit();
    return true;
    }
    } catch (HibernateException e) {
    if (tx != null) {
    tx.rollback();
    }
    e.printStackTrace();
    System.out.println("Connection to Database FAILED!  " + e);
    return false;
    } finally {
    session.close();
    }
    }*/
    boolean deleteItem(Item myItem);

    boolean deleteItemForTest(Item_Test myItem);
    
}
