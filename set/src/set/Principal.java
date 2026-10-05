package set;

import java.util.*;

class Empleado{
	
	private String nombre;

	public Empleado(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		//return 99;
		//return Objects.hash(nombre);
		return nombre.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(nombre, other.nombre);
	}


	
}
public class Principal {

	public static void main(String[] args) {
		
		Set<Empleado> empleados = new HashSet<>();
		
		empleados.add(new Empleado("Patrobas"));
		empleados.add(new Empleado("Filologo"));
		empleados.add(new Empleado("Andronico"));
		empleados.add(new Empleado("Patrobas"));
		
		for(Empleado emp : empleados) {
			System.out.println(emp);
		}
		
	}
}
