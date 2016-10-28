/*
 * By: Tyler Mikolajczyk
 * Project: Clash of Candidates tower defense game
 * This java file: JFrame creator/ game window 
 */
package clashofcandidates;
// imports

import java.awt.*;
import static java.awt.Color.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.File;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import sun.audio.*;

/**
 *
 * @author tlm5570
 */
class gWindow implements ActionListener{
    
    private JFrame frame;
    private JButton startButton;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel background;
    private JLabel background2;
    private JLabel background3;
    private JPanel panel;
    private JButton TrumpButton;
    private JButton HillaryButton;
    private JPanel panel2;
    private JPanel gamePanel;
    private JLabel jLabel3;
    private JButton quitButton;
    public String character;
    private JPanel buttonPanel;
    private JButton beginButton;
    private JButton turret1;
    private JButton turret2;
    private JPanel levelPanel;
    private JButton characterButton;
    private JButton characterButton2;
    
    public gWindow() throws IOException
    {
        //create and initialize frame 
        frame = new JFrame();
        frame.setTitle("Clash of Candidates");
        
        
       /* 
        
        
        //BeginSession();
        int[][] map= {
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0}    
   
        };
        TileGrid grid = new TileGrid(map);
        Tile tile = new Tile(0, 0, 64, 64, TileType.Grass);
        Tile tile2 = new Tile(0, 0, 64, 64, TileType.Dirt);
        
        
        while(!Display.isCloseRequested()){
            
            grid.Draw();
            Display.update();
            Display.sync(60);
            
        }
        Display.destroy();
       
        
        */
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //Map map = new Map();
        frame.setSize(1300,700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        music();
        
        // initialize panel components
        startButton = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        TrumpButton = new JButton();
        panel = new JPanel();
        panel2 = new JPanel();
        gamePanel = new JPanel();
        jLabel3 = new JLabel();
        quitButton = new JButton();
        HillaryButton = new JButton();
        buttonPanel = new JPanel();
        beginButton = new JButton();
        turret1 = new JButton();
        turret2 = new JButton();
        levelPanel = new JPanel();
        characterButton = new JButton();
        characterButton2 = new JButton();
        character = "";
        
        // create and initialize image backgrounds
        ImageIcon bg = new ImageIcon(getClass().getResource("flag.gif"));
        background = new JLabel(bg);
        background.setPreferredSize(new Dimension(80,180));
       
        ImageIcon bt = new ImageIcon(getClass().getResource("trump.png"));
        TrumpButton = new JButton(bt); 
        TrumpButton.setPreferredSize(new Dimension(180, 170));
        
        ImageIcon bt2 = new ImageIcon(getClass().getResource("Hillary.png"));
        HillaryButton = new JButton(bt2); 
        HillaryButton.setPreferredSize(new Dimension(180, 170));
        
        ImageIcon bg2 = new ImageIcon(getClass().getResource("TrumpvsHillary.jpg"));
        background2 = new JLabel(bg2);
        //background2.setPreferredSize(new Dimension(200,400));
        
        ImageIcon level = new ImageIcon(getClass().getResource("usMap.jpeg"));
        background3 = new JLabel(level);
        
        ImageIcon tb = new ImageIcon(getClass().getResource("turret2Small.jpg"));
        turret1 = new JButton(tb);
        
        ImageIcon tb2 = new ImageIcon(getClass().getResource("turret1-small.jpg"));
        turret2 = new JButton(tb2);
        
        ImageIcon cb = new ImageIcon(getClass().getResource("Hillary.png"));
        characterButton = new JButton(cb);
        characterButton.setPreferredSize(new Dimension(30,30));
        
        ImageIcon cb2 = new ImageIcon(getClass().getResource("Trump.png"));
        characterButton2 = new JButton(cb2);
        characterButton2.setPreferredSize(new Dimension(30,30));
       
        
         // add components to the panels and set panel format
        frame.setLayout(new BorderLayout()); 
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.BLACK);
        frame.add(panel);
        panel.add(background, BorderLayout.CENTER);
        panel.add(startButton, BorderLayout.EAST);
        panel.add(jLabel1, BorderLayout.NORTH);
        panel.add(quitButton, BorderLayout.WEST);
        jLabel1.setFont(new Font("Copperplate Gothic Bold",40,90));
        jLabel1.setForeground(Color.green);
        jLabel2.setFont(new Font("Copperplate Gothic Bold", 40,90));
        jLabel2.setForeground(Color.BLUE);
        jLabel3.setFont(new Font("Chiller", 40, 90));
        jLabel3.setForeground(Color.RED);
           
        panel2.add(jLabel2, BorderLayout.NORTH);
        panel2.add(TrumpButton, BorderLayout.EAST);
        panel2.setBackground(Color.white);
        
        panel2.add(background2, BorderLayout.CENTER);
        panel2.add(HillaryButton, BorderLayout.WEST);
        
        
        gamePanel.setLayout(new BorderLayout());
        
        //gamePanel.add(background3, BorderLayout.CENTER);
        Map map = new Map();
        gamePanel.add(map, BorderLayout.CENTER);
        
        levelPanel.setLayout(new BorderLayout());
        //levelPanel.add(background3, BorderLayout.CENTER);
        //levelPanel.add(characterButton, BorderLayout.CENTER);
       // levelPanel.add(jLabel3, BorderLayout.NORTH);
        //gamePanel.add(jLabel3,BorderLayout.NORTH);
        //gamePanel.add(background3, BorderLayout.CENTER);
       
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.add(beginButton);
        buttonPanel.add(turret1);
        buttonPanel.add(turret2);
        
     
        // set the text for the title screen labels 
        startButton.setText("Start Game");
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);
        startButton.setFont(new Font("Stencil",Font.PLAIN,40));
        startButton.setForeground(Color.green);
        
        quitButton.setText("Exit Game");
        quitButton.setContentAreaFilled(false);
        quitButton.setBorderPainted(false);
        quitButton.setFocusPainted(false);
        quitButton.setFont(new Font("Stencil", Font.PLAIN, 40));
        quitButton.setForeground(Color.green);
        
        TrumpButton.setContentAreaFilled(false);
        TrumpButton.setBorderPainted(false);
        TrumpButton.setFocusPainted(false);
        HillaryButton.setContentAreaFilled(false);
        HillaryButton.setBorderPainted(false);
        HillaryButton.setFocusPainted(false);
        beginButton.setText("Begin Wave");

        jLabel1.setText("     Clash of Candidates");
        jLabel2.setText("Choose your Character");
        jLabel3.setText("   DANGER INCOMING");
        
        // create action listener for the start button that changes the panel  
        startButton.addActionListener(new ActionListener(){
          
            @Override
        public void actionPerformed(ActionEvent e)
        {
           frame.getContentPane().removeAll();
           frame.add(panel2);
           //panel2.add(quitButton, BorderLayout.SOUTH);
           frame.revalidate();
           frame.repaint();
        }
     });
        
        // create action listener for the character selection and makes new panel (gamePanel)
        HillaryButton.addActionListener(new ActionListener(){
        
            @Override
        public void actionPerformed(ActionEvent e)
        {
           character = "Hillary" ; 
           frame.getContentPane().removeAll();
           //battleSong();
           
           //frame.add(gamePanel, BorderLayout.CENTER);
           //frame.add(buttonPanel, BorderLayout.NORTH);
           
           frame.add(jLabel3, BorderLayout.NORTH);
           levelPanel.add(characterButton2, BorderLayout.CENTER);
           frame.add(levelPanel, BorderLayout.CENTER);
           frame.add(background3, BorderLayout.WEST);
           //buttonPanel.add(quitButton);
           characterButton2.setContentAreaFilled(false);
           characterButton2.setBorderPainted(false);
           characterButton2.setFocusPainted(false);
           //quitButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
           //quitButton.setForeground(Color.black);
           frame.revalidate();
           frame.repaint();
        }
     });
        TrumpButton.addActionListener(new ActionListener(){
        
            @Override
        public void actionPerformed(ActionEvent e)
        {
           character = "Trump";
           frame.getContentPane().removeAll();
           //battleSong();
          frame.add(jLabel3, BorderLayout.NORTH);
          levelPanel.add(characterButton, BorderLayout.CENTER);
          frame.add( levelPanel , BorderLayout.CENTER);
          frame.add(background3, BorderLayout.WEST);
           //frame.add(gamePanel, BorderLayout.CENTER);
           //frame.add(buttonPanel, BorderLayout.NORTH);
           //buttonPanel.add(quitButton);
           characterButton.setContentAreaFilled(false);
           characterButton.setBorderPainted(false);
           characterButton.setFocusPainted(false);
           //quitButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
           //quitButton.setForeground(Color.black);
           frame.revalidate();
           frame.repaint();
               
            }
        
        
     });
        
         characterButton.addActionListener(new ActionListener(){
        
            @Override
        public void actionPerformed(ActionEvent e)
        {
           
           frame.getContentPane().removeAll();
           //battleSong();
           frame.add(gamePanel, BorderLayout.CENTER);
           frame.add(buttonPanel, BorderLayout.NORTH);
           buttonPanel.add(quitButton);
           quitButton.setContentAreaFilled(true);
           quitButton.setBorderPainted(true);
           quitButton.setFocusPainted(true);
           quitButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
           quitButton.setForeground(Color.black);
           frame.revalidate();
           frame.repaint();
               
           }
            
        
        
     });
        
        characterButton2.addActionListener(new ActionListener(){
        
            @Override
        public void actionPerformed(ActionEvent e)
        {
           
           frame.getContentPane().removeAll();
           //battleSong();
           frame.add(gamePanel, BorderLayout.CENTER);
           frame.add(buttonPanel, BorderLayout.NORTH);
           buttonPanel.add(quitButton);
           quitButton.setContentAreaFilled(true);
           quitButton.setBorderPainted(true);
           quitButton.setFocusPainted(true);
           quitButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
           quitButton.setForeground(Color.black);
           frame.revalidate();
           frame.repaint();
               
           }
            
        
        
     });
        quitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
            
        });
        
    }
    // create music player for menu screen
     public static void music() {
            AudioPlayer MGP = AudioPlayer.player;
            AudioStream BGM;
            AudioData MD;
            ContinuousAudioDataStream loop = null;
            
            try {
                
                InputStream test = new FileInputStream("src\\activePower.wav.wav");
                BGM = new AudioStream(test);
                AudioPlayer.player.start(BGM);
                MD = BGM.getData();
                loop = new ContinuousAudioDataStream(MD);
                
            }
            catch(FileNotFoundException e){
                System.out.printf(e.toString());
            }
            
            catch (IOException error){
                System.out.print(error.toString());
            }
            MGP.start(loop);
            
        };
     public static void battleSong() {
            AudioPlayer MGP = AudioPlayer.player;
            AudioStream BGM;
            AudioData MD;
            ContinuousAudioDataStream loop = null;
            
            try {
                InputStream bgMusic = new FileInputStream("src\\WarGod.wav");
                BGM = new AudioStream(bgMusic);
                AudioPlayer.player.start(BGM);
                MD = BGM.getData();
                loop = new ContinuousAudioDataStream(MD);
                
            }
            catch(FileNotFoundException e){
                System.out.printf(e.toString());
            }
            
            catch (IOException error){
                System.out.print(error.toString());
            }
            MGP.start(loop);
        };

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
    
    

