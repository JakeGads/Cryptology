
public class TheoryTestFile 
{

	public static void main(String[] args) 
	{
		char[] array1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
						'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}; //26
		String string1 = "dogs";
		char insertStart = 'z';
		char[] stringArray = string1.toCharArray();
		
		int point = 0;
		
		/*
		 * Lengths: array1 = 26
		 * 			stringArray = 4
		 */
		
		
		for(int q = 0; q < array1.length; q++)
		{
			
			if(array1[q] == insertStart)
			{
				point = q;
			}
	
		}
		System.out.println(point);
		//good till here
		
		//TODO figure out how to get word to wrap around to start of array if at spot 26
		 		
		int e = 0;
		int w = 0;
		for(int i = point; i < array1.length; i++)
		{
			
			if(i < 26 && e < stringArray.length)
			{
				array1[i] = stringArray[e];
				e++;
			} 
			else if(i >= 26 && e < stringArray.length)
			{
				array1[w] = stringArray[e];
				w++;
				e++;
			} 
			
		}
	
		System.out.println(array1);
		
	}

	//Test Prints
	//System.out.println("I'm in the loop");
	//System.out.println("");
	//System.out.println();

}
