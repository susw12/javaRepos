package mr.gonzalez.xc240.jsonProject;

import swain.sujay.xc240.LinkedList.MyLinkedList;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Hashtag {
    String hastagName;
    MyLinkedList<HashtagOccurences> occurences;
    Date firstInstance;
    Date lastInstance;

    public Hashtag(String hashTag) {
        hastagName = hashTag;
        occurences = new MyLinkedList<HashtagOccurences>();
        firstInstance = null;
        lastInstance = null;
    }

    public String getHastagName() {
        return hastagName;
    }

    public void setHastagName(String hastagName) {
        this.hastagName = hastagName;
    }

    public MyLinkedList<HashtagOccurences> getOccurences() {
        return occurences;
    }

    public void setOccurences(MyLinkedList<HashtagOccurences> occurences) {
        this.occurences = occurences;
    }

    public Date getFirstInstance() {
        return firstInstance;
    }

    public void setFirstInstance(Date firstInstance) {
        this.firstInstance = firstInstance;
    }

    public Date getLastInstance() {
        return lastInstance;
    }

    public void setLastInstance(Date lastInstance) {
        this.lastInstance = lastInstance;
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
