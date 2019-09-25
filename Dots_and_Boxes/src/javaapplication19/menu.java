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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import onlineGaming.Server;

/**
 *
 * @author Mosaddeklul Islam
 */
public class menu extends Application {
     
    public menu(Stage stage) throws Exception{
        start(stage);
        
    }
  
    public void start(Stage stage) throws Exception {
        
         final AudioClip cursormove = 
            new AudioClip(Formate2.class.getResource("whistle.mp3").toString());
        
        DropShadow borderGlow= new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.RED);
        borderGlow.setWidth(80);
        borderGlow.setHeight(80);
        
        Pane root=new Pane();
        javafx.scene.image.Image x=new javafx.scene.image.Image("/game background.png");
        
        ImageView xx=new ImageView(x);
        xx.setFitWidth(800);
        xx.setFitHeight(500);
        
        javafx.scene.image.Image x1=new javafx.scene.image.Image("/start.png");
        
        ImageView xx1=new ImageView(x1);
        xx1.setLayoutX(340);
        xx1.setLayoutY(80);
        xx1.setFitWidth(130);
        xx1.setFitHeight(70);
        
        
        
        
        javafx.scene.image.Image x2=new javafx.scene.image.Image("/high score.png");
        
        ImageView xx2=new ImageView(x2);
        xx2.setLayoutX(280);
        xx2.setLayoutY(170);
        xx2.setFitWidth(260);
        xx2.setFitHeight(70);
        
        javafx.scene.image.Image x3=new javafx.scene.image.Image("/help.png");
        
        ImageView xx3=new ImageView(x3);
        xx3.setLayoutX(340);
        xx3.setLayoutY(260);
        xx3.setFitWidth(130);
        xx3.setFitHeight(70);
        
         javafx.scene.image.Image x4=new javafx.scene.image.Image("/exit.png");
        
        ImageView xx4=new ImageView(x4);
        xx4.setLayoutX(340);
        xx4.setLayoutY(350);
        xx4.setFitWidth(130);
        xx4.setFitHeight(70);
        
        
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);
        ds.setOffsetX(3.0);
        ds.setColor(Color.GRAY);
       
//        Text t = new Text();
//        t.setEffect(ds);
//        t.setCache(true);
//        t.setX(400);
//        t.setY(450);
//        t.setFill(Color.RED);
//        t.setFont(Font.font(33));
//        t.setText("Press ENTER to continue...");

        root.getChildren().add(xx);
        root.getChildren().add(xx1);
        root.getChildren().add(xx2);
        root.getChildren().add(xx3);
        root.getChildren().add(xx4);
        Scene scene=new Scene(root,800,500);
        
      
         xx1.setOnMouseClicked(e->{
            try { 
                
                new Formateselection(stage);
               
            } catch (Exception ex) {
                Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
         
         xx1.setOnMouseEntered(e->{
             
        
        xx1.setEffect(borderGlow);
        xx1.setCursor(Cursor.HAND);
        cursormove.play();
        
             
         });
         xx1.setOnMouseExited(e->{
            
             xx1.setEffect(ds);
         
         });
         xx4.setOnMouseEntered(e->{
             
        
        xx4.setEffect(borderGlow);
        xx4.setCursor(Cursor.HAND);
        cursormove.play();
        
             
         });
         xx4.setOnMouseExited(e->{
            
             xx4.setEffect(ds);
         
         });
         
         xx4.setOnMouseClicked(e->{
             
             exit(1);
         });
         xx3.setOnMouseEntered(e->{
             
        
        xx3.setEffect(borderGlow);
        xx3.setCursor(Cursor.HAND);
        cursormove.play();
             
         });
         xx3.setOnMouseExited(e->{
            
             xx3.setEffect(ds);
         
         });
         xx3.setOnMouseClicked(e->{
         
             try {
                 new rules(stage);
             } catch (Exception ex) {
                 Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
             }
         
         });
         
         xx2.setOnMouseEntered(e->{
             
        
        xx2.setEffect(borderGlow);
        xx2.setCursor(Cursor.HAND);
        cursormove.play();
        
             
         });
         xx2.setOnMouseExited(e->{
            
             xx2.setEffect(ds);
         
         });
           
         xx2.setOnMouseClicked(e->{
             
            
             
         });
        
        
        stage.setScene(scene);
        
   }  
        
        
        
    }
    
    

