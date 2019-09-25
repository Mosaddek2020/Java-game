/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineGaming;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
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
public class Player2 extends Player{
    Group root;
    Rectangle [][] recth;
     Rectangle [][] rectv;
     Label l;
     Rectangle[][] rectBox; 
     int Row=5,Col=5;
     Text t;
     public boolean con=true;
   
    public Player2(ConnectionUtillities conn,Rectangle[][]reh,Rectangle [][]rev,Rectangle[][]recbox,Group rot,Text tt){
        super();
       
        recth=reh;
        rectv= rev;
        ncCon=conn; 
        rectBox = recbox;
        root=rot;
        t=tt;
        t.setText(" Yor oponent's Turn");
       
        
        
       
        
       
    }
    
    public int count;
    public int x;
    public int y;
    public Character ch;
    public boolean pendingUpdate=false;
    public  boolean bol=false;
    
    
    
    public void update() throws Exception{
        if(pendingUpdate==true){
            if ( ch == 'h'){
                bol=false;
                recth[x][y].setFill(Color.GREY);
                checkh(x,y);
               // pendingUpdate=false;
            }
            else{
                
                rectv[x][y].setFill(Color.GREY);
               // pendingUpdate=false;
                checkv(x,y);
            }
            
           
           //l.setText("Your oponent's Turn");
        }
      //  System.out.println(x +" " + y);
      // rect[x][y].setFill(Color.CORAL);
      //  display.setText(Integer.toString(count));
     //   circle.setCenterX(x);
      //  circle.setCenterY(y);
    }
    
     private void checkh(int ih, int jh) throws Exception {
        
        
            if(ih==Row-1){
                
                if( !rectv[ih-1][jh].getFill().equals(Color.BEIGE) && !recth[ih-1][jh].getFill().equals(Color.BEIGE) && !rectv[ih-1][jh+1].getFill().equals(Color.BEIGE)){
                 
                    // this info has to  send 
                    makeBox(ih-1,jh);
                   
           
                }
                else{
                    
                   pendingUpdate=false;
                   t.setText("Your Turn");
                   
                   
                  
                } 
            }
                
            else if( ih == 0){
                
                if(!rectv[ih][jh].getFill().equals(Color.BEIGE) && !recth[ih+1][jh].getFill().equals(Color.BEIGE) && !rectv[ih][jh+1].getFill().equals(Color.BEIGE)){
                    
                    makeBox(ih,jh);
                    //BoxData da = new BoxData(ih, jh,true);
                    //ncCon.write(da);
                     
                }
                else{
                   pendingUpdate=false;
                   t.setText("Your Turn");
                   
                } 
            }
            else{
                
               if( !rectv[ih-1][jh].getFill().equals(Color.BEIGE) && !recth[ih-1][jh].getFill().equals(Color.BEIGE) && !rectv[ih-1][jh+1].getFill().equals(Color.BEIGE)){
                 
                   bol=true;
                    makeBox(ih-1,jh);
                  
                    
                   
                
                }
                if(!rectv[ih][jh].getFill().equals(Color.BEIGE) && !recth[ih+1][jh].getFill().equals(Color.BEIGE) && !rectv[ih][jh+1].getFill().equals(Color.BEIGE)){
                    bol = true;
                    makeBox(ih,jh);
                    
                    //ncCon.write(da);
                    
                }
                if( !bol){
                    pendingUpdate = false;
                    t.setText("Your Turn");
                     
                    // ncCon.write(da);
                    
                }
               
               }
            }
     
     
     private void checkv(int iv, int jv) throws Exception {
        
        
            if(jv==Col-1){
                
                if( !rectv[iv][jv-1].getFill().equals(Color.BEIGE) && !recth[iv][jv-1].getFill().equals(Color.BEIGE) && !recth[iv+1][jv-1].getFill().equals(Color.BEIGE)){
                    makeBox(iv,jv-1);
                   // ncCon.write(da);
                      
                }
                else{
                    
                    pendingUpdate=false;
                    t.setText("Your Turn");
                    
                    
                } 
                
            }
                
            else if( jv == 0){
                
                if(!recth[iv][jv].getFill().equals(Color.BEIGE) && !recth[iv+1][jv].getFill().equals(Color.BEIGE) && !rectv[iv][jv+1].getFill().equals(Color.BEIGE)){
                    makeBox(iv,jv);
                    //BoxData da = new BoxData(iv, jv,true);
                    //ncCon.write(da);
                     
                }
                
                else{
                   
                    pendingUpdate= false;
                    t.setText("Your Turn");
                     
                } 
            }
            else{
                 if(!recth[iv][jv].getFill().equals(Color.BEIGE) && !recth[iv+1][jv].getFill().equals(Color.BEIGE) && !rectv[iv][jv+1].getFill().equals(Color.BEIGE)){
                     bol=true;
                     
                     makeBox(iv,jv);

                   
     
                }
                 if( !rectv[iv][jv-1].getFill().equals(Color.BEIGE) && !recth[iv][jv-1].getFill().equals(Color.BEIGE) && !recth[iv+1][jv-1].getFill().equals(Color.BEIGE)){
                    
                     bol=true;
                     makeBox(iv,jv-1);
                   //  BoxData da = new BoxData(iv, jv-1,true);
                    // ncCon.write(da);
                    
                      
                }
                  if( !bol){
                      
                    pendingUpdate=false;
                    t.setText("Your Turn");
                    
               
                    
                }
               
            }
             
//            Player1_score.setText(Name1+": "+score1);
//            Player2_score.setText(Name2+": "+score2);
    }
     
     private void makeBox( int ih, int jh) throws Exception {
        
      if( pendingUpdate && bol ){
           rectBox[ih][jh].setFill(Color.GREY);
         
           
      }
      else {
          rectBox[ih][jh].setFill(Color.RED);
          
          
      }
      // k++;
      // isEnd();
       
       
    }

    
    
    
     
}
