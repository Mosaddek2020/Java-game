/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineGaming;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import util.BoxData;
import util.ConnectionUtillities;
import util.Data;

/**
 *
 * @author user
 */
public class Player1 extends Player {

    boolean isMyTurn;
   
    Group root;
    Rectangle[][] recth;
    Rectangle[][] rectv;
    Rectangle[][] rectbox;
    boolean bol;
    int Col=5,Row=5;
    public int k;
    Text t;
   
    
   
    
    public Player1(boolean turn, ConnectionUtillities conn,Rectangle[][] reh,Rectangle[][]rev,Rectangle[][] rebox,Group rot,Text tt) {
        root = rot;
        recth = reh;
        rectv = rev;
        ncCon = conn;
        isMyTurn = turn;
        rectbox = rebox;
        t=tt;
        t.setText("Your Turn");
       
        
      
    }
    
     
        

    public void setHandler(Scene scene,Rectangle[][]recth,Rectangle[][]rectv) {

        DropShadow ds1 = new DropShadow();
        ds1.setOffsetY(2.0);
        Reflection ref = new Reflection();
        ds1.setInput(ref);
        
        final DropShadow borderGlow= new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.GOLDENROD);
        borderGlow.setWidth(30);
        borderGlow.setHeight(30);
        
        
        for (int i = 0; i < Row; i++) {

            for (int j = 0; j < Col; j++) {
                int ix = i, iy = j;
                
                 recth[i][j].setOnMouseEntered(e->{
                 if( isMyTurn){    
                 if(recth[ix][iy].getFill().equals(Color.BEIGE)) 
                    recth[ix][iy].setEffect(borderGlow);
                 } 
                
                });
                recth[i][j].setOnMouseExited(e->{
                    if(isMyTurn)
                    recth[ix][iy].setEffect(ds1);
                    
                    
                });
                
                recth[i][j].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent t) {

                        //System.out.println(isMyTurn);
                        if (isMyTurn)// to make it dynamic remove isMyTurn alwas true
                        {
                            if( recth[ix][iy].getFill().equals(Color.BEIGE)){
                                recth[ix][iy].setFill(Color.RED);
                               
                                try {
                                    bol=false;
                                    // isMyTurn = false;
                                    checkh(ix, iy);
                                } catch (Exception ex) {
                                   
                                    System.out.println("Error in checkh");
                                }
                           }
                            //-----------------------by me------------------------------

                            //----------------------------------------------------------
//                            Data data = new Data(ix, iy,'h');
//                            ncCon.write(data);
                            System.out.println(ix+ " " + iy);
                        }

                 
                    }

 
                });
                
                 rectv[i][j].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent t) {

                        //System.out.println(isMyTurn);
                        if (isMyTurn)// to make it dynamic remove isMyTurn alwas true
                        {

                             
                           if( rectv[ix][iy].getFill().equals(Color.BEIGE)){
                                bol= false;
                                rectv[ix][iy].setFill(Color.RED);
                               try {
                                   //isMyTurn = false;
                                   checkv(ix, iy);
                               } catch (Exception ex) {
                                   System.out.println("Error in checkv");
                               }
                           }
                            
                            
                            //-----------------------by me------------------------------

                            //----------------------------------------------------------
                           
                          //  ncCon.write(data);
                            System.out.println(ix+ " " + iy);
                        }

                 
                    }

 
                });
                 
                 rectv[i][j].setOnMouseEntered(e->{
                   if(isMyTurn){
                   if(rectv[ix][iy].getFill().equals(Color.BEIGE))  
                    rectv[ix][iy].setEffect(borderGlow);
                   }
                
                });
                rectv[i][j].setOnMouseExited(e->{
                  if(isMyTurn){
                      if(rectv[ix][iy].getFill().equals(Color.BEIGE)) 
                    rectv[ix][iy].setEffect(ds1);
                  }
                    
                });
                
                
                
                
            }
        }
    }
    
   
    
     private void checkh(int ih, int jh) throws Exception {
        
        
            if(ih==Row-1){
                
                if( !rectv[ih-1][jh].getFill().equals(Color.BEIGE) && !recth[ih-1][jh].getFill().equals(Color.BEIGE) && !rectv[ih-1][jh+1].getFill().equals(Color.BEIGE)){
                 
                    // this info has to  send 
                    makeBox("X",ih-1,jh);
                     
                    Data data = new Data(ih, jh,'h',true);
                    ncCon.write(data);
           
                }
                else{
                    
                   isMyTurn=false;
                   t.setText("Your oponent's move");
                   Data data = new Data(ih, jh,'h',false);
                   ncCon.write(data);
                   
                } 
            }
                
            else if( ih == 0){
                
                if(!rectv[ih][jh].getFill().equals(Color.BEIGE) && !recth[ih+1][jh].getFill().equals(Color.BEIGE) && !rectv[ih][jh+1].getFill().equals(Color.BEIGE)){
                    
                    makeBox("X",ih,jh);
                    Data data = new Data(ih, jh,'h',true);
                    ncCon.write(data);
                     
                }
                else{
                   isMyTurn=false;
                   t.setText("Your oponent's move");
                   Data data = new Data(ih, jh,'h',false);
                   ncCon.write(data);
                } 
            }
            else{
                
               if( !rectv[ih-1][jh].getFill().equals(Color.BEIGE) && !recth[ih-1][jh].getFill().equals(Color.BEIGE) && !rectv[ih-1][jh+1].getFill().equals(Color.BEIGE)){
                 
                   bol=true;
                    makeBox("X",ih-1,jh);
                   Data data = new Data(ih, jh,'h',true);
                   ncCon.write(data);
                    
                   
                
                }
                if(!rectv[ih][jh].getFill().equals(Color.BEIGE) && !recth[ih+1][jh].getFill().equals(Color.BEIGE) && !rectv[ih][jh+1].getFill().equals(Color.BEIGE)){
                    bol = true;
                    makeBox( "X",ih,jh);
                    Data data = new Data(ih, jh,'h',true);
                    ncCon.write(data);
                    
                }
                if( !bol){
                    isMyTurn = false; 
                    t.setText("Your oponent's move");
                     Data data = new Data(ih, jh,'h',false);
                     ncCon.write(data);
                    // ncCon.write(da);
                    
                }
               
               }
            }
     
     
     private void checkv(int iv, int jv) throws Exception {
        
        
            if(jv==Col-1){
                
                if( !rectv[iv][jv-1].getFill().equals(Color.BEIGE) && !recth[iv][jv-1].getFill().equals(Color.BEIGE) && !recth[iv+1][jv-1].getFill().equals(Color.BEIGE)){
                    makeBox("X",iv,jv-1);
                     Data data = new Data(iv, jv,'v',true);
                     ncCon.write(data);
                      
                }
                else{
                    
                    isMyTurn=false;
                    t.setText("Your oponent's move");
                    Data data = new Data(iv, jv,'v',false);
                    ncCon.write(data);
                    
                } 
                
            }
                
            else if( jv == 0){
                
                if(!recth[iv][jv].getFill().equals(Color.BEIGE) && !recth[iv+1][jv].getFill().equals(Color.BEIGE) && !rectv[iv][jv+1].getFill().equals(Color.BEIGE)){
                    makeBox("X",iv,jv);
                    Data data = new Data(iv, jv,'v',true);
                    ncCon.write(data);
                     
                }
                
                else{
                   
                    isMyTurn= false;
                    t.setText("Your oponent's move");
                    Data data = new Data(iv, jv,'v',false);
                    ncCon.write(data);
                } 
            }
            else{
                 if(!recth[iv][jv].getFill().equals(Color.BEIGE) && !recth[iv+1][jv].getFill().equals(Color.BEIGE) && !rectv[iv][jv+1].getFill().equals(Color.BEIGE)){
                     bol=true;
                     
                     makeBox("X",iv,jv);
                     Data data = new Data(iv, jv,'v',true);
                     ncCon.write(data);
                   
     
                }
                 if( !rectv[iv][jv-1].getFill().equals(Color.BEIGE) && !recth[iv][jv-1].getFill().equals(Color.BEIGE) && !recth[iv+1][jv-1].getFill().equals(Color.BEIGE)){
                    
                     bol=true;
                     makeBox("X",iv,jv-1);
                     Data data = new Data(iv, jv,'v',true);
                     ncCon.write(data);
                    
                      
                }
                  if( !bol){
                    isMyTurn=false;
                    t.setText("Your oponent's move");
                    
                   Data data = new Data(iv, jv,'v',false);
                   ncCon.write(data);
                    
                }
               
            }
             
//            Player1_score.setText(Name1+": "+score1);
//            Player2_score.setText(Name2+": "+score2);
    }

            
     private void makeBox(String x, int ih, int jh) throws Exception {
        
      
           rectbox[ih][jh].setFill(Color.RED);
          
          
      
       
      // isEnd();
       
       
    }
    
    
    

}
