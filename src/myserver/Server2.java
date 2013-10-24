package myserver;

import UTEHN.SimpleMySQL;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.ini4j.Ini;

/**
 *
 * @author Administrator
 */
public class Server2 extends javax.swing.JFrame implements Runnable {

    String HOST, USER, PASS, DB;

    private int PORT = 2000;
    String instring = "";
    int client_id = 0;
    int count = 0;
    String data_input;

    public Server2() {
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">

        /*
         try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
         if ("Nimbus".equals(info.getName())) {
         javax.swing.UIManager.setLookAndFeel(info.getClassName());
         break;
         }
         }
         } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(Server2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(Server2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(Server2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(Server2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         //</editor-fold>
         * */
    }//end constructor

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popmnu = new javax.swing.JPopupMenu();
        mnuClear = new javax.swing.JMenuItem();
        btnStart = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCountClient = new javax.swing.JLabel();
        txtCountClient1 = new javax.swing.JLabel();
        lbConTo = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cli = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        evt_log = new javax.swing.JTextArea();
        txtPort = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        lbIp = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        mnuClear.setLabel("Clear...");
        mnuClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuClearActionPerformed(evt);
            }
        });
        popmnu.add(mnuClear);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PLK DW Gateway 1.0");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        btnStart.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnStart.setForeground(new java.awt.Color(0, 153, 64));
        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(6, 215, 53));
        jLabel1.setText(" PORT : ");

        jPanel1.setBackground(new java.awt.Color(115, 115, 115));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("  PLK DW Gateway 1.0");

        txtCountClient.setBackground(new java.awt.Color(255, 255, 255));
        txtCountClient.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtCountClient.setForeground(new java.awt.Color(0, 255, 0));
        txtCountClient.setText("0");
        txtCountClient.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txtCountClient1.setBackground(new java.awt.Color(255, 255, 255));
        txtCountClient1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtCountClient1.setForeground(new java.awt.Color(255, 255, 225));
        txtCountClient1.setText("Client:");
        txtCountClient1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lbConTo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbConTo.setForeground(new java.awt.Color(255, 200, 0));
        lbConTo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbConTo.setText("[DB:192.168.5.1]");
        lbConTo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbConToMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lbConTo, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCountClient1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCountClient)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCountClient)
                    .addComponent(txtCountClient1)
                    .addComponent(lbConTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cli.setColumns(20);
        cli.setLineWrap(true);
        cli.setRows(5);
        cli.setWrapStyleWord(true);
        cli.setComponentPopupMenu(popmnu);
        jScrollPane2.setViewportView(cli);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Client", jPanel2);

        evt_log.setColumns(20);
        evt_log.setLineWrap(true);
        evt_log.setRows(5);
        evt_log.setWrapStyleWord(true);
        jScrollPane1.setViewportView(evt_log);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("  Log  ", jPanel3);

        txtPort.setText("2000");

        btnExit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 51, 51));
        btnExit.setText(" Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lbIp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbIp.setForeground(new java.awt.Color(245, 32, 32));
        lbIp.setText("Running on");

        jMenu1.setText("File");

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem1.setText("Database");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbIp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtPort)
                        .addGap(18, 18, 18)
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnStart)
                        .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lbIp)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed

        String port = txtPort.getText().toString().trim();

        if (port.equals("")) {
            return;
        }
        this.PORT = Integer.parseInt(port);

        try {
            new Thread(this).start();

            this.setTitle("Server port " + PORT + " Strated.");

        } catch (Exception e) {
            e.printStackTrace();

        }

    }//GEN-LAST:event_btnStartActionPerformed

    private void mnuClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClearActionPerformed

        cli.setText("");
    }//GEN-LAST:event_mnuClearActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "ออกจากโปรแกรม", "Confirm", dialogButton);
        if (dialogResult == 0) {
           
            System.exit(0);
        }
        
    }//GEN-LAST:event_btnExitActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dlgDatabase d = new dlgDatabase(this, true);
        d.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "ออกจากโปรแกรม", "Confirm", dialogButton);
        if (dialogResult == 0) {
           
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void lbConToMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbConToMouseClicked
        dlgDatabase d = new dlgDatabase(this, true);
        d.setVisible(true);
    }//GEN-LAST:event_lbConToMouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        try {
            Ini ini = new Ini(new File("dwconfig.ini"));
            HOST = ini.get("Connection", "HOST");
            USER = ini.get("Connection", "USER");
            PASS = ini.get("Connection", "PASS");
            DB = ini.get("Connection", "DB");
            lbConTo.setText("[Dw:" + HOST + " , Db:" + DB + "]");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_formWindowGainedFocus

    public void run() {
        try {

            //ServerSocket serverSocket = new ServerSocket(PORT);
            ServerSocket serverSocket = new ServerSocket(PORT, 1, InetAddress.getByName("0.0.0.0"));
            evt_log.append(new Date() + ": Listening on port " + PORT + "\n");
            evt_log.setCaretPosition(evt_log.getDocument().getLength());

            btnStart.setEnabled(false);
            txtPort.setEditable(false);
            while (true) {
                //*Listen for new connections
                Socket socketServ = serverSocket.accept();

                //*handle client in new thread
                ClientHandler handle = new ClientHandler(socketServ, client_id++);
                Thread newThread = new Thread(handle);
                newThread.start();
            }
        } catch (Exception exception) {

            this.setTitle("Server port " + PORT + " " + exception.getMessage());
            evt_log.append(new Date() + ": Err 0 " + exception.toString() + '\n');
            evt_log.setCaretPosition(evt_log.getDocument().getLength());

        }
    }// end main run

    class ClientHandler implements Runnable {

        private Socket client_socket;
        int clientID = -1;
        boolean running = true;
        BufferedReader brinp = null;
        PrintWriter output = null;

        public ClientHandler(Socket socket, int i) {
            this.client_socket = socket;
            clientID = i;
            count = count + 1;
        }

        public void run() {

            SimpleMySQL mysql = new SimpleMySQL();
            mysql.connect("localhost:3307", "sa", "sa", "plkdwdc", "tis620");

            txtCountClient.setText(String.valueOf(count));

            String d = new Date().toString();
            evt_log.append(new Date() + ":" + clientID + "-Connection from: " + client_socket + '\n');
            evt_log.setCaretPosition(evt_log.getDocument().getLength());

            try {

                brinp = new BufferedReader(new InputStreamReader(client_socket.getInputStream(), Charset.forName("TIS-620")));
                //DataOutputStream output = new DataOutputStream(_socket.getOutputStream());
                output = new PrintWriter(new OutputStreamWriter(client_socket.getOutputStream()), true);//*
                output.println("person,patient");

                while (running) {//*infinite loop to handle the client

                    try {

                        instring = brinp.readLine();
                        //instring = instring.trim().replace("\n", "NNNN").replace("\r", "RRRR");
                        try {
                            instring = instring.substring(1);
                            instring = instring.substring(0, instring.length() - 1);
                        } catch (Exception e) {
                        }
                        //cli.setText("[" + clientID + "]" + instring + "\n");

                        mysql.query("insert ignore into pp (text) values ('" + instring + "')");

                        output.println("0");

                        if (output.checkError()) {
                            throw new IOException("Error transmitting data.");
                        }

                    } catch (IOException e) {
                        evt_log.append(new Date() + ": Err 1 " + e.toString() + " - " + client_socket + "\n");
                        evt_log.setCaretPosition(evt_log.getDocument().getLength());
                        count = count - 1;
                        txtCountClient.setText(String.valueOf(count));
                        if (count <= 0) {

                            evt_log.append(new Date() + ": No client connection." + '\n');
                            client_id = 0;
                        }
                        break;

                    }

                }

            } catch (IOException e) {
                evt_log.append(new Date() + ": Err 2 " + e.toString() + '\n');
                evt_log.setCaretPosition(evt_log.getDocument().getLength());

            }
            mysql.close();
        } //end child run
    }// Runable Class
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnStart;
    private javax.swing.JTextArea cli;
    private javax.swing.JTextArea evt_log;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbConTo;
    private javax.swing.JLabel lbIp;
    private javax.swing.JMenuItem mnuClear;
    private javax.swing.JPopupMenu popmnu;
    private javax.swing.JLabel txtCountClient;
    private javax.swing.JLabel txtCountClient1;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables
}// end Program

