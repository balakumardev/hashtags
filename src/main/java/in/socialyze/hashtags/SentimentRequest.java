package in.socialyze.hashtags;

/**
 * Created by balak on 6/30/2017.
 */
public class SentimentRequest {
    private String txt;

    public SentimentRequest(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
