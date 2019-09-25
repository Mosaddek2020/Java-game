/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class rules extends Application{

    rules(Stage ss) throws Exception{
        start(ss);
    }
    public void start(Stage stage) throws Exception {
          Pane root=new Pane();
        javafx.scene.image.Image x=new javafx.scene.image.Image("/rules.png");
        
        ImageView xx=new ImageView(x);
        xx.setFitWidth(800);
        xx.setFitHeight(500);
        root.getChildren().add(xx);
        
         Button back =new Button("Menu");
        back.setLayoutX(700);
        back.setLayoutY(400);
        root.getChildren().add(back);
        back.setOnMouseClicked(e->{
            try {
                new menu(stage);
            } catch (Exception ex) {
                Logger.getLogger(Formate1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
        stage.setScene(new Scene(root,800,500));
        
        
        
        
    }
    
    
    
    
}
