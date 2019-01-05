package mr.gonzalez.xc240.jsonProject;

/**
 * Tweet Class
 * <p>This class represents a tweet taken from the JSON file containing all relevant and important information
 * <p>
 * ADSB JSON Project Part 1
 * 01/01/2019
 *
 * @author Sujay Swain
 */
public class Tweet {
    private String text;
    private String id_str;
    private boolean favorited;
    private boolean truncated;
    private int retweet_count;
    private String in_reply_to_screen_name;
    private int in_reply_to_user_id;
    private String source;
    private String created_at;
    private boolean retweeted;
    private String in_reply_to_status_id_str;
    private String in_reply_to_user_id_str;
    private String entities;
    private String contributors;
    private String place;
    private String coordinates;
    private String user;
    private long id;
    private long in_reply_to_status_id;

    //constructor given all of a tweet's properties
    public Tweet(String text, String id_str, boolean favorited, boolean truncated, int retweet_count, String in_reply_to_screen_name, int in_reply_to_user_id, String source, String created_at, boolean retweeted, String in_reply_to_status_id_str, String in_reply_to_user_id_str, String entities, String contributors, String place, String coordinates, String user, long id, long in_reply_to_status_id) {
        this.text = text;
        this.id_str = id_str;
        this.favorited = favorited;
        this.truncated = truncated;
        this.retweet_count = retweet_count;
        this.in_reply_to_screen_name = in_reply_to_screen_name;
        this.in_reply_to_user_id = in_reply_to_user_id;
        this.source = source;
        this.created_at = created_at;
        this.retweeted = retweeted;
        this.in_reply_to_status_id_str = in_reply_to_status_id_str;
        this.in_reply_to_user_id_str = in_reply_to_user_id_str;
        this.entities = entities;
        this.contributors = contributors;
        this.place = place;
        this.coordinates = coordinates;
        this.user = user;
        this.id = id;
        this.in_reply_to_status_id = in_reply_to_status_id;
    }

    //constructor given a line representing one tweet formatted as a JSON
    public Tweet(String line) {
        if (fullTweet(line)) {
            try {
                text = line.substring(line.indexOf("\"text\":") + 8, line.indexOf("\","));
            } catch (IndexOutOfBoundsException e) {
                text = line.substring(line.indexOf("\"text\":") + 8, line.indexOf("\",\"id_str\":"));
            }
            id_str = line.substring(line.indexOf("\"id_str\":") + 10, line.indexOf("\",", line.indexOf("\"id_str\":")));
            try {
                favorited = Boolean.parseBoolean(line.substring(line.indexOf("\"favorited\":") + 13, line.indexOf(",", line.indexOf("\"favorited\":"))));
            } catch (IndexOutOfBoundsException e) {
                favorited = Boolean.parseBoolean(line.substring(line.indexOf("\"favorited\":") + 13, line.indexOf("}", line.indexOf("\"favorited\":"))));
            }
            truncated = Boolean.parseBoolean(line.substring(line.indexOf("\"truncated\":") + 13, line.indexOf(",", line.indexOf("\"truncated\":"))));

            String rCount = line.substring(line.indexOf("\"retweet_count\":") + 16, line.indexOf(",", line.indexOf("\"retweet_count\":")));
            if (rCount.equals("\"100+\"")) {
                retweet_count = 100;
            } else {
                retweet_count = Integer.parseInt(rCount);
            }

            if ((line.substring(line.indexOf("\"in_reply_to_screen_name\":") + 26, line.indexOf("\"in_reply_to_screen_name\":") + 30).equals("null"))) {
                in_reply_to_screen_name = null;
            } else {
                in_reply_to_screen_name = line.substring(line.indexOf("\"in_reply_to_screen_name\":") + 27, line.indexOf(",", line.indexOf("\"in_reply_to_screen_name\":")));
            }

            String in_reply;
            try {
                in_reply = line.substring(line.indexOf("\"in_reply_to_user_id\":") + 22, line.indexOf(",", line.indexOf("\"in_reply_to_user_id\":")));
            } catch (IndexOutOfBoundsException e) {
                in_reply = line.substring(line.indexOf("\"in_reply_to_user_id\":") + 22, line.indexOf("}", line.indexOf("\"in_reply_to_user_id\":")));
            }
            if (in_reply.equals("null")) {
                in_reply_to_user_id = -1;
            } else {
                try {
                    in_reply_to_user_id = Integer.parseInt(in_reply);
                } catch (NumberFormatException e1) {
                    try {
                        in_reply_to_user_id = Integer.parseInt(line.substring(line.indexOf("\"in_reply_to_user_id\":") + 22, line.indexOf("}", line.indexOf("\"in_reply_to_user_id\":"))));
                    } catch (NumberFormatException e2) {
                        in_reply_to_user_id = -1;
                    }
                }
            }

            if ((line.substring(line.indexOf("\"in_reply_to_status_id_str\":") + 28, line.indexOf("\"in_reply_to_status_id_str\":") + 32).equals("null"))) {
                in_reply_to_status_id_str = null;
            } else {
                try {
                    in_reply_to_status_id_str = line.substring(line.indexOf("\"in_reply_to_status_id_str\":") + 29, line.indexOf(",", line.indexOf("\"in_reply_to_status_id_str\":")));
                } catch (IndexOutOfBoundsException e) {
                    in_reply_to_status_id_str = line.substring(line.indexOf("\"in_reply_to_status_id_str\":") + 29, line.indexOf("}", line.indexOf("\"in_reply_to_status_id_str\":")));
                }
            }

            source = line.substring(line.indexOf("\"source\":") + 10, line.indexOf("\",", line.indexOf("\"source\":")));
            created_at = line.substring(line.indexOf("\"created_at\":") + 14, line.indexOf("\",", line.indexOf("\"created_at\":")));
            retweeted = Boolean.parseBoolean(line.substring(line.indexOf("\"retweeted\":") + 13, line.indexOf(",", line.indexOf("\"retweeted\":"))));

            if ((line.substring(line.indexOf("\"contributors\":") + 15, line.indexOf("\"contributors\":") + 19).equals("null"))) {
                contributors = null;
            } else {
                contributors = line.substring(line.indexOf("\"contributors\":") + 16, line.indexOf("}", line.indexOf("\"contributors\":")));
            }

            if (line.substring(line.indexOf("\"in_reply_to_user_id_str\":") + 26, line.indexOf("\"in_reply_to_user_id_str\":") + 30).equals("null")) {
                in_reply_to_user_id_str = null;
            } else {
                try {
                    in_reply_to_user_id_str = line.substring(line.indexOf("\"in_reply_to_user_id_str\":") + 27, line.indexOf(",", line.indexOf("\"in_reply_to_user_id_str\":")));
                } catch (IndexOutOfBoundsException e) {
                    in_reply_to_user_id_str = line.substring(line.indexOf("\"in_reply_to_user_id_str\":") + 27, line.indexOf("}", line.indexOf("\"in_reply_to_user_id_str\":")));
                }
            }

            entities = line.substring(line.indexOf("\"entities\":") + 13, line.indexOf("},", line.indexOf("\"entities\":")));;

            if ((line.substring(line.indexOf("\"coordinates\":") + 14, line.indexOf("\"coordinates\":") + 18).equals("null"))) {
                contributors = null;
            } else {
                contributors = line.substring(line.indexOf("\"coordinates\":") + 15, line.indexOf("}", line.indexOf("\"coordinates\":")));
            }

            if ((line.substring(line.indexOf("\"place\":") + 8, line.indexOf("\"place\":") + 12).equals("null"))) {
                contributors = null;
            } else {
                int end = -1;
                int left = 1;
                int right = 0;
                for (int i = line.indexOf("\"place\":") + 9; i < line.length(); i++) {
                    if (line.substring(i,i+1).equals("{")) {
                        left++;
                    } else if (line.substring(i,i+1).equals("}")) {
                        right++;
                    }
                    if (left == right) {
                        end = i;
                        break;
                    }
                }
                contributors = line.substring(line.indexOf("\"place\":") + 9, end);
            }

            user = line.substring(line.indexOf("\"user\":") + 8, line.indexOf("}", line.indexOf("\"user\":")));
            try {
                id = Long.parseLong(line.substring(line.indexOf("\"id\":", line.indexOf("\"location\":")) + 5, line.indexOf(",", line.indexOf("\"id\":", line.indexOf("\"location\":")))));
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                id = Long.parseLong(line.substring(line.indexOf("\"id\":", line.indexOf("\"location\":")) + 5, line.indexOf("}", line.indexOf("\"id\":", line.indexOf("\"location\":")))));
            }

            if ((line.substring(line.indexOf("\"in_reply_to_status_id\":") + 24, line.indexOf("\"in_reply_to_status_id\":") + 28).equals("null"))) {
                in_reply_to_status_id = -1;
            } else {
                try {
                    in_reply_to_status_id = Long.parseLong(line.substring(line.indexOf("\"in_reply_to_status_id\":") + 24, line.indexOf("},", line.indexOf("\"in_reply_to_status_id\":"))));
                } catch (IndexOutOfBoundsException | NumberFormatException e) {
                    try {
                        in_reply_to_status_id = Long.parseLong(line.substring(line.indexOf("\"in_reply_to_status_id\":") + 24, line.indexOf(",", line.indexOf("\"in_reply_to_status_id\":"))));
                    } catch (IndexOutOfBoundsException e2) {
                        in_reply_to_status_id = Long.parseLong(line.substring(line.indexOf("\"in_reply_to_status_id\":") + 24, line.indexOf("}", line.indexOf("\"in_reply_to_status_id\":"))));
                    }
                }
            }
        }
    }

    //Make sure it is a full tweet
    public boolean fullTweet(String line) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.substring(i,i+1).equals("{")) {
                left++;
            } else if (line.substring(i,i+1).equals("}")) {
                right++;
            }
        }
        return (left == right);
    }

    //converts a tweet to a string, showing all of its properties
    public String toString() {
        String s = "";
        s += "text:\t\t\t\t";
        s += text;
        s += "\n";
        s += "id_str:\t\t\t\t";
        s += id_str;
        s += "\n";
        s += "favorited:\t\t\t";
        s += favorited;
        s += "\n";
        s += "truncated:\t\t\t";
        s += truncated;
        s += "\n";
        s += "retweet_count:\t\t\t";
        s += retweet_count;
        s += "\n";
        s += "in_reply_to_screen_name:\t";
        s += in_reply_to_screen_name;
        s += "\n";
        s += "in_reply_to_user_id:\t\t";
        s += in_reply_to_user_id;
        s += "\n";
        s += "source:\t\t\t\t";
        s += source;
        s += "\n";
        s += "created_at:\t\t\t";
        s += created_at;
        s += "\n";
        s += "retweeted:\t\t\t";
        s += retweeted;
        s += "\n";
        s += "in_reply_to_status_id_str:\t";
        s += in_reply_to_status_id_str;
        s += "\n";
        s += "in_reply_to_user_id_str:\t";
        s += in_reply_to_user_id_str;
        s += "\n";
        s += "entities:\t\t\t";
        s += entities;
        s += "\n";
        s += "contributors:\t\t\t";
        s += contributors;
        s += "\n";
        s += "place:\t\t\t\t";
        s += place;
        s += "\n";
        s += "coordinates:\t\t\t";
        s += coordinates;
        s += "\n";
        s += "user:\t\t\t\t";
        s += user;
        s += "\n";
        s += "id:\t\t\t\t";
        s += id;
        s += "\n";
        s += "in_reply_to_status_id:\t\t";
        s += in_reply_to_status_id;
        return s;
    }

    //getters and setters for all of the tweet's properties

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId_str() {
        return id_str;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    public boolean getFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public boolean getTruncated() {
        return truncated;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public int getRetweet_count() {
        return retweet_count;
    }

    public void setRetweet_count(int retweet_count) {
        this.retweet_count = retweet_count;
    }

    public String getIn_reply_to_screen_name() {
        return in_reply_to_screen_name;
    }

    public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
        this.in_reply_to_screen_name = in_reply_to_screen_name;
    }

    public int getIn_reply_to_user_id() {
        return in_reply_to_user_id;
    }

    public void setIn_reply_to_user_id(int in_reply_to_user_id) {
        this.in_reply_to_user_id = in_reply_to_user_id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public boolean getRetweeted() {
        return retweeted;
    }

    public void setRetweeted(boolean retweeted) {
        this.retweeted = retweeted;
    }

    public String getIn_reply_to_status_id_str() {
        return in_reply_to_status_id_str;
    }

    public void setIn_reply_to_status_id_str(String in_reply_to_status_id_str) {
        this.in_reply_to_status_id_str = in_reply_to_status_id_str;
    }

    public String getIn_reply_to_user_id_str() {
        return in_reply_to_user_id_str;
    }

    public void setIn_reply_to_user_id_str(String in_reply_to_user_id_str) {
        this.in_reply_to_user_id_str = in_reply_to_user_id_str;
    }

    public Object getEntities() {
        return entities;
    }

    public void setEntities(String entities) {
        this.entities = entities;
    }

    public String getContributors() {
        return contributors;
    }

    public void setContributors(String contributors) {
        this.contributors = contributors;
    }

    public Object getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Object getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getIn_reply_to_status_id() {
        return in_reply_to_status_id;
    }

    public void setIn_reply_to_status_id(int in_reply_to_status_id) {
        this.in_reply_to_status_id = in_reply_to_status_id;
    }

}
