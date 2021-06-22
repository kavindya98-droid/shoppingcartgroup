/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.javains.mates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maneesha Nirman
 */
@WebServlet(name = "Shoppingservletdelete", urlPatterns = {"/Shoppingservletdelete"})
public class Shoppingservletdelete extends HttpServlet {
@EJB
    private shoopingCartLogicRemote shoopingCartLogic;
    //@javax.enterprise.context.SessionScoped



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
              
        String pid=request.getParameter("productid");
        
     
        
        ArrayList<Product> products=shoopingCartLogic.cartdel(pid);
         
       if(products!=null){
       
           for (Product product : products) {
               System.out.println(product.getId()+" "+product.getName()+" "+product.getPrice()+" "+product.getQty());
                response.getWriter().write("Deleted!"+" "+ product.getId()+" "+product.getName()+" "+product.getPrice()+" "+product.getQty()); 
           }
       }
        
         
        
    }

   
   
}
