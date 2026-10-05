package command.undo.comandos;

public interface Command {
	
	void execute();
	
	void undo();

}
