package techtweaking.test.emulator;



public class Line {
    
    public Line(){
        this.sympol = null;
    }

    private String sympol;
    private OPCODE opcode;
    private OPERAND operand =new OPERAND();
    private int Loc;///////////
    
  
   public void setSymbol(String sympol){
       
               this.sympol=sympol;
   }
   
   public void setOpcode(OPCODE opcode){
       this.opcode=opcode;
   }
   
   public void setOperand(String operand){
       this.operand.setString(operand);
   }
   
   public void setLoc(int Loc){
       this.Loc = Loc;
       

   }
   public int getLoc(){
           return this.Loc;}
   
 public OPCODE getOpcode (){
     return this.opcode;
 }
 
public OPERAND getOperand (){
     return this.operand;
 }

public String getSympol (){
     return this.sympol;
 }
}
