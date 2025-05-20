package com.example.weather.network.socket;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    private String host;
    private int port;
    private Socket socket;
    private OutputStream OPS;
    private InputStream IPS;

    public Client(String host,int port){
        this.host = host;
        this.port = port;
    }

    public boolean connect(){
        try{
            this.socket = new Socket(host,port);
            this.IPS = socket.getInputStream();
            this.OPS = socket.getOutputStream();
            return true;
        }catch (IOException e){
            Log.e("Socket",String.format("failed to connect IP:%s port:%d",this.host,this.port));
            return false;
        }
    }
    public boolean close(){
        try{
            this.socket.close();
            IPS.close();
            OPS.close();
            return true;
        }catch (IOException e){
            Log.e("Socket",String.format("failed to close IP:%s port:%d",this.host,this.port));
            return false;
        }
    }

    //发送数据
    public int send(String message){
        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
        try{
            OPS.write(bytes);
        }catch (IOException e){
            Log.e("Socket",String.format("failed to send IP:%s port:%d",this.host,this.port));
        }
        return 1;
    }
 }
