
package javaapplication19;

//import java.awt.Image;
import java.io.File;
import java.time.Duration;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application; 
import static javafx.application.Application.launch; 
import javafx.event.EventHandler;
 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent; 
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Circle; 

import javafx.scene.text.Font; 
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text; 
import javafx.stage.Stage;   
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class First_page extends Application { 
   
    public MediaPlayer mediaplayer;
   public void start(Stage stage) throws Exception {            

        Pane root=new Pane();
        javafx.scene.image.Image x=new javafx.scene.image.Image("/final opening scene.png");
        
        ImageView xx=new ImageView(x);
        xx.setFitWidth(800);
        xx.setFitHeight(500);
        
        
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);
        ds.setOffsetX(3.0);
        ds.setColor(Color.GRAY);
       
        Text t = new Text();
        t.setEffect(ds);
        t.setCache(true);
        t.setX(400);
        t.setY(450);
        t.setFill(Color.RED);
        t.setFont(Font.font(33));
        t.setText("Press ENTER to continue...");

        root.getChildren().add(xx);
        root.getChildren().add(t);
        Scene scene=new Scene(root,800,500);
        
        // sound 
//       String musicFile = "Zedd - Stay the Night.mp3";     // For example
//
//      Media sound = new Media(new File(musicFile).toURI().toString());
//      MediaPlayer mediaPlayer = new MediaPlayer(sound);
//      mediaPlayer.play();


        //background music
        
        
        Media song=new Media("file:///C:/Users/DELL/Documents/NetBeansProjects/JavaApplication19/src/backgroundmusic.mp3");
      
                    mediaplayer =new MediaPlayer(song);
                    mediaplayer.setAutoPlay(true);
                    mediaplayer.setVolume(1);
        
        

        scene.setOnKeyReleased(e->{
          
        //mediaPlayer.play();
        
            
          
                switch (e.getCode()) {
                    case ENTER:
                {
                    
                    try {
                        //new ending(stage);
                        new menu(stage);
                       // new Formateselection(stage);
                       //new  startclass(stage);
                      //new DotsAndBoxes(stage,"a","b",5,5);
                     // new Announcment(stage,"a","b",4,5,"c");
                    } catch (Exception ex) {
                        Logger.getLogger(First_page.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }

                }
            
        });
        
        stage.setScene(scene);
        stage.show();
   }  
   
   
   public static void main(String args[]){          
      launch(args);     
   }  
   
   
}