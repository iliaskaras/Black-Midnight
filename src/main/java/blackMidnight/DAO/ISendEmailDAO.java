/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO;

import java.io.FileNotFoundException;

/**
 *
 * @author Ilias
 */
public interface ISendEmailDAO {
    
     public String readFromRegisterUsersLogEmail(String username) throws FileNotFoundException;
     public String readFromStoreListEmail(String storeName) throws FileNotFoundException;
    
}
