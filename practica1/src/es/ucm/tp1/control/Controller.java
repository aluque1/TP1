package es.ucm.tp1.control;

import java.util.Scanner;

import es.ucm.tp1.logic.Game;

public class Controller {
	
	// Attributes ---------------------------------------------------
	private boolean exit;
	private boolean passTurn;

	private static final String PROMPT = "Command > ";

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";

	/* @formatter:off */
	private static final String[] HELP = new String[] {
		"Available commands:",
		"[h]elp: show this help",
		"[i]nfo: prints gameobjet info",
		"[n]one | []: update",
		"[q]: go up",
		"[a]: go down",
		"[e]xit: exit game",
		"[r]eset: reset game",
		"[t]est: enables test mode",	
	};
	/* @formatter:off */

	private Game game;
	private Scanner scanner;

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
	}

	public void printGame() {
		System.out.println(game.ToString());
	}

	public void run() {
		String line;
		String[] words;
		printGame();
		
		while (!exit) {
			// We use this to parse the command so it's all in the same format and then we divide the line entered in the console to and array of words
			System.out.print(PROMPT);
			line = scanner.nextLine();
			words = line.toLowerCase().trim().split("\\st");
			
			System.out.println("[DEBUG] Executing: " + words[0]);
			
			// We add a switch statement to create the command options selection
			switch (words[0]) {
			
			// Prints the available commands
			case "help" : case "h":
				for(int i = 0; i < HELP.length; i++)
					System.out.println(HELP[i]);
				passTurn = false;
				break;
				
			// Prints the game object info
			case "info" : case "i" :
				System.out.println(game.getGameStatus());
				passTurn = false;
				break;
				
			// Passes one game cycle without moving UP or DOWN, just FORWARD 1 cell
			case "none" : case "n" : case "":
				passTurn = true;
				break;
			
			// Passes one game cycle and moves the car UP 1 cell
			case "q" :
				 passTurn = game.moveUp();
					if(!passTurn)
						System.out.println("[ERROR] : You are at the edge of the road, you can't move up.");

				break;
			
			//Passes one game cycle and moves the car DOWN 1 cell
			case "a" :
				 passTurn = game.moveDown();
					if(!passTurn)
						System.out.println("[ERROR] : You are at the edge of the road, you can't move down.");
				 
				break;
			
			// Exits the game
			case "exit" : case "e" :
				exit = true;
				System.out.println("[GAME OVER] Player leaves the game");
				passTurn = false; // Don't know if this is needed or not 
				break;
			
			// Resets the game with the same LEVEL and SEED parameters as before
			case "reset": case "r" :
				game.init(); 
				printGame();
				passTurn = false;
				break;
			
			// Enables test mode
			case "test" : case "t" :
				game.toggleTest();
				passTurn = false; // Don't know if this is needed or not 
				printGame();
				break;
			
			
			// In the default case we let the Player know that there has been an error trying to parse the command and doesn't pass a turn.
			default:
				System.out.println("[ERROR] " + UNKNOWN_COMMAND_MSG);
				passTurn = false;
				break;
			}
			
			//This if is to check if we have to update the game board as there are some command that don't advance one step in the game
			if(passTurn) {
				exit = this.game.update();
			if (!exit)
				printGame();
				
			}
		}
	}

}
