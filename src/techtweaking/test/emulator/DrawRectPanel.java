package techtweaking.test.emulator;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author goon
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



class DrawRectPanel extends JFrame {
  public DrawRectPanel() {
      
    setSize(300, 350);
    setTitle("Bounce");
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    Container contentPane = getContentPane();
    canvas = new JPanel();
    contentPane.add(canvas, "Center");
    JPanel p = new JPanel();
   
contentPane.add(p, "South");
  
       
    
  }

public  void  startt(){Ball b = new Ball(canvas);
        b.start();}

  private JPanel canvas;
}

class Ball extends Thread {
  public Ball(JPanel b) {
    box = b;
  }

  public void draw() {
    Graphics g = box.getGraphics();
    g.fillOval(x, y, XSIZE, YSIZE);
    g.dispose();
  }
int portA = 0;
int portC = 0;

  public void move() {
    //if (!box.isVisible())
    //  return;
      int temp;
      int temp2;
      //Graphics  g = box.getGraphics();
      Graphics  g = box.getGraphics();
      boolean pass = true;
      for(int i = 0 ;i< 8 ;i++){
          
          
          temp = (((int)(Math.pow(2,i))) & portA); 
          if (!(temp > 0)){pass = false;}
          for(int j=0;j<8;j++){
              
              if(pass ){
          
              temp2 = ((int)(Math.pow(2,j)) & portC);
              if(temp2 > 0){
                  
    g.setColor(Color.RED);
    g.fillOval((i+1)*30, 30*(j+1), 20, 20);
              } else{g.setColor(Color.BLACK);g.fillOval((i+1)*30, 30*(j+1), 20, 20);System.out.println("************");}
              
              
              
              }else{g.setColor(Color.BLACK);g.fillOval((i+1)*30, 30*(j+1), 20, 20);/*System.out.println("@@@@@@@@@@@@@");*/}
              }
          }
      
 /*   Graphics g = box.getGraphics();
    g.setXORMode(box.getBackground());
    g.fillOval(x, y, XSIZE, YSIZE);
    x += dx;
    y += dy;
    Dimension d = box.getSize();
    if (x < 0) {
      x = 0;
      dx = -dx;
    }
    if (x + XSIZE >= d.width) {
      x = d.width - XSIZE;
      dx = -dx;
    }
    if (y < 0) {
      y = 0;
      dy = -dy;
    }
    if (y + YSIZE >= d.height) {
      y = d.height - YSIZE;
      dy = -dy;
    }
    g.fillOval(x, y, XSIZE, YSIZE);
    g.dispose();
    */
  }
boolean shutdown = false;
void shutdown(boolean x) { this.shutdown = x;}
  public void run() {
    try {
     // draw();
      while (!shutdown) {
       portA = ProgramWithOpjectCode.P.IOinterface(1);  
                 portC= ProgramWithOpjectCode.P.IOinterface(0);  
            System.out.println("Iam heeeeeeeeeererererlskajflkajlcjasf;lasjfjas;jf;lasjdfljasjdf");
        move();
        Thread.sleep(500);
      }
    } catch (InterruptedException e) {
    }
  }

  private JPanel box;

  private static final int XSIZE = 10;

  private static final int YSIZE = 10;

  private int x = 0;

  private int y = 0;

  private int dx = 2;

  private int dy = 2;
}
