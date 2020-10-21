package kunal;

import java.lang.Math;
import java.util.Scanner;

public class Solution 
{
	public static String encryptString(String str)
	{
		//We remove all the white spaces from the string.
		str=str.replaceAll("\\s","");
		
		//We define the number of rows and columns in our encryption grid.
		int rows,cols;
		rows=((int)Math.sqrt(str.length()))+1;
		cols=((int)Math.sqrt(str.length()))+1;
		
		//We initialize the encryption grid.
		char [][]grid=new char[rows][cols];
		
		//A pointer is used to iterate through the entire grid.
		int pointer=0;
		int i=0;
		
		//As we move through the string, we keep on storing the characters in the encryption grid.
		while(i<rows)
		{
			int j=0;
			while(j<cols)
			{
				if(pointer<str.length()) 
				{
					grid[i][j]=str.charAt(pointer++);
				}
				j++;
			}
			i++;
		}
		
		//We iterate column wise through the encryption grid and append all the characters to the string.
		//When we reach the end of each column, we will append a whitespace.
		String encryptedString="";
		for(i=0;i<cols;i++)
		{
			for(int j=0;j<rows;j++)
			{
				if(grid[j][i]!='\0' && grid[j][i]!=' ')
				{
					encryptedString+=grid[j][i];
				}
			}
			encryptedString+=" ";
		}
		
		//Finally, we will return the result.
		return encryptedString;
	}
	public static void main(String []args) 
	{
		Scanner scanner=new Scanner(System.in);
		
		//We will input the string that is to be encrypted.
		System.out.println("Enter the string to be encrypted.");
		String str=scanner.nextLine();
		
		//We will invoke the function to encrypt the string.
		System.out.println(encryptString(str));
		
		//To avoid resource leakage, we close the scanner resource.
		scanner.close();
	}
}
