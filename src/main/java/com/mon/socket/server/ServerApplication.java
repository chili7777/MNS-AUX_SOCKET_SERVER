package com.mon.socket.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

@SpringBootApplication
public class ServerApplication
{

    public static void main(String[] args) throws
                                           IOException
    {
        int          port         = 8888;
        ServerSocket serverSocket = new ServerSocket(port);

        while (true)
        {
            System.out.println("Calling server");
            Socket socket = serverSocket.accept();
            new Thread(() -> handleClient(socket)).start();
        }
    }

    private static void handleClient(Socket socket)
    {
        try
        {
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(),
                    true
            );
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String request;
            while ((request = in.readLine()) != null)
            {
                String response = processRequest(request);
                out.println(response);
            }

            out.close();
            in.close();
            socket.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String processRequest(String request)
    {
        return "Server response: " + request.toUpperCase();
    }

}