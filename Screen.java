/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdtest;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;


/**
 *
 * @author Tyler
 */
public class Screen extends JPanel implements Runnable {
    
   public Thread thread = new Thread(this);
   
   public static Image[] tileset_ground = new Image[100];
   public static Image[] tileset_air = new Image[100];
   public static Image[] tileset_stone = new Image[100];
   
   
   public static int myWidth, myHeight;
   public static boolean isFirst = true;
   
   
   public static Point mse = new Point(0,0);
   
   public static Room room;
   public static Save save;
   
    public Screen() {
        
        thread.start();
        
    }
    
    public void define() {
        room = new Room();
        save = new Save();
        for(int i=0; i < tileset_ground.length; i++){
            tileset_ground[i] = new ImageIcon("E:\\testGame\\tdTest\\src\\res\\tileset_ground.png").getImage();
            tileset_ground[i] = createImage(new FilteredImageSource(tileset_ground[i].getSource(), new CropImageFilter(0, 26*i, 26, 26)));
             
        }
         for(int i=0; i < tileset_air.length; i++){
            tileset_air[i] = new ImageIcon("E:\\testGame\\tdTest\\src\\res\\tileset_air.png").getImage();
            tileset_air[i] = createImage(new FilteredImageSource(tileset_air[i].getSource(), new CropImageFilter(0, 26*i, 26, 26)));
            
        }
          for(int i=0; i < tileset_stone.length; i++){
            tileset_stone[i] = new ImageIcon("E:\\testGame\\tdTest\\src\\res\\stoneTile.png").getImage();
            tileset_stone[i] = createImage(new FilteredImageSource(tileset_stone[i].getSource(), new CropImageFilter(0, 26*i, 26, 26)));
            
        }
         try {
            save.loadSave(new File("E:\\testGame\\tdTest\\src\\save\\level1.tyler"));
         }
         catch(Exception e){
             e.printStackTrace();
         }
         
         
    }
    
   @Override
    public void paintComponent(Graphics g){
        
        if(isFirst){
            myWidth = getWidth();
            myHeight = getHeight();
            
            define();
            isFirst = false;
        }
        g.clearRect(0, 0, getWidth(), getHeight());
        
        room.draw(g); //draw the room
        
    }
    
    
   @Override
    public void run (){
        while(true){
            if(!isFirst){
                room.physic();
                
            }
            repaint();
            
            try {
                Thread.sleep(1);
            }
            catch (Exception e) {
                
            }
        }
        
    }
    
}
