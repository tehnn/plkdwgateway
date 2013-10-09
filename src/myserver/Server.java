
package myserver;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author UTEHN
 */
public class Server extends JFrame implements Runnable {
    //Text Area for displaying connection information

    private JTextArea cli = new JTextArea();
    int PORT = 2000;

    

    public void run() {
        setLayout(new BorderLayout());
        //DefaultCaret caret = (DefaultCaret) cli.getCaret();
        //caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        add(new JScrollPane(cli), BorderLayout.CENTER);

        setTitle("Server port "+PORT);
        setSize(580, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        try {
            //Creating server socket
            //ServerSocket serverSocket = new ServerSocket(PORT);
            ServerSocket serverSocket=new ServerSocket(PORT, 1,InetAddress.getByName("0.0.0.0"));
            cli.append(new Date() + ": Hosting on port " + PORT + " started.\n");
            cli.setCaretPosition(cli.getDocument().getLength());


            while (true) {
                //Listen for new connections
                Socket socket = serverSocket.accept();

                //when a client connects, gather information and print to cli
                InetAddress inetAddress = socket.getInetAddress();
                cli.append(new Date() + ": Connection made from " + inetAddress.getHostAddress() + '\n');
                cli.setCaretPosition(cli.getDocument().getLength());

                //handle client in new thread
                ClientHandler handle = new ClientHandler(socket);
                Thread newThread = new Thread(handle);
                newThread.start();
            }
        } catch (IOException exception) {
            cli.append(new Date() + ": Err0" + exception.toString() + '\n');
            cli.setCaretPosition(cli.getDocument().getLength());

        }
    }

    class ClientHandler implements Runnable {

        private Socket _socket;
        //construct the thread

        public ClientHandler(Socket socket) {
            this._socket = socket;
        }
        //launch the thread

        public void run() {
            try {
                //create Input/Output Streams
                DataInputStream input = new DataInputStream(_socket.getInputStream());
                DataOutputStream output = new DataOutputStream(_socket.getOutputStream());
                String instring;
                //launch an infinite loop to handle the client
                while (true) {
                    try {
                        //listens for any incoming communication and appends it to the cli
                        instring = input.readLine().toString();
                        cli.append(new Date() + ": From Client->" + instring.toString() + '\n');
                        cli.setCaretPosition(cli.getDocument().getLength());
                        //now sending a message back to client to confirm that the string was received
                        output.writeBytes("From Server: " + new Date() + "-" + instring + '\n');
                        //cli.append("Receipt sent \n");
                    } catch (IOException e) {
                        cli.append(new Date() + ": Err1" + e.toString() + '\n');
                        cli.setCaretPosition(cli.getDocument().getLength());
                        break;
                    }

                }
                output.flush();
                output.close();
                this._socket.close();

            } catch (IOException e) {
                cli.append(new Date() + ": Err2" + e.toString() + '\n');
                cli.setCaretPosition(cli.getDocument().getLength());
                //return;
            }
        }
    }
}
