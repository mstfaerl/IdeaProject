/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.staj;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiBcmPin;
import com.pi4j.io.gpio.RaspiGpioProvider;
import com.pi4j.io.gpio.RaspiPinNumberingScheme;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import jssc.SerialPortList;

/**
 *
 * @author m07er
 */
public class PortScannerFrame extends javax.swing.JFrame implements SerialPortEventListener {

    SerialPort serialPort;

    final GpioController gpio = GpioFactory.getInstance();
    final GpioPinDigitalOutput pin18 = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_18, PinState.LOW);
    final GpioPinDigitalOutput pin23 = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_23, PinState.LOW);
    final GpioPinDigitalOutput pin24 = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_24, PinState.LOW);

    /**
     * Creates new form PortScannerFrame
     */
    public PortScannerFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        portList();
        //Aktif veya pasif durumları setEnable false ise disable true ise enable
        sendingButton.setEnabled(false);
        DisconnectButton.setEnabled(false);
        incomingText.setEditable(false);
        sendingText.setEnabled(false);
        this.setTitle("Ardunio");
        //Kapatırken emin misin Evet ise portların bsğlantısını kes ve sistemden çık
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(rootPane,
                        "Are you sure you want to close this window?", "Close Window?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    DisconnectButton.getAction();
                    System.exit(0);
                }
            }
        });
        //Hayır ise hiçbir şey yapma
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        if (ComportCombobox.getItemCount() == 0) {
            ConnectButton.setEnabled(false);
        }
    }

    public void portList() {
        String[] serialPortNames = SerialPortList.getPortNames();
        for (String name : serialPortNames) {
            ComportCombobox.addItem(name);
        }
    }

    public void temizle() {
        sendingText.setText(null);
        incomingText.setText(null);
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {
        try {
            String receivedDatas = serialPort.readString();
            incomingText.append(receivedDatas);
        } catch (SerialPortException ex) {
            JOptionPane.showMessageDialog(this, "Data can not reading!");
        } catch (NullPointerException npex) {
            JOptionPane.showMessageDialog(this, "Data can not reading!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Data can not reading!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComportCombobox = new javax.swing.JComboBox<>();
        ConnectButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        incomingText = new javax.swing.JTextArea();
        BaudRateCombobox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DisconnectButton = new javax.swing.JButton();
        sendingText = new javax.swing.JTextField();
        sendingButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ScanButton = new javax.swing.JButton();
        chooseButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        choosenFile = new javax.swing.JTextArea();
        gpio18Button = new javax.swing.JButton();
        gpio23Button = new javax.swing.JButton();
        gpio24Button = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ComportCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComportComboboxActionPerformed(evt);
            }
        });

        ConnectButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ConnectButton.setText("Connect");
        ConnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectButtonActionPerformed(evt);
            }
        });

        incomingText.setColumns(20);
        incomingText.setRows(5);
        jScrollPane1.setViewportView(incomingText);

        BaudRateCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "9600", "115200" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Select Port");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Baud Rate");

        DisconnectButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        DisconnectButton.setText("Disconnect");
        DisconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisconnectButtonActionPerformed(evt);
            }
        });

        sendingButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        sendingButton.setText("Send");
        sendingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendingButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Data to Send");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Incoming Data");

        ScanButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ScanButton.setText("Scan Port");
        ScanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScanButtonActionPerformed(evt);
            }
        });

        chooseButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        chooseButton.setText("Choose File");
        chooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseButtonActionPerformed(evt);
            }
        });

        choosenFile.setColumns(20);
        choosenFile.setRows(5);
        jScrollPane2.setViewportView(choosenFile);

        gpio18Button.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        gpio18Button.setText("High");
        gpio18Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gpio18ButtonActionPerformed(evt);
            }
        });

        gpio23Button.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        gpio23Button.setText("High");
        gpio23Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gpio23ButtonActionPerformed(evt);
            }
        });

        gpio24Button.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        gpio24Button.setText("High");
        gpio24Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gpio24ButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("GPIO18");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("GPIO23");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("GPIO24");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ComportCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addComponent(ScanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(gpio18Button, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 168, Short.MAX_VALUE)
                                        .addComponent(ConnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(177, 177, 177))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(BaudRateCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(DisconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(gpio24Button, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(gpio23Button, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sendingText)
                        .addGap(18, 18, 18)
                        .addComponent(sendingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(chooseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComportCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gpio18Button, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ConnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gpio23Button, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BaudRateCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DisconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gpio24Button, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chooseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendingText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComportComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComportComboboxActionPerformed

    }//GEN-LAST:event_ComportComboboxActionPerformed

    private void ConnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectButtonActionPerformed
        // TODO add your handling code here:
        try {
            //Serial port adını ComboBox dan seçiyoruz.
            serialPort = new SerialPort(ComportCombobox.getSelectedItem().toString());
            serialPort.openPort();  // Portu Aç
            serialPort.addEventListener(this);
            //Port ile bağlantı sağlanmışsa buton durumlarını güncelle
            if (serialPort.isOpened()) {
                ComportCombobox.setEnabled(false);
                sendingButton.setEnabled(true);
                ConnectButton.setEnabled(false);
                DisconnectButton.setEnabled(true);
                BaudRateCombobox.setEnabled(false);
                ScanButton.setEnabled(false);
                sendingText.setEnabled(true);
                JOptionPane.showMessageDialog(this, "Connected to port!");
            }

        } catch (SerialPortException ex) {
            JOptionPane.showMessageDialog(this, "Port is busy!");
        } catch (NullPointerException npex) {
            JOptionPane.showMessageDialog(this, "Port is busy!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Port is busy!");
        }
        try {
            if (BaudRateCombobox.getSelectedItem().toString().equals("9600")) {
                serialPort.setParams(serialPort.BAUDRATE_9600, 8, 1, 0); // 9600 Baud, 8 bit veri, 1 bit stop biti, Parity biti  (*********) 
            }
            if (BaudRateCombobox.getSelectedItem().toString().equals("115200")) {
                serialPort.setParams(serialPort.BAUDRATE_115200, 8, 1, 0);
            }

        } catch (SerialPortException ex) {
            JOptionPane.showMessageDialog(this, "Port not opened!");
        } catch (NullPointerException npex) {
            JOptionPane.showMessageDialog(this, "Port not opened!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Port not opened!");
        }
        temizle();


    }//GEN-LAST:event_ConnectButtonActionPerformed

    private void DisconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisconnectButtonActionPerformed
        // TODO add your handling code here:  
        try {
            serialPort.closePort();  // Portu Kapat
            //Port eğer bağlı değilse buton durumlarını güncelle
            if (!serialPort.isOpened()) {
                ComportCombobox.setEnabled(true);
                sendingButton.setEnabled(false);
                ConnectButton.setEnabled(true);
                DisconnectButton.setEnabled(false);
                BaudRateCombobox.setEnabled(true);
                ScanButton.setEnabled(true);
                sendingText.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Disconnected to port!");
            }

        } catch (SerialPortException ex) {
            JOptionPane.showMessageDialog(this, "Port already closed!");
        } catch (NullPointerException npex) {
            JOptionPane.showMessageDialog(this, "Port already closed!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Port already closed!");
        }
        temizle();

    }//GEN-LAST:event_DisconnectButtonActionPerformed

    private void sendingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendingButtonActionPerformed
        // TODO add your handling code here:       
        try {
            serialPort.writeString(sendingText.getText());
        } catch (SerialPortException ex) {
            JOptionPane.showMessageDialog(this, "Please open port!");
        } catch (NullPointerException npex) {
            JOptionPane.showMessageDialog(this, "Please open port!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please open port!");
        }
        sendingText.setText(null);
    }//GEN-LAST:event_sendingButtonActionPerformed

    private void ScanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScanButtonActionPerformed
        // TODO add your handling code here:
        ComportCombobox.removeAllItems();
        portList();
        JOptionPane.showMessageDialog(this, "Port scanned!");
        if (ComportCombobox.getItemCount() != 0) {
            ConnectButton.setEnabled(true);
        } else {
            ConnectButton.setEnabled(false);
        }
    }//GEN-LAST:event_ScanButtonActionPerformed

    private void chooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(f));
            choosenFile.read(reader, null);
            choosenFile.requestFocus();
//            while(reader.readLine() != null){
//            System.out.println(reader.readLine());
//            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_chooseButtonActionPerformed

    private void gpio18ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gpio18ButtonActionPerformed
        // TODO add your handling code here:
        if (pin18.isLow()) {
            pin18.high();
            gpio18Button.setText("Low");
        } else {
            pin18.low();
            gpio18Button.setText("High");
        }
    }//GEN-LAST:event_gpio18ButtonActionPerformed

    private void gpio23ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gpio23ButtonActionPerformed
        // TODO add your handling code here:
        if (pin23.isLow()) {
            pin23.high();
            gpio23Button.setText("Low");
        } else {
            pin23.low();
            gpio23Button.setText("High");
        }
    }//GEN-LAST:event_gpio23ButtonActionPerformed

    private void gpio24ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gpio24ButtonActionPerformed
        // TODO add your handling code here:
        if (pin24.isLow()) {
            pin24.high();
            gpio24Button.setText("Low");
        } else {
            pin24.low();
            gpio24Button.setText("High");
        }
    }//GEN-LAST:event_gpio24ButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PortScannerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PortScannerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PortScannerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PortScannerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PortScannerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BaudRateCombobox;
    private javax.swing.JComboBox<String> ComportCombobox;
    private javax.swing.JButton ConnectButton;
    private javax.swing.JButton DisconnectButton;
    private javax.swing.JButton ScanButton;
    private javax.swing.JButton chooseButton;
    private javax.swing.JTextArea choosenFile;
    private javax.swing.JButton gpio18Button;
    private javax.swing.JButton gpio23Button;
    private javax.swing.JButton gpio24Button;
    private javax.swing.JTextArea incomingText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton sendingButton;
    private javax.swing.JTextField sendingText;
    // End of variables declaration//GEN-END:variables

}
