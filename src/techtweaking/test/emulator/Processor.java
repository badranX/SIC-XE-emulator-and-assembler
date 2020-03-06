package techtweaking.test.emulator;


import java.lang.Object;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
public class Processor implements Runnable {
processorFrame frame = new processorFrame();
int ProgramLength =0;
 
    public Processor(){
        
               frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               
               frame.setVisible(true);
               Arrays.fill(BusyPins, false);
               
               
    }
    
 public static int[] Memory = new int[1048576];
    
 int[] A =  new int[1];
 int[] X = new int[1];
 int[] B = new int[1];
 int[] S = new int[1];
 int[] T = new int[1];
 int[] L = new int[1];
 long[] F = new long[1];
 
 
 int timer;
    static IOchannel [] IOchannels = new IOchannel[0xff];
 
 
 boolean MODE,IDLE;
 int ID,ICODE;
 int MASK;
 
 
 boolean equal,greatter,smaller;
int OpCode;
int PC=0;



int[] IOports = new int[256];
boolean[] BusyPins = new boolean[256];

int  IOinterface(int port){
   return IOports[port];
   
}
DrawRectPanel IOLED = new DrawRectPanel();


void setBusy(int x){this.BusyPins[x] = true;}
int loaderCounter = 0;
void Loader(ArrayList<String> iFromAssembler){
    System.out.println(Global.Mode);
    if(!Global.Mode){
    int i=Integer.parseInt(iFromAssembler.get(iFromAssembler.size()-1));
    
    for( ;i <  iFromAssembler.size()-1 ; i++ ){
                Memory[i] = Integer.parseInt(iFromAssembler.get(i),16);
                System.out.println(Integer.parseInt(iFromAssembler.get(i),16));
                ProgramLength = i;
                
            }//PC = Integer.parseInt(iFromAssembler.get(iFromAssembler.size()-1),16);
    PC = 0;
   // Memory[ProgramLength] = 0xb0;
    }else {
      Memory[1043006+3] = 262144;
      
           int i=Integer.parseInt(iFromAssembler.get(iFromAssembler.size()-1));
    
    for( ;i <  iFromAssembler.size()-1 ; i++ ){
        int tempi = Integer.parseInt(iFromAssembler.get(i),16);
        for(int j=0;j<Global.ModeficationRecord.size(); j++){
            
        if(Global.ModeficationRecord.get(j)==i) 
            tempi += loaderCounter*262144;
            }
                Memory[i+loaderCounter*262144] = tempi;
                ProgramLength = i;
             
    }
    loaderCounter++;
   
    }
    String []StringMemory = new String[1048576];
    for(int i=0 ;i< 1048576;i++ )
                   StringMemory[i] = Integer.toHexString(Memory[i] );
    
    frame.fillList(StringMemory);
   
}

void changeSW(int SW){
    this.MODE = ((SW & 0x1) == 1 )? true : false;
    this.IDLE =  (((SW & 0x2)>>1) == 1) ? true : false; 
    this.ID = (SW & 60) >> 2;
    int CC = ((SW & 192) >> 6);
    if( CC == 0) {smaller = true;equal = false;greatter= false;}
    else if(CC ==1) {smaller = false; equal = true ; greatter = false;}
    else if(CC ==2) {smaller = false; equal = false ; greatter = true;}
    
    this.MASK = (SW & 3840) >> 9;
    this.ICODE = (SW & 16711680) >> 16;
    
}
boolean shutdown=false;
boolean SingleStep= true;
boolean StartStop = true;
int delay= 1000;
public void Delay(int x) { this.delay = x;}
 public void Shutdown(boolean x) {shutdown = x;}
public void SingleStep(boolean x){SingleStep = x;}
 public void startStop(boolean x) {StartStop = x;}
 public void  shutdown(boolean x){shutdown=x;}
int counter =0;
int IntervalTimer = 0;
public void run(){
      int temp;
      
      
  

    
    while(!shutdown){
        while(StartStop){}
        OpCode = Memory[PC++];
        System.out.println(" PRogram COunter =   " + PC);
        System.out.println(OpCode & 0xfc);
        counter++;
        if(!SingleStep){
        try{
        Thread.sleep(this.delay);
        }catch(InterruptedException e){}
        }
  switch (OpCode & 0xfc)
  {
      
      case 0x18 :  A[0] +=  TargetAddress(3);break;
          
      case 0x58 : F[0] +=  sample(6,TargetAddress(3));break;
         
      case 0x90 :    Registers(0);break;
          
      case 0x40 : A[0] &= TargetAddress(3);break;
      case 0xb4 : Registers(1);break;
      case 0x28 :flag(A[0] , TargetAddress(3));break;
      case 0x88 : flag(F[0],sample(6,TargetAddress(6)));break;
      case 0xa0 : Registers(2);break;
      case 0x24 : A[0] = A[0]/TargetAddress(3);break;
      case 0x64 : //break;
          break;
      case 0x9c : Registers(3);break;
      case 0xC4 : //
          break;
      case 0xC0 : //
          break;
      case 0xF4 : IOchannels[A[0]].Commands(0,0,0);
          break;
      case 0x3c : PC = TargetAddress(0);break;
      case 0x30 : if (equal) PC = TargetAddress(0);else TargetAddress(0);break;
      case 0x34 : if(greatter) PC =TargetAddress(0);else TargetAddress(0);break;
      case 0x38 : if(smaller)  PC =TargetAddress(0);else TargetAddress(0);break;
      case 0x48 :temp = TargetAddress(0)  ;
          L[0] = PC  ;PC = temp  ;break;
      case 0x00 :temp = TargetAddress(3);
          A[0] = temp;break;
      case 0x68 : B[0] = TargetAddress(3);break;
      case 0x50 : A[0] &=0xffffff00; A[0] += TargetAddress(3);System.out.println(" PC is : " +Integer.toHexString(PC));break;
      case 0x70 : //
          break;
      case 0x08 : L[0] = TargetAddress(3);break;
      case 0x6c : S[0] = TargetAddress(3);break;
      case 0x74 : T[0] = TargetAddress(3);break;
      case 0x04 : X[0] = TargetAddress(3);break;
      case 0xD0 : temp = TargetAddress(0);
          changeSW((int)sample(3,temp));
          PC = (int)sample(3,temp+3);
          A[0] = (int)sample(3,temp+6);
          X[0] =(int)sample(3,temp+9);
          L[0] = (int)sample(3,temp+12);
          B[0] =(int)sample(3,temp+15);
          S[0] =(int)sample(3,temp+18);
          T[0] =(int)sample(3,temp+21);
          //F[0] = sample(6,temp+24); 
          counter = 0;
          break;
      case 0x20 : A[0] = A[0] * TargetAddress(3);break;
      case 0x60 : //
          break;
      case 0x98 : Registers(4);break;
      case 0xC8 : //
          break;
      case 0x44 : A[0] |= TargetAddress(3);break;
      case 0xD8 :  temp = A[0] ;
          IOports[TargetAddress(1)] = temp*0x000f;break;
      case 0xAC : Registers(5);break;
      case 0x4C : PC = L[0];break;
      case 0xA4 : Registers(6);break;//shift
      case 0xA8 : //shift
      case 0xF0 : //IO
      case 0xEC : //IO
      case 0x0C : writeToMemory(A);break;
          
      case 0x78 : writeToMemory(B);break;
          
      case 0x54 : temp = A[0];
          Memory[TargetAddress(1)] = temp*0x000f;break;
      case 0x80 : //
          break;
         
      case 0xD4 : timer = TargetAddress(3);
          break;
          
      case 0x14 :  writeToMemory(L);break;
      case 0x7C : writeToMemory(S);break;
      case 0xE8 : break;//SW
      case 0x84 :writeToMemory(T);break;
      case 0x10 :writeToMemory(X);break;
      case 0x1C :A[0] -= TargetAddress(3);break;
      case 0x5C ://
          break;
      case 0x94 : Registers(7);break;
      case 0xB0 : int r1 = (Memory[PC++] & 0xf0) >> 1;
          if( r1 == 0){
              PC = 0;
              
          }
          
          
      case 0xE0 :if(BusyPins[TargetAddress(1)]){ 
          equal = true;smaller = false;}else {equal = false;smaller = true;}
       break;
      case 0xF8 :break;//IO
      case 0x2C : ++X[0];break; //CC
      case 0xB8 : ++X[0];Registers(2);break; //CC
      case 0xDC : temp = A[0];
      int TargetTemp =TargetAddress(1);
          IOports[TargetTemp] = temp&0xff;
          if(TargetTemp == 1 || TargetTemp ==0){
              
    IOLED.show();
    IOLED.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    IOLED.startt();}break;
      
      
  }

   frame.refrish(A, X, B, S, T, L, PC,this.MODE,this.IDLE,this.ID);
 
    /* Check for interrupts and do other */
    /* cyclic tasks here                 */
    
    if(counter == IntervalTimer){
        temp = 1043000;
        int mode = (this.MODE) ? 1 : 0;
          int idle = (this.IDLE) ? 1 : 0;
          Memory[temp] = mode + idle + this.ID; 
          Memory[temp+3] = PC;
          Memory[temp+6] = A[0];
          Memory[temp+9] =  X[0];
          Memory[temp+12] = L[0];
          Memory[temp+15] = B[0];
          Memory[temp+18] = S[0];
          Memory[temp+21] = T[0];
          Memory[temp+24] = A[0];
         
          
          changeSW((int)sample(3,temp));
          PC = 0;
          
         /*
          A[0] = (int)sample(3,temp+6);
          X[0] =(int)sample(3,temp+9);
          L[0] = (int)sample(3,temp+12);
          B[0] =(int)sample(3,temp+15);
          S[0] =(int)sample(3,temp+18);
          T[0] =(int)sample(3,temp+21);
          F[0] = sample(6,temp+24); */
          counter = 0;
          IntervalTimer = 0;
    }
    /*ExitRequired*/ 
  
    
    
   
    if(SingleStep)
        startStop(true);
    
    }//end Of while
}

  boolean isExtended(int Opcode){
    if (Integer.toBinaryString(Opcode).charAt(3) == '1')
        return true;
    return false;
} 
  void writeToMemory(int [] R){
     int temp = R[0];
          int temp1 =TargetAddress(1);
          Memory[temp1] = (temp & 0xff0000) >> 4;
          temp = R[0];
          Memory[++temp1] = (temp & 0xff00) >>2;
          temp = R[0];
          Memory[++temp1] = (temp & 0xff) ;
  }
  long sample(int N,int address  ){
      long sampleTemp=0;
      if(N == 0){
          return address;
      }
      for (int i =N-1; i>= 0 ;i--){
         sampleTemp +=  Memory[address++] << 8*i;
      }return sampleTemp;
  }
  void flag(long x,long y){
      if (x == y) {equal =true;greatter = false;smaller=false;}
      else if (x > y) {equal =false;greatter = true;smaller=false;}
      else {equal =false;greatter = false;smaller=true;
      System.out.println("he888888888888888888888");}
  }
  void Registers (int operation ){
      int toot = (Memory[PC++]);
      
       int[] R = new int[2];
      
      R[0] = toot & 0x0f;
      R[1] = (toot & 0xf0) >> 4;
      
      int[] R0= new int[1];
      int [] R1= new int[1];
      
      switch (R[0]){
          case 0 : R0 = A;break;
          case 1 : R0 = X;break;
          
          case 3 : R0 = B;break;
          case 4 : R0 = S;break;
          case 5 : R0 = T;System.out.println("T  is : " + R0[0]);break;
          
          default : System.out.print("nod define Register");break;
      } 
      if(operation != 6){
              switch (R[1]){
          case 0 : R1 = A;break;
          case 1 : R1 = X;break;
          
          case 3 : R1 = B;break;
          case 4 : R1 = S;break;
          case 5 : R1 = T;break;
         
          
          default : System.out.print("nod define Register2");break;
          
      }}
            
              switch (operation) {
                  case 0 : R1[0] = R0[0] + R1[0];break;
                  case 1 : R0[0] = 0;break;
                  case 2 : flag(X[0],R1[0]);System.out.println("R0  : " +R0[0]);break;
                  case 3 : R1[0] = R1[0]/R0[0];break;
                  case 4 : R1[0] = R1[0]*R0[0];break;
                  case 5 : R1[0] = R0[0];break;
                  case 7 : R1[0] -= R0[0];break;
                   case 6 : R1[0]= (R1[0] >>> R[1]) | (R1[0] << (32 - R[1]));
              }
              
      }
  
  int TargetAddress(int N){
      int a1 = (OpCode & 0x003);
     System.out.println("OPCODE :: " +Integer.toHexString(OpCode) );
      int b1 = Memory[PC++];
      int c1 = Memory[PC++];
     System.out.print("Memmory contents :  "+ "i,n  : " +Integer.toHexString(a1) + "  " +Integer.toHexString(b1) + " " + Integer.toHexString(c1));
      int teet =b1 & 0xf0;
      int flags = (a1 << 4) + ( (teet) >> 4);
      
      
      int disp = (( b1 & 0x0f )<< 8 )+ c1 ;
    
      int test = flags & 0x001;
      System.out.println("flag is  : " + flags);
      if(test  != 1){
      switch(flags){
          //simple addressing
          case 0x30 : return (int)sample(N,disp);
          case 0x32 : return (int)sample(N,PC + disp);
          case 0x34 : return (int)sample(N,B[0] + disp);
          case 0x38 : return (int)sample(N,X[0] + disp);
          case 0x3a : return (int)sample(N,PC + X[0] + disp);
          case 0x3c : return (int)sample(N,B[0] + X[0] + disp);
          
          //Indirect addressing
          case 0x20 : return (int)sample(N,Memory[disp]);
          case 0x22 : return (int)sample(N,Memory[PC + disp]);
          case 0x24 : return (int)sample(N,Memory[B[0] + disp]);
              
              //Imediate addressing
              
          case 0x10 : return disp;
          case 0x12 : return PC + disp;
          case 0x14 : return B[0] + disp;
          
      }
      
      test =flags & 0x38;
      
      int test2 = flags & 0x07;
      if (test == 0)
          return (int)sample(N,test2 + disp);
      else if (test == 1)
          return (int)sample(N,(test2 + disp) + X[0]);
      
      
      
  }
   else {
    int d = Memory[PC++];
    
    
         System.out.print(" " +d);
System.out.println("   disp before : " + d);
    disp = (disp << 8) +  d;
    switch (flags) {
        case 0x31 : System.out.println("disp is     " + disp);return (int)sample(N,disp);
        case 0x39 : return (int)sample(N,disp + X[0]);
        case 0x21 : System.out.println("deeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeer");return (int)sample(N,Memory[PC + disp]);
        case 0x11 : System.out.println("tooooot");System.out.println(disp + "  disp ");return disp;
        default : System.out.print("error in the Addressing Mode2");break;
    }
    
}
  return 0;
  }
}
