package in.socialyze.hashtags;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by balak on 6/29/2017.
 */
@Document
public class Hashtag {
    @Id
    private String tag;
    private List<Tweet> tweetList;
    private int positive = 0;
    private int negative = 0;
    private int neutral = 0;

    public Hashtag() {}

    public Hashtag(String tag, List<Tweet> tweetList, int positive, int negative, int neutral) {
        this.tag = tag;
        this.tweetList = tweetList;
        this.positive = positive;
        this.negative = negative;
        this.neutral = neutral;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void addTweet(Tweet t) {
        if(tweetList != null) {
            tweetList.add(t);
        } else {
            tweetList = new LinkedList<Tweet>();
            tweetList.add(t);
        }
    }

    public List<Tweet> getTweetList() {
        return tweetList;
    }

    public void setTweetList(List<Tweet> tweetList) {
        this.tweetList = tweetList;
    }

    public int getPositive() {
        return positive;
    }

    public void setPositive(int positive) {
        this.positive = positive;
    }

    public int getNegative() {
        return negative;
    }

    public void setNegative(int negative) {
        this.negative = negative;
    }

    public int getNeutral() {
        return neutral;
    }

    public void setNeutral(int neutral) {
        this.neutral = neutral;
    }

    public void incPositive() {
        this.positive++;
    }

    public void incNegative() {
        this.negative++;
    }

    public void incNeutral() {
        this.neutral++;
    }
}
