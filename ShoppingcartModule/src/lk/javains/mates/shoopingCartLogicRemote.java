/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.javains.mates;

import java.util.ArrayList;
import java.util.Map;
import javax.ejb.Remote;


/**
 *
 * @author Maneesha Nirman
 */
@Remote
public interface shoopingCartLogicRemote {

    ArrayList<Product> addCart(String pid, String pname, String pqty, String pprice);

    ArrayList<Product> updateCart(String pid, String pname, String pqty, String pprice);

    ArrayList<Product> cartloadAll();

    ArrayList<Product> cartdel(String pid);
    
}
