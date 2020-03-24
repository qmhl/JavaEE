package com.zhangqi.javaee.NIOBIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;

public class BioServer {
    public static void main(String[] args) throws IOException {
        byte[] bs = new byte[1024];
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(9876));
        while (true) {

            System.out.println("等待连接======");
            Socket socket = serverSocket.accept();
            System.out.println("链接成功======");
            socket.getInputStream().read(bs);

            Thread thread = new Thread(new ExcuteSocket(socket));
            thread.start();
        }




    }


    static class  ExcuteSocket implements Runnable{

        private Socket socket;

        public ExcuteSocket(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

        }
    }

}
