package com.example.jdbc.Server;

import com.example.jdbc.Action;
import com.example.jdbc.Client;
import com.example.jdbc.Server.repo.ShopRepository;
import com.example.jdbc.Server.entity.Shop;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        serverSocket = new ServerSocket(8000);
        System.out.println("Server is ready");
        ShopRepository shopRepository = new ShopRepository();
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println(clientSocket);

            new Thread(new Handler(clientSocket, shopRepository)).start();
        }
    }
}

class Handler implements Runnable {

    private final Client client;
    private ShopRepository shopRepository;

    public Handler(Socket clientSocket, ShopRepository shopRepository) {
        client = new Client(clientSocket);
        this.shopRepository = shopRepository;
    }

    @Override
    public void run() {
        boolean flag = true;
        while (flag){
            Action action = (Action) client.readObject();
            switch (action){
                case READ:{
                    List<Shop> shops = shopRepository.getAll();
                    client.writeObject(shops);
                    break;
                }
                case ADD: {
                    shopRepository.addNewShop((Shop)client.readObject());
                    break;
                }
                case DELETE: {
                    shopRepository.deleteById((Integer)client.readObject());
                    break;
                }
                case UPDATE: {
                    shopRepository.updateShop((Shop)client.readObject());
                    break;
                }
                case EXIT: {
                    client.disConnect();
                    flag = false;
                    break;
                }
            }
        }
    }
}
