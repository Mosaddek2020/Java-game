/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author uesr
 */
public class Data  implements Serializable {
    
     public Character info;
     public int count;
     
     public int x,y;
     public boolean bol;
     
     
     
     public Data(int cnt){
         count=cnt;
     }
     public Data(int x1,int y1,Character ch,boolean b){
         x=x1;
         y=y1;
         info = ch;
         bol = b;
     }
    
}
