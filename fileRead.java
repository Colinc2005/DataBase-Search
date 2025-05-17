package fileread;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class fileRead{
	// fields
	private ArrayList<String> lines;
	
	// constructor
	public fileRead(String filename) {
		lines = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String read;
			while((read = reader.readLine()) != null) {
				lines.add(read);
			}
			reader.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// methods
	public int getNumberOfLines() {
		return lines.size();
	}
	
	public String getLine(int index) {
		return lines.get(index);
	}
}