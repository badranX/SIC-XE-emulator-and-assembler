package techtweaking.test.emulator;



public class OPERAND {
    private String operand;
  boolean immediate;
  boolean C;
  boolean X;
  boolean indirect;
  boolean index;
    public void setString(String S){
        if(S.length()>= 2)
        if (S.substring(0,2).equals( "C'")) {
        S=S.substring(2);
        S = S.substring(0, S.length() - 1);
        C=true;
        X=false;
        immediate = false;
                indirect = false;
                index = false;

        }else if(S.substring(0,2).equals("X'")){
        
            S=S.substring(2);
        S = S.substring(0, S.length() - 1);
        X=true; 
        C=false;
        immediate = false;
                indirect = false;
index = false;
        }else if (S.charAt(0)=='#')
        {
           S = S.substring(1);
           X=false; 
        C=false;
        immediate = true;
        indirect = false;
        index = false;
        }else if(S.charAt(0) == '@'){
             S=S.substring(1);
        
            X=false; 
        C=false;
        immediate = false;
        indirect=true;
        index = false;
       }else if (S.substring(S.length() - 2,S.length()).equals(",X") ){
           
           S=S.substring(0,S.length()-2);
             X=false; 
        C=false;
        immediate = false;
        indirect=false;
        index = true;
       }
        
        
         this.operand = S;
    }
    
    public String getString(){
        if (operand == null) return "";
         return this.operand ;
    }
    
    
    
    public int getLength(){
        
        return this.operand.length()-3;
    }
    
    public int getNumber(){
        return Integer.parseInt(operand);
    }
    
    public int getNumber0X(){
        return Integer.parseInt(operand,16);
    }
    
    public boolean immediate(){
        return this.immediate;
    }
    public void setImmediate(boolean x){
        this.immediate=x;
    }
      public boolean C(){
        return this.C;
    }
        public boolean X(){
        return this.X;
    }
        public boolean index(){
            return this.index;
        }
        
        public boolean indirect(){
            return this.indirect;
            
        }
}
