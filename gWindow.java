/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clashofcandidates;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import static java.awt.Color.RED;
import static java.awt.Frame.MAXIMIZED_BOTH;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 *
 * @author tlm5570
 */
class gWindow implements ActionListener{
    
    private JFrame frame;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel background;
    private JLabel background2;
    private JLabel background3;
    private JPanel panel;
    private JButton jButton;
    private JPanel panel2;
    private JPanel gamePanel;
    private JLabel jLabel3;
    
    public gWindow() throws IOException
    {
        frame = new JFrame();
        frame.setTitle("Clash of Candidates");
      
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        
        jButton1 = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jButton2 = new JButton();
        panel = new JPanel();
        panel2 = new JPanel();
        gamePanel = new JPanel();
        jLabel3 = new JLabel();
       
        
        ImageIcon bg = new ImageIcon(getClass().getResource("usa.gif"));
        background = new JLabel(bg);
        background.setPreferredSize(new Dimension(1800,2000));
        //background.setPreferredSize(new Dimension(JFrame.MAXIMIZED_BOTH, JFrame.MAXIMIZED_BOTH));
        //background.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().add(new JPanel());
       
        ImageIcon bt = new ImageIcon(getClass().getResource("trump.png"));
        jButton = new JButton(bt); 
        jButton.setPreferredSize(new Dimension(160, 150));
        
        ImageIcon bg2 = new ImageIcon(getClass().getResource("tvtbg.jpg"));
        background2 = new JLabel(bg2);
        
        ImageIcon map = new ImageIcon(getClass().getResource("usa.jpg"));
        background3 = new JLabel(map);
        
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.BLUE);
        gamePanel.setLayout(new FlowLayout());
        gamePanel.add(jLabel3);
        gamePanel.setPreferredSize(frame.getSize());
        //frame.add(panel);
        frame.add(panel);
        frame.add(background);
        //panel.add(background);
        //panel.add(jButton1);
        //panel.add(jButton);
        //background.setLayout(new FlowLayout());
        //background2.setLayout(new FlowLayout(FlowLayout.CENTER));
        background.setLayout(new FlowLayout());
        background2.setLayout(new FlowLayout());
        
        
        background.add(jLabel1);   
        background.add(jButton1);
        
        
        
        jLabel1.setFont(new Font("Copperplate Gothic Bold",50,100));
        jLabel1.setForeground(Color.BLUE);
        jLabel2.setFont(new Font("Copperplate Gothic Bold", 60,120));
        jLabel2.setForeground(Color.BLUE);
        jLabel3.setFont(new Font("Chiller", 50, 100));
        jLabel3.setForeground(Color.RED);
           
        panel2.add(background2);
        background2.add(jLabel2);
        background2.add(jButton);
        
        gamePanel.add(background3);
     
        jButton1.setText("Start Game");
        
        
        
        
        jButton1.addActionListener(new ActionListener(){
        
            @Override
        public void actionPerformed(ActionEvent e)
        {
           music();
           //frame.removeAll();
           frame.getContentPane().removeAll();
           frame.add(panel2);
           frame.revalidate();
           frame.repaint();
        }
     });
        
        jButton.addActionListener(new ActionListener(){
        
            @Override
        public void actionPerformed(ActionEvent e)
        {
           music(); 
        
           //frame.removeAll();
           frame.getContentPane().removeAll();
           frame.add(gamePanel);
           frame.revalidate();
           frame.repaint();
        }
     });
            
        //jButton2.setText("Exit Game");

        jLabel1.setText("Clash of Candidates");
        jLabel2.setText("Choose your Character");
        jLabel3.setText("I'm gonna make America great again");
        
    }
     public static void music() {
            AudioPlayer MGP = AudioPlayer.player;
            AudioStream BGM;
            AudioData MD;
            ContinuousAudioDataStream loop = null;
            
            try {
                BGM = new AudioStream(new FileInputStream("activePower.mp3"));
                MD = BGM.getData();
                loop = new ContinuousAudioDataStream(MD);
                
            }
            catch (IOException error){}
            MGP.start(loop);
        };

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
    

