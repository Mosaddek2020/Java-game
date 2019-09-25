
package javaapplication19;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
 *
 * @author
*/
public class Formate1 extends Application {
    
    
    public  int k=0;
    public  int score1=0,score2=0;
    public  int control = 1;  
    public  boolean bol=false;
    String Name1,Name2,str;
    int Row, Col;
    
    Label Player1_score;
    Label Player2_score;
    Label Anouncment;
  //--------------------------------------------------------------------------------------------------  
  //-------------------------------------------------------------------------------------------------- 
        /* Declaring.... globally
           *a circle array
           *a horizental rectangle array
           *a vertical rectangle array
           *a label array for every Box 
         */
        Circle[][] circle ;
        Rectangle[][] recth;
        Rectangle[][] rectv;
        Rectangle rectbox[][];
        Label point[][] ;
        Stage stage;
        boolean ForCon;
    public Formate1(Stage ss,String p1,String p2,int colno,int rowno,boolean b) throws Exception
    {
        ForCon =b;
        stage =ss;
        Name1 = p1;
        Name2 = p2;
        Col = colno;
        Row = rowno;
        circle = new Circle[Row][Col];
        recth  = new Rectangle[Row][Col];
        rectv = new Rectangle[Row][Col];
        rectbox=new Rectangle[Row][Col];
        point = new Label [Row][Col];
        
        start(ss);
    }
    
    
    
   
        final AudioClip wrongMove = 
            new AudioClip(Formate2.class.getResource("wrong move.mp3").toString());
         final AudioClip rightMove = 
            new AudioClip(Formate2.class.getResource("validMove.mp3").toString());
         final AudioClip boxmade = 
            new AudioClip(Formate2.class.getResource("boxmade.mp3").toString());
    
    
  //----------------------------------------------------------------------------------------------------

    
        
        
   
    public void start(Stage primaryStage) {
        
        Scene scene;

                        
        int X = 30, Y = 30, dis = 50, r = 10;

        Group root = new Group();
        scene = new Scene(root, 800, 500, Color.BEIGE);

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
        
        
        javafx.scene.image.Image x=new javafx.scene.image.Image("/game background.png");
        
        ImageView xx=new ImageView(x);
        xx.setFitWidth(800);
        xx.setFitHeight(500);
        root.getChildren().add(xx);

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
                recth[i][j].setOnMouseClicked((MouseEvent event) -> {
                           bol=false;
                     if( recth[ih][jh].getFill().equals(Color.BEIGE) ){ 
                               try {
                                   MakeRedrecth(ih,jh);
                               } catch (Exception ex) {
                                   Logger.getLogger(Formate2.class.getName()).log(Level.SEVERE, null, ex);
                               }
                           rightMove.play();
                           
                     }
                   
                   else
                   {
                       System.out.println("Press Again");
                       wrongMove.play();
                       
                   } 
                    
                    
                });
                recth[i][j].setOnMouseEntered(e->{
                 if(recth[ih][jh].getFill().equals(Color.BEIGE)) 
                    recth[ih][jh].setEffect(borderGlow);
                    
                
                });
                recth[i][j].setOnMouseExited(e->{
                    recth[ih][jh].setEffect(ds1);
                    
                    
                });

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
                rectv[i][j].setOnMouseClicked((MouseEvent event) -> {
                    
                     bol=false;
                   if( rectv[iv][jv].getFill().equals(Color.BEIGE) ) {
                         try {
                             MakeRedrectv(iv,jv);
                         } catch (Exception ex) {
                             Logger.getLogger(Formate2.class.getName()).log(Level.SEVERE, null, ex);
                         }
                    rightMove.play();
                    
                    
                   }
                   else{
                       System.out.println("Press Again");
                       wrongMove.play();
                   } 
                       
                    
                });
      //-------------------------------------------------------------------
                    // adding glow effect
      //--------------------------------------------------------------------
                 rectv[i][j].setOnMouseEntered(e->{
                   if(rectv[iv][jv].getFill().equals(Color.BEIGE))  
                    rectv[iv][jv].setEffect(borderGlow);
                    
                
                });
                rectv[i][j].setOnMouseExited(e->{
                    rectv[iv][jv].setEffect(ds1);
                    
                    
                });
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
        
      
        
        
       String Player1= Name1+": "+score1;
       String Player2= Name2+": "+score2 ;
       
       Player1_score = new Label (Player1);
       Player1_score.setLayoutX(500);
       Player1_score.setLayoutY(10);
       Player1_score.setFont(Font.font(20));
       Player1_score.setTextFill(Color.RED);
       //Anouncment = new Label( " " );
       
        Player2_score = new Label (Player2);
        Player2_score.setLayoutX(500);
        Player2_score.setLayoutY(30);
        Player2_score.setFont(Font.font(20));
        Player2_score.setTextFill(Color.YELLOW);
        
        Button back =new Button("Menu");
        back.setLayoutX(700);
        back.setLayoutY(250);
        root.getChildren().add(back);
        back.setOnMouseClicked(e->{
            try {
                new menu(stage);
            } catch (Exception ex) {
                Logger.getLogger(Formate1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
        root.getChildren().addAll(Player1_score,Player2_score);
        
         primaryStage.setScene(scene);
        // primaryStage.show();

    }

//    public static void main(String[] args) {
//        launch(args);
//    }

    private void MakeRedrecth(int ih, int jh) throws Exception {
       if( control==1 ) 
        recth[ih][jh].setFill(Color.RED);
       else
           recth[ih][jh].setFill(Color.YELLOW);
           
       // makeBox("X",ih,jh);
        // System.out.println(ih+ " " + jh);
         //MakeRedrectv(ih,jh);
         checkh(ih,jh);
    }
    

    private void MakeRedrectv(int iv, int jv) throws Exception {
       if( control==1 )
        rectv[iv][jv].setFill(Color.RED);
       else
           rectv[iv][jv].setFill(Color.YELLOW);
     // MakeRedrecth(iv,jv);
     checkv(iv,jv);
     
      //  System.out.println(iv +" "+ jv);
    }

    private void checkh(int ih, int jh) throws Exception {
        
        
            if(ih==Row-1){
                
                if( !rectv[ih-1][jh].getFill().equals(Color.BEIGE) && !recth[ih-1][jh].getFill().equals(Color.BEIGE) && !rectv[ih-1][jh+1].getFill().equals(Color.BEIGE)){
                 
                    makeBox("X",ih-1,jh);
                    //System.out.println("hi");
                    if( control==1){
                       
                       score1++;
                    }
                    else
                        score2++;
                
                }
                else{
                    if( control == 1){
                       control=2;   
                    }
                    else
                        control=1;
                } 
            }
                
            else if( ih == 0){
                
                if(!rectv[ih][jh].getFill().equals(Color.BEIGE) && !recth[ih+1][jh].getFill().equals(Color.BEIGE) && !rectv[ih][jh+1].getFill().equals(Color.BEIGE)){
                    makeBox("X",ih,jh);
                      if( control==1)
                        score1++;
                    else
                        score2++;
                      
                    
                    
                }
                else{
                    if( control == 1){
                       control=2;   
                    }
                    else
                        control=1;
                } 
            }
            else{
                
               if( !rectv[ih-1][jh].getFill().equals(Color.BEIGE) && !recth[ih-1][jh].getFill().equals(Color.BEIGE) && !rectv[ih-1][jh+1].getFill().equals(Color.BEIGE)){
                 
                   bol=true;
                    makeBox("X",ih-1,jh);
                    //System.out.println("hi");
                    if( control==1)
                        score1++;
                    else
                        score2++;
                
                }
                if(!rectv[ih][jh].getFill().equals(Color.BEIGE) && !recth[ih+1][jh].getFill().equals(Color.BEIGE) && !rectv[ih][jh+1].getFill().equals(Color.BEIGE)){
                    bol = true;
                    makeBox( "X",ih,jh);
                      if( control==1)
                         score1++;
                      else
                        score2++;
                    
                    
                }
                if( !bol){
                    if( control == 1){
                       control=2;   
                    }
                    else
                        control=1;
                    
                }
               
//                if(!rectv[ih][jh].equals(Color.BEIGE) && !recth[ih+1][jh].equals(Color.BEIGE) && !rectv[ih][jh+1].equals(Color.BEIGE)){
//                    makeBox("X",ih,jh);
//                      if( control==1)
//                        score1++;
//                    else
//                        score2++;
//                    
//                    
//                }
            }
            
            Player1_score.setText(Name1+": "+score1);
            Player2_score.setText(Name2+": "+score2);
            
       
            
    }
    private void checkv(int iv, int jv) throws Exception {
        
        
            if(jv==Col-1){
                
                if( !rectv[iv][jv-1].getFill().equals(Color.BEIGE) && !recth[iv][jv-1].getFill().equals(Color.BEIGE) && !recth[iv+1][jv-1].getFill().equals(Color.BEIGE)){
                    makeBox("X",iv,jv-1);
                       if( control==1){
                           int x=Integer.parseInt(point[iv][jv-1].getText());
                           score1++;
                           System.out.println(x);
                       }
                       else{
                        int x=Integer.parseInt(point[iv][jv-1].getText());
                        score2++;
                        System.out.println(x);
                       }
                }
                else{
                    if( control == 1){
                       control=2;   
                    }
                    else
                        control=1;
                } 
                
            }
                
            else if( jv == 0){
                
                if(!recth[iv][jv].getFill().equals(Color.BEIGE) && !recth[iv+1][jv].getFill().equals(Color.BEIGE) && !rectv[iv][jv+1].getFill().equals(Color.BEIGE)){
                    makeBox("X",iv,jv);
                     if( control==1){
                         int x = Integer.parseInt(point[iv][jv].getText());
                        score1++;
                        System.out.println(x);
                     }
                     else{
                         int x=Integer.parseInt(point[iv][jv].getText());
                        score2++;
                        System.out.println(x);
                     }
                }
                
                else{
                    if( control == 1){
                       control=2;   
                    }
                    else
                        control=1;
                } 
            }
            else{
                 if(!recth[iv][jv].getFill().equals(Color.BEIGE) && !recth[iv+1][jv].getFill().equals(Color.BEIGE) && !rectv[iv][jv+1].getFill().equals(Color.BEIGE)){
                     bol=true;
                     
                     makeBox("X",iv,jv);
                     if( control==1){
                        
                         int x=Integer.parseInt(point[iv][jv].getText());
                         score1++;
                         System.out.println(x);
                     
                     }
                     
                     else{
                         int x = Integer.parseInt(point[iv][jv].getText());
                        score2++;
                        System.out.println(x);
                     }
                }
                 if( !rectv[iv][jv-1].getFill().equals(Color.BEIGE) && !recth[iv][jv-1].getFill().equals(Color.BEIGE) && !recth[iv+1][jv-1].getFill().equals(Color.BEIGE)){
                    
                     bol=true;
                     makeBox("X",iv,jv-1);
                    
                       if( control==1){
                         int x=  Integer.parseInt(point[iv][jv-1].getText());
                        score1++;
                        System.out.println(x);
                       }
                       else{
                        int x= Integer.parseInt(point[iv][jv-1].getText());
                        score2++;
                           System.out.println(x);
                        
                       }
                }
                  if( !bol){
                    if( control == 1){
                       control=2;   
                    }
                    else
                        control=1;
                    
                }
               
            }
             
            Player1_score.setText(Name1+": "+score1);
            Player2_score.setText(Name2+": "+score2);
    }

    private void makeBox(String x, int ih, int jh) throws Exception {
        boxmade.play();
       if( control ==1){
           rectbox[ih][jh].setFill(Color.RED);
       }
       else
           rectbox[ih][jh].setFill(Color.YELLOW);
       k++;
       isEnd();
       
       
    }
    public void isEnd() throws Exception{
        
        Label declaration = new Label();
        
        if( score1> score2){
            str=Name1;
        }
        else if(score1<score2){
            str=Name2;
        }
        else str="Match Drawn";
        
//        declaration.setText(str);
//        declaration.setMinSize(10, 50);
//        declaration.setAlignment(Pos.CENTER);
//        GridPane root=new GridPane();
//        root.setAlignment(Pos.CENTER);
//        root.add(declaration,0,0);
        
       
        
        
        if( k >= (Row-1)*(Col-1)){
           // isEnd();
         
          new Announcment(stage,Name1,Name2,Col,Row,str,ForCon);

            
        }
        
    }
    
//    public static  void main(String args[] ){
//        launch(args);
//    }
    

   

}
