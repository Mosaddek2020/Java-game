/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class BoxData  implements Serializable {
    
    // public Character info;
     public boolean Boxmade;
     
     public int x,y;
     
     
     
     public BoxData(){
         Boxmade = false;
     }
     public BoxData(int x1,int y1,boolean bol){
         x=x1;
         y=y1;
         Boxmade = bol;
         
     }
    
}
