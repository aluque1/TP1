package es.ucm.tp1.supercars.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.SaveExecuteException;

public enum Record {
	
	TEST(Long.MAX_VALUE), EASY(Long.MAX_VALUE), HARD(Long.MAX_VALUE), ADVANCED(Long.MAX_VALUE);
	
	Long record;
	
	private Record(long record) {
		this.record = record;
	}
	
	public void getRecordsFromFile() {
		
	}
	
	public boolean execute(Game game) throws CommandExecuteException {
		try (FileReader file = new FileReader ("record.txt");
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
	
	public void changeRecord(Long newRecord) {
		if(newRecord < record) {
			record = newRecord;
		}
	}

}
