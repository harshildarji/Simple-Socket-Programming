package client.server;
import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("127.0.0.1",7777);
            PrintStream out = new PrintStream(s.getOutputStream());
            out.print("1");
	    out.print("3");
            out.write(0);
            out.flush();
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            int c;
            while((c = in.read()) != -1){
                System.out.print((char)c);
            }
            System.out.println("");
            s.close();
        }
        catch(IOException e){
            System.err.println(e);
        }
    } 
}