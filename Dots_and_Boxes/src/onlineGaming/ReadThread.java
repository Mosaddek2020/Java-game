/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineGaming;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import util.BoxData;
import util.ConnectionUtillities;
import util.Data;

/**
 *
 * @author user
 */
public class ReadThread implements Runnable{    
    public ConnectionUtillities ncCon;
    public Player1 player1;
    public Player2 player2;

    public ReadThread(Player1 p1,Player2 p2, ConnectionUtillities conn){
        player1=p1;
        player2=p2;
        ncCon=conn;
    }
    
    
    @Override
    public void run() {
         while(true){
             
             final Data obj=(Data)ncCon.read();
            // final BoxData obj1 = (BoxData)ncCon.read();
             
                                    
//             player2.x=obj.x;
//             player2.y=obj.y;
            // player2.rect[obj.x][obj.y].setFill(Color.CORAL);
             /*
             player2.x=obj.x;
             player2.y=obj.y;
             */
             
            System.out.println("Received"+obj.x+obj.y);
             
            
            player2.pendingUpdate=true;
             
             
             Platform.runLater(new Runnable(){                 
                 @Override
                 public void run() {
                    // player2.display.setText(Integer.toString(obj.count));
                    // player2.circle.setCenterX(obj.x);
                    // player2.circle.setCenterY(obj.y);
                    //----------------------------------
                     
             //player1.isMyTurn=true;                          
             player2.x=obj.x;
             player2.y=obj.y;
             player2.ch=obj.info;
             player1.isMyTurn=true;
             player2.bol= obj.bol;
            // player2.rect[obj.x][obj.y].setFill(Color.CORAL);
           
             
                 }
             });
             
             
             
         }   
         
    }
    
}
