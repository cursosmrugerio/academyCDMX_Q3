package com.sim21.v0;

interface AmazingInterface{
    String value = "amazing"; //public static final
    void amazingMethod(String arg); //public abstract
}

abstract class AmazingClass implements AmazingInterface{
    static String value = "awesome";
    //Overloadig (Sobrecarga)
    abstract void amazingMethod(String arg1, String arg2);
}


public class Awesome extends AmazingClass implements AmazingInterface {
	@Override
    public void amazingMethod(String arg1){ }
	@Override
    public void amazingMethod(String arg1, String arg2){ }
   
    public static void main(String[] args){
        AmazingInterface ai = new Awesome();

        //INSERT CODE HERE
        //ai.amazingMethod(AmazingInterface.value, AmazingClass.value);
        
        ai.amazingMethod(AmazingInterface.value);
        
        //((AmazingClass)ai).amazingMethod("x1", value); 
        
        //ai.amazingMethod(value);
        
        ai.amazingMethod("x1");
        
        
    
    }

}        