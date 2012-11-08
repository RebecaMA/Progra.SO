/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Libreria.*;

import SocketCliente.ClienteSocket;
import javax.swing.JOptionPane;

import SocketCliente.*;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Rebeca
 */
public class PaginaComandos extends javax.swing.JFrame {

    /**
     * Creates new form PaginaComandos
     */
    
    String _nombreUsuario;

    ClienteSocket _socket;
    Boolean _sistemaMontado;
    File _file;
    ManejadorArchivos _manejadorArchivos;
    public PaginaComandos() {
        initComponents();
    }
    
     public PaginaComandos(String pnombreUsuario) {
        initComponents();
        _nombreUsuario = pnombreUsuario;
        LabelNombreUsuario.setText(pnombreUsuario);  
        _socket = new ClienteSocket();
        LabelNombreUsuario.setText(pnombreUsuario);
        BotonFileChooser.setVisible(false);         
        
    }
     


    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LabelNombreUsuario = new javax.swing.JLabel();
        ComboBoxComando = new javax.swing.JComboBox();
        TextFieldCampo1 = new javax.swing.JTextField();
        TextFieldCampo2 = new javax.swing.JTextField();
        TextFieldCampo3 = new javax.swing.JTextField();
        TextFieldCampo4 = new javax.swing.JTextField();
        BotonAceptar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextAreaResultado = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        BufferDatos = new javax.swing.JScrollPane();
        TexTAreaBufferDatos = new javax.swing.JTextArea();
        BotonFileChooser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(70, 50, 0, 0));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Bienvenido ");

        LabelNombreUsuario.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LabelNombreUsuario.setText("Usuario");

        ComboBoxComando.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ComboBoxComando.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "df", "mount", "unmount", "ls", "rm", "open", "read", "write", "repos", "close\t", "cat", "importar", "exportar", "salir", "terminar" }));
        ComboBoxComando.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxComandoItemStateChanged(evt);
            }
        });
        ComboBoxComando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxComandoActionPerformed(evt);
            }
        });

        TextFieldCampo1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextFieldCampo1.setForeground(new java.awt.Color(0, 102, 102));
        TextFieldCampo1.setText("Campo 1");
        TextFieldCampo1.setPreferredSize(new java.awt.Dimension(85, 26));
        TextFieldCampo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldCampo1ActionPerformed(evt);
            }
        });

        TextFieldCampo2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextFieldCampo2.setForeground(new java.awt.Color(0, 102, 102));
        TextFieldCampo2.setText("Campo 2");
        TextFieldCampo2.setPreferredSize(new java.awt.Dimension(85, 26));

        TextFieldCampo3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextFieldCampo3.setForeground(new java.awt.Color(0, 102, 102));
        TextFieldCampo3.setText("Campo 3");
        TextFieldCampo3.setPreferredSize(new java.awt.Dimension(85, 26));

        TextFieldCampo4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextFieldCampo4.setForeground(new java.awt.Color(0, 102, 102));
        TextFieldCampo4.setText("Campo 4");
        TextFieldCampo4.setPreferredSize(new java.awt.Dimension(85, 26));
        TextFieldCampo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldCampo4ActionPerformed(evt);
            }
        });

        BotonAceptar.setBackground(new java.awt.Color(0, 51, 153));
        BotonAceptar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BotonAceptar.setForeground(new java.awt.Color(255, 255, 255));
        BotonAceptar.setText("Aceptar");
        BotonAceptar.setBorder(null);
        BotonAceptar.setBorderPainted(false);
        BotonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAceptarActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        TextAreaResultado.setBackground(new java.awt.Color(204, 204, 204));
        TextAreaResultado.setColumns(20);
        TextAreaResultado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextAreaResultado.setLineWrap(true);
        TextAreaResultado.setRows(5);
        TextAreaResultado.setBorder(null);
        jScrollPane2.setViewportView(TextAreaResultado);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Shell");

        TexTAreaBufferDatos.setColumns(20);
        TexTAreaBufferDatos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TexTAreaBufferDatos.setLineWrap(true);
        TexTAreaBufferDatos.setRows(5);
        BufferDatos.setViewportView(TexTAreaBufferDatos);

        BotonFileChooser.setText("Elegir Archivo");
        BotonFileChooser.setHideActionText(true);
        BotonFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFileChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelNombreUsuario))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BotonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BufferDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ComboBoxComando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextFieldCampo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(BotonFileChooser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldCampo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextFieldCampo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextFieldCampo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(LabelNombreUsuario))
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboBoxComando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextFieldCampo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextFieldCampo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextFieldCampo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextFieldCampo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonFileChooser))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BotonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BufferDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 257, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAceptarActionPerformed
        // TODO add your handling code here:
        // Manda el mensaje al socket
        
        Mensaje mensaje = new Mensaje();
        mensaje.setTipoMensaje(ComboBoxComando.getSelectedItem().toString());
        mensaje.setUsuario(_nombreUsuario);
        int indiceOperacion = ComboBoxComando.getSelectedIndex();
                
        switch(indiceOperacion)
        { 
            case 0: //
            
            break;
            case 1:
                if(TextFieldCampo1.getText().equals("") || TextFieldCampo2.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(this, "Campos en blanco", "Shell", JOptionPane.ERROR_MESSAGE);                    
                }
                else
                {
                    
                }
            break;
            case 2:
                
            break;
            case 3:
                if(TextFieldCampo1.getText().equals(""))
                {
                    //Ejecutar ls normal
                }
                else
                {
                    //ejecutar ls para el archivo especificado
                }
            break;
            case 4: //
                if(TextFieldCampo1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(this, "Campo en blanco", "Shell", JOptionPane.ERROR_MESSAGE);                    
                }
                else
                {
                    
                }
            break;
            case 5: //
                if(TextFieldCampo1.getText().equals("") || TextFieldCampo2.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(this, "Campos en blanco", "Shell", JOptionPane.ERROR_MESSAGE);                    
                }
                else
                {
                    
                }
            break;
            case 6: //
                if(TextFieldCampo1.getText().equals("") || TextFieldCampo2.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(this, "Campos en blanco", "Shell", JOptionPane.ERROR_MESSAGE);                    
                }
                else
                {
                    
                }
            break;
            case 7: //
                if(TextFieldCampo1.getText().equals("") || TextFieldCampo2.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(this, "Campos en blanco", "Shell", JOptionPane.ERROR_MESSAGE);                    
                }
                else
                {
                    
                }
            break;
            case 8: //
                if(TextFieldCampo1.getText().equals("") || TextFieldCampo2.getText().equals("") || TextFieldCampo2.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(this, "Campos en blanco", "Shell", JOptionPane.ERROR_MESSAGE);                    
                }
                else
                {
                    
                }
            break;
            case 9: //
                if(TextFieldCampo1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(this, "Campos en blanco", "Shell", JOptionPane.ERROR_MESSAGE);                    
                }
                else
                {
                    
                }
            break;
            case 10: //
                if(TextFieldCampo1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(this, "Campos en blanco", "Shell", JOptionPane.ERROR_MESSAGE);                    
                }
                else
                {
                    
                }
            break;
            case 11: //
                if(TextFieldCampo1.getText().equals("") || TextFieldCampo2.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(this, "Campos en blanco", "Shell", JOptionPane.ERROR_MESSAGE);                    
                }
                else
                {
                    
                }
            break;
            case 12: //
                if(TextFieldCampo1.getText().equals("") || TextFieldCampo2.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(this, "Campos en blanco", "Shell", JOptionPane.ERROR_MESSAGE);                    
                }
                else
                {
                    
                }
            break;
            case 13: //
           
            break;                
            case 14: //
           
            break;                
        };

        Mensaje _nuevoMensaje = new Mensaje();
        String _mensaje = null;
        _mensaje = ComboBoxComando.getSelectedItem().toString();
        _manejadorArchivos = new ManejadorArchivos();

        if(BotonFileChooser.isVisible()){
            if(_mensaje.equals("Importar")){
               _mensaje += " " + _nombreUsuario;
               _mensaje += " " +TextFieldCampo1.getText();
               _mensaje += " "+  _manejadorArchivos._leerArchivo(_file);
            }else {
            // Enviar q me de lo q escribo escribirlo
                // y despues llamar a 
                _mensaje += " " +TextFieldCampo3.getText();
                // Con eso me devuelve el contenidop en String exportarmensaje
                //_manejadorArchivos._escribirArchivo(_File, exportarmensaje);
                
            }   
        }
        else{
        if(TextFieldCampo1.isVisible())
        {
            _mensaje += " " +TextFieldCampo1.getText();
        }else if(TextFieldCampo2.isVisible())
        {
            _mensaje += " " +TextFieldCampo2.getText();
        }else if (TextFieldCampo3.isVisible())
        {
            _mensaje += " " +TextFieldCampo3.getText();
        } else if(TextFieldCampo4.isVisible())
        {
            _mensaje += " " +TextFieldCampo4.getText();
        }
        }
        
        
        
        

        _nuevoMensaje.setMensaje(_mensaje);
    }//GEN-LAST:event_BotonAceptarActionPerformed

    private void TextFieldCampo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldCampo4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldCampo4ActionPerformed

    private void TextFieldCampo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldCampo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldCampo1ActionPerformed

    private void ComboBoxComandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxComandoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxComandoActionPerformed

    private void ComboBoxComandoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxComandoItemStateChanged
        // TODO add your handling code here:
        int _index = ComboBoxComando.getSelectedIndex();
        borrarCampos();

        switch(_index)
        { case 0: //
            TextFieldCampo1.setVisible(false);
            TextFieldCampo2.setVisible(false);
            TextFieldCampo3.setVisible(false);
            TextFieldCampo4.setVisible(false);
            BotonFileChooser.setVisible(false);
            BufferDatos.setVisible(false);          
            break;
            case 1:
            TextFieldCampo1.setVisible(true);
            TextFieldCampo2.setVisible(true);
            TextFieldCampo3.setVisible(false);
            TextFieldCampo4.setVisible(false);
            BotonFileChooser.setVisible(false);
            BufferDatos.setVisible(false);
            break;
            case 2:
            TextFieldCampo1.setVisible(false);
            TextFieldCampo2.setVisible(false);
            TextFieldCampo3.setVisible(false);
            TextFieldCampo4.setVisible(false);
            BotonFileChooser.setVisible(false);
            BufferDatos.setVisible(false);
            break;
            case 3:
            TextFieldCampo1.setVisible(true);
            TextFieldCampo2.setVisible(false);
            TextFieldCampo3.setVisible(false);
            TextFieldCampo4.setVisible(false);
            BotonFileChooser.setVisible(false);
            BufferDatos.setVisible(false);
            break;
            case 4: //
            TextFieldCampo1.setVisible(true);
            TextFieldCampo2.setVisible(false);
            TextFieldCampo3.setVisible(false);
            TextFieldCampo4.setVisible(false);
            BotonFileChooser.setVisible(false);
            BufferDatos.setVisible(false);
            break;
            case 5: //
            TextFieldCampo1.setVisible(true);
            TextFieldCampo2.setVisible(true);
            TextFieldCampo3.setVisible(false);
            TextFieldCampo4.setVisible(false);
            BotonFileChooser.setVisible(false);
            BufferDatos.setVisible(false);
            break;
            case 6: //
            TextFieldCampo1.setVisible(true);
            TextFieldCampo2.setVisible(true);
            TextFieldCampo3.setVisible(false);
            TextFieldCampo4.setVisible(false);
            BotonFileChooser.setVisible(false);
            BufferDatos.setVisible(true);
            break;
            case 7: //
            TextFieldCampo1.setVisible(true);
            TextFieldCampo2.setVisible(true);
            TextFieldCampo3.setVisible(false);
            TextFieldCampo4.setVisible(false);
            BufferDatos.setVisible(true);
            break;
            case 8: //
            TextFieldCampo1.setVisible(true);
            TextFieldCampo2.setVisible(true);
            TextFieldCampo3.setVisible(true);
            TextFieldCampo4.setVisible(true);
            BotonFileChooser.setVisible(false);
            BufferDatos.setVisible(false);
            break;
            case 9: //
            TextFieldCampo1.setVisible(true);
            TextFieldCampo2.setVisible(false);
            TextFieldCampo3.setVisible(false);
            TextFieldCampo4.setVisible(false);
            BotonFileChooser.setVisible(false);
            break;
            case 10: //
            TextFieldCampo1.setVisible(true);
            TextFieldCampo2.setVisible(false);
            TextFieldCampo3.setVisible(false);
            TextFieldCampo4.setVisible(false);
            BotonFileChooser.setVisible(false);
            BufferDatos.setVisible(false);
            break;
            case 11: //
            BotonFileChooser.setVisible(false);
            TextFieldCampo1.setVisible(true);
            TextFieldCampo2.setVisible(false);
            TextFieldCampo3.setVisible(false);
            TextFieldCampo4.setVisible(false);
            BotonFileChooser.setVisible(true);
            BufferDatos.setVisible(false);
            break;
            case 12: //
            BotonFileChooser.setVisible(false);
            TextFieldCampo1.setVisible(false);
            TextFieldCampo2.setVisible(false);
            TextFieldCampo3.setVisible(true);
            TextFieldCampo4.setVisible(false);
            BotonFileChooser.setVisible(true);
            BufferDatos.setVisible(false);
            break;
            case 13: //
            TextFieldCampo1.setVisible(true);
            TextFieldCampo2.setVisible(true);
            TextFieldCampo3.setVisible(false);
            TextFieldCampo4.setVisible(false);
            BotonFileChooser.setVisible(false);
            BufferDatos.setVisible(false);
            break;
            case 14: //
            TextFieldCampo1.setVisible(false);
            TextFieldCampo2.setVisible(false);
            TextFieldCampo3.setVisible(false);
            TextFieldCampo4.setVisible(false);
            BotonFileChooser.setVisible(false);
            BufferDatos.setVisible(false);
            break;                
            case 15: //
            TextFieldCampo1.setVisible(false);
            TextFieldCampo2.setVisible(false);
            TextFieldCampo3.setVisible(false);
            TextFieldCampo4.setVisible(false);
            BufferDatos.setVisible(false);
            break;                
        };

    }//GEN-LAST:event_ComboBoxComandoItemStateChanged

    private void BotonFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonFileChooserActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            _file = fileChooser.getSelectedFile();
        }
    }//GEN-LAST:event_BotonFileChooserActionPerformed

    
    
    private void borrarCampos()
    {
       TextFieldCampo1.setText("");
       TextFieldCampo2.setText("");
       TextFieldCampo3.setText("");
       TextFieldCampo3.setText("");
       TexTAreaBufferDatos.setText("");
    }
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
            java.util.logging.Logger.getLogger(PaginaComandos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaComandos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaComandos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaComandos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaComandos().setVisible(true);
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAceptar;
    private javax.swing.JButton BotonFileChooser;
    private javax.swing.JScrollPane BufferDatos;
    private javax.swing.JComboBox ComboBoxComando;
    private javax.swing.JLabel LabelNombreUsuario;
    private javax.swing.JTextArea TexTAreaBufferDatos;
    private javax.swing.JTextArea TextAreaResultado;
    private javax.swing.JTextField TextFieldCampo1;
    private javax.swing.JTextField TextFieldCampo2;
    private javax.swing.JTextField TextFieldCampo3;
    private javax.swing.JTextField TextFieldCampo4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
