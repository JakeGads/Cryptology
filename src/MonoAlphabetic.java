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
											  + "\n1. Additive Cipher \n2. Multiplication Cipher \n3. Affine Cipher"
											  + "\n4. Keyword Cipher");
				menuOption = Integer.parseInt(menuOptionStr);
		} while(menuOption <= 0 || menuOption >= 5);
		
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
		case 4:
			KeywordCipher(message, encrDecr);
			break;
		default:
			menu(menuOption);
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
	 *  Purpose: This functions purpose is to execute the process of taking the multiplicative
	 *  		 key and turning it into the inverse.
	 */
	public static int MultiplicativeInverse(int key)

	{
		switch(key)
		{
			case 1:
				key = 1;
				break;
			case 3:
				key = 9;
				break;
			case 5:
				key = 21;
				break;
			case 7:
				key = 15;
				break;
			case 9:
				key = 3;
				break;
			case 11:
				key = 19;
				break;
			case 15:
				key = 7;
				break;
			case 17:
				key = 23;
				break;
			case 19:
				key = 11;
				break;
			case 21:
				key = 5;
				break;
			case 23:
				key = 17;
				break;
			case 25:
				key = 25;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Invalid Multiplicative Key");
				break;
		}	
		return key;
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
		String keyStr = "";
		int key = 0;
		int validation = 0;
		
		do
		{
			if(validation == 0)
			{
			keyStr = JOptionPane.showInputDialog("Please enter the multiplicative key number: ");
			key = Integer.parseInt(keyStr);
			++validation;
			}
			else
			{
				keyStr = JOptionPane.showInputDialog("Valid key numbers are 1, 3, 5, 7, 9, 11, 15, 17,"
						+ "19, 21, 23, 25: ");
				key = Integer.parseInt(keyStr);
			}
		}while(key != 1 && key != 3 && key != 5 && key != 7 && key != 9 && key != 11 && key != 15 && 
				key != 17 && key != 19 && key != 21 && key != 21 && key != 23 && key != 25);
		

		String cipherText = "",
				plainText = "";
		char encrypting = ' ',
				decrypting = ' ';
		
		if(encrDecr == 2)
		{
			MultiplicativeInverse(key);
		}
		
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
				plainText += (char)((int)((decrypting - 97) * (key)) % 26 + 97);
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
		int keyMult = 0;
		int validation = 0;
		
		do
		{
			if(validation == 0)
			{
			keyStr = JOptionPane.showInputDialog("Please enter the multiplicative key number: ");
			keyMult = Integer.parseInt(keyStr);
			validation++;
			}
			else
			{
				keyStr = JOptionPane.showInputDialog("Valid key numbers are 1, 3, 5, 7, 9, 11, 15, 17,"
						+ "19, 21, 23, 25: ");
				keyMult = Integer.parseInt(keyStr);
			}
				
		}while(keyMult != 1 && keyMult != 3 && keyMult != 5 && keyMult != 7 && keyMult != 9 && 
				keyMult != 11 && keyMult != 15 && keyMult != 17 && keyMult != 19 && keyMult != 21 && 
				keyMult != 23 && keyMult != 25);
		
		
		if(encrDecr == 2)
		{
			MultiplicativeInverse(keyMult);
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
				plainText += (char)((((keyMult) * ((decrypting - 97) + (26 - keyAdd))) % 26) + 97);
			}
			JOptionPane.showMessageDialog(null, plainText);
		}
		
	}
	
	/**
	 *  Purpose: This functions purpose is to execute the KeyWord cipher, both encrypting or decrypting.
	 */
	public static void KeywordCipher(String message, int encrDecr)
	{
		String keyStartStr = JOptionPane.showInputDialog("Please enter the keyword starting point: ");
		//int keyStart = (Integer.parseInt(keyStartStr) - 97);
		
		String keyWord = JOptionPane.showInputDialog("Please enter the key word: ");
		
		char[] letterArray = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s',
							't','u','v', 'w','x','y','z'};
		
		keyWord = keyWord.toLowerCase();
		int length = keyWord.length();
		 
		char[] charArray = keyWord.toCharArray();
		for(int i = 0; i < length; i++)
		{
			if(letterArray[length + 1] <= 26)
			{
				letterArray[length + i] = charArray[i];
			}
			else
			{
				for(int t =0; t< length; t++)
				{
				letterArray[t] = charArray[i];
				}
			}
				
		}
		
		JOptionPane.showMessageDialog(null, letterArray);
		
	}
	 
}