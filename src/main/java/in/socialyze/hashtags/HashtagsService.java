package in.socialyze.hashtags;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by balak on 6/29/2017.
 */
@Service
public class HashtagsService {
    @Autowired
    private HashtagsRepository hashRepos;

    public List<Hashtag> findAllHashtags() {
        return (List<Hashtag>) hashRepos.findAll();
    }

    public void addHashtag(Hashtag tag) {
        hashRepos.save(tag);
    }

    public void deleteAll() {
        hashRepos.deleteAll();
    }

    public void addTweet(String tag, Tweet t) {
        Hashtag hashtag = hashRepos.findOne(tag);

        String url = "https://community-sentiment.p.mashape.com/text/";

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("X-Mashape-Key", "HGR91g48i8mshbswwSe3HkcDAXiNp1QGAXLjsnp00qvp1IZqaZ");
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpEntity<String> entity = new HttpEntity<String>("txt=" + t.getTweet(), headers);
        String resp = restTemplate.postForObject(url, entity, String.class);
        if (resp.contains("Positive")) {
            t.setFeedback("Positive");
        } else if (resp.contains("Negative")) {
            t.setFeedback("Negative");
        } else if (resp.contains("Neutral")) {
            t.setFeedback("Neutral");
        }


        switch (t.getFeedback()) {
            case "Positive":
                hashtag.incPositive();
                break;
            case "Negative":
                hashtag.incNegative();
                break;
            case "Neutral":
                hashtag.incNeutral();
                break;
        }
        hashtag.addTweet(t);
        hashRepos.save(hashtag);
    }

    public List<Tweet> getAllTweets(String tag) {
        Hashtag hashtag = hashRepos.findOne(tag);
        return hashtag.getTweetList();
    }
}
