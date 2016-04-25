/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author khalid
 */
public class Lab9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

         String path="C://Users//khalid//Desktop//6th sem//test//net.txt";
         int o=interpret(path);
         System.out.println("value:"+o);
         
    }//main
    
    
    public static int interpret(String p){
          ArrayList var = new ArrayList();
          ArrayList val = new ArrayList(); 
          ArrayList out = new ArrayList();
          ArrayList op = new ArrayList();
          String variable;
          String operator;
          int value;
          int output=0;
          String ret="print";
     File f=new File(p);
         try {
    BufferedReader br = new BufferedReader(new FileReader(f));
    
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        String search  = "=" ;
        
        
        while (line != null) {
            
            if (line.toLowerCase().indexOf(search.toLowerCase()) != -1 ) {
                ///////
                //value=Integer.parseInt(line.substring(line.indexOf("=") + 1, line.indexOf(";")));
                value=Integer.parseInt(line.substring(line.indexOf("=") + 1));
                val.add(value);
                variable=line.substring(line.indexOf(" ") + 1, line.indexOf("="));
                var.add(variable);
                }//if
            
            if (line.toLowerCase().indexOf(ret.toLowerCase()) != -1 ) {
                ret=line;
            }
            
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        br.close();
        
    } catch(Exception e) {
        
      //  System.out.println("Sorry file not found!");
    }
         
         try{
         for(int i=0;i< ret.length();i++){
             if(var.contains(""+ret.charAt(i))){ 
                 output=((Integer)val.get(var.indexOf(""+ret.charAt(i)))).intValue();
                 out.add(output);
    
             }
             if(ret.charAt(i)=='+'||ret.charAt(i)=='-'||ret.charAt(i)=='/'|ret.charAt(i)=='*'){
                 op.add(ret.charAt(i));             
             }
             if(Character.isDigit(ret.charAt(i))){
                 output= Character.getNumericValue(ret.charAt(i));
                 out.add(output);
                
             }
             
             
         }//for
         output=0;
         if(op.size()==0){
             return ((Integer)out.get(0)).intValue();
         }
         if(op.size()>0){
          for(int i=0;i<op.size();i++){
              
              /////+///////////
              if(op.get(i).toString().charAt(0)=='+'){
                  if(i==op.size()-1){
                      output=output+((Integer)out.get(i)).intValue()+((Integer)out.get(i+1)).intValue();
                  }
                   
              }
              //////////-//////
              if(op.get(i).toString().charAt(0)=='-'){
                  if(i==op.size()-1){
                      output=((Integer)out.get(i)).intValue()-((Integer)out.get(i+1)).intValue();}
              }
              //////*////////
              if(op.get(i).toString().charAt(0)=='*'){
                  if(i==op.size()-1){

                  output=((Integer)out.get(i)).intValue()*((Integer)out.get(i+1)).intValue();
                  }
                  
              }
              /////// div  //////
              if(op.get(i).toString().charAt(0)=='/'){
                  if(i==op.size()-1){
                   output=((Integer)out.get(i)).intValue()/((Integer)out.get(i+1)).intValue();
                  }
              }
              
              
              
              
          
          }//for
          
         }//if
          
         //System.out.println("value is:"+output);
         }//try
         catch(Exception e){
         System.out.println("error!"+Thread.currentThread().getStackTrace()[1].getLineNumber());
         
         }
         
         
     return output;
  
    }//method
    
    
}
