package net.mrpaul.ads.XC240.ps07;

import java.io.*;
import java.util.*;

/**
 * Find consonsant positions and converts words to Pig Latin
 * 
 * This program takes a string from the user and converts it to Pig Latin.
 * It also finds the consonant/cluster position.
 * <p>
 * ADSA PS07: PigLatin
 * 5/6/2018
 * 
 * @author Sujay Swain
 */
public class PigLatin {
	/**
	 * Run and test other methods
	 * This method will be able to test the other methods in the class.
	 * @author Sujay Swain
	 * @param args
	 * @return none
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String s = "text_to_latin.txt";
		fileToPigLatin(s);
	}
	/**
	 * Returns index of first consonant
	 * This method returns the index of the first consonant in the user's string
	 * @author Sujay Swain
	 * @param s - user inputted string
	 * @return index of the first consonant, if any
	 */
	public static int startOfFirstConsonantCluster(String s) {
		//declarations
		int length = s.length();
		int index = length+2;
		s = s.toLowerCase();
		
		//for each index value in the word
		for(int i = 0; i < length; i++) {
	        try
	        {
	            // checking valid integer using parseInt() method
	            Integer.parseInt(s);
	            break;
	        } 
	        //if string isn't integer
	        catch (NumberFormatException e) 
	        {
	        	if(s.charAt(i) != 'a'&&s.charAt(i) != 'e'&&s.charAt(i)!='i'&&s.charAt(i)!='o'&&s.charAt(i)!='u') {
					index = i;
				}
				//if y
				if(s.charAt(i) == 'y') {
					//if y is first letter
					if(i == 0 && s.charAt(i) == 'y') {
						//if 2nd letter is vowel, y is consonant
						if(s.charAt(i + 1)=='a'||s.charAt(i + 1)=='e'||s.charAt(i + 1)=='i'||s.charAt(i + 1)=='o'||s.charAt(i + 1)=='u') {
							index = 0;
						}
						else if(i > 0 && i < length-1) {
							//if letter before and after y are NOT consonants, y is consonant
							if(!(s.charAt(i - 1)!='a'&&s.charAt(i - 1)!='e'&&s.charAt(i - 1)!='i'&&s.charAt(i - 1)!='o'&&s.charAt(i - 1)!='u' &&
									s.charAt(i + 1)!='a'&&s.charAt(i + 1)!='e'&&s.charAt(i + 1)!='i'&&s.charAt(i + 1)!='o'&&s.charAt(i + 1)!='u')) {
								index = i;
							}
						}
					}//end if
				}//end if
				//if index got changed
				if(index != length+2) {
					break;
				}
	        }//end catch
			
		}//end for
		if(s.equals("") || index == length+2) {
			index = -1;
		}
		//vowel when surrounded by consonants or at end of word
		return index;
	}
	/**
	 * Returns index of consonant cluster
	 * This method returns the index of the last consonant in the first consonant cluster.
	 * @author Sujay Swain
	 * @param s - user inputted string
	 * @return index of the end of first consonant cluster
	 */
	public static int endOfFirstConsonantCluster(String s) {
		//declarations
		int length = s.length();
		int index = length+2;
		int c = 0;
		s = s.toLowerCase();
		
		//for every index in the word
		for(int i = 0; i < length; i++) {
	        try
	        {
	            // checking valid integer using parseInt() method
	            Integer.parseInt(s);
	            break;
	        } 
	        catch (NumberFormatException e) 
	        {
	        	//if not vowel
	        	if(s.charAt(i) != 'a'&&s.charAt(i) != 'e'&&s.charAt(i)!='i'&&s.charAt(i)!='o'&&s.charAt(i)!='u') {
					//if y
	        		if(s.charAt(i) == 'y') {
						//if y is first letter
						if(i == 0 && s.charAt(i) == 'y') {
							//if 2nd letter is vowel, y is consonant
							if(s.charAt(i + 1)=='a'||s.charAt(i + 1)=='e'||s.charAt(i + 1)=='i'||s.charAt(i + 1)=='o'||s.charAt(i + 1)=='u') {
								index = i;
								c += 1;
							}
						}//end if
						else if(i > 0 && i < length-1) {
							//if letter before and after y are NOT consonants, y is consontant
							if((s.charAt(i - 1)=='a'||s.charAt(i - 1)=='e'||s.charAt(i - 1)=='i'||s.charAt(i - 1)=='o'||s.charAt(i - 1)=='u') ||(
								s.charAt(i + 1)=='a'||s.charAt(i + 1)=='e'||s.charAt(i + 1)=='i'||s.charAt(i + 1)=='o'||s.charAt(i + 1)=='u')) {
								index = i;
								c += 1;
							}
							else {
								break;
							}
						}//end else if
	        		}//end main y if
	        		else if(s.charAt(i)!='y') {
	        			index = i;
	        			c += 1;
	        		}
				}//end main if
				//if is a vowel
	        	else {
		        	if(c != 0) {
		        		break;
		        	}
	        	}
	        }//end catch
		}//end for
		if(s.equals("") || index == length+2) {
			index = -1;
		}
		//vowel when surrounded by consonants or at end of word
		return index;
	}//end endOfFirstConsonantCluster
	
	/**
	 * Converts word to Pig Latin
	 * This method converts word to pig latin and returns the pig latin.
	 * @author Sujay Swain
	 * @param s - user inputted string
	 * @return the word converted to pig latin
	 */
	public static String wordToPigLatin(String s) {
		//declarations
		String newS, subString;
		int cluster;
		s = s.trim();
		s = s.toLowerCase();
		newS = s;
		char letter = s.charAt(0);
		
		//if begin with vowel
		if(letter == 'a'||letter=='e'||letter=='i'||letter=='o'||letter=='u'||letter=='A'||
				letter=='E'||letter=='I'||letter=='O'||letter=='U') {
			newS += "way";
		}
		else if((letter == 'Y' || letter=='y') && (s.charAt(1)!='a'&&s.charAt(1)!='e'&&s.charAt(1)!='i'&&s.charAt(1)!='o'&&s.charAt(1)!='u'&&s.charAt(1)!='A'
				&&s.charAt(1)!='E'&&s.charAt(1)!='I'&&s.charAt(1)!='O'&&s.charAt(1)!='U')) {
			newS += "way";
		}

		//if begin with consonant
		else {
			cluster = endOfFirstConsonantCluster(s);
			subString = s.substring(0, cluster+1);
			//remove beginning consonant cluster
			newS = newS.replace(subString, " ");
			newS = newS.trim();
			newS = newS + subString + "ay";
		}
		return newS;
	}//end wordToPigLatin
	
	/**
	 * Returns index of first punctuation
	 * This method finds the index of the first punctuation in the string and returns it.
	 * @author Sujay Swain
	 * @param s - user inputted string
	 * @return index of the first punctuation mark
	 */
	public static int findStartOfEndingPuncSeq(String s) {
		//declarations
		s = s.toLowerCase();
		int index = 0;
		String[] letter = {".", "-", "!", "?", ",", ";"};
		int length = s.length();
		
		//for each index in string s
		for(int i=0; i<length; i++) {
			for(int j=0; j<6; j++) {
				String sub = s.substring(i, i+1);
				//if the string s has any of the punctuation marks
				if(s.contains(letter[j]) && sub.contains(letter[j])) {
					index = i;
					break;
				}
				//if no punctuation marks
				else {
					index = -1;
				}
			if(index != -1) {
				break;
			}
			}
		if(index != -1) {
			break;
		}
		}
		
		return index;
	}//end findStartOfEndingPuncSeq
	
	/**
	 * Converts and writes pig latin
	 * This method converts a string to pig latin by reading a text file.
	 * It also writes the converted pig latin to a file.
	 * @author Sujay Swain
	 * @param s - user inputted string
	 * @throws FileNotFoundException
	 * @returns none
	 */
	public static void fileToPigLatin(String s) throws FileNotFoundException {
		//declarations
		String x, write;
		Scanner reader = new Scanner (new File (s));
		PrintWriter writer = new PrintWriter(new File("file_PL.txt"));
		
		//while there's still a word in the text file
		while(reader.hasNext()) {
			x = reader.next();
			//if doesn't end in punctuation
			if(findStartOfEndingPuncSeq(x)==-1) {
				write = wordToPigLatin(x);
				write += " ";
				writer.write(write);
			}
			//if does end in a punctuation
			else {
				String sub = x.substring(findStartOfEndingPuncSeq(x));
				if(sub.equals(x)) {
					write = x + " ";
					writer.write(write);
				}
				else {
					x = x.replaceAll(sub, "");
					write = wordToPigLatin(x);
					write = write + sub + " ";
					writer.write(write);
				}
			}
		}
		writer.close();
	}
}
