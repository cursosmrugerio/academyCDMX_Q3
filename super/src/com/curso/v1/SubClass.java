package com.curso.v1;

class BaseClass{
	   public void print(String s) {  
		   System.out.println("BaseClass :"+s); } //2
	}
	class SubClass extends BaseClass{
	   public void print(String s){
	      System.out.println("SubClass :"+s); //1
	      super.print(s);
	   }
	   public static void main(String args[]){
	      SubClass sc = new SubClass();
	      sc.print("location");
	   }
	}