package com.example.onlineshopingmanagementsystem.project.clientside;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
        }


    @Override
    public void start(Stage primaryStage) throws Exception {
        // Instantiate the client GUI
        ClientGUI clientGUI = new ClientGUI();

        // Call necessary methods to initialize and start the client
        clientGUI.init();

        // Start the client GUI
        clientGUI.start(primaryStage);

         //Note: If you have a separate ClientSock class, instantiate and start it here.
        //ClientSocket clientSock = new ClientSocket(clientGUI);


    }

}
