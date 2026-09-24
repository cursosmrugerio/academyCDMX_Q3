package com.sim21.v1;

public class TestClass{
	   static int si = 10;
	   public static void main (String args[]){
	      new TestClass();
	   }
	   public TestClass(){
	      System.out.println(this);
	   }
	   public String toString(){
	      return "TestClass.si = "+ this.si;
	   }
	}