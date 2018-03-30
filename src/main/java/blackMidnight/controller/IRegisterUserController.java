/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.controller;

import blackMidnight.model.User;

/**
 *
 * @author Ilias
 */
public interface IRegisterUserController {

    boolean registerUserController(User user);
    boolean editUserController(User user);
    public boolean deleteUserController(String username);
}
