package es.ucm.tp1.supercars.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import es.ucm.tp1.supercars.control.exceptions.InputOutputRecordException;

public enum Record {
	
	TEST(Long.MAX_VALUE), EASY(Long.MAX_VALUE), HARD(Long.MAX_VALUE), ADVANCED(Long.MAX_VALUE);
	
	Long record;
	
	private Record(long record) {
		this.record = record;
	}
	
	public void getRecordsFromFile() {
		
	}
	
	public Record execute(Game game) throws InputOutputRecordException {
		Record rec = null;
		try (FileReader file = new FileReader ("record.txt");
				BufferedReader reader = new BufferedReader(file)){
			String l[];
			for (Record r: Record.values()) {
				while ((l = reader.readLine().toLowerCase().trim().split(":")) != null){
					if (l[0] == r.name()) {
						record = Long.valueOf(l[1]);
						rec = r;
					}
				} 
			}
			reader.close();
		} catch (IOException e1) {
			throw new InputOutputRecordException(e1.getMessage());
		}
		
		return rec;
	}
	
	public String getRecordOfLevel(Game game) throws InputOutputRecordException {
		return String.valueOf(execute(game).record);
	}
	
	public void changeRecord(Long newRecord) {
		if(newRecord < record) {
			record = newRecord;
		}
	}

}
