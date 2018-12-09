package mr.gonzalez.xc240.jsonProject;

import swain.sujay.xc240.LinkedList.MyLinkedList;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Hashtag {
    public static void main(String[] args) {

    }

    public Hashtag(String hashTag) {
        String hastagName = hashTag;
        MyLinkedList<HashtagOccurences> occurences = new MyLinkedList<HashtagOccurences>();
        Date firstInstance = null;
        Date lastInstance = null;
    }

    public void updateOccurences(String fileName) {
        Scanner jsonFile = new Scanner(System.in);

        while (jsonFile.hasNextLine()) {
            String tempStore = jsonFile.nextLine();
            if (tempStore.substring(0,6).equals("{\"text\":")) {
                for (String read : tempStore.split(",")) {
                    if (read.substring(0,10).equals("\"entities\":")) {
                        String toList = read.split(",")[0];
                        String justTheHashtags = toList.substring(22, toList.length() - 1);
                    }

                }

            }
        }
    }

    public class HashtagOccurences {
        private String hashName;
        private Date date;

        public HashtagOccurences(String hashTag, Date tweetDate) {
            hashName = hashTag;
            date = tweetDate;
        }

        public String getHashName() {
            return hashName;
        }

        public void setHashName(String hashName) {
            this.hashName = hashName;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }
}
