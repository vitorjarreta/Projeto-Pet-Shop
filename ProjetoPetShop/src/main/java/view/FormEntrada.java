/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

/**
 *
 * @author felipe.guerrera
 */
public class FormEntrada extends javax.swing.JFrame {

    /**
     * Creates new form FormEntrada
     */
    public FormEntrada() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nomepetshop = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bt_fechar = new javax.swing.JButton();
        bt_ircadastro = new javax.swing.JButton();
        bt_irlogar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        nomepetshop.setBackground(new java.awt.Color(255, 255, 0));
        nomepetshop.setFont(new java.awt.Font("Ravie", 1, 24)); // NOI18N
        nomepetshop.setForeground(new java.awt.Color(255, 255, 0));
        nomepetshop.setText("Pet Shop Bicho Sacana");

        bt_fechar.setBackground(new java.awt.Color(0, 0, 255));
        bt_fechar.setFont(new java.awt.Font("Ravie", 1, 14)); // NOI18N
        bt_fechar.setForeground(new java.awt.Color(255, 255, 0));
        bt_fechar.setText("Sair");
        bt_fechar.setBorder(null);
        bt_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fecharActionPerformed(evt);
            }
        });

        bt_ircadastro.setBackground(new java.awt.Color(0, 0, 255));
        bt_ircadastro.setFont(new java.awt.Font("Ravie", 1, 14)); // NOI18N
        bt_ircadastro.setForeground(new java.awt.Color(255, 255, 0));
        bt_ircadastro.setText("Cadastrar");
        bt_ircadastro.setBorder(null);
        bt_ircadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ircadastroActionPerformed(evt);
            }
        });

        bt_irlogar.setBackground(new java.awt.Color(0, 0, 255));
        bt_irlogar.setFont(new java.awt.Font("Ravie", 1, 14)); // NOI18N
        bt_irlogar.setForeground(new java.awt.Color(255, 255, 0));
        bt_irlogar.setText("Logar");
        bt_irlogar.setBorder(null);
        bt_irlogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_irlogarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 69, Short.MAX_VALUE)
                .addComponent(nomepetshop)
                .addGap(60, 60, 60))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bt_fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(bt_ircadastro))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(bt_irlogar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nomepetshop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(bt_irlogar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_ircadastro)
                .addGap(87, 87, 87)
                .addComponent(bt_fechar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_irlogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_irlogarActionPerformed
        FormLogin fun = new FormLogin();
        fun.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bt_irlogarActionPerformed

    private void bt_ircadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ircadastroActionPerformed
        FormUsuario fun = new FormUsuario();
        fun.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bt_ircadastroActionPerformed

    private void bt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_bt_fecharActionPerformed

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
            java.util.logging.Logger.getLogger(FormEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormEntrada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_fechar;
    private javax.swing.JButton bt_ircadastro;
    private javax.swing.JButton bt_irlogar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nomepetshop;
    // End of variables declaration//GEN-END:variables

    private void ConfigurarForm(){
        
        
    }

}
