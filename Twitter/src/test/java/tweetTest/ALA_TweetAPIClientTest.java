package tweetTest;

import org.testng.annotations.BeforeClass;
import tweet.Ala_TweetAPIClient;

public class ALA_TweetAPIClientTest {
    private Ala_TweetAPIClient ala_tweetAPIClient;
    @BeforeClass
    public void setUpTweetAPI() {
        this.ala_tweetAPIClient = new Ala_TweetAPIClient();
    }

}
