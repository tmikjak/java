/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clashofcandidates;

/**
 *
 * @author Tyler
 */
import java.awt.Point;
import java.awt.event.*;
/**
 *
 * @author tlm5570
 */
public class keyHandle implements MouseMotionListener, MouseListener{

    @Override
    public void mouseDragged(MouseEvent e) {
      Screen.mse = new Point((e.getX())+((gWindow.size.width - Screen.myWidth)/2), (e.getY())+ ((gWindow.size.height - (Screen.myHeight))-(gWindow.size.width - Screen.myWidth)/2));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
      Screen.mse = new Point((e.getX())-((gWindow.size.width - Screen.myWidth)/2), (e.getY())- ((gWindow.size.height - (Screen.myHeight))-(gWindow.size.width - Screen.myWidth)/2));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }
    
}

