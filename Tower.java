/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clashofcandidates;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author tlm5570
 */
public class Tower {
    public int Damage = 50;
    public static String Tower = "turret1-original";
    static Image tower = new ImageIcon("E:\\college\\ClashofCandidates\\build\\classes\\clashofcandidates\\" +Tower +".png").getImage();
    public Tower(int x, int y, int width, int height) {
        //setBounds(x, y, width, height);
   
      
}
    
    
}
