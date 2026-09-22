package com.curso.v0;

public class Bear1 { 
    private Bear1 pandaBear; 
    
    private void roar(Bear1 b) { 
        //System.out.println("Roar!"); 
        pandaBear = b;         
    } 
    
    public static void main(String[] args) { 
        Bear1 brownBear = new Bear1(); 
        Bear1 polarBear = new Bear1(); 
        Bear1 bear = new Bear1(); 
        
        brownBear.roar(polarBear); 
        polarBear.roar(bear);
        
        brownBear.pandaBear = polarBear.pandaBear;
        
        System.out.println(bear == brownBear.pandaBear); //true
                
        polarBear = null; 
        brownBear = null; 
        System.gc(); 
    } 
}