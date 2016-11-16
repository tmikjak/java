/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package clashofcandidates;
/*
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import clashofcandidates.Sprite;
import clashofcandidates.Animation;
import clashofcandidates.gWindow;
import static clashofcandidates.gWindow.character;
import clashofcandidates.Minion;
import static clashofcandidates.Minion.enemy;
import static clashofcandidates.Tower.tower;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import static clashofcandidates.gWindow.beginButton;
import java.awt.image.ImageObserver;



/**
 *
 * @author Tyler
 */

/*
public class Map extends JPanel { //implements Runnable{
    
    public static final Color CITY = new Color(214,217,223);
    public static final Color OCEAN = new Color(0,0,153);
    public static final Color PLAINS = new Color(40,180,0);
    
    private JButton turret1;
    private JButton turret2;

    
    //String character = gWindow.getCharacter(character);  
    String character ="hillaryHead" ;
     
    Image bghouse = new ImageIcon("E:\\college\\ClashofCandidates\\build\\classes\\clashofcandidates\\whiteHouse.jpg").getImage(); 
    //Image.setPreferredSize(new Dimension(20,20));
     //Image bg = new ImageIcon("E:\\college\\ClashofCandidates\\build\\classes\\clashofcandidates\\" + gWindow.character + ".png").getImage();
    // Image bg = new ImageIcon("E:\\college\\ClashofCandidates\\build\\classes\\clashofcandidates\\" + character + ".png").getImage();
    //Image bg = new ImageIcon("E:\\college\\ClashofCandidates\\build\\classes\\clashofcandidates\\" + character.getText() + ".png").getImage();
    Image bg = new ImageIcon("E:\\college\\ClashofCandidates\\build\\classes\\clashofcandidates\\" + character + ".png").getImage();
    
    Image turretOne = new ImageIcon("E:\\college\\ClashofCandidates\\build\\classes\\clashofcandidates\\turret1-original.png").getImage();
    Image turretTwo = new ImageIcon("E:\\college\\ClashofCandidates\\build\\classes\\clashofcandidates\\turret2-original.png").getImage(); 
     
     
    //public void start() {
    //    isRunning = true;
    //    if (thread == null){
        
   // }
    //public void run() {
    //    start();
        
    //}
    
    //hLabel = new JLabel(hb); 
    //hLabel.setPreferredSize(new Dimension(10, 10));

    public static final Color[] TERRAIN = {
        CITY,
        OCEAN,
        PLAINS
    };
  
    public static final int NUM_ROWS = 38;
    public static final int NUM_COLS = 35;

    public int x = 600;
    public int y = 20;
    public int horizontalIndex = 20;
    
    public static final int PREFERRED_GRID_SIZE_PIXELS = 80;
    //final BufferedImage image = ImageIO.read(new File("Hillary.jpg"));
    // In reality you will probably want a class here to represent a map tile,
    // which will include things like dimensions, color, properties in the
    // game world.  Keeping simple just to illustrate.
    private final Color[][] terrainGrid;
    ImageIcon[][] plane1;

    public Map() throws IOException{
        this.terrainGrid = new Color[NUM_ROWS][NUM_COLS];
        this.plane1 = new ImageIcon[NUM_ROWS][NUM_COLS];
        
        turret1 = new JButton(); 
        turret2 = new JButton();
        
        ImageIcon tb = new ImageIcon(getClass().getResource("turret1-original.png"));
        turret1 = new JButton(tb);
        turret1.setPreferredSize(new Dimension(50, 50));
        
        ImageIcon tb2 = new ImageIcon(getClass().getResource("turret2-original.png"));
        turret2 = new JButton(tb2);
        turret2.setPreferredSize(new Dimension(50, 50));
        
        add(turret1);
        
          turret1.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent m){
                x = m.getX() + 600;
                y = m.getY() - 65 ;
                
               //g.drawImage(turret1, x, y, null);
                
                repaint();
               
            }
            
        }); 
        
        add(turret2);
        
          turret2.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent m){
                x = m.getX() + 600;
                y = m.getY() - 65 ;
                
               //g.drawImage(turret1, x, y, null);
                
                repaint();
               
            }
            
        }); 
        
        
        // Randomize the terrain
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                //int randomTerrainIndex = r.nextInt(TERRAIN.length);
                //Color randomColor = TERRAIN[randomTerrainIndex];
                this.terrainGrid[i][j] = PLAINS;//randomColor;
                if (i < 10){
                    this.terrainGrid[i][5] = CITY;
                }
                 if (i > 10){
                    this.terrainGrid[i][20] = CITY;
                }
                 if (j  > 4 && j < 21){
                    this.terrainGrid[10][j] = CITY;
                }
               //   if (terrainGrid[35][30] == OCEAN ){
               //     g.drawImage(image, 0, 0, null);
                    //Sprite.loadSprite();
               // }
                
            }
        }
       
        int preferredWidth = NUM_COLS * PREFERRED_GRID_SIZE_PIXELS;
        int preferredHeight = NUM_ROWS * PREFERRED_GRID_SIZE_PIXELS;
        setPreferredSize(new Dimension(preferredWidth, preferredHeight));
        
       
    }

    @Override
    public void paintComponent(Graphics g) {
        // Important to call super class method
        super.paintComponent(g);
        // Clear the board
        g.clearRect(0, 0, getWidth(), getHeight());
        // Draw the grid
        int rectWidth = getWidth() / NUM_COLS;
        int rectHeight = getHeight() / NUM_ROWS;

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                // Upper left corner of this terrain rect
                int x = i * rectWidth;
                int y = j * rectHeight;
                Color terrainColor = terrainGrid[i][j];
                g.setColor(terrainColor);
                g.fillRect(x, y, rectWidth , rectHeight);
                //terrainGrid[35][20] = bg;
              //  if (terrainGrid[35][30] == OCEAN ){
                    //g.drawImage(Sprite.loadSprite(), x, y, null);
               //     Sprite.loadSprite(Sprite.file);
               
              //  }
            }
        }
       
            //g.drawImage(Animation.getSprite(), WIDTH, WIDTH, this);
           if (beginButton.getModel().isPressed()){
                g.drawImage(bg, 0, 0,null);
           }
            
            
            g.drawImage(bghouse,1100,235,null);
            //Minion.draw();
            
            if (beginButton.getModel().isPressed()){
                g.drawImage(enemy, 50, 50, null);
            }
            
           if (turret1.getModel().isPressed()) {
                g.drawImage(tower, x, y, turret2 );
           
           }
           if (turret2.getModel().isPressed()) {
                g.drawImage(turretTwo, x, y, turret1 );
           
           }
           
           
           g.drawImage(enemy, horizontalIndex, 60, null);
           
    }
      void update() {
       horizontalIndex++;
       
       //System.out.print(horizontalIndex);
       //revalidate();
       repaint(); 
       
    }
           
           
          // if (beginButton.getModel().isPressed()) { 
          
              //g.drawImage(enemy, 110, 60, null);
        //   }
       //    else {
       //        System.out.print("messed up");
               
       //    }
            
            //g.drawImage(Sprite.getSprite(20,20), 400, 150, null);
        
    }
  
*/
   





    


        
        
               
   

    
    
    
    
    
    
   
