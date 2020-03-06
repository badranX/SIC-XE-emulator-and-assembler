package techtweaking.test.emulator;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Hashtable;
import java.util.ArrayList;
import javax.swing.JFrame;

import javax.swing.JTextArea;
/**
 *
 * @author yahya
 */
public class ASSEMBLER {
    
      String programName ;
    
     private Hashtable<String, Integer> SYMTAB = new Hashtable();
     private Hashtable<String,Integer> EQUtable = new Hashtable();
   private OPTAB OPTAB = new OPTAB();
   public   ArrayList<Line> intermediateFile = new ArrayList<Line>();
   public ArrayList<OpjectCode> OpjectCode = new ArrayList<OpjectCode>();
   
   private int startingAddress ;
   private int LOCCTR;
   private int programLength;
    private boolean errorFlag;
    private boolean errorFlagOC;
    private int counter = 0;
    
    
    private OpjectProgram opjectProgram =new OpjectProgram();
  private  JTextArea program;
    private boolean Base= false;
    int BASE ;
    public ASSEMBLER ( JTextArea program){
        this.program = program;
       
        
        
    }
  /*  public String twoComplement (int X)
    {
        
        String S = Integer.toHexString(X);
        
        while (S.length() < 3 )
            S= "0" +S;
        
       int w;
      /*  for (int i = 0 ; i < S.length() ; i++){
            
               w= Integer.parseInt(S.substring(i,i+1) ,16); 
               
               w=15-w;
              S = S.substring(0,i) + Integer.toHexString(w) + S.substring(i+1);
        }
         w=Integer.parseInt(S,16);
         w=w+1;
         S=Integer.toHexString(w);
        
        return S;
    } */
    public   ArrayList<Line> Ilines = new ArrayList<Line>();
   public void OpjectCode(Line line){
   Ilines.add(line);
         if(line.getOperand() != null){ //if there's operand
                
               
                   
           
                
                
              
        
      int n =2;
      int i = 1;
      int x=0;
      int b=0;
      int p=0;
      int e=0;
      
       if (line.getOpcode().format()[0] && line.getOpcode().format()[1] ) {
      

       if(line.getOperand().immediate())
       {  i =1; n=0;}
       
       
       if(line.getOperand().indirect())
       {i =0; n = 2;}
       
     
       if(line.getOperand().index()){
           x=8;
       }
       
       if(line.getOpcode().extended())
       {
          
            e=1;
Global.ModeficationRecord.add(line.getLoc());
 String TargetAddress;
           if(SYMTAB.get(line.getOperand().getString()) != null)
                     TargetAddress = Integer.toHexString( SYMTAB.get(line.getOperand().getString()));
           else
             TargetAddress = Integer.toHexString(Integer.parseInt( line.getOperand().getString()));
           
           String flag = Integer.toHexString(x + b+p+e);
           String O =   Integer.toHexString(Integer.parseInt(line.getOpcode().getOpcode(),16) +i + n);
           
           
           
           
           while(TargetAddress.length() <5){
           TargetAddress = "0" + TargetAddress;
       }
           while(O.length() <2){
               O = "0" + O;
      }
         
           OpjectCode.add(new OpjectCode (line.getLoc(), O + flag + TargetAddress ));
           return;
       }else if(!line.getOpcode().extended()){
           
          e=0;
          String TargetAddress;
                     String O =   Integer.toHexString(Integer.parseInt(line.getOpcode().getOpcode(),16) +i + n);
 while(O.length() <2){
           O = "0" + O;
       }
                     
           if(SYMTAB.get(line.getOperand().getString()) != null)
                     TargetAddress = Integer.toHexString( SYMTAB.get(line.getOperand().getString()));
           else if(line.getOperand().getString().matches(("((-|\\+)?[0-9]+(\\.[0-9]+)?)+"))){
              TargetAddress = Integer.toHexString(Integer.parseInt( line.getOperand().getString()));
                while(TargetAddress.length() <3){
           TargetAddress = "0" + TargetAddress;
       }
                                    OpjectCode.add(new OpjectCode (line.getLoc(), O + "0" + TargetAddress ));
                           return;
           }
           
           else {
                 OpjectCode.add(new OpjectCode (line.getLoc(),O +"0000"));
                 return;
           }
            
           
           int   disp =Integer.parseInt (TargetAddress,16) - (line.getLoc() + 3);
;
          
           if(disp >= -2048 && disp <=2047){b=0;p=2;
           } else if(this.Base){ b=4;p=0;
           disp=Integer.parseInt (TargetAddress,16) - this.BASE;
           }
          
           
          String flag = Integer.toHexString(x + b+p+e);
          
                while(O.length() <2){
               O = "0" + O;
       }
                TargetAddress = Integer.toHexString(disp);
                if(disp < 0){
                    TargetAddress = TargetAddress.substring(5, TargetAddress.length());
                    
                }
                    
                    
                
                  while(TargetAddress.length() <3){
           TargetAddress = "0" + TargetAddress;
       }
                  TargetAddress.substring(0,3);
                      OpjectCode.add(new OpjectCode (line.getLoc(), O + flag + TargetAddress ));
                     return;
       }
       
            }
       else if (line.getOpcode().format()[0] && !line.getOpcode().format()[1]){
           
           String halfByte = "";
           String test = line.getOperand().getString();
       String byt;
           if(test.charAt(0) == 'A') halfByte = "0";
          else if(test.charAt(0)== 'X') halfByte = "1";
          else if(test.charAt(0)== 'S') halfByte = "4";
          else if(test.charAt(0)== 'B') halfByte = "3";
          else if(test.charAt(0)== 'T') halfByte = "5";
          else if(test.charAt(0)== 'F') halfByte = "6";
          

           byt=halfByte;
                     halfByte = "0";

           if(line.getOperand().getString().length()>2){
           test=line.getOperand().getString().substring(2);
           if(test.charAt(0) == 'A') halfByte = "0";
         else  if(test.charAt(0)== 'X')halfByte = "1";
         else  if(test.charAt(0)== 'S') halfByte = "4";
         else  if(test.charAt(0)== 'B') halfByte = "3";
         else  if(test.charAt(0)== 'T') halfByte = "5";
         else  if(test.charAt(0)== 'F') halfByte = "6";
           
           }
                      byt=byt + halfByte;

                      OpjectCode.add(new OpjectCode (line.getLoc(), line.getOpcode().getOpcode() + byt ));
                    return;
           
       }
        
        }else if(!line.getOpcode().format()[0] && line.getOpcode().format()[1]){
           
           OpjectCode.add(new OpjectCode(line.getLoc(),line.getOpcode().getOpcode()));
           return;
       }
        
        if(!line.getOpcode().format()[0] && !line.getOpcode().format()[1]){
           
           if(line.getOpcode().getMnemonic().equals("WORD")){
               String S= Integer.toString(Integer.parseInt(line.getOperand().getString(),16)) ;
               while (S.length() <6){
                   S = "0"  + S;
               }
              
               OpjectCode.add(new OpjectCode(line.getLoc(),S));
               return;
           }
           else if( line.getOpcode().getMnemonic().equals("BYTE")){
               String S="";
               if(line.getOperand().C()){
                   String test = line.getOperand().getString();
     for ( int i = 0; i < test.length(); ++i ) {
       char c = test.charAt( i );
       int j = (int) c;
       S= S + Integer.toHexString(j);
       
       }
          while (S.length() <6){
                   S = "0"  + S;
               }
          OpjectCode.add(new OpjectCode(line.getLoc(),S));
          return;
               }else if (line.getOperand().X()){
                    OpjectCode.add(new OpjectCode(line.getLoc(),line.getOperand().getString()));
                    return;
               }
           }
       }
            
   }
    public void PASS2() {
        
       
        if (this.intermediateFile.get(0).getOpcode().getMnemonic().equals("START")){
            
            ///creating Header Record
        
            opjectProgram.HeaderRecord("H");
            opjectProgram.HeaderRecord(this.intermediateFile.get(0).getSympol());
            opjectProgram.HeaderRecord(Integer.toHexString(this.startingAddress),Integer.toHexString(this.startingAddress).length());
         
            opjectProgram.HeaderRecord(Integer.toHexString(this.programLength),Integer.toHexString(this.programLength).length());
          
        }
        
        for (int i = 0 ;i< this.intermediateFile.size();i++){  /// while not "end"
            
            
            Line line = this.intermediateFile.get(i);
            
            if(line.getOpcode().getMnemonic().equals("BASE")){
                this.Base = true;
                this.BASE = SYMTAB.get(line.getOperand().getString());
                continue;
            }
            else if(line.getOpcode().getMnemonic().equals("NOBASE")){
                this.Base=false;
                
                continue;
            }
            else if(line.getOpcode().getMnemonic() .equals("END")){
                break;
            }
            else if(line.getOpcode().getMnemonic().equals("RESW")  || line.getOpcode().getMnemonic().equals("RESB")){
                continue;
            }
            else if(line.getOpcode().getMnemonic().equals("EQU")){continue;}
            
            
            
                OpjectCode(line);
                
              //table frame I blocked it for now
    }
       
        
  TableFrame1 frame = new TableFrame1(this.OpjectCode,Ilines);
               frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               frame.setSize(500,600);
               frame.setVisible(true);
           
  
   /*
  for(int i = 0 ; i < this.intermediateFile.size() ; i++){
    System.out.println(this.intermediateFile.get(i).getLoc());
      System.out.println(this.intermediateFile.get(i).getOpcode().getOpcode());
  System.out.println(this.intermediateFile.get(i).getOperand().getString());}
    */
    
    
    }
    
    
    
    
    
    
    
    public  void PASS1 (){
        
            
        
        Line line =new Line();

line = readLine();

if ( line.getOpcode().getMnemonic().equals("START") ) 
{
    startingAddress = Integer.parseInt (line.getOperand().getString(),16);
   programName = line.getSympol();
    LOCCTR =startingAddress;
    intermediateFile.add(line);
    line = readLine();  
}
else{ LOCCTR = 0;}

    
    while (!line.getOpcode().getMnemonic().equals("END"))
    {
        
        line.setLoc(LOCCTR);
        if(line.getSympol() != null) 
        {
            
            if (SYMTAB.get(line.getSympol()) != null)
                errorFlag = true;
            else if (line.getOpcode().getMnemonic().equals("EQU")){
                
                    SYMTAB.put(line.getSympol(), line.getOperand().getNumber());
            //EQUtable.put(line.getSympol(), line.getOperand().getNumber());
            }
            else{
                SYMTAB.put(line.getSympol(), LOCCTR);
            }
        }
        
     
            if(OPTAB.get(line.getOpcode().getMnemonic()) != null)
            {
                        OPCODE OP = OPTAB.get(line.getOpcode().getMnemonic());

                if (OP.extended())
                        LOCCTR =LOCCTR +4;
                else if (!OP.extended() && OP.format()[0] && OP.format()[1] )
                    LOCCTR = LOCCTR + 3;
                else if (!OP.extended() && OP.format()[0] &&  !OP.format()[1] ) 
                     LOCCTR = LOCCTR + 2;
                else if (!OP.extended() &&     !OP.format()[0] &&  OP.format()[1] ) 
                     LOCCTR = LOCCTR + 1;
                 else if (OPTAB.get(line.getOpcode().getMnemonic()).getMnemonic().equals("WORD"))
                LOCCTR = LOCCTR +3;
            else if(OPTAB.get(line.getOpcode().getMnemonic()).getMnemonic().equals("RESW"))
                LOCCTR = LOCCTR + line.getOperand().getNumber()*3 ;
             else if(OPTAB.get(line.getOpcode().getMnemonic()).getMnemonic().equals("RESB"))
                LOCCTR = LOCCTR + line.getOperand().getNumber();
            else if(OPTAB.get(line.getOpcode().getMnemonic()).getMnemonic().equals("BYTE") && line.getOperand().C())
            LOCCTR=LOCCTR + 3;
              else if(OPTAB.get(line.getOpcode().getMnemonic()).getMnemonic().equals("BYTE") && line.getOperand().X())
            LOCCTR=LOCCTR + 1;
              
            else
                errorFlagOC =true;
                
            }
           
            
            
                
         intermediateFile.add(line); 
        line =readLine();
        
        
        
       
    }
    intermediateFile.add(line); 
    programLength = LOCCTR - startingAddress;
   
               
          
          this.PASS2();
    }
    
    
       private Line readLine (){
       
          String str;
          String tempstr;
       
          
         Line line = new Line() ;
        
        
        
BufferedReader reader = new BufferedReader(
  new StringReader(program.getText()));
    
try {
    //escape line which has been *************
    for (int i = 1; i <= counter ;i++ ){
          reader.readLine();
        
       
    
    }counter++;
    
    // end
   
  if ((str = reader.readLine()) != null) {
                
         
              for (int i=0; i <str.length();i++){
                  
                  
              
                          if (str.charAt(i) !=' '){
                              int j =i;
          for (;str.charAt(i) !=' ' ;i++){
              
              if (i  == str.length()-1 )
              {
              i=i+1;
              break;}
                          }
                
          
          if(OPTAB.get(str.substring(j,i)) != null)
                  line.setOpcode(OPTAB.get(str.substring(j,i)));
          
           else if(line.getOpcode() !=null) 
              line.setOperand( str.substring(j,i)); 
                  
              
           else line.setSymbol( str.substring(j,i));
               }  
                          
              } 
          
         



          }
  
   
             
              
  
         
         
}     
          

 catch(IOException e) {
  e.printStackTrace();
} 
      

return line;
    }
    
}
