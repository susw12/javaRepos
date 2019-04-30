package net.mr.gonzalez.exercise1;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/**
 * Has constructor for cemetery object
 * This program contains the cemetery constructor and its functions.
 * <p>
 * AOA Exercise 01: Cemetery.java
 * 2/24/2019
 * 
 * 
 * @author Sujay Swain
 */
public class Cemetery {
	private TreeMap<Double, Tombstone> record = new TreeMap<>();

	/**
	 * Scans the file for elements
	 * This method is basically a scanner for the file.
	 * <p>
	 * @author Sujay Swain
	 * @param fileName
	 * @return f1
	 * @throws FileNotFoundException
	 */
	public Scanner scan (String fileName) throws FileNotFoundException {
		File f = new File(fileName);
		return new Scanner(f);
	}
	/**
	 * Fills treeMap for number buried
	 * This method puts everyone buried in a treeMap to make it easier to count the number of buried people.
	 * <p>
	 * @author Sujay Swain
	 * @param s - scanner
	 */
	public void fillTreeMap(Scanner s) {
		TreeMap<Double, Tombstone> replacement = new TreeMap<>();
		String line;
		double holder, count = 0;
		for(int i = 0; i<4; i++)
			s.nextLine();
		while(s.hasNextLine()) {
			line = s.nextLine();
			Tombstone tomb = new Tombstone();
			
			String name = line.substring(0, 24);
			String day = line.substring(25,27);
			String month= line.substring(27,31);
			String year = line.substring(31,36);
			String age = line.substring(37,41);
			String address = line.substring(41);
			
			tomb.setAddress(address);
			tomb.setName(name);
			Date date = new Date();
			date.setMonth(month.trim());
			date.setDay(Integer.parseInt(day.trim()));
			date.setYear(Integer.parseInt(year.trim()));
			tomb.setDate(date);

			if(age.contains("d")) {
				String[] a = age.trim().split("d");
				tomb.setAge(Integer.parseInt(a[0].trim()));
			}
			else if(age.contains("w")){
				int day1 = Integer.parseInt(age.split("w")[0]);
				tomb.setAge(day1 * 7);}
			else if(age.contains(".")) {
				age = age.replace(".", "");
				int y = Integer.parseInt(age.trim().substring(0, 1));
				int m = Integer.parseInt(age.substring(1,3).trim());
				tomb.setAge(y * 365 + m * 30);
			}
			else {
				int new_year = Integer.parseInt(age.trim());
				tomb.setAge(new_year * 365);
			}
			
			holder = tomb.getDate().getDay() + tomb.getDate().getMonth() * 30
					+ tomb.getDate().getYear() * 365;
			if(replacement.containsKey(holder)) {
				replacement.put(holder+count,tomb);
				count += 0.0001;
			}
			else {
				replacement.put(holder,tomb);
			}
		}
		record = replacement;
	}
	
	/**
	 * Reads treeMap for number buried
	 * This method returns the number of buried people.
	 * <p>
	 * @author Sujay Swain
	 */
	public void numberBuried() {
		int count = record.size() + 1;
		System.out.println(count);
	}
	
	/**
	 * Lists buries earliest to latest
	 * This method sorts the buried people from earliest to latest.
	 * <p>
	 * @author Sujay Swain
	 */
	public void burialList() {
		for(Entry<Double, Tombstone> i : record.entrySet()) {
			Tombstone element = i.getValue();
			String ret = element.getDate().toString() + " " + element.getName()
			  + " " + element.getAddress();
			  System.out.println(ret);
		}
	}
	
	/**
	 * Displays total citizens average age
	 * This method displays the total number of citizens and the average age.
	 * <p>
	 * @author Sujay Swain
	 */
	public void averageAge() {
		int total_citizens = 0, sub = 0;
		double ret;
		
		for(Entry<Double, Tombstone> i : record.entrySet()) {
			  Tombstone element = i.getValue();
			  Date d = element.getDate();
			  int a = d.getDay() + d.getMonth() * 30 + d.getYear() * 365;
			  
			  if((a >= 662656 && a<675581) && element.getAddress().contains("Little Carter")) {
			  String s = element.getDate().toString() + " " + 
					  element.getName() + " " + element.getAddress();
				System.out.println(s);
				
				sub += element.getAge();
				total_citizens++;
			  }
		}
		ret = (double)sub;
		
		System.out.println("\n");
		System.out.println("Total Citizens: " + total_citizens);
		System.out.println("Average age: " + ret/(total_citizens * 365) + " Years Old");
		System.out.println();
	}
}
