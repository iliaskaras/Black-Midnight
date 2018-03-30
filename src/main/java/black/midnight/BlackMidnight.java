/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package black.midnight;

import blackMidnight.ui.LoginForm;
import blackMidnight.util.HibernateUtil;
import blackMidnight.util.HibernateUtilTest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ilias
 */
public class BlackMidnight {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // TODO issue: check hours 
     //   Creating for first time the tables in main database blackMidnight //
       
  //      SessionFactory factoryForTests = HibernateUtilTest.getSessionFactory();
//        SessionFactory factory = HibernateUtil.getSessionFactory();
        String version = System.getProperty("java.version");
        System.out.println("VERSION!:"+version);
        new LoginForm().setVisible(true);
        
    }
    
}
