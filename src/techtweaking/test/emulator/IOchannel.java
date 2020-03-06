package techtweaking.test.emulator;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class IOchannel implements Runnable {
    int commandCode;
        int deviceCode;
        int bytesLength;
        int startingAddress;
        boolean Halt;
        int[][] IOmemory = new int[0xf][] ;
        
        
       
        void Commands(int commandCode,int bytesLength,int startingAddress){
            this.commandCode = commandCode;
        
        this.bytesLength = bytesLength;
        this.startingAddress = startingAddress;
        
        if(this.commandCode == 0)
            {Halt = true;}
            
        
        }
        
        
       public void run(){
        
       while(!Halt){
            if(this.commandCode == 0)
            {Halt = true;continue;}
            else if(this.commandCode == 1){}
                // for (int i=0 ;(i < bytesLength) && !Halt;i++) */
                  //Processor.Memory[startingAddress++] = this.IOmemory[i];
           else if(this.commandCode == 2)
                for (int i=0 ; (i< bytesLength) && !Halt ; i++){}
                  // this.IOmemory[i] = Processor.Memory[startingAddress++];
                    }
   }
        
}
   
                
            
            
                    
        
    

