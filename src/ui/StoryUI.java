
package ui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.Timer;
import storyteller.JsonRead;
import storyteller.StoryTeller;
import controller.ProccessManagement;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import tree.ImageNode;


public class StoryUI extends javax.swing.JFrame {
    
    private ProccessManagement treeProccess;

    private ArrayList<String> finalUrlLinks = new ArrayList<String>() ;
    private ArrayList<String> finalImageCaptions= new ArrayList<String>();    
    JLabel pic;
    Timer tm;
    int x = 0; 
     String[] list = {
                      "C:\\Users\\Joseph Salas\\Documents\\NetBeansProjects\\StoryTeller\\src\\storyteller\\j1.jpg",//0
                      "C:\\Users\\Joseph Salas\\Documents\\NetBeansProjects\\StoryTeller\\src\\storyteller\\j2.jpg",//1
                      "C:\\Users\\Joseph Salas\\Documents\\NetBeansProjects\\StoryTeller\\src\\storyteller\\j3.jpg",//2
                      "C:\\Users\\Joseph Salas\\Documents\\NetBeansProjects\\StoryTeller\\src\\storyteller\\j4.jpg.jpg",//3
                      "C:\\Users\\Joseph Salas\\Documents\\NetBeansProjects\\StoryTeller\\src\\storyteller\\j5.jpg",//4
                      "C:\\Users\\Joseph Salas\\Documents\\NetBeansProjects\\StoryTeller\\src\\storyteller\\j6.jpg",//5
                      "C:\\Users\\Joseph Salas\\Documents\\NetBeansProjects\\StoryTeller\\src\\storyteller\\j7.jpg"//6
                    };


    public StoryUI() {
        initComponents();
        
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OpenButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        TagField = new javax.swing.JTextField();
        DescriptionField = new javax.swing.JTextField();
        ImageLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mainImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1100, 600));
        setMinimumSize(new java.awt.Dimension(1100, 600));
        setPreferredSize(new java.awt.Dimension(1100, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        TagField.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        TagField.setOpaque(false);
        TagField.setBorder(null);
        TagField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TagFieldActionPerformed(evt);
            }
        });
        getContentPane().add(TagField, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 320, -1));

        DescriptionField.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        DescriptionField.setBorder(null);
        DescriptionField.setOpaque(false);
        DescriptionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescriptionFieldActionPerformed(evt);
            }
        });
        getContentPane().add(DescriptionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 570, -1));
        getContentPane().add(ImageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jLabel1.setText("DESCRIPTION");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jLabel2.setText("TAG");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, -1, -1));

        mainImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/minimalist-white-img218.jpg"))); // NOI18N
        getContentPane().add(mainImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
         int returnValue = fileChooser.showOpenDialog(null);
         if (returnValue == JFileChooser.APPROVE_OPTION) {
             File file = fileChooser.getSelectedFile();
             String path = file.getAbsolutePath();
            try {
                treeProccess = new ProccessManagement(path);
            } catch (URISyntaxException ex) {
                Logger.getLogger(StoryUI.class.getName()).log(Level.SEVERE, null, ex);
            }
         }    
        treeProccess.captionLinks();
        finalUrlLinks =  treeProccess.getFinalUrlLinks();
        System.out.println(finalUrlLinks);
        finalImageCaptions =  treeProccess.getFinalImageCaptions();
        System.out.println(finalImageCaptions);
        secondsThread(2);
        
        
        
        
     /*    pic = new JLabel();
         pic.setBounds(85, 75, 700, 300);
         SetImageSize(6);
         
          tm = new Timer(4000,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if(x >= list.length )
                    x = 0; 
            }
        });
          tm.start();*/
    }//GEN-LAST:event_OpenButtonActionPerformed

    
    private void TagFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TagFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TagFieldActionPerformed

    private void DescriptionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescriptionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescriptionFieldActionPerformed
    
   /* public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
        add(pic);
    }*/
    
    
    
    private void secondsThread(int seconds) {
		try {
             for (int i = 0; i<= finalImageCaptions.size()-1; i++ )
             {
            DescriptionField.setText(finalImageCaptions.get(i));
            DescriptionField.setVisible(true);
            Thread.sleep(seconds * 10);
            }
			
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
    
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
    private javax.swing.JTextField DescriptionField;
    private javax.swing.JLabel ImageLabel;
    private javax.swing.JButton OpenButton;
    private javax.swing.JTextField TagField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel mainImage;
    // End of variables declaration//GEN-END:variables
}
