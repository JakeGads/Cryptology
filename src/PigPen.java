import javax.swing.JOptionPane;

public class PigPen {
	//TODO rework the entire class using JOptionPane image views
	/**
	 * @author Jake Gadaleta
	 *takes plaintext and converts it to the somewhat pigpen information
	 */
	public static void main(String[] args) {
		String
				pigPenAlphabet[] = {"_|", "_|", "|_", "]", "[]", "[", "-|", "|-|", "|-",
									"._|", "._|", ".|_", ".]", ".[]", ".[", ".-|", ".|-|", ".|-",
									"V", ">", "<","^", "V.", ">.", "<.","^."},
				alphabetUpper = "ABCDEFGHJKLMNOPQRSTUVWXYZ",
				plaintext = JOptionPane.showInputDialog("Please enter the text that you would like to be converted"),
				encrypted = ""; 
		plaintext = plaintext.replaceAll("\\s+", "");
		plaintext = plaintext.toUpperCase();
		char[] 	
				charPlain = plaintext.toCharArray();
		for(int i = 0; i < charPlain.length; i++) {
			if(charPlain[i] == 'I') {
				charPlain[i] = 'J';
				
			}
			for(int h = 0; h < alphabetUpper.length(); h++)
			{
				if(plaintext.toUpperCase().charAt(i) == alphabetUpper.charAt(h)) {
					encrypted += pigPenAlphabet[h];
				}
			}
		}
		JOptionPane.showMessageDialog(null, encrypted, "Encrypted", 1);
	}
}
