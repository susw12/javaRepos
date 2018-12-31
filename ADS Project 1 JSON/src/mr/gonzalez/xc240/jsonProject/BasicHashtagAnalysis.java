package mr.gonzalez.xc240.jsonProject;


import swain.sujay.xc240.ListType.MyLinkedList;

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
     * <p>Stores all hashtags from multiple tweets into a linked list of Hashtag objects.
     * <br>Finds the ten most used hashtags.
     * <p>
     * @author Sujay Swain
     * @throws FileNotFoundException
     */
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws FileNotFoundException {
        //start
        long lStartTime = System.nanoTime();

        File folder = new File("DataSet1");
        MyLinkedList<Hashtag> hashtagList = new MyLinkedList<Hashtag>();
        MyLinkedList<Hashtag> topTen = new MyLinkedList<Hashtag>();

        for (int i = 0; i < folder.listFiles().length; i++) {
            String fileName = i + "_scrubbed.json";
            Scanner reader = new Scanner(new File("DataSet1/" + fileName));

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

        //end
        long lEndTime = System.nanoTime();

        //time elapsed
        long output = lEndTime - lStartTime;

        System.out.println("Elapsed time in milliseconds: " + output / 1000000);
    }

}
