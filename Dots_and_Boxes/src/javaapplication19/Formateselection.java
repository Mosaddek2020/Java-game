/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class Formateselection extends Application{

    public Formateselection(Stage ss) throws Exception {
        start(ss);
    }

    
    
    
    public void start(Stage stage) throws Exception {
        
         final AudioClip cursormove = 
            new AudioClip(Formate2.class.getResource("whistle.mp3").toString());
         //To change body of generated methods, choose Tools | Templates.
         Pane root = new Pane();
          
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);
        ds.setOffsetX(3.0);
        ds.setColor(Color.GRAY);
         
         
        DropShadow borderGlow= new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.RED);
        borderGlow.setWidth(80);
        borderGlow.setHeight(80);
         
         
         javafx.scene.image.Image x=new javafx.scene.image.Image("/game background.png");
        
        ImageView xx=new ImageView(x);
        xx.setFitWidth(800);
        xx.setFitHeight(500);
        root.getChildren().add(xx);
        
        
         javafx.scene.image.Image x2=new javafx.scene.image.Image("/format1.png");
        
        ImageView xx2=new ImageView(x2);
        xx2.setFitWidth(250);
        xx2.setFitHeight(200);
        xx2.setLayoutX(150);
        xx2.setLayoutY(150);
        xx2.setEffect(ds);
        root.getChildren().add(xx2);
        
        
         javafx.scene.image.Image x3=new javafx.scene.image.Image("/format2.png");
        
        ImageView xx3=new ImageView(x3);
        xx3.setFitWidth(250);
        xx3.setFitHeight(200);
        xx3.setLayoutX(450);
        xx3.setLayoutY(150);
        xx3.setEffect(ds);
        root.getChildren().add(xx3);
        
        
         xx2.setOnMouseEntered(e->{
             
        
        xx2.setEffect(borderGlow);
        xx2.setCursor(Cursor.HAND);
        cursormove.play();
        
             
         });
         xx2.setOnMouseExited(e->{
            
             xx2.setEffect(ds);
         
         });
         
         
         xx2.setOnMouseClicked(e->{
             
             try {
                 new startclass(stage, false);
             } catch (Exception ex) {
                 Logger.getLogger(Formateselection.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             
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
                 new startclass(stage, true);
             } catch (Exception ex) {
                 Logger.getLogger(Formateselection.class.getName()).log(Level.SEVERE, null, ex);
             }
             
         });
        
        
        
        
        
        stage.setScene(new Scene(root,800,500));
    }
    
    
}
