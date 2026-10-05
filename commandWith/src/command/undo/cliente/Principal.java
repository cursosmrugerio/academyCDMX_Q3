package command.undo.cliente;

import command.undo.dispositivo.*;

public class Principal {

	public static void main(String[] args) {

		ControlInteligente control = new ControlInteligente();
		
		Configuracion.configurar(control);
		
		control.clickBoton1();
		
		//control.clickBotonUndo();
		
		control.clickBoton3();
		
		//control.clickBotonUndo();
		
		control.clickBoton2();
		
		//control.clickBotonUndo();
		
		control.clickBoton4();
		
		control.clickBotonUndo();

		
	}

}
