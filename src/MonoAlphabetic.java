import javax.swing.JOptionPane;

/**
 *  Author: William Fitzgerald
 *  Purpose: This class's purpose is to implement the user selected cipher to encrypt or decrypt a message entered by
 *  		 the user. 
 */
public class MonoAlphabetic 
{

	/**
	 * Purpose: This function is the main function, it calls other functions and stores/displays what they
	 * 			return
	 */
	public static void main(String[] args) 
	{
		int menuOption = 0;
		menuOption = menu(menuOption);
		
		int encrDecr = 0;
		encrDecr = getEncryptDecrypt(encrDecr);
		
		String message = "";
		message = getMessage(message);
				
		cipherSelect(menuOption, message, encrDecr);
		
		System.exit(0);
	}
	
	/**
	 * Purpose: This functions purpose is to display the menu and get the input on which cipher is selected
	 * Returns: Integer menuOption
	 */
	public static int menu(int menuOption)
	{
		do
		{
				String menuOptionStr = JOptionPane.showInputDialog("Please select the cipher you would like to use: "
											  + "\n1. Additive Cipher \n2. Multiplication Cipher \n3. Affine Cipher");
				menuOption = Integer.parseInt(menuOptionStr);
		} while(menuOption < 0 || menuOption > 4);
		
		return menuOption;
	}
	
	/**
	 * 
	 *  Purpose: This functions purpose is to ask the user for the message that will be encrypted
	 *  		 or decrypted. 
	 *  Returns: String message
	 */
	public static String getMessage(String message)
	{
		String messageOrg = JOptionPane.showInputDialog("Please enter your message: ");
		String messageLow = messageOrg.toLowerCase();
		message = messageLow.replaceAll("\\s", ""); 
				
		return message;
	}
	
	/**
	 *  Purpose: This functions purpose is to take the integer returned from menuOption and call that related 
	 *  		 function. (The selected cipher)
	 */
	public static void cipherSelect(int menuOption, String message, int encrDecr)
	{
		switch(menuOption)
		{
		case 1:
			AdditiveCipher(message, encrDecr);
			break;
		case 2: 
			MultiplicationCipher(message, encrDecr);
			break;
		case 3:
			AffineCipher(message, encrDecr);
			break;
		}
	}
	
	/**
	 *  Purpose: This functions purpose is to ask the user whether they would like to encrypt or decrypt the 
	 *           message.
	 *  Returns: Integer encrDecr
	 */
	public static int getEncryptDecrypt(int encrDecr)
	{
		do
		{
			String optionStr = JOptionPane.showInputDialog("Please select requested action: \n1.Encrypt \n2. Decrypt");
			encrDecr = Integer.parseInt(optionStr);
		} while(encrDecr < 0 || encrDecr > 3);
		
		return encrDecr;
	}
	
	/**
	 *  Purpose: This functions purpose is to execute the Additive cipher, both encrypting or decrypting.
	 */
	public static void AdditiveCipher(String message, int encrDecr)
	{
		String keyStr = JOptionPane.showInputDialog("Please enter the key number: ");
		int key = Integer.parseInt(keyStr);
		
		String cipherText = "",
				plainText = "";
		char encrypting = ' ',
				decrypting = ' ';
		
		if(encrDecr == 1)
		{
			for(int i = 0; i < message.length(); i++)
			{
				encrypting = (message.charAt(i));
				cipherText += (char)((int)(encrypting + key -97) % 26 + 97);
			
			}
			JOptionPane.showMessageDialog(null, cipherText);
		}
		else
		{
			for(int i = 0; i < message.length(); i++)
			{
				decrypting = (message.charAt(i));
				plainText += (char)((int)((decrypting - 97) + (26 - key )) % 26 + 97);
			}
			JOptionPane.showMessageDialog(null, plainText);
		}
		
	}
	
	/**
	 *  Purpose: This functions purpose is to execute the Multiplicative cipher, both encrypting or decrypting.
	 */
	public static void MultiplicationCipher(String message, int encrDecr)
	{
		String keyStr = JOptionPane.showInputDialog("Please enter the key number: ");
		int key = Integer.parseInt(keyStr);

		String cipherText = "",
				plainText = "";
		char encrypting = ' ',
				decrypting = ' ';
		
		if(encrDecr == 1)
		{
			for(int i = 0; i < message.length(); i++)
			{
				encrypting = (message.charAt(i));
				cipherText += (char)((int)(encrypting - 97) * key % 26 + 97);
			}
			JOptionPane.showMessageDialog(null, cipherText);
		}
		
		else
		{
			for(int i = 0; i < message.length(); i++)
			{
				decrypting = (message.charAt(i));
				plainText += (char)((int)(decrypting - 97) * (26 - key) % 26 + 97);
			}
			JOptionPane.showMessageDialog(null, plainText);
		}
		
	}
	
	/**
	 *  Purpose: This functions purpose is to execute the Affine cipher, both encrypting or decrypting.
	 */
	public static void AffineCipher(String message, int encrDecr)
	
	{
		String keyStr = JOptionPane.showInputDialog("Please enter the additive key number: ");
		int keyAdd = Integer.parseInt(keyStr);

		keyStr = JOptionPane.showInputDialog("Please enter the multiplicative key number: ");
		int keyMult = Integer.parseInt(keyStr);
		
		if(encrDecr == 2)
		{
			switch(keyMult)
			{
				case 1:
					keyMult = 1;
					break;
				case 3:
					keyMult = 9;
					break;
				case 5:
					keyMult = 21;
					break;
				case 7:
					keyMult = 15;
					break;
				case 9:
					keyMult = 3;
					break;
				case 11:
					keyMult = 19;
					break;
				case 15:
					keyMult = 7;
					break;
				case 17:
					keyMult = 23;
					break;
				case 19:
					keyMult = 11;
					break;
				case 21:
					keyMult = 5;
					break;
				case 23:
					keyMult = 17;
					break;
				case 25:
					keyMult = 25;
					break;
				default:
					JOptionPane.showMessageDialog(null, "Invalid Multiplicative Key");
					AffineCipher(message, encrDecr);
					break;
			}	
		}
		
		String cipherText = "",
				plainText = "";
		char encrypting = ' ',
				decrypting = ' ';
		
		if(encrDecr == 1)
		{
			for(int i = 0; i < message.length(); i++)
			{
				encrypting = (message.charAt(i));
				cipherText += (char)((int)((encrypting - 97) * keyMult + keyAdd) % 26 + 97);
			}
			JOptionPane.showMessageDialog(null, cipherText);
		}
		
		else
		{
			for(int i = 0; i < message.length(); i++)
			{
				decrypting = (message.charAt(i));
				//TODO make a new formula for finding inverse keyMultiplicitve
				plainText += (char)((((keyMult) * ((decrypting - 97) + (26 - keyAdd))) % 26) + 97);
			}
			JOptionPane.showMessageDialog(null, plainText);
		}
		
	}

}
