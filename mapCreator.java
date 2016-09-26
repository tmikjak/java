/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package political.power.tower.defense;
import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author tlm5570
 */
public class mapCreator {
       
    private JFrame frame;
    private int WIDTH = 1020, HEIGHT = 780;
    private JButton start;
    private JLabel label1; 
    private JLabel background;
    
    
    public mapCreator (){
    
     frame = new JFrame();
        frame.setTitle("ClashOfCandidates");
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        label1.setText("Clash of Candidates");
        frame.add(label1);
        
        //ImageIcon tvtbg = new ImageIcon(getClass().getResource("tvtbg.jpg"));
        //background = new JLabel(tvtbg);
        
        frame.add(background);
        
        background.add(label1);
}
        
}
