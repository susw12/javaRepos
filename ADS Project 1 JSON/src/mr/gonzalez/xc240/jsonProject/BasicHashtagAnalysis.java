package mr.gonzalez.xc240.jsonProject;


import swain.sujay.xc240.LinkedList.MyLinkedList;

import java.io.*;
import java.util.*;

/**
 * Tweet JSON hashtag analyzer.
 * <p>This class analyzes hashtags from multiple tweets represented by JSON files.
 * <p>
 * ADSB JSON Project Part 1
 * 12/30/2018
 *
 * @author Sujay Swain
 */
public class BasicHashtagAnalysis {

    /**
     * Top ten hashtag finder.
     * <p>Stores all hashtags used in multiple tweets, represented by JSON files, into a linked list of Hashtag objects.
     * <br>Finds the ten most used hashtags.
     * <br>This takes a long time to run so this is the output: https://imgur.com/a/NzigqYX
     * <p>
     * @author Jason Liu
     * @param args Unused
     * @return void
     * @throws FileNotFoundException if JSON file is not found
     */
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws FileNotFoundException {

        File folder = new File("DataSet1");
        MyLinkedList<Hashtag> hashtagList = new MyLinkedList<Hashtag>();
        MyLinkedList<Hashtag> topTen = new MyLinkedList<Hashtag>();
		/*
		File[] fileList = folder.listFiles();
		for (File f : fileList) {
			System.out.println(f.getName());
			Scanner reader = new Scanner(f);
		*/

        for (int i = 0; i < folder.listFiles().length; i++) {
            String fileName = i + "_scrubbed.json";
            //System.out.println(fileName);
            Scanner reader = new Scanner(new File("DataSet1/" + fileName));
            //int lineNum = 1;

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String hashtags;
                try {
                    hashtags = line.substring(line.indexOf("[",line.indexOf("hashtags\":")), line.indexOf("]}]},",line.indexOf("hashtags\":"))+1);
                    if (Character.toString(hashtags.charAt(1)).equals("]")) {
                        hashtags = "";
                    }
                } catch (IndexOutOfBoundsException e1) {
                    try {
                        hashtags = line.substring(line.indexOf("[",line.indexOf("hashtags\":")), line.indexOf("],",line.indexOf("hashtags\":"))+1);
                        if (Character.toString(hashtags.charAt(1)).equals("]")) {
                            hashtags = "";
                        }
                    } catch (IndexOutOfBoundsException e2) {
                        hashtags = "";
                    }
                }

                if (hashtags.length() != 2 && hashtags.length() != 0) {
                    hashtags = hashtags.substring(1, hashtags.length()-1).toLowerCase();
                    String[] jsonHashtags = hashtags.split("},");
                    for (int j = 0; j < jsonHashtags.length; j++) {
                        try {
                            jsonHashtags[j] = jsonHashtags[j].substring(9,jsonHashtags[j].indexOf("indices")-3);
                        } catch (IndexOutOfBoundsException e) {
                            jsonHashtags[j] = "";
                        }
                    }

                    String date;
                    try {
                        date = line.substring(line.indexOf("created_at\":")+12, line.indexOf(",", line.indexOf("created_at\":")));
                    } catch (IndexOutOfBoundsException e) {
                        date = "";
                    }
                    if (date.length() != 0) {
                        int year = Integer.parseInt(date.substring(27,31)) - 1900;
                        String m = date.substring(5,8);
                        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
                        int month = 0;
                        for (int j = 0; j < months.length; j++) {
                            if (months[j].equals(m)) {
                                month = j;
                            }
                        }
                        int day = Integer.parseInt(date.substring(9,11));
                        Date d = new Date(year, month, day);

                        for (String s : jsonHashtags) {
                            HashtagOccurance ht = new HashtagOccurance(s, d);

                            boolean found = false;
                            for (Hashtag h : hashtagList) {
                                if (h.getHashtagName().equals(s)) {
                                    found = true;
                                    h.addInstance(ht);
                                }
                            }
                            if (!found) {
                                MyLinkedList<HashtagOccurance> temp = new MyLinkedList<HashtagOccurance>();
                                temp.add(ht);
                                hashtagList.add(new Hashtag(s, d, d, temp));
                            }
                        }
                    }
                }

            }
            reader.close();
        }

        for (int i = 0; i < 10; i++) {
            int max = -1, index = -1;
            for (int j = 0; j < hashtagList.size(); j++) {
                if (hashtagList.get(j).getOccurences().size() > max) {
                    max = hashtagList.get(j).getOccurences().size();
                    index = j;
                }
            }
            topTen.add(hashtagList.get(index));
            hashtagList.remove(index);
        }

        System.out.println("Top Ten Hashtags: ");
        for (Hashtag h : topTen) {
            System.out.println("#" + h.getHashtagName() + " : " + h.getOccurences().size());
        }
    }

}
