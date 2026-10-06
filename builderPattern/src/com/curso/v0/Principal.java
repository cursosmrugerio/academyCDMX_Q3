package com.curso.v0;

import java.time.LocalDate;

public class Principal {

	public static void main(String[] args) {

		Task task1 = new TaskBuilder(1)
						.build();
		
		System.out.println(task1);
		
		
		Task task2 = new TaskBuilder(2)
				.setResponsable(new StringBuilder("Patrobas"))
				.setFechaCreacion(LocalDate.now())
				.build();

		System.out.println(task2);
		
		Task task3 = new TaskBuilder(3)
				.setProyecto("Academy Xideral")
				.setResponsable(new StringBuilder("Epeneto"))
				.setFechaCreacion(LocalDate.now())
				.setDescripcion("Revisar issue")
				.setConcluido(true)
				.setCancelado(false)
				.setAsignado(new StringBuilder("Mike"))
				.build();
		
		System.out.println(task3);
		
		Task task4 = new Task(4, 
							null, 
							null,
							null,
							null,
							null,
							false,
							null,
							false);
		
		System.out.println(task4);
	}

}
