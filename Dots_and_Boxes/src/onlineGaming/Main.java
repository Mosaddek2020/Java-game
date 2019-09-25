/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineGaming;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import util.ConnectionUtillities;


/**
 *
 * @author user
 */
public abstract class Main extends Application{
    
    ConnectionUtillities ncCon;
    boolean isMyTurn;
    //-------------
    
       public Label l;
       public Label Acnt;
       public String str1 = "Your Turn now";
       public String str2 = "Your movement now";
       public Text t= new Text("");
       
       
      public  Label Player1_score;
      public  Label Player2_score;
      public int Score_server=0;
      public int Score_client=0;
    
    //-------------
    
       
    int Col = 5;
    int Row = 5;
    Circle[][] circle = new Circle[Row][Col];
    Rectangle [][] recth  = new Rectangle[Row][Col];
    Rectangle[][] rectv = new Rectangle[Row][Col];
    Rectangle [][] rectbox=new Rectangle[Row][Col];
    Label[][] point = new Label [Row][Col];
       
       
    
    public abstract void CreateConnection();
    
    public void update(Player2 player2,long now) throws Exception{
        player2.update();
    }
    
    
    @Override
    public void start(Stage stage) throws Exception {
        
        CreateConnection();
         Group root = new Group();
         
           Player1_score=new Label("Server :"+ Score_server );
           Player1_score.setLayoutX(250);
           
           Player2_score= new Label("Client :"+ Score_client);
           Player2_score.setLayoutX(250);
           Player2_score.setLayoutY(10);
        
         root.getChildren().add(l);
         root.getChildren().add(t);
         t.setLayoutX(30);
         root.getChildren().addAll(Player1_score,Player2_score);
       
        
         
       
//        GridPane board=new GridPane();
//        board.setHgap(20);
//        board.setHgap(20);
//        board.setAlignment(Pos.CENTER);        
//        board.add(player1.design, 0, 1);
//        board.add(player2.design, 1, 1);
//        
        
        
       // FlowPane root=new FlowPane();
        //root.getChildren().add(player1.design);
        //root.getChildren().add(player2.design);
        
       // Group design=new Group();
        //-------------------------------------------
       
//        root.getChildren().add(Acnt);


    final Player1 player1=new Player1(isMyTurn,ncCon,recth,rectv,rectbox,root,t);
    final Player2 player2=new Player2(ncCon,recth,rectv,rectbox,root,t);
        
        int X = 30, Y = 30, dis = 50, r = 10;
        DropShadow ds1 = new DropShadow();
        ds1.setOffsetY(2.0);
        Reflection ref = new Reflection();
        ds1.setInput(ref);
       
        

       
        
//        javafx.scene.image.Image x=new javafx.scene.image.Image("/game background.png");
//        
//        ImageView xx=new ImageView(x);
//        xx.setFitWidth(800);
//        xx.setFitHeight(500);
//        root.getChildren().add(xx);

//--
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//                   two nested for loop for initialization of every array elements   
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

        for (int i = 0; i < Row; i++) {
          
            Y += dis;
            X = 25;
            for (int j = 0; j < Col; j++) {
                X += dis;
        //------------------------------------------------------------      
        //---------------- Horizental Rectagnle-----------------------
        //-----------------------------------------------------------
        
                //creating horizental rectangle 
                recth[i][j] = new Rectangle(X, Y, dis, r);
                recth[i][j].setFill(Color.BEIGE);
                recth[i][j].setEffect(ds1);

              

                // setting mouse event for horizental rectangle
                int ih = i;
                int jh = j;
//                recth[i][j].setOnMouseClicked((MouseEvent event) -> {
//                           
//                     if( recth[ih][jh].getFill().equals(Color.BEIGE) ){ 
//                               try {
//                                   MakeRedrecth(ih,jh);
//                               } catch (Exception ex) {
//                                   Logger.getLogger(DotsAndBoxes.class.getName()).log(Level.SEVERE, null, ex);
//                               }
//                           rightMove.play();
//                           
//                     }
//                   
//                   else
//                   {
//                       System.out.println("Press Again");
//                       wrongMove.play();
//                       
//                   } 
//                    
//                    
//                });
                

                // adding the horizental rectangle in the group
                if (i < Row && j<Col-1) {
                    root.getChildren().add(recth[i][j]);
                    
                }

        //----------------------------------------------------------------------------------------------               
        //------------------- Vertical Rectangle--------------------------------------------------------
        //----------------------------------------------------------------------------------------------
        
        
                //creating vertical rectangle 
                rectv[i][j] = new Rectangle(X - (r / 2), Y, r, dis);
                rectv[i][j].setFill(Color.BEIGE);
                rectv[i][j].setEffect(ds1);

                //  setting mouse event for vertical rectangle
                int iv = i;
                int jv = j;
//                rectv[i][j].setOnMouseClicked((MouseEvent event) -> {
//                    
//                     bol=false;
//                   if( rectv[iv][jv].getFill().equals(Color.BEIGE) ) {
//                         try {
//                             MakeRedrectv(iv,jv);
//                         } catch (Exception ex) {
//                             Logger.getLogger(DotsAndBoxes.class.getName()).log(Level.SEVERE, null, ex);
//                         }
//                    rightMove.play();
//                    
//                    
//                   }
//                   else{
//                       System.out.println("Press Again");
//                       wrongMove.play();
//                   } 
//                       
//                    
//                });
      //-------------------------------------------------------------------
                    // adding glow effect
      //--------------------------------------------------------------------
                 
      //--------------------------------------------------------------------------------          

                // adding vertical rectangle in the group
                if (i < Row-1 && j<Col) {
                    
                    root.getChildren().add(rectv[i][j]);
                    
                }
        //----------------------------------------------------------------------
        //--------------------Circle--------------------------------------------
        //----------------------------------------------------------------------
        
        
                // creating circle 
                circle[i][j] = new Circle(X, Y, r, Color.GOLD);
                circle[i][j].setEffect(ds1);

                //adding cercle in the group
                root.getChildren().addAll(circle[i][j]);
                
                
        //-------------------------------------------------------------------------
        //----------------------Label----------------------------------------------
        //-------------------------------------------------------------------------
        
                 //creating a label for every box
               
                
                Random rand = new Random(); 
                Integer value = rand.nextInt(100)+1;
                point[i][j] = new Label(value.toString());
                
                point[i][j].setLayoutX(X+10);
                point[i][j].setLayoutY(Y+15);
                
                
                
                
                rectbox[i][j]=new Rectangle(X +10, Y+15,30,30);
                rectbox[i][j].setFill(Color.BEIGE);
                //adding lebel int the gruop
                if (i < Row-1  && j<Col-1){
                    
                    root.getChildren().add(rectbox[i][j]);
                   // root.getChildren().add(point[i][j]);
                   
                }
                
                
                    
            }
        }
     
        
        Scene scene=new Scene(root,500,400);
        
        player1.setHandler(scene,recth,rectv);  
        
        
        
        stage.setScene(scene);
       // stage.show();       
        
        ReadThread myRead=new ReadThread(player1,player2,ncCon);
        
        new Thread(myRead).start();
        new AnimationTimer() {

            @Override
            public void handle(long l) {
                try {
                    update(player2,l);
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
        
    }
}