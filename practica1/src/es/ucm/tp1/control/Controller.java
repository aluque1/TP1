package es.ucm.tp1.control;

import java.util.ArrayList;
import java.util.Scanner;

import es.ucm.tp1.logic.Game;

public class Controller {

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
		System.out.println(game);
	}

	public void run() {
		String line;
		String[] words;
		
		line = scanner.nextLine();
		words = line.toLowerCase().trim().split("\\s+");
		
		switch(words[0]) {
		case "h" || "help":
			
			// Prueba github
		}
		
		
		
	}

}
