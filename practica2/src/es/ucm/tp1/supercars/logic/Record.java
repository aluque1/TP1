package es.ucm.tp1.supercars.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.ucm.tp1.supercars.control.exceptions.InputOutputRecordException;

public class Record {

	private List<String> records;

	Record(Game game){
		records = new ArrayList<>();
		try {
			initRecords(game);
		} catch (InputOutputRecordException e) {
			e.printStackTrace();
		}
		
	}

	public void initRecords(Game game) throws InputOutputRecordException {
		try (FileReader file = new FileReader ("record.txt");
				BufferedReader reader = new BufferedReader(file)){
			String l;
			while ((l = reader.readLine()) != null){
				records.add(l);
			} 
			reader.close();
		} catch (IOException e) {
			throw new InputOutputRecordException(e.getMessage());
		}
	}

	public Long updateRecord(Game game) throws InputOutputRecordException {
		Long rec = null;
		try(FileWriter file = new FileWriter("record.txt");
				BufferedWriter writer = new BufferedWriter(file);) {
			for(String record: records) {
				writer.write(record);
				writer.newLine();
			}
			writer.close();

		} catch (IOException e) {
			throw new InputOutputRecordException(e.getMessage());
		}

		return rec;
	}

	public void changeRecord(Game game) {
		String level = game.getLevel().name();
		boolean changed = false;
		boolean levelFound = false;
		int i = 0;
		while(!changed && i < records.size()) {
			String parameters[] = records.get(i).trim().split(":");
			String levelName = parameters[0];
			Long levelRecord = Long.parseLong(parameters[1]);
			if(levelName.equalsIgnoreCase(level)) {
				levelFound = true;
				if(levelRecord > game.elapsedTime()) {
					changed = true;
					records.remove(i);
					records.add(levelName + ":" + game.elapsedTime());
				}
			}
			i++;
		}
		if(!levelFound) {
			records.add(level+ ":" + game.elapsedTime());
		}
		try {
			updateRecord(game);
		} catch (InputOutputRecordException e) {
			e.printStackTrace();
		}
	}

	public Long getRecord(Game game) {
		String level = game.getLevel().name();
		boolean changed = false;
		int i = 0;
		Long record = Long.MAX_VALUE;
		if(!records.isEmpty()) {
			while(!changed && i < records.size()) {
				String parameters[] = records.get(i).trim().split(":");
				String levelName = parameters[0];
				Long levelRecord = Long.parseLong(parameters[1]);
				if(levelName.equalsIgnoreCase(level)) {
					changed = true;
					record = levelRecord;
				}
				i++;
			}
		}

		return record;
	}

}
