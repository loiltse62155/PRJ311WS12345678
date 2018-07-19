/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws5;

import javax.swing.*;
import java.io.*;
import java.net.*;

/**
 *
 * @author Stagit
 */
public class OutputThread extends Thread {
    Socket socket;
    JTextArea txt;
    BufferedReader br;
    String sender;
    String receiver;

    public OutputThread(Socket socket, JTextArea txt, String sender, String receiver) {
        super();
        this.socket = socket;
        this.txt = txt;
        this.sender = sender;
        this.receiver = receiver;
        
        try {
            br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrongs with your network");
            System.exit(0);
        }
    }
    
    @Override
    public void run() {
        while(true) {
            try {
                if(socket != null ){
                    String msg = "";
                    if((msg = br.readLine()) != null && msg.length() > 0 ) {
                        txt.append("\n"+receiver+": "+msg);
                    }
                   sleep(1000);
                }
            } catch (Exception e) {
            }
        }
    }
    
    
    
    
}
