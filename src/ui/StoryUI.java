
package ui;

import java.io.File;
import javax.swing.JFileChooser;
import storyteller.JsonRead;


public class StoryUI extends javax.swing.JFrame {


    public StoryUI() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        OpenButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        mainImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1100, 600));
        setMinimumSize(new java.awt.Dimension(1100, 600));
        setPreferredSize(new java.awt.Dimension(1100, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("WELCOME");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("STORY TELLER");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, -1, -1));

        OpenButton.setText("Open Album");
        OpenButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OpenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenButtonActionPerformed(evt);
            }
        });
        getContentPane().add(OpenButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 130, -1));

        jButton1.setText("Save Album");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 130, -1));

        jButton2.setText("About");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 130, -1));

        mainImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/MainTemplate.png"))); // NOI18N
        getContentPane().add(mainImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
         int returnValue = fileChooser.showOpenDialog(null);
         if (returnValue == JFileChooser.APPROVE_OPTION) {
             File file = fileChooser.getSelectedFile();
             JsonRead readAlbum = new JsonRead();
             String path = file.getAbsolutePath();
             readAlbum.photoLinks(path);

         }
         
         
    }//GEN-LAST:event_OpenButtonActionPerformed

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
            java.util.logging.Logger.getLogger(StoryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StoryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StoryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StoryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StoryUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OpenButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel mainImage;
    // End of variables declaration//GEN-END:variables
}
