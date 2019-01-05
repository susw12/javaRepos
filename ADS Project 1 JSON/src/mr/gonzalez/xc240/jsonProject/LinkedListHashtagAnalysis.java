package mr.gonzalez.xc240.jsonProject;

import swain.sujay.xc240.ListType.MyArrayList;
import swain.sujay.xc240.ListType.MyLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Tweet JSON data analyzer.
 * <p>This class analyzes all data from multiple tweets represented by JSON files.
 * <p>
 * ADSB Problem Set 14 - JSON Project Part 1
 * 12/23/2018
 *
 * @author Sujay Swain
 */
public class LinkedListHashtagAnalysis {

    /**
     * Linked/Array list operation timer.
     * <p>Stores all tweets, represented by JSON files, into a linked list or array list of Tweet objects.
     * <br>Measures the time taken, in nanoseconds, to store the Tweet objects in both types of lists, using 10 tweets, 1 JSON file, and all JSON files.
     * <br>Removes all Tweets with the hashtag #lol or the user @justinbieber from the array of
     * <br>Measures the time taken, in nanoseconds, for removal in both types of lists.
     * <p>
     * @author Sujay Swain
     * @throws FileNotFoundException if JSON file is not found
     */
    @SuppressWarnings("resource")
    public static void main(String[] args) throws FileNotFoundException {

        long start1L = System.nanoTime();
        Scanner reader1L = new Scanner(new File("DataSet1/0_scrubbed.json"));
        MyLinkedList<Tweet> tweets1L = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            String s = reader1L.nextLine();
            if (!s.contains("\"delete\":")) {
                Tweet t = new Tweet(s);
                tweets1L.add(t);
            }
        }
        long end1L = System.nanoTime();
        System.out.print("Run Time for 10 tweets in a MyLinkedList: ");
        System.out.println(end1L-start1L);
        System.out.println("Physical Size: " + tweets1L.size());
        reader1L.close();
        System.out.println();

        long start1A = System.nanoTime();
        Scanner reader1A = new Scanner(new File("DataSet1/0_scrubbed.json"));
        MyArrayList<Tweet> tweets1A = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            String s = reader1A.nextLine();
            if (!s.contains("\"delete\":")) {
                Tweet t = new Tweet(s);
                tweets1A.add(t);
            }
        }
        long end1A = System.nanoTime();
        System.out.print("Run Time for 10 tweets in a MyArrayList: ");
        System.out.println(end1A-start1A);
        System.out.println("Physical Size: " + tweets1A.size());
        reader1A.close();
        System.out.println();



        long start2L = System.nanoTime();
        Scanner reader2L = new Scanner(new File("DataSet1/0_scrubbed.json"));
        MyLinkedList<Tweet> tweets2L = new MyLinkedList<>();
        while (reader2L.hasNextLine()) {
            String s = reader2L.nextLine();
            if (!s.contains("\"delete\":")) {
                Tweet t = new Tweet(s);
                tweets2L.add(t);
            }
        }
        long end2L = System.nanoTime();
        System.out.print("Run Time for 1 JSON file in a MyLinkedList: ");
        System.out.println(end2L-start2L);
        System.out.println("Physical Size: " + tweets2L.size());
        reader2L.close();
        System.out.println();

        long start2A = System.nanoTime();
        Scanner reader2A = new Scanner(new File("DataSet1/0_scrubbed.json"));
        MyArrayList<Tweet> tweets2A = new MyArrayList<>();
        while (reader2A.hasNextLine()) {
            String s = reader2A.nextLine();
            if (!s.contains("\"delete\":")) {
                Tweet t = new Tweet(s);
                tweets2A.add(t);
            }
        }
        long end2A = System.nanoTime();
        System.out.print("Run Time for 1 JSON file in a MyArrayList: ");
        System.out.println(end2A-start2A);
        System.out.println("Physical Size: " + tweets2A.size());
        reader2A.close();
        System.out.println();



        long start3L = System.nanoTime();
        MyLinkedList<Tweet> tweets3L = new MyLinkedList<>();
        File folderl = new File("DataSet1");
        for (int i = 0; i < Objects.requireNonNull(folderl.listFiles()).length; i++) {
            String fileNamel = i + "_scrubbed.json";
            Scanner reader3L = new Scanner(new File("DataSet1/" + fileNamel));
            while (reader3L.hasNextLine()) {
                String s = reader3L.nextLine();
                if (!s.contains("\"delete\":")) {
                    Tweet t = new Tweet(s);
                    tweets3L.add(t);
                }
            }
        }
        long end3L = System.nanoTime();
        System.out.print("Run Time for all JSON files in a MyLinkedList: ");
        System.out.println(end3L-start3L);
        System.out.println("Physical Size: " + tweets3L.size());
        System.out.println();
        int tweets3Lorig = tweets3L.size();

        long start3A = System.nanoTime();
        MyLinkedList<Tweet> tweets3A = new MyLinkedList<>();
        File folderA = new File("DataSet1");
        for (int i = 0; i < Objects.requireNonNull(folderA.listFiles()).length; i++) {
            String fileNameA = i + "_scrubbed.json";
            Scanner reader3a = new Scanner(new File("DataSet1/" + fileNameA));
            while (reader3a.hasNextLine()) {
                String s = reader3a.nextLine();
                if (!s.contains("\"delete\":")) {
                    Tweet t = new Tweet(s);
                    tweets3A.add(t);
                }
            }
        }
        long end3A = System.nanoTime();
        System.out.print("Run Time for all JSON files in a MyArrayList: ");
        System.out.println(end3A-start3A);
        System.out.println("Physical Size: " + tweets3A.size());
        System.out.println();
        int tweets3Aorig = tweets3A.size();



        int justin = 0, lol = 0;
        long start4L = System.nanoTime();
        for (int i = 0; i < tweets3L.size(); i++) {
            if (tweets3L.get(i).getId_str() != null && tweets3L.get(i).getEntities() != null) {
                String line1 = ((String) tweets3L.get(i).getUser());
                if ((line1.substring(line1.indexOf("\"screen_name\":")+15, (line1.indexOf("\",", line1.indexOf("screen_name")))).equals("justinbieber"))) {
                    tweets3L.remove(i);
                    justin++;
                } else {
                    boolean remove = false;

                    String hashtags, line = (String) tweets3L.get(i).getEntities();
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
                            } catch (IndexOutOfBoundsException e1) {
                                jsonHashtags[j] = "";
                            }
                            if (jsonHashtags[j].equals("lol")) {
                                remove = true;
                            }
                        }
                    }

                    if (remove) {
                        tweets3L.remove(i);
                        lol++;
                    }
                }
            } else if (tweets3L.get(i).getId_str() != null) {
                String line1 = ((String)tweets3L.get(i).getUser());
                if ((line1.substring(line1.indexOf("\"screen_name\":")+15, (line1.indexOf("\",", line1.indexOf("screen_name")))).equals("justinbieber"))) {
                    tweets3L.remove(i);
                    justin++;
                }
            } else if (tweets3L.get(i).getEntities() != null) {
                boolean remove = false;

                String hashtags, line = (String) tweets3L.get(i).getEntities();
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
                        } catch (IndexOutOfBoundsException e1) {
                            jsonHashtags[j] = "";
                        }
                        if (jsonHashtags[j].equals("lol")) {
                            remove = true;
                        }
                    }
                }

                if (remove) {
                    tweets3L.remove(i);
                    lol++;
                }
            }
        }
        long end4L = System.nanoTime();
        System.out.print("Run Time for removal in a MyLinkedList: ");
        System.out.println(end4L-start4L);
        System.out.println("Removed: " + (tweets3Lorig - tweets3L.size()) + " total tweets, " + lol + " #lol, " + justin + " @justinbieber");
        System.out.println();

        justin = 0;
        lol = 0;
        long start4A = System.nanoTime();
        for (int i = 0; i < tweets3A.size(); i++) {
            if (tweets3A.get(i).getId_str() != null && tweets3A.get(i).getEntities() != null) {
                String line1 = ((String)tweets3A.get(i).getUser());
                if ((line1.substring(line1.indexOf("\"screen_name\":")+15, (line1.indexOf("\",", line1.indexOf("screen_name")))).equals("justinbieber"))) {
                    tweets3A.remove(i);
                    justin++;
                } else {
                    boolean remove = false;

                    String hashtags, line = (String) tweets3A.get(i).getEntities();
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
                            } catch (IndexOutOfBoundsException e1) {
                                jsonHashtags[j] = "";
                            }
                            if (jsonHashtags[j].equals("lol")) {
                                remove = true;
                            }
                        }
                    }

                    if (remove) {
                        tweets3A.remove(i);
                        lol++;
                    }
                }
            } else if (tweets3A.get(i).getId_str() != null) {
                String line1 = ((String)tweets3A.get(i).getUser());
                if ((line1.substring(line1.indexOf("\"screen_name\":")+15, (line1.indexOf("\",", line1.indexOf("screen_name")))).equals("justinbieber"))) {
                    tweets3A.remove(i);
                    justin++;
                }
            } else if (tweets3A.get(i).getEntities() != null) {
                boolean remove = false;

                String hashtags, line = (String) tweets3A.get(i).getEntities();
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
                        } catch (IndexOutOfBoundsException e1) {
                            jsonHashtags[j] = "";
                        }
                        if (jsonHashtags[j].equals("lol")) {
                            remove = true;
                        }
                    }
                }

                if (remove) {
                    tweets3A.remove(i);
                    lol++;
                }
            }
        }
        long end4A = System.nanoTime();
        System.out.print("Run Time for removal in a MyArrayList: ");
        System.out.println(end4A-start4A);
        System.out.println("Removed: " + (tweets3Aorig - tweets3A.size()) + " total tweets, " + lol + " #lol, " + justin + " @justinbieber");
    }

}
