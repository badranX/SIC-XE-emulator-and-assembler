package techtweaking.test.emulator;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author goon
 */

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
 import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame implements Runnable {
            public static int [] Memory = new int[4968];
            
            ActionListener taskPerformer = new ActionListener() {
  public void actionPerformed(ActionEvent evt) {
     
    Comp.repaint();
    
  }
};


            public void run(){
                
                    
                new Timer(1000, taskPerformer).start();
               
  
               
            }

    public  Screen() {
         Processor.IOchannels[0].IOmemory[0] = this.Memory;
                this.setSize(400, 200);
                getContentPane().setBackground(Color.black);
                this.add(Comp);
                
                  
        
        
               
        
        
        
        
        
    }
    
    JComponent Comp = new JComponent() {
            String[] lines = new String[50];
            public void paintComponent(Graphics g) {
                for(int i =0 ;i <46; i++){
                    lines[i] = "";
                    for ( int j=0 ; j<108 ; j++){
                        
                        lines[i] += Character.toString((char)Memory[i + j]);
                        
                    }
                }
                
                
                String str = "hello wfkdjfldjs orld!";
                
                
                Color textColor = Color.WHITE;
                Color bgColor = Color.BLACK;
                int x = 0;
                int y =10;
                

                FontMetrics fm = g.getFontMetrics();
                Rectangle2D rect = fm.getStringBounds(str, g);

                g.setColor(bgColor);
                g.fillRect(0, 30  , (int) rect.getWidth(),
                           (int) rect.getHeight());

                g.setColor(textColor);
                
               String S = "";
                        for ( int j=0 ; j<46 ; j++){
                         
                        g.drawString(lines[j] , 0, 10 + j*15);
                    }
                
                    
                
                
            }
        };
}
