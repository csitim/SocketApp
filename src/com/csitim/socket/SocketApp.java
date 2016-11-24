package com.csitim.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Timea_Csiszar on 11/24/2016.
 */
public class SocketApp {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        Socket clientSocket = serverSocket.accept();

        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("' " + line + " '");
            if (line.equals("")) {
                writer.write("HTTP/1.1 200 Ok\n");
                writer.write("\n");
                writer.write("Hello browser!");
                break;
            }
        }


        writer.close();
        reader.close();
        inputStream.close();
        outputStream.close();
        clientSocket.close();
        serverSocket.close();

    }

}
