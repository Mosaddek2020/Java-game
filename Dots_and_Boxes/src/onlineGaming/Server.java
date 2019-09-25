/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineGaming;

import java.net.ServerSocket;
import java.net.Socket;
import static javafx.application.Application.launch;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import util.ConnectionUtillities;

/**
 *
 * @author user
 */
public class Server extends Main{
    
     public void CreateConnection(){
        try{
            ServerSocket serve=new ServerSocket(12345);
            Socket sock=serve.accept();
            ncCon=new ConnectionUtillities(sock);        
        }
        catch(Exception e){

        }
        isMyTurn=true;
        //this.launch(args);
        l =new Label("Server");
        l.setLayoutX(20);
        l.setLayoutY(5);
       
        
        
    }     
    
    public static void main(String[] args) {
        
          //Server server=new Server();
          //server.CreateConnection(args);        
        launch(args);
    }
   
     
     
}
