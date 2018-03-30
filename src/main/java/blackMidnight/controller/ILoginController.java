/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.controller;

/**
 *
 * @author Ilias
 */
public interface ILoginController {

    Integer ownerLoginController(Integer userId);

    Integer userLoginController(String username, String password);
    
}
