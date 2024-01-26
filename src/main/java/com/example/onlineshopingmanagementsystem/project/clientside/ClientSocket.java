package com.example.onlineshopingmanagementsystem.project.clientside;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

import static com.example.onlineshopingmanagementsystem.project.clientside.ClientGUI.*;

public class ClientSocket {
    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private final ClientGUI clientGUI;

    public ClientSocket(ClientGUI clientGUI) {
        this.clientGUI = clientGUI;
    }

    public void connectToServer() {
        try {
            // Establish a connection to the server on port 6001
            socket = new Socket("localhost", 6001);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());

            // Assume additional initialization if needed
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnectFromServer() {
        try {
            // Close the socket and streams
            if (socket != null) {
                socket.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sendDataToServer(Product data) {
        try {
            // Send data to the server using serialization
            outputStream.writeObject(data);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deleteAllDataOnServer() {
        try {
            // Send the string "DELETE_ALL_DATA" to indicate a delete-all request
            outputStream.writeObject("DELETE_ALL_DATA");
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void submitOrder() {
        try {
            outputStream.writeObject("SUBMIT_ALL_DATA");
            outputStream.flush();
            clientGUI.modal("Operation Successful", "Your order is submitted to server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fetchDataFromServer() {
        try {
            // Send a request to the server for data
            outputStream.writeObject("FETCH_DATA");
            outputStream.flush();

            // Receive an ArrayList<ClientGUI.Product> in response
            Object response = inputStream.readObject();

            if (response instanceof ArrayList<?>) {
                ArrayList<?> receivedData = (ArrayList<?>) response;

                if (!receivedData.isEmpty()) {
                    if (receivedData.getFirst() instanceof Product) {
                        @SuppressWarnings("unchecked")
                        ArrayList<Product> newData = (ArrayList<Product>) receivedData;
                        clientGUI.receiveDataFromServer(newData);
                        clientGUI.modal("Operation Successful", "Data received from server.");
                    } else {
                        System.err.println("Unexpected response format from server. ArrayList should contain ClientGUI.Product objects.");
                    }
                } else {
                    clientGUI.modal("Operation Successful", "Database is empty.");
                    @SuppressWarnings("unchecked")
                    ArrayList<Product> newData = (ArrayList<Product>) receivedData;
                    clientGUI.receiveDataFromServer(newData);
                }
            } else {
                System.err.println("Unexpected response from server: " + response);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle fetch data error (notify user or take appropriate action)
        }

    }



}
