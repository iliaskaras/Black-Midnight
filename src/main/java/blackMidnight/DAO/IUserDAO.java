/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.DAO;

import blackMidnight.model.User;

/**
 *
 * @author Ilias
 */
public interface IUserDAO {

    /**
     *
     * @param user the value of user
     * @return the Id of the created user
     */
    Integer addUser(User user);

    void deleteUser(Integer userID);

    /**
     * This method update the fields of an existing user in the database
     *
     * @param username username of the user
     * @param userFirstName First name of user
     * @param userLastName last name of user
     * @param password password
     * @param phoneNumber phone number of user
     * @param usermail email of user
     */
    void updateUser(String username, String userFirstName, String userLastName, String phoneNumber, String password, String usermail);

    /**
     *
     * @param username the username of the user to search for
     * @return the id of the user if the user exists in the database table 0
     * else.
     */
    Integer userIdReturn(String username);

    User userReturn(Integer userID);
    
}
