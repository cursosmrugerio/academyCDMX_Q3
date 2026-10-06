package com.curso.v0;

import java.time.LocalDate;

public class TaskBuilder {
	
	private int id;
	private LocalDate fechaCreacion;
	private LocalDate fechaTermino;
	private String descripcion;
	private StringBuilder responsable;
	private StringBuilder asignado;
	private boolean concluido;
	private String proyecto;
	private boolean cancelado;
	
	public TaskBuilder(int id) {
		this.id = id;
	}

	public TaskBuilder setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
		return this;
	}

	public TaskBuilder setFechaTermino(LocalDate fechaTermino) {
		this.fechaTermino = fechaTermino;
		return this;
	}

	public TaskBuilder setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	public TaskBuilder setResponsable(StringBuilder responsable) {
		this.responsable = responsable;
		return this;
	}

	public TaskBuilder setAsignado(StringBuilder asignado) {
		this.asignado = asignado;
		return this;
	}

	public TaskBuilder setConcluido(boolean concluido) {
		this.concluido = concluido;
		return this;
	}

	public TaskBuilder setProyecto(String proyecto) {
		this.proyecto = proyecto;
		return this;
	}

	public TaskBuilder setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
		return this;
	}
	
	public Task build(){
		return new Task(id, 
				    fechaCreacion,
				    fechaTermino,
				    descripcion,
				    responsable,
				    asignado,
				    concluido,
				    proyecto,
				    cancelado);
	}
	
}
