package techtweaking.test.emulator;



public class OPCODE {
    private String mnemonic =new String();
    private boolean format0 ;
    private boolean format1 ;
    private boolean extended;
    private boolean index;
    private String Opcode ;
    
    public OPCODE() {
    }
    
    public OPCODE (String mnemonic ,boolean  format0 ,boolean format1,boolean extended,boolean index, String Opcode){
        
        this.mnemonic = mnemonic;
        this.format0 = format0;
        this.format1 =format1;
        this.extended = extended;
        this.index = index;
        this.Opcode = Opcode;
        
    }
    
    public String getMnemonic (){
      
        return this.mnemonic;
        
    }
   public void setMnemonic(String S){
    
       this.mnemonic = S;
   }
    public boolean[] format () {
        boolean [] X = new boolean[2];
        X[0] = this.format0;
        X[1] = this.format1;
        return X;
    }
    
    
    public String getOpcode(){
        return this.Opcode;
    }
    public void setExtended(){
        this.extended =true;
    }
    public boolean extended(){
        return this.extended;
    }
        public void setIndex() {
            index = true;
        }
        
        public void copy(OPCODE X){
            
            this.mnemonic = X.mnemonic;
            this.format0 = X.format0;
            this.format1 = X.format1;
            this.extended = X.extended;
            this.index = X.index;
            this.Opcode = X.Opcode;
        }
    
}
