package com.curso.v0;

import java.time.*;

public class Task {
	
	private int id;
	private LocalDate fechaCreacion;
	private LocalDate fechaTermino;
	private String descripcion;
	private StringBuilder responsable;
	private StringBuilder asignado;
	private boolean concluido;
	private String proyecto;
	private boolean cancelado;
	
	public Task(int id, LocalDate fechaCreacion, LocalDate fechaTermino, String descripcion, StringBuilder responsable,
			StringBuilder asignado, boolean concluido, String proyecto, boolean cancelado) {
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.fechaTermino = fechaTermino;
		this.descripcion = descripcion;
		this.responsable = responsable;
		this.asignado = asignado;
		this.concluido = concluido;
		this.proyecto = proyecto;
		this.cancelado = cancelado;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", fechaCreacion=" + fechaCreacion + ", fechaTermino=" + fechaTermino
				+ ", descripcion=" + descripcion + ", responsable=" + responsable + ", asignado=" + asignado
				+ ", concluido=" + concluido + ", proyecto=" + proyecto + ", cancelado=" + cancelado + "]";
	}
	

}
