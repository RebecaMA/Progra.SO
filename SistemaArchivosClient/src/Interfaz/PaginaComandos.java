/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Libreria.*;

/**
 *
 * @author Rebeca
 */
public class PaginaComandos extends javax.swing.JFrame {

    /**
     * Creates new form PaginaComandos
     */
    
    String _nombreUsuario;
    public PaginaComandos() {
        initComponents();
    }
    
     public PaginaComandos(String pnombreUsuario) {
        initComponents();
        _nombreUsuario = pnombreUsuario;
        LabelNombreUsuario.setText(pnombreUsuario);
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
        LabelRespuesta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arabic Typesetting", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenido ");

        LabelNombreUsuario.setFont(new java.awt.Font("Arabic Typesetting", 1, 24)); // NOI18N
        LabelNombreUsuario.setForeground(new java.awt.Color(0, 255, 255));
        LabelNombreUsuario.setText("Usuario");

        ComboBoxComando.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        ComboBoxComando.setForeground(new java.awt.Color(0, 204, 204));
        ComboBoxComando.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "df", "mount", "ls", "rm", "open", "read", "write", "repos", "close\t", "cat", "Importar", "exportar", "salir", "terminar" }));
        ComboBoxComando.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxComandoItemStateChanged(evt);
            }
        });

        TextFieldCampo1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        TextFieldCampo1.setForeground(new java.awt.Color(0, 102, 102));
        TextFieldCampo1.setText("Campo 1");
        TextFieldCampo1.setEnabled(false);

        TextFieldCampo2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        TextFieldCampo2.setForeground(new java.awt.Color(0, 102, 102));
        TextFieldCampo2.setText("Campo 2");
        TextFieldCampo2.setEnabled(false);

        TextFieldCampo3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        TextFieldCampo3.setForeground(new java.awt.Color(0, 102, 102));
        TextFieldCampo3.setText("Campo 3");
        TextFieldCampo3.setEnabled(false);

        TextFieldCampo4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        TextFieldCampo4.setForeground(new java.awt.Color(0, 102, 102));
        TextFieldCampo4.setText("Campo 4");
        TextFieldCampo4.setEnabled(false);
        TextFieldCampo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldCampo4ActionPerformed(evt);
            }
        });

        BotonAceptar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        BotonAceptar.setForeground(new java.awt.Color(0, 204, 204));
        BotonAceptar.setText("Aceptar");
        BotonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAceptarActionPerformed(evt);
            }
        });

        LabelRespuesta.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        LabelRespuesta.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LabelNombreUsuario))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BotonAceptar)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ComboBoxComando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TextFieldCampo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TextFieldCampo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextFieldCampo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextFieldCampo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(LabelRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(LabelNombreUsuario))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxComando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldCampo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldCampo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldCampo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldCampo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(BotonAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(LabelRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void borrarCampos()
    {
       TextFieldCampo1.setEnabled(false);
       TextFieldCampo2.setEnabled(false);
       TextFieldCampo3.setEnabled(false);
       TextFieldCampo3.setEnabled(false);
      
    }
    private void ComboBoxComandoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxComandoItemStateChanged
        // TODO add your handling code here:
        int _index = ComboBoxComando.getSelectedIndex();
        borrarCampos();
        
        switch(_index)
        { case 0: //
            break;
        case 1: 
            TextFieldCampo1.setEnabled(true);
            TextFieldCampo2.setEnabled(true);
            break;
        case 2: 
            TextFieldCampo1.setEnabled(true);
            break; 
         case 3: 
             TextFieldCampo1.setEnabled(true);
            break; 
        case 4: //
            TextFieldCampo1.setEnabled(true);
            TextFieldCampo2.setEnabled(true);
            break;
        case 5: //
            TextFieldCampo1.setEnabled(true);
            TextFieldCampo2.setEnabled(true);
            break;
        case 6: //
            TextFieldCampo1.setEnabled(true);
            TextFieldCampo2.setEnabled(true);
            break; 
         case 7: //
             TextFieldCampo1.setEnabled(true);
            TextFieldCampo2.setEnabled(true);
            TextFieldCampo3.setEnabled(true);
            break; 
         case 8: //
             TextFieldCampo1.setEnabled(true);
            break;
        case 9: //
            TextFieldCampo1.setEnabled(true);
            break;
        case 10: //
            TextFieldCampo1.setEnabled(true);
            TextFieldCampo2.setEnabled(true);
            break; 
         case 11: //
            TextFieldCampo1.setEnabled(true);
            TextFieldCampo2.setEnabled(true);
            break; 
        case 12: //
            break;
        case 13: //
            break;

       default: //
        };
        
    }//GEN-LAST:event_ComboBoxComandoItemStateChanged

    private void TextFieldCampo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldCampo4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldCampo4ActionPerformed

    private void BotonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAceptarActionPerformed
        // TODO add your handling code here:
        // Manda el mensaje al socket
        
        Mensaje _nuevoMensaje = new Mensaje();
        String _mensaje = null;
        _mensaje = ComboBoxComando.getSelectedItem().toString();
        
        if(TextFieldCampo1.isEnabled())
        {
            _mensaje += " " +TextFieldCampo1.getText();
        }else if(TextFieldCampo2.isEnabled())
        {
            _mensaje += " " +TextFieldCampo2.getText();
        }else if (TextFieldCampo3.isEnabled())
        {
            _mensaje += " " +TextFieldCampo3.getText();
        } else if(TextFieldCampo4.isEnabled())
        {
            _mensaje += " " +TextFieldCampo4.getText();
        }
        
        _nuevoMensaje.setMensaje(_mensaje);
    }//GEN-LAST:event_BotonAceptarActionPerformed

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
    private javax.swing.JComboBox ComboBoxComando;
    private javax.swing.JLabel LabelNombreUsuario;
    private javax.swing.JLabel LabelRespuesta;
    private javax.swing.JTextField TextFieldCampo1;
    private javax.swing.JTextField TextFieldCampo2;
    private javax.swing.JTextField TextFieldCampo3;
    private javax.swing.JTextField TextFieldCampo4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
