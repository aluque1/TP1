package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.*;
import es.ucm.tp1.supercars.logic.Game;

public abstract class Command {

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";

	protected static final String INCORRECT_NUMBER_OF_ARGS_MSG = "Incorrect number of arguments";

	/* @formatter:off */
	protected static final Command[] AVAILABLE_COMMANDS = {
		new HelpCommand(),
		new InfoCommand(),
		new UpdateCommand(),
		new MoveUpCommand(),
		new MoveDownCommand(),
		new ExitCommand(),
		new CheatCommand(),
		new ResetCommand(),
		new TestCommand(),
		new ShootCommand(),
		new GrenadeCommand(),
		new WaveCommand(),
		new ClearCommand()
		
		// Add the new commands created here last one without a coma
	};
	/* @formatter:on */

	public static Command getCommand(String[] commandWords) throws CommandParseException {
		Command command = null;
		int i = 0;
		while(command == null && i < AVAILABLE_COMMANDS.length) {
			command = AVAILABLE_COMMANDS[i].parse(commandWords);
			i++;
		}
		if(command == null)
			System.out.format("[ERROR]: %s%n%n", UNKNOWN_COMMAND_MSG);
		
		return command;
	}

	private final String name;

	private final String shortcut;

	private final String details;

	private final String help;

	public Command(String name, String shortcut, String details, String help) {
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}

	public abstract boolean execute(Game game) throws CommandExecuteException;

	protected boolean matchCommandName(String name) {
		return this.shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);
	}

	protected Command parse(String[] words) throws CommandParseException{ 
		if (matchCommandName(words[0])) {
			if (words.length != 1) {
				throw new CommandParseException(String.format("[Error] : Command %s: %s", name, INCORRECT_NUMBER_OF_ARGS_MSG));
			} else {
				return this;
			}
		}
		return null;
	}

	protected String getHelp() {
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < AVAILABLE_COMMANDS.length; i++) {
			str.append(AVAILABLE_COMMANDS[i].details + ": " + AVAILABLE_COMMANDS[i].help + '\n' );
		}
		return str.toString();
		
	}
	
	protected boolean doesInstantMovement() {
		return false;
	}
	
}
