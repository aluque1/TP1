package es.ucm.tp1.supercars.control.commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.control.exceptions.SaveExecuteException;
import es.ucm.tp1.supercars.logic.Game;

public class DumpCommand extends Command{

	private static final String NAME = "dump";

	private static final String DETAILS = "[d]ump <filename>";

	private static final String SHORTCUT = "d";

	private static final String HELP = "Shows the conntent of a saved file.";

	private String filename;

	public DumpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws SaveExecuteException{
		try (FileReader file = new FileReader (filename + ".txt");
				BufferedReader reader = new BufferedReader(file)){
			String l;
			while ((l = reader.readLine()) != null){
				System.out.println(l);
			} 
			reader.close();

		} catch (IOException e1) {
			throw new SaveExecuteException(e1.getMessage());
		}
		
		return false;
	}

	@Override
	protected Command parse(String[] words) throws CommandParseException{
		Command command = null;
		if (super.matchCommandName(words[0])) {
			if (words.length != 2) {
				throw new CommandParseException(String.format("[Error] : Command %s: %s", NAME, INCORRECT_NUMBER_OF_ARGS_MSG));
			}

			filename = words[1];
			command = this;
		}
		return command;
	}

}
