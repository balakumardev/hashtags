package in.socialyze.hashtags;

/**
 * Created by balak on 6/29/2017.
 */

public class Tweet {
    String tweet;
    String author;
    String feedback;

    public Tweet() {

    }

    public Tweet(String tweet, String author, String feedback) {
        this.tweet = tweet;
        this.author = author;
        this.feedback = feedback;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFeedback() {
        return feedback;
    }
}
