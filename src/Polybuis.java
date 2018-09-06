import javax.swing.JOptionPane;

/**
 * 
 * @author Jake Gadaleta
 *
 */
/*
 * String
			keyword = JOptionPane.showInputDialog("Enter the Key Word");
		int
			poly[][],
			i = 0;
		
		for(int counter = 0; counter < keyword.length(); counter++) {
			if(counter % 5 == 0) {
				i = 0;
			}
 */
public class Polybuis {
	public static void main(String[] args) {
			int choice = Integer.parseInt(JOptionPane.showInputDialog("1. Encrypt\n2. Decrypt\n3. Exit"));
			switch(choice) {
			case 1: encrypt(); break;
			case 2: decrypt(); break;
			case 3: System.exit(0);
			default:
				JOptionPane.showMessageDialog(null, "Improper Input", "ERROR", 0);
		}
	}
	
	private static void decrypt() {
		
	}

	private static void encrypt() {
		String
			keyword = JOptionPane.showInputDialog("Enter the Key Word"),
			plainText = JOptionPane.showInputDialog("Enter the plain text");
		char
			poly[][];
		int
			col = 0,
			row = 0;
	}
}

