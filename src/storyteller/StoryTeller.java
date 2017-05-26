
package storyteller;


import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class StoryTeller extends JFrame{
    
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


     
public StoryTeller()
    {
        super("Java SlideShow");
        pic = new JLabel();
        pic.setBounds(40, 30, 700, 300);
         SetImageSize(6);
         
          tm = new Timer(500,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if(x >= list.length )
                    x = 0; 
            }
        });
        add(pic);
        tm.start();
        setLayout(null);
        setSize(800, 400);
        getContentPane().setBackground(Color.decode("#bdb67b"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    
    }     
     

public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }
     
     
    public static void main(String[] args) {
        
        new StoryTeller();

    }
    
}
