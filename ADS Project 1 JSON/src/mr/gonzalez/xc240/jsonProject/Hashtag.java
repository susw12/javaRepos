package mr.gonzalez.xc240.jsonProject;

import swain.sujay.xc240.LinkedList.MyLinkedList;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Hashtag {
    private String hashtagName;
    private MyLinkedList<HashtagOccurence> occurences;
    private Date firstInstance;
    private Date lastInstance;

    public Hashtag(String hashTag) {
        hashtagName = hashTag;
        occurences = new MyLinkedList<HashtagOccurence>();
        firstInstance = null;
        lastInstance = null;
    }

    public String getHashtagName() {
        return hashtagName;
    }

    public void setHashtagName(String hashtagName) {
        this.hashtagName = hashtagName;
    }

    public MyLinkedList<HashtagOccurence> getOccurences() {
        return occurences;
    }

    public void setOccurences(MyLinkedList<HashtagOccurence> occurences) {
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
}
