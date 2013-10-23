/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myserver;

import java.io.File;
import java.io.IOException;

/**
 * * @author UTEHN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File iniFile = new File("dwconfig.ini");
        if (!iniFile.exists()) {
            try {
                iniFile.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        Server2 server = new Server2();
        //Thread serverThread = new Thread(server);

        //Client client1 = new Client();
        //Thread clientThread1 = new Thread(client1);
        //serverThread.start();
        //clientThread1.start();
    }
}
