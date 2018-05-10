package net.mrpaul.ads.XC240.ps07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Converts the recovery file
 *
 * <p>Converts the recovery file to readable stuff</p>
 * ADS PS07: Pig Latin
 * 5/6/18
 *
 *
 * @author Sujay Swain
 *
 */

public class VoterFileRecovery {
    /**
     * Call main functions
     * <p>Calls the main methods to run the functions</p>
     * @param args
     */
	public static void main(String[] args) throws FileNotFoundException {
        System.out.println(nthInstance(2, "as", "Mynameas as as as"));
        generatePhoneList("Recovered Voterfile Pipe Delimited.txt");

	}

    /**
     * Finds the nth instance of a string
     *
     * <p>Finds the nth instance of a string in another string</p>
     * @param n
     * @param sub
     * @param line
     * @return index
     */
	public static int nthInstance(int n, String sub, String line) {
	    //Declaring necessary variables
	    int x = 0;
	    int subLength = sub.length();
	    int lineLength = line.length();
	    int toReturn = 0;

	    //Loops through all indices in the larger string line that the sub is inside
        for (int i = 0; i <= lineLength-subLength; i++) {
            //If the string is found inside
            if (line.substring(i,i+subLength).equals(sub)) {
                x += 1;
            }
            //Checks to see if this is the nth instance
            if (x == n) {
                return i;
            }
        }
        return -1;

    }


    public static void generatePhoneList(String fileName) throws FileNotFoundException {
	    //Declares necessary variables
        String line, firstName, lastName, city, phone, lastID;
        int votingHistory = 0, lineNum = 0;

        //Creates a Scanner object to read the .txt file
        Scanner reader = new Scanner(new File(fileName));

        //Creates a PrintWriter object to create and write to a file in a new location
        PrintWriter writer = new PrintWriter(new File("XC240_phonelist.txt"));

        //Loops through all the lines of information in the text file until there are no more lines
        while (reader.hasNextLine()) {
            //Increasing the line number and reading the next line
            lineNum++;
            line = reader.nextLine();

            //Checks if it's the first line
            if (lineNum == 1) {
                //Generates first line info
                writer.printf("%-16s","FIRST NAME");
                writer.printf("%-16s","LAST NAME");
                writer.printf("%-22s","CITY");
                writer.printf("%-16s","PHONE");
                writer.printf("%19s","LAST ID");
                writer.printf("%15s","VOTING HISTORY");
            }
            //Checks to see the information is not available...
            else if (line.substring(0,4).equals("#N/A")) {
                writer.print("#N/A");
            }
            //For all other types of information
            else {
                //Gets data in each column
                firstName = line.substring((nthInstance(1, "|", line)+1), nthInstance(2, "|", line));
                lastName = line.substring((nthInstance(2, "|", line)+1), nthInstance(3, "|", line));
                city = line.substring((nthInstance(4, "|", line)+1), nthInstance(5, "|", line));
                phone = line.substring((nthInstance(7, "|", line)+1), nthInstance(8, "|", line));
                lastID = line.substring((nthInstance(8, "|", line)+1), nthInstance(9, "|", line));

                //adds the voting data to get total votes per voter
                votingHistory = 0;
                for (int n = 9; n <= 16; n++) {//Loops through all elections
                    //Voter voting check
                    if (line.substring(nthInstance(n,"|",line)+1,nthInstance(n+1,"|",line)).equals("1")){
                        votingHistory++;
                    }
                }
                //Write out the data
                writer.printf("%-16s",firstName);
                writer.printf("%-16s",lastName);
                writer.printf("%-22s",city);
                writer.printf("%-16s",phone);
                writer.printf("%19s",lastID);
                writer.printf("%15s",votingHistory+"/8");
            }
            writer.println("");
        }
        writer.close();
    }

}
