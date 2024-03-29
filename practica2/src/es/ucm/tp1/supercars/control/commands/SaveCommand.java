package es.ucm.tp1.supercars.control.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.control.exceptions.SaveExecuteException;
import es.ucm.tp1.supercars.logic.Game;

public class SaveCommand extends Command{
	private static final String NAME = "save";

	private static final String DETAILS = "[v]: Save <filename>";

	private static final String SHORTCUT = "v";

	private static final String HELP = "Saves the game data in the file specified by the user";

	private String filename;
	
	public SaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public boolean execute(Game game) throws SaveExecuteException {
		try (FileWriter file = new FileWriter (filename + ".txt");
				BufferedWriter writer = new BufferedWriter(file)){
			writer.write(game.toSerialize());
			writer.close();
			System.out.println("Game successfully saved in file " + filename + ".txt");
			
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
