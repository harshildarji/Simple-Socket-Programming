package client.server;
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(7777);
            Socket s  = ss.accept();
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            int c,ans=0;
            while((c=in.read()) != 0){
                ans=ans+Character.getNumericValue(c);
            }
            PrintWriter out = new PrintWriter(s.getOutputStream());
            out.print("Answer: "+ans);
            out.flush();
            s.close();
        }
        catch(IOException e){
            System.err.println(e);
        }
    }
}