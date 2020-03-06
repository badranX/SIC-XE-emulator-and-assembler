package techtweaking.test.emulator;


import java.util.Hashtable;
import java.util.*;


public class OPTAB {
    private Hashtable<String, OPCODE> OPTAB = new Hashtable();
 public OPTAB(){   
     OPTAB.put("START",new OPCODE("START",false,false,false,false,"18") );
   
    OPTAB.put("ADD",new OPCODE("ADD",true,true,false,false,"18") );
OPTAB.put("ADDF", new OPCODE("ADDF",true,true,false,false,"58"));
OPTAB.put("ADDR", new OPCODE("ADDR",true,false,false,false,"90"));
OPTAB.put("AND", new OPCODE("AND",true,true,false,false,"40"));
OPTAB.put("CLEAR", new OPCODE("CLEAR",true,false,false,false,"B4"));
OPTAB.put("COMP", new OPCODE("COMP",true,true,false,false,"28"));
OPTAB.put("COMPF", new OPCODE("COMPF",true,true,false,false,"88"));
OPTAB.put("COMPR", new OPCODE("COMPR",true,false,false,false,"A0"));
OPTAB.put("DIV", new OPCODE("DIV",true,true,false,false,"24"));
OPTAB.put("DIVF", new OPCODE("DIVF",true,true,false,false,"64"));
OPTAB.put("DIVR", new OPCODE("DIVR",true,false,false,false,"9C"));
OPTAB.put("FIX", new OPCODE("ADDR",false,true,false,false,"C4"));
OPTAB.put("FLOAT", new OPCODE("FLOAT",true,true,false,false,"C0"));
OPTAB.put("HIO", new OPCODE("HIO",false,true,false,false,"F4"));
OPTAB.put("J", new OPCODE("J",true,true,false,false,"3C"));
OPTAB.put("JEQ", new OPCODE("JEQ",true,true,false,false,"30"));
OPTAB.put("JGT", new OPCODE("JGT",true,true,false,false,"34"));
OPTAB.put("JLT", new OPCODE("JLT",true,true,false,false,"38"));
OPTAB.put("JSUB", new OPCODE("JSUB",true,true,false,false,"48"));
OPTAB.put("LDA", new OPCODE("LDA",true,true,false,false,"00"));
OPTAB.put("LDB", new OPCODE("LDB",true,true,false,false,"68"));
OPTAB.put("LDCH", new OPCODE("LDCH",true,true,false,false,"50"));
OPTAB.put("LDF", new OPCODE("LDF",true,true,false,false,"70"));
OPTAB.put("LDL", new OPCODE("LDL",true,true,false,false,"08"));
OPTAB.put("LDS", new OPCODE("LDS",true,true,false,false,"6C"));
OPTAB.put("LDT", new OPCODE("LDT",true,true,false,false,"74"));
OPTAB.put("LDX", new OPCODE("LDX",true,true,false,false,"04"));
OPTAB.put("LPS", new OPCODE("LPS",true,true,false,false,"D0"));
OPTAB.put("MULF", new OPCODE("MULF",true,true,false,false,"60"));
OPTAB.put("MULR", new OPCODE("MULR",true,false,false,false,"98"));
OPTAB.put("NORM", new OPCODE("NORM",false,true,false,false,"C8"));
OPTAB.put("OR", new OPCODE("OR",true,true,false,false,"44"));
OPTAB.put("RD", new OPCODE("RD",true,true,false,false,"D8"));
OPTAB.put("RMO", new OPCODE("RMO",true,false,false,false,"AC"));
OPTAB.put("RSUB", new OPCODE("RSUB",true,true,false,false,"4C"));
OPTAB.put("SHIFTL", new OPCODE("SHIFTL",true,false,false,false,"A4"));
OPTAB.put("SHIFTR", new OPCODE("SHIFTR",true,false,false,false,"A8"));
OPTAB.put("SIO", new OPCODE("SIO",false,true,false,false,"F0"));
OPTAB.put("SSK", new OPCODE("SSK",true,true,false,false,"EC"));
OPTAB.put("STA", new OPCODE("STA",true,true,false,false,"0C"));
OPTAB.put("STB", new OPCODE("STB",true,true,false,false,"78"));
OPTAB.put("STCH", new OPCODE("STCH",true,true,false,false,"54"));
OPTAB.put("STF", new OPCODE("STF",true,true,false,false,"80"));
OPTAB.put("STI", new OPCODE("STI",true,true,false,false,"D4"));
OPTAB.put("STL", new OPCODE("STL",true,true,false,false,"14"));
OPTAB.put("STS", new OPCODE("STS",true,true,false,false,"7C"));
OPTAB.put("STSW", new OPCODE("STSW",true,true,false,false,"E8"));
OPTAB.put("STT", new OPCODE("STT",true,true,false,false,"84"));
OPTAB.put("STX", new OPCODE("STX",true,true,false,false,"10"));
OPTAB.put("SUB", new OPCODE("SUB",true,true,false,false,"1C"));
OPTAB.put("SUBF", new OPCODE("SUBF",true,true,false,false,"5C"));
OPTAB.put("SUBR", new OPCODE("SUBR",true,false,false,false,"94"));
OPTAB.put("SVC", new OPCODE("SVC",true,false,false,false,"B0"));
OPTAB.put("TD", new OPCODE("TD",true,true,false,false,"E0"));
OPTAB.put("TIO", new OPCODE("TIO",false,true,false,false,"F8"));
OPTAB.put("TIX", new OPCODE("TIX",true,true,false,false,"2C"));
OPTAB.put("TIXR", new OPCODE("TIXR",true,false,false,false,"B8"));
OPTAB.put("WD", new OPCODE("WD",true,true,false,false,"DC"));




OPTAB.put("END", new OPCODE("END",false,false,false,false,""));
OPTAB.put("BASE", new OPCODE("BASE",false,false,false,false,""));

OPTAB.put("BYTE", new OPCODE("BYTE",false,false,false,false,""));
OPTAB.put("WORD", new OPCODE("WORD",false,false,false,false,""));
OPTAB.put("RESB", new OPCODE("RESB",false,false,false,false,""));
OPTAB.put("RESW", new OPCODE("RESW",false,false,false,false,""));
OPTAB.put("EQU", new OPCODE("EQU", false,false,false,false,""));
}
 
 public OPCODE get(String S){
     
     if(S.length()> 1){
     if (S.charAt(0) == '+')  {
         OPCODE X = new OPCODE();
        X.copy(this.get(S.substring(1)));
        X.setMnemonic(S);
        X.setExtended();
        OPTAB.put(X.getMnemonic(), X);
     
     
     }
     
     
     }
        
     return OPTAB.get(S);
 } 
         
 

 
}
