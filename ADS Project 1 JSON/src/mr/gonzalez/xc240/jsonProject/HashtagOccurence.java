package mr.gonzalez.xc240.jsonProject;

import java.util.Date;

public class HashtagOccurence {
    private String hashName;
    private Date date;

    public HashtagOccurence(String hashTag, Date tweetDate) {
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
