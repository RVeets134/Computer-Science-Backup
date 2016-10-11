/*
 * Rakesh Veetekat
 * 9/23/16
 * Period 6 Computer Science
 * Zipcode Project
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class zipcode {

	public static void main(String[] args) throws IOException {

		//Declare and initialize text files
		
		File file1 = new File("ZipCodes.txt");
		File file2 = new File("ZipCodesCity.txt");
		File file3 = new File("ZipBarCodes.txt");
		
		//Array used to switch between zip and bar codes
		
		String[] converter = converter();
		
		//Declare and initialize scanners
		
		Scanner zipcodes = new Scanner(file1);
		Scanner cities = new Scanner(file2);
		Scanner barcodes = new Scanner(file3);
		
		System.out.println("Options 1 and 2");
		System.out.println();
		
		//Find and print cities within the given zipcodes
				
		findCities(zipcodes,cities,converter,file2);
		
		System.out.println();
		System.out.println("Option 3");
		System.out.println();
		
		
		//Translate barcodes into zipcodes and find the respective cities
		
		barToZip(cities,barcodes,converter,file2);
		
	}

	/**
	 * This method creates a string array that will be used to translate barcodes in to zipcodes, and vice versa.
	 * @return - This method returns a string array containing the barcodes for each index digit.
	 */
	private static String[] converter()
	{
		
		String[] converter = new String[10];
		
		converter[0] = "||:::";
		converter[1] = ":::||";
		converter[2] = "::|:|";
		converter[3] = "::||:";
		converter[4] = ":|::|";
		converter[5] = ":|:|:";
		converter[6] = ":||::";
		converter[7] = "|:::|";
		converter[8] = "|::|:";
		converter[9] = "|:|::";
		
		return converter;
		
	}
	
	/**
	 * This method will find the cities with the zipcodes from the given file, and it will print them along with the zipcodes.
	 * @param zipcodes - This Scanner is used to read through the text file with the given zipcodes.
	 * @param cities - This Scanner is used to read through the text file with the database of cities and their respective zipcodes.
	 * @param converter - This parameter is an array that has barcodes aligned with their respective digits using the index of each barcode.
	 * @param file2 - This file contains the cities and their respective zipcodes.
	 * @throws IOException
	 */
	private static void findCities(Scanner zipcodes,Scanner cities,String[] converter,File file2) throws IOException
	{
		
		//Sets up loop to read through the text file of zipcodes
		
		while(zipcodes.hasNext())
		{
			
			//Sets value of the zipcode 
			
			String zipcode = zipcodes.next();
			
			//Starts the loop to read through each city in the text file
			
			while(cities.hasNextLine())
			{
				
				//Store entire line in a variable to check for zipcode with .contains method
				
				String city = cities.nextLine();
				if(city.contains(zipcode))
				{
					
					//Skip to beginning on city name and replace commas with spaces
					
					city = city.substring(5);
					city = city.replace(","," ");
					System.out.println(zipcode + "\t" + city);
					
				}
				
			}
			
			//Method that prints out the readable and postal barcodes
			
			zipToBar(zipcode,converter);
			
			//Resets the cities Scanner so it can be read through again in the next loop
			
			cities = new Scanner(file2);
			
		}
		
	}
	
	/**
	 * This method translates zipcodes sent as parameters into barcodes
	 * @param zipcode - This is the zipcode that needs to be translated
	 * @param converter - This array contains barcodes aligned with their respective digits through the indexes of the array.
	 */
	private static void zipToBar(String zipcode,String[] converter) 
	{

		String barcode = "";
		
		for(int i = 0; i < zipcode.length(); i++)
		   {
			
		    barcode += converter[Integer.parseInt(zipcode.charAt(i) + "")];
		   
		   }
		
		//Splices the barcode up to create the readable barcode
		
		String firstFive = barcode.substring(0,4);
		String secondFive = barcode.substring(5,9);
		String thirdFive = barcode.substring(10,14);
		String fourthFive = barcode.substring(15,19);
		String fifthFive = barcode.substring(20,24);
		   
		System.out.println("\t" + "Readable Barcode: |" + firstFive + "   " 
							+ secondFive + "   " + thirdFive + "   " 
							+ fourthFive + "   " + fifthFive + "   ");
		System.out.println("\t" + "Postal Barcode: " + barcode);
		System.out.println();
				
	}
	
	/**
	 * This method translates the given barcodes into zipcodes and finds the cities associated with those zipcodes. 
	 * If a zipcode does not exist for the barcode, the method prints out an error message.
	 * @param cities - This Scanner reads through the database of cities and their respective zipcodes.
	 * @param barcodes - This Scanner reads through the barcodes that need to be translated.
	 * @param converter - This array contains barcodes and their respective digits through the use of the array's indexes.
	 * @param file2 - This file contains the database of cities and will be used to reset the Scanner
	 * so that the file can be read through more than once.
	 * @throws IOException
	 */
	private static void barToZip(Scanner cities, Scanner barcodes, String[] converter, File file2) throws IOException
	{
		
		String currentBar = "";
		
		//Sets loop to after each barcode has been processed
		
		while(barcodes.hasNext())
		{
			
			//Stores entire bar into a variable
			
			currentBar = barcodes.next();
			
			//Splices ends of bar to be able to seperate and find the digits of each group of five characters
			
			currentBar = currentBar.substring(1,currentBar.length()-1);
			
			//Array that will contain the five digits of the zip code and the check digit
			
			int[] zipcodeArray = new int[6];
			
			//Sets up loop to read through and find digits for each bar in the entire barcode
			
			for(int n = 0;n < 6;n++)
			{

				//Sets up the start and end points of each bar as multiples of five 
				
				String subBar = currentBar.substring(n*5,n*5 + 5);
				
				//Finds the digit value of each bar and stores it in the array
				
				for(int i = 0;i < 10;i++)
				{
					
					if(subBar.contains(converter[i]))
					{
						zipcodeArray[n] = i;
					}
					
				}
				
			}
			
			int sum = 0;
			
			//Check sum to see if the zipcode exists. It won't if the sum is not a multiple of 10
			
			for(int x = 0;x < 6;x++)
			{
				
				sum += zipcodeArray[x];
				
			}
			
			//If sum not a multiple, prints the error
			
			if((sum % 10) != 0)
			{
				
				System.out.println(currentBar + "   ------>   ERROR - Invalid check digit!");
				System.out.println("No Location Found");
				System.out.println();
				
			}
			else
			{
				
				//Change the zipcode into an String to make it comparable to the String zipcodes in the cities file
				
				String zipcode = Integer.toString(zipcodeArray[0]) + 
								Integer.toString(zipcodeArray[1]) + 
								Integer.toString(zipcodeArray[2]) + 
								Integer.toString(zipcodeArray[3]) +
								Integer.toString(zipcodeArray[4]);
				
				System.out.println(currentBar + "   ------>   " + zipcode);
				
				//Check through the cities database now
				
				while(cities.hasNextLine())
				{
					
					//Store the city's information in the variable to check its zipcode
					
					String city = cities.nextLine();
					if(city.contains(zipcode))
					{
						
						//Isolate the city's name and replace commas with spaces
						
						city = city.substring(5);
						city = city.replace(","," ");
						
						//Print all of the cities with the zipcode derived from the barcode
						
						System.out.println(city);
						
					}
				
				}
				
				System.out.println();
					
				//Reset the cities Scanner to allow for it to be read through again
				
				cities = new Scanner(file2);
			
			}
												
		}
		
	}

}
