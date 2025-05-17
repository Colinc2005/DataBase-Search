package filewrite;

import java.util.ArrayList;
import java.io.*;

public class fileWrite{
	// fields
	private ArrayList<String> buff;
	private String filename;
	
	// constructor
	public fileWrite(String filename) {
		this.filename = filename;
		buff = new ArrayList<>();
	}
	
	// methods
	public void writeLine(String newLine) {
		buff.add(newLine);
	}
	
	public void saveFile() {
		try {
			FileWriter fw = new FileWriter(filename);
			BufferedWriter bw = new BufferedWriter(fw);
			for(String f: buff) {
				bw.write(f);
				bw.write('\n');
			}
			bw.close();
		}catch(IOException e) {
			System.out.println("no file found");
		}
	}
}