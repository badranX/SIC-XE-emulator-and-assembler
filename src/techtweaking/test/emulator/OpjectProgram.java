package techtweaking.test.emulator;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author yahya
 */


public class OpjectProgram {
    
    
 private ArrayList< String> HeaderRecord=new ArrayList<String >();
 private ArrayList<ArrayList<String>> TextRecord;
  
   private       ArrayList<String> EndRecord;
    
   
   
   public void HeaderRecord (String S) {
       
       this.HeaderRecord.add(S);
       
   }
   
    public void HeaderRecord (String S,int length) {
       
         for(int i = 1 ; i <= 6-length ;i++){
             S = "0" + S ;}
         
       this.HeaderRecord.add(S);
       
   }
   
   public String getHeaderRecord(int i) {
       return this.HeaderRecord.get(i);
   }
    
    /////////////////////
    
    
    
}
