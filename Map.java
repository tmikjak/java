/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clashofcandidates;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import clashofcandidates.Sprite;
import clashofcandidates.Animation;
import clashofcandidates.gWindow;


/**
 *
 * @author Tyler
 */

public class Map extends JPanel{
    
    public static final Color CITY = new Color(214,217,223);
    public static final Color OCEAN = new Color(0,0,153);
    public static final Color PLAINS = new Color(40,180,0);
   String character;
     Image bghouse = new ImageIcon("E:\\college\\ClashofCandidates\\build\\classes\\clashofcandidates\\whiteHouse.jpg").getImage(); 
    //Image.setPreferredSize(new Dimension(20,20));
     Image bg = new ImageIcon("E:\\college\\ClashofCandidates\\build\\classes\\clashofcandidates\\" +character + ".png").getImage();

    
    
    
    //hLabel = new JLabel(hb); 
    //hLabel.setPreferredSize(new Dimension(10, 10));

    public static final Color[] TERRAIN = {
        CITY,
        OCEAN,
        PLAINS
    };
    public static int[][] tGrid = {
        {0,0,0,0,1},
        {0,0,0,0,1},
        {0,0,0,1,1}
        
    };
    public static final int NUM_ROWS = 38;
    public static final int NUM_COLS = 35;

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
        //if (terrainGrid[35][20] == OCEAN){
            //g.drawImage(Animation.getSprite(), WIDTH, WIDTH, this);
            g.drawImage(bg, 0, 0,null);
            g.drawImage(bghouse,1100,235,null);
            //g.drawImage(Sprite.getSprite(20,20), 400, 150, null);
        //}
    }

   }





    


        
        
               
   

    
    
    
    
    
    
   
