/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.javains.mates;

import java.io.IOException;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lk.javains.mates.shoopingCartLogicRemote;

        

/**
 *
 * @author Maneesha Nirman
 */
@WebServlet(name = "Shoppingservlet", urlPatterns = {"/Shoppingservlet"})
public class Shoppingservlet extends HttpServlet {

    @EJB
    private shoopingCartLogicRemote shoopingCartLogic;

  
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String pid=request.getParameter("productid");
        String pname=request.getParameter("productname");
        String pqty=request.getParameter("productqty");
        String pprice=request.getParameter("productprice");
     
        
        ArrayList<Product> products=shoopingCartLogic.addCart(pid, pname, pqty, pprice);
         
       if(products!=null){
       
           for (Product product : products) {
               System.out.println(product.getId()+" "+product.getName()+" "+product.getPrice()+" "+product.getQty());
             response.getWriter().write("OK"+" "+ product.getId()+" "+product.getName()+" "+product.getPrice()+" "+product.getQty()); 
           }
       }
        
         
    }

   

}
