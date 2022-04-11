/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**
 *
 * @author raf
 */
public class JF_Jogo extends javax.swing.JFrame {

    /**
     * Creates new form JF_Jogo
     */
    public JF_Jogo() {
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

        jP_Background = new javax.swing.JPanel();
        jP_InnerBackground = new javax.swing.JPanel();
        jL_Titulo = new javax.swing.JLabel();
        jSep_TituloMenu = new javax.swing.JSeparator();
        jScrolP = new javax.swing.JScrollPane();
        jTP_Interface = new javax.swing.JTextPane();
        jL_NomeJogador = new javax.swing.JLabel();
        jB_Reiniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jP_Background.setBackground(new java.awt.Color(0, 0, 0));
        jP_Background.setPreferredSize(new java.awt.Dimension(600, 500));

        jP_InnerBackground.setBackground(new java.awt.Color(102, 102, 102));

        jL_Titulo.setFont(new java.awt.Font("Felix Titling", 1, 48)); // NOI18N
        jL_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_Titulo.setText("Dr. Disease");

        jSep_TituloMenu.setBackground(new java.awt.Color(0, 0, 0));
        jSep_TituloMenu.setForeground(new java.awt.Color(0, 0, 0));
        jSep_TituloMenu.setOpaque(true);

        jTP_Interface.setBackground(new java.awt.Color(102, 102, 102));
        jTP_Interface.setBorder(null);
        jTP_Interface.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        jTP_Interface.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrolP.setViewportView(jTP_Interface);

        jL_NomeJogador.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jL_NomeJogador.setText("Nickname");

        jB_Reiniciar.setBackground(new java.awt.Color(102, 102, 102));
        jB_Reiniciar.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jB_Reiniciar.setText("Reiniciar");
        jB_Reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ReiniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_InnerBackgroundLayout = new javax.swing.GroupLayout(jP_InnerBackground);
        jP_InnerBackground.setLayout(jP_InnerBackgroundLayout);
        jP_InnerBackgroundLayout.setHorizontalGroup(
            jP_InnerBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSep_TituloMenu)
            .addGroup(jP_InnerBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_InnerBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrolP)
                    .addComponent(jL_Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addGroup(jP_InnerBackgroundLayout.createSequentialGroup()
                        .addComponent(jL_NomeJogador, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jB_Reiniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jP_InnerBackgroundLayout.setVerticalGroup(
            jP_InnerBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_InnerBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jL_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSep_TituloMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrolP, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_InnerBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_NomeJogador)
                    .addComponent(jB_Reiniciar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jP_BackgroundLayout = new javax.swing.GroupLayout(jP_Background);
        jP_Background.setLayout(jP_BackgroundLayout);
        jP_BackgroundLayout.setHorizontalGroup(
            jP_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_BackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jP_InnerBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jP_BackgroundLayout.setVerticalGroup(
            jP_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_BackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jP_InnerBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jP_Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jP_Background, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jB_ReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ReiniciarActionPerformed
        JF_Menu abrir = new JF_Menu();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jB_ReiniciarActionPerformed

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
            java.util.logging.Logger.getLogger(JF_Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Jogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_Reiniciar;
    public static javax.swing.JLabel jL_NomeJogador;
    private javax.swing.JLabel jL_Titulo;
    private javax.swing.JPanel jP_Background;
    private javax.swing.JPanel jP_InnerBackground;
    private javax.swing.JScrollPane jScrolP;
    private javax.swing.JSeparator jSep_TituloMenu;
    private javax.swing.JTextPane jTP_Interface;
    // End of variables declaration//GEN-END:variables
}
