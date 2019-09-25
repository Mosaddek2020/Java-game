/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class playerVsComputer extends Application {
    int Col=5,Row=5;
    
    Rectangle[][] recth = new Rectangle[Row][Col];
    Rectangle [][] rectv = new Rectangle[Row][Col];
    Circle[][] circle = new Circle[Row][Col];
    
    
    
    

    
    public void start(Stage primaryStage) throws Exception {
        
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 700, Color.BEIGE);
        
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
        
        
        javafx.scene.image.Image pic=new javafx.scene.image.Image("/game background.png");
        
        ImageView xx=new ImageView(pic);
        xx.setFitWidth(1000);
        xx.setFitHeight(700);
        root.getChildren().add(xx);
        
        
        
        int dis = 500/Col,r=dis/10;
        
        int X = 100,Y =100;
        int y=Y;
        for( int i=0; i< Row; i++){
            int x=X;
            y+=dis;
            for( int j=0; j< Col ;j++){
                
                recth[i][j] = new Rectangle(x,y,r/2,dis);
                rectv[i][j] = new Rectangle(x,y,dis,r/2);
                circle[i][j] = new Circle(x, y, r,Color.KHAKI);
                x+=dis;
                root.getChildren().addAll(recth[i][j],rectv[i][j],circle[i][j]);
               
                
            }
        }
        
        
        
        
        
         

        
        
        
        
        
        
        
        
        
        
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
    public static void main(String [] args){
        
        launch(args);
    } 
    
    
    
    
    
}
