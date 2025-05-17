package keyboardinput;

import java.util.Scanner;
public class keyboardInput{
	// fields
	private Scanner kb;
	
	//constructor
	public keyboardInput() {
		kb = new Scanner(System.in);
	}
	
	// methods
	public String getKeyboardLine(String s) {
		System.out.println(s);
		String line = kb.nextLine();
		return line;
	}
	
	public void closeKeyboard() {
		kb.close();
	}
}