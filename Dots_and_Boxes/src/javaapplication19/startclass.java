/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class startclass extends Application {
     
    boolean formateControler ;
    public startclass(Stage ss,boolean b) throws Exception {
        formateControler =b;
        start(ss);
    }

    @Override
    public void start(Stage stage) throws Exception {

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

        // Effect for text
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);
        ds.setOffsetX(3.0);
        ds.setColor(Color.GRAY);

        //text for name of player1
        Text tpalyer1 = new Text();
        tpalyer1.setEffect(ds);
        tpalyer1.setCache(true);
        tpalyer1.setX(300);
        tpalyer1.setY(120);
        tpalyer1.setFill(Color.RED);
        tpalyer1.setFont(Font.font(33));
        tpalyer1.setText("Name of Player 1:");
        
         //textfield for name of player1
        TextField TAplayer1 = new TextField();
        TAplayer1.setLayoutX(300);
        TAplayer1.setLayoutY(140);
        TAplayer1.setPromptText("player1");

        root.getChildren().add(TAplayer1);

       
        root.getChildren().add(tpalyer1);

        //text for name of player2
        Text tpalyer2 = new Text();
        tpalyer2.setEffect(ds);
        tpalyer2.setCache(true);
        tpalyer2.setX(300);
        tpalyer2.setY(200);
        tpalyer2.setFill(Color.RED);
        tpalyer2.setFont(Font.font(33));
        tpalyer2.setText("Name of Player 2:");

        root.getChildren().add(tpalyer2);

       
        
        //textField for player2
        TextField TAplayer2 = new TextField();
        TAplayer2.setLayoutX(300);
        TAplayer2.setLayoutY(220);
        TAplayer2.setPromptText("player2");

        root.getChildren().add(TAplayer2);
        
        

        // text for col number
        Text Tcol = new Text();
        Tcol.setEffect(ds);
        Tcol.setCache(true);
        Tcol.setX(300);
        Tcol.setY(300);
        Tcol.setFill(Color.RED);
        Tcol.setFont(Font.font(20));
        Tcol.setText("Number of Colum");

        root.getChildren().add(Tcol);
        
        //TextField for col number

       TextField TFcol = new TextField();
      TFcol.setLayoutX(300);
       TFcol.setLayoutY(310);
       TFcol.setPrefSize(50, 10);
       TFcol.setPromptText("5");
       root.getChildren().add(TFcol);
       
       
       // text for row number
        Text Trow = new Text();
        Trow.setEffect(ds);
        Trow.setCache(true);
        Trow.setX(300);
        Trow.setY(360);
        Trow.setFill(Color.RED);
        Trow.setFont(Font.font(20));
        Trow.setText("Number of row");

        root.getChildren().add(Trow);
        
        //TextField for row number

       TextField TFrow = new TextField();
       TFrow.setLayoutX(300);
       TFrow.setLayoutY(370);
       TFrow.setPrefSize(50, 10);
       TFrow.setPromptText("5");
       root.getChildren().add(TFrow);
       
       Button btn= new Button("OK");
      btn.setLayoutX(300);
       btn.setLayoutY(400);
       btn.setMinSize(100,30);
       root.getChildren().add(btn);
       
      // Broot.setCenter(root);
       btn.setOnAction(e->{
           
            try {
                int i =Integer.parseInt(TFcol.getText());
                int j=Integer.parseInt(TFrow.getText());
                
                if(formateControler)
                new Formate2(stage,TAplayer1.getText(),TAplayer2.getText(),i,j,formateControler);
                else
                    new Formate1(stage,TAplayer1.getText(),TAplayer2.getText(),i,j,formateControler);
                    
            } catch (Exception ex) {
                Logger.getLogger(startclass.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           
       });
       
       
       
       stage.setScene(new Scene(root,800,500));
       
       
       
       
        
        
        

    }

}
