/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.javains.mates;

import java.util.ArrayList;
import javax.ejb.Stateful;

/**
 *
 * @author Maneesha Nirman
 */
@Stateful

public class shoopingCartLogic implements shoopingCartLogicRemote, shoopingCartLogicLocal {
    static ArrayList<Product> products=new ArrayList<>();   
    
    
    @Override
    public ArrayList<Product> addCart(String pid, String pname, String pqty, String pprice) {
  
        Product p=new Product();
        p.setId(pid);
        p.setName(pname);
        p.setPrice(pprice);
        p.setQty(pqty);
       
        products.add(p);
     //   System.out.println(pid);
        
        return products;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public ArrayList<Product> updateCart(String pid, String pname, String pqty, String pprice) {
        
        System.out.println("AWA update");
        System.out.println(products.toString());
        
       for(Product p:products){
       
           if(p.getId().equals(pid)){
               
           p.setId(pid);
           p.setName(pname);
           p.setPrice(pprice);
           p.setQty(pqty);
           
          
               System.out.println("update pid"+" "+pid);
         
           }else{
               System.out.println("update wenna na");
           }
           
           System.out.println("Array update"+" "+products.toString());
       }
        
        System.out.println("methana hri");
        return products;
    }

    
    
 

    @Override
    public ArrayList<Product> cartloadAll() {
        
        
        return products;
    }

    @Override
    public ArrayList<Product> cartdel(String pid) {
  
        Product product1=null;
       for(Product p:products){
       
           if(p.getId().equals(pid)){
               System.out.println("awa del");  
               product1=p;
          
           
           }
       
       }
       products.remove(product1);
        return products;
    
}
}
