package mr.gonzalez.xc240.jsonProject;

import swain.sujay.xc240.ListType.MyLinkedList;

import java.util.Date;

public class Hashtag {
    private String hashtagName;
    private MyLinkedList<HashtagOccurance> occurances;
    private Date firstInstance;
    private Date lastInstance;

    public Hashtag(String hashTag) {
        hashtagName = hashTag;
        occurances = new MyLinkedList<HashtagOccurance>();
        firstInstance = null;
        lastInstance = null;
    }

    public Hashtag(String hashTag, Date firstInst, Date lastInst, MyLinkedList<HashtagOccurance> occurances) {
        hashtagName = hashTag;
        this.occurances = occurances;
        firstInstance = firstInst;
        lastInstance = lastInst;
    }


    public String getHashtagName() {
        return hashtagName;
    }

    public void setHashtagName(String hashtagName) {
        this.hashtagName = hashtagName;
    }

    public MyLinkedList<HashtagOccurance> getOccurences() {
        return occurances;
    }

    public void setOccurences(MyLinkedList<HashtagOccurance> occurances) {
        this.occurances = occurances;
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

    public void addInstance(HashtagOccurance newInst) {
        this.occurances.add(newInst);
    }
}
