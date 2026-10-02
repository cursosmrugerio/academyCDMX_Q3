package com.generics.v2;

public class Contenedor<T extends Transporte> {
	
	private T t;

	public Contenedor(T t) {
		this.t = t;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	public <U> void mostrarCertificado(U u){
		
		System.out.println( t +": "+u);
		
	}
	
}
