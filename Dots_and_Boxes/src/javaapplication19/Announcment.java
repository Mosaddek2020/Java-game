/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;

import static java.lang.System.exit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class Announcment extends Application {
    
    String p1,p2,winner;
    int col,row;
    boolean ForCon;
    Announcment( Stage ss,String name1,String name2,int x,int y,String p,boolean b) throws Exception{
        ForCon = b;
        p1 = name1;
        p2 = name2;
        winner = p;
        col = x;
        row = y;
        start(ss);
        
    }
    
    public void start(Stage stage) throws Exception {
        //glow effect
        DropShadow borderGlow= new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.RED);
        borderGlow.setWidth(80);
        borderGlow.setHeight(80);
        
        //show effect
        
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);
        ds.setOffsetX(3.0);
        ds.setColor(Color.GRAY);
        
        
        
        
        
            
        Group root = new Group();
        //root.setAlignment(Pos.CENTER);
        //VBox root =new VBox();
       // root.setPadding(new Insets(5, 5, 5, 5));

        // setting background image
        javafx.scene.image.Image x1 = new javafx.scene.image.Image("/Board.png");
        ImageView xx1 = new ImageView(x1);
        xx1.setFitWidth(800);
        xx1.setFitHeight(500);
       // root.backgroundProperty();
        root.getChildren().add(xx1);
        
         Text t = new Text();
       // t.setEffect(ds);
        t.setCache(true);
        t.setX(300);
        t.setY(250);
        t.setFill(Color.RED);
        t.setFont(Font.font(50));
        t.setText(winner + " Has won" );
        root.getChildren().add(t);
        
        Button btnnewgame = new Button(" New Game");
        btnnewgame.setLayoutX(300);
        btnnewgame.setLayoutY(350);
        btnnewgame.setMinSize(80,20);
        root.getChildren().add(btnnewgame);
        
        
         btnnewgame.setOnMouseEntered(e->{
             
        
        btnnewgame.setEffect(borderGlow);
        btnnewgame.setCursor(Cursor.HAND);
        
        
             
         });
          btnnewgame.setOnMouseExited(e->{
            
              btnnewgame.setEffect(ds);
         
         });
        
        
        
        
        btnnewgame.setOnMouseClicked(e->{
            try {
                new Formateselection(stage);
            } catch (Exception ex) {
                Logger.getLogger(Announcment.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
        
        Button btnplayagin = new Button (" Play Again");
        btnplayagin.setLayoutX(400);
        btnplayagin.setLayoutY(350);
        btnplayagin.setMinSize(80,20);
        root.getChildren().add(btnplayagin);
        
         btnplayagin.setOnMouseEntered(e->{
             
        
         btnplayagin.setEffect(borderGlow);
        btnplayagin.setCursor(Cursor.HAND);
        
        
             
         });
           btnplayagin.setOnMouseExited(e->{
            
              btnplayagin.setEffect(ds);
         
         });
        
        
         
        
        btnplayagin.setOnMouseClicked(e->{
            
            try {
              if(ForCon )  
                new Formate2(stage,p1,p2,col,row,ForCon);
              else
                  new Formate1(stage,p1,p2,col,row,ForCon);
                  
            } catch (Exception ex) {
                Logger.getLogger(Announcment.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
        
        Button btnexit = new Button (" Exit ");
        btnexit.setLayoutX(500);
        btnexit.setLayoutY(350);
        btnexit.setMinSize(80,20);
        root.getChildren().add(btnexit);
        
        
         btnexit.setOnMouseEntered(e->{
             
        
         btnexit.setEffect(borderGlow);
       btnexit.setCursor(Cursor.HAND);
        
        
             
         });
          btnexit.setOnMouseExited(e->{
            
             btnexit.setEffect(ds);
         
         });
        
         
        
        btnexit.setOnMouseClicked(e->{
            exit(1);
            
        });
        
        stage.setScene(new Scene(root,800,500));
        
        
        
        
        
    }
    
    
    
    
}
