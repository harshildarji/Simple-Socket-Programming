package client.server;
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try{
            //Creating object of ServerSocket using 7777 as port number(same as provided in client.java).
            ServerSocket ss = new ServerSocket(7777);
            
            //Invoking accept() method using object of ServerSocket.
            Socket s  = ss.accept();
            
            //Creating object of InputStreamReader to read input from the client.
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            int c,ans=0;
            
            //Reading input untill reached 0(End of Input).
            while((c=in.read()) != 0){
                //Adding numeric value of each input to ans.
                ans=ans+Character.getNumericValue(c);
            }
            
            //Creating object of PrintWriter.
            PrintWriter out = new PrintWriter(s.getOutputStream());
            
            //Using object of PrintWriter to transmit output.
            out.print("Answer: "+ans);
            out.flush();
            
            //Closing the connection.
            in.close();
            out.close();
            s.close();
        }
        catch(IOException e){
            //Printing error(if occurred).
            System.err.println(e);
        }
    }
}