package client.server;
import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try{
            //Creating object of Socket class using 127.0.0.1 as IP Address and 7777 as port number.
            Socket s = new Socket("127.0.0.1",7777);
            
            //Creating object of PrintStream class.
            PrintStream out = new PrintStream(s.getOutputStream());
            
            //Using object of PrintStream to transmit input.
            out.print("1");
	        out.print("3");
            
            //Appending 0 to notify end of string/input.
            out.write(0);                   
            out.flush();
            
            //Creating object of InputStreamReader to accept data from server.
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            int c;
            
            //Reading input from the server untill reached -1 (End of input).
            while((c = in.read()) != -1){
                //Printing each input character.
                System.out.print((char)c);
            }
            System.out.println("");
            
            //Closing the connection.
            s.close();
        }
        catch(IOException e){
            //Printing error (if occurred).
            System.err.println(e);
        }
    } 
}