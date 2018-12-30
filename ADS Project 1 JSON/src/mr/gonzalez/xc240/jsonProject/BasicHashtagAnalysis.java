package mr.gonzalez.xc240.jsonProject;
import swain.sujay.xc240.LinkedList.MyLinkedList;

import java.io.File;
import java.util.Date;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class BasicHashtagAnalysis {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(new File("DataSet1/0_scrubbed.json"));
        for (int x = 0; x < hashtagParser(reader).size(); x++) {
            System.out.println(hashtagParser(reader).get(x).getHashtagName());
        }
    }
    public static MyLinkedList<Hashtag> hashtagParser(Scanner reader) {
        MyLinkedList<Hashtag> hashtagCollection = new MyLinkedList<>();
        int lineCounter = 0;
        while (reader.hasNextLine() && !reader.nextLine().substring(3, 9).equals("delete")) {
            lineCounter += 1;
            System.out.println(lineCounter);
            String line = reader.nextLine();
            String hashtags;
            Date tweetDate;
            int tweetDateLocation = line.indexOf("created_at");
            tweetDate = new Date(Integer.parseInt(line.substring(tweetDateLocation + 39, tweetDateLocation + 43)), monthToNumber(line.substring(tweetDateLocation+17, tweetDateLocation+20)), Integer.parseInt(line.substring(tweetDateLocation+21, tweetDateLocation+23)));
            try {
                hashtags = line.substring(line.indexOf("[", line.indexOf("hashtags:\"")), line.indexOf("]}]}", line.indexOf("hashtags:\"")));
                if (Character.toString(hashtags.charAt(1)).equals("]")) {
                    hashtags = "";
                }
            } catch (IndexOutOfBoundsException e1) {
                try {
                    hashtags = line.substring(line.indexOf("[", line.indexOf("hashtags:\"")), line.indexOf("]", line.indexOf("hashtags:\"")));
                    if (Character.toString(hashtags.charAt(1)).equals("]")) {
                        hashtags = "";
                    }
                }
                catch (IndexOutOfBoundsException e2) {
                    hashtags = "";
                }
            }
            if (hashtags.length() != 2 && hashtags.length() != 0) {
                hashtags = hashtags.substring(1, hashtags.length()-1).toLowerCase();
                String[] jasonHashtags = hashtags.split("},");
                for (int x = 0; x < jasonHashtags.length; x++) {
                    try {
                        jasonHashtags[x] = hashtags.substring(9, hashtags.indexOf("\",\"indices"));
                        boolean hashtagExist = false;
                        int hashtagsLocation = hashtagCollection.size()-1;
                        for (int y = 0; y < hashtagCollection.size()-1; y++) {
                            try {
                                if (hashtagCollection.get(y).getHashtagName().equals(jasonHashtags[x])) {
                                    hashtagExist = true;
                                    hashtagsLocation = y;
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ignored) {
                            }
                        }
                        if (!hashtagExist) {
                            hashtagCollection.add(new Hashtag(jasonHashtags[x]));
                        }
                        hashtagCollection.get(hashtagsLocation).getOccurences().add(new HashtagOccurence(hashtagCollection.get(hashtagsLocation).getHashtagName(), tweetDate));
                        } catch (IndexOutOfBoundsException e1) {
                        jasonHashtags[x] = "";
                    }
                }
            }
        }
        return hashtagCollection;
    }

    public static int monthToNumber(String month) {
        MyLinkedList<String> months = new MyLinkedList<>() {{
            add("Jan");
            add("Feb");
            add("Mar");
            add("Apr");
            add("May");
            add("Jun");
            add("Jul");
            add("Aug");
            add("Sep");
            add("Oct");
            add("Nov");
            add("Dec");
        }};
        for (int x = 0; x < months.size(); x++) {
            if (months.get(x).equals(month)) {
                return x;
            }
        }
        return 0;
    }
}
