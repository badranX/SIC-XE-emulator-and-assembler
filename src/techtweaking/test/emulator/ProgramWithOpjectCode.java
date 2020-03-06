package techtweaking.test.emulator;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author yahya
 */

import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ProgramWithOpjectCode extends JPanel {
    static public  Processor P = new Processor();
    static Thread ProccessorThread = new Thread(P);
    
     static void  ProccessorThread (boolean SingleStep){
        if(!ProccessorThread.isAlive()){
            ProccessorThread.start();
        }
        else{
         if(SingleStep){
             P.SingleStep(true);
             P.startStop(false);
         }else{
             P.SingleStep(false);
             P.startStop(false);
         }
     }
        
        
    }
     
     static void ProccessorDelay(int x){
            P.Delay(x);
        }
public String[] splitStringEvery(String s, int interval) {
    int arrayLength = (int) Math.ceil(((s.length() / (double)interval)));
    String[] result = new String[arrayLength];
    
    
    
    int j = 0;
    int lastIndex = result.length - 1;
    for (int i = 0; i < lastIndex; i++) {
        result[i] = s.substring(j, j + interval);
        j += interval;
    } //Add the last bit
    result[lastIndex] = s.substring(j);

    return result;
}
    
    public  ProgramWithOpjectCode(ArrayList<OpjectCode> searchList,ArrayList<Line> Ilines) {
        
     
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(searchList.size() +1,1));
        
         JTextField header = new JTextField ();
            JTextField header1 = new JTextField ();
            JTextField header2 = new JTextField ();
            
           
            
            header.setText("Line");
            
            header1.setText("Loc");
            
            header2.setText("Object Code");
            
            
           
            
            panel.add(header);
            panel.add(header1);
            panel.add(header2);
            
           
       for (int i = 0 ; i < (searchList.size());i++){
            
            JTextField text = new JTextField ();
            JTextField text1 = new JTextField ();
            JTextField text2 = new JTextField ();
           
            
            text.setText(Ilines.get(i+1).getOpcode().getMnemonic());
                 
            text1.setText(Integer.toHexString(searchList.get(i).getLOCCTR()));
                        text2.setText(searchList.get(i).getOpjectCode());

            
            
            
            
            
            
            
            panel.add(text);
            panel.add(text1);
            panel.add(text2);
           
           
       
            } 
       
      
       add(panel,BorderLayout.CENTER);
       /////////////////////////////////////////////////////////////////////
        ArrayList<String> ObjectProgram1 = new ArrayList<String>();
     
        for (int i = 0 ; i < (searchList.size());i++){
            int temp = searchList.get(i).getLOCCTR();
           System.out.println( searchList.get(i).opjectCode);
          for (int l = ObjectProgram1.size();l<temp;l++){
              ObjectProgram1.add("0");
              
              
          }
            String[] s = splitStringEvery(searchList.get(i).getOpjectCode(),2);
            
            for(int j=0 ;j <  s.length ; j++ ){
                ObjectProgram1.add(s[j]);
            }
            
            
            
        }ObjectProgram1.add(Integer.toHexString(searchList.get(0).getLOCCTR()));//I should fix this because it's 3byte
       
      System.out.println(Global.ModeficationRecord);
     P.Loader(ObjectProgram1);
     
    }
        
    }

           
    
    
   


