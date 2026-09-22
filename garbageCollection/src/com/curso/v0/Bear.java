package com.curso.v0;

public class Bear { 
    private Bear pandaBear; 
    
    private void roar(Bear b) { 
        System.out.println("Roar!"); 
        pandaBear = b; 
        
        System.out.println(this.pandaBear == b); //true
        
    } 
    
    public static void main(String[] args) { 
        Bear brownBear = new Bear(); 
        Bear polarBear = new Bear(); 
        brownBear.roar(polarBear); 
        
        System.out.println(brownBear.pandaBear == polarBear); //true
        
        polarBear = null; 
        brownBear = null; 
        System.gc(); 
    } 
}