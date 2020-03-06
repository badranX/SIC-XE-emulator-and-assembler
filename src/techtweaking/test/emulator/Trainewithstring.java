package techtweaking.test.emulator;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFrame;
import static techtweaking.test.emulator.Screen.Memory;

public class Trainewithstring {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) throws IOException {
       
       train frame = new train();
       frame.setVisible(true);
  
  
       /*
       Screen S = new Screen();
       S.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       S.setVisible(true); 
       Thread t = new Thread(S);
       t.start();
    */
       
       /* check Screen  
     for(int i =0; i<Screen.Memory.length; i++){
                        Screen.Memory[i] = 0x48;
                    }
  try {
    Thread.sleep(1000);
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
  for(int i =0; i<Screen.Memory.length; i++){
                        Screen.Memory[i] = 0x4B;
                    }
  
       */
       
       
       
   
  
  }
}
