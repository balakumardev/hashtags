package in.socialyze.hashtags;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by balak on 6/29/2017.
 */
@RestController
public class HashtagsController {
    @Autowired
    private HashtagsService hashService;

    @CrossOrigin("http://localhost:4200")
    @RequestMapping("/hashtags")
    public List<Hashtag> findAllHashtags() {
        return hashService.findAllHashtags();
    }
    @CrossOrigin("http://localhost:4200")
    @RequestMapping(method=RequestMethod.POST, value="/hashtags/add")
    public void addHashtag(@RequestBody Hashtag tag) {
        hashService.addHashtag(tag);
    }
    @CrossOrigin("http://localhost:4200")
    @RequestMapping("/hashtags/deleteAll")
    public void deleteAllHashtags() {
        hashService.deleteAll();
    }

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(method=RequestMethod.POST, value="/hashtags/{tag}/tweets/add")
    public void addTweet(@PathVariable("tag") String tag, @RequestBody Tweet t) {
        hashService.addTweet(tag, t);
    }

    @CrossOrigin("http://localhost:4200")
    @RequestMapping("/hashtags/{tag}/tweets")
    public List<Tweet> getAllTweets(String tag) {
        return hashService.getAllTweets(tag);
    }
}
