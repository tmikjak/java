/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clashofcandidates;

import java.io.*;
import sun.audio.*;

/**
 *
 * @author Tyler
 */
public class Music {
     public static boolean sound = false;
    static AudioPlayer MGP = AudioPlayer.player;
           
      static AudioStream BGM;
      static AudioData MD; 
      static ContinuousAudioDataStream loop = null;
     public static void music() {
           
        if (sound == false) {    
           
            try {
                
                InputStream test = new FileInputStream("src\\activePower.wav.wav");
                BGM = new AudioStream(test);
                AudioPlayer.player.start(BGM);
                MD = BGM.getData();
                loop = new ContinuousAudioDataStream(MD);
                sound = true;
                
            }
            catch(FileNotFoundException e){
                System.out.printf(e.toString());
            }
            
            catch (IOException error){
                System.out.print(error.toString());
            }
            
                MGP.start(loop);
            
            sound = true ;
            
        }
        
        else {
            
            MGP.stop(loop);
            AudioPlayer.player.stop(BGM);
            
              try {
                
                InputStream test = new FileInputStream("src\\battle-mus.wav");
                BGM = new AudioStream(test);
                AudioPlayer.player.start(BGM);
                MD = BGM.getData();
                loop = new ContinuousAudioDataStream(MD);
                sound = true;
                
            }
            catch(FileNotFoundException e){
                System.out.printf(e.toString());
            }
            
            catch (IOException error){
                System.out.print(error.toString());
            }
            MGP.start(loop);
            sound = true ;
            }
        
            
        }
            
        };

     
