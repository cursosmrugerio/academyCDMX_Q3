package com.sim21.v0;

interface Classic {
    int version = 1; //public static final
    public void read() ;
}

class MediaReader implements Classic{
    int version = 2;
    public void read() {

        //Insert code here
    	//System.out.println(version); //2
    	//System.out.println((Classic)version);
    	
    	System.out.println(((Classic)this).version);
    	
    	//System.out.println(this.Classic.version);
    	//System.out.println(this.version); //2
    	
    	System.out.println(Classic.version);

    }
}

public class ReaderTest{
    public static void main(String[] args) {
        MediaReader mr = new MediaReader();
        mr.read();
    }
}