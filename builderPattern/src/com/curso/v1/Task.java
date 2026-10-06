package com.curso.v1;

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
	
	private Task(int id, LocalDate fechaCreacion, LocalDate fechaTermino, String descripcion, StringBuilder responsable,
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
	
	//NESTED STATIC 
	static class TaskBuilder {
		
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

}
