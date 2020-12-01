package tweetTest;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tweet.TweetAPIClientRuna;
import tweet.TwiterApiaAutomationWithRestAssured;

import java.util.UUID;

public class TwiterApiAutomationWithRestAssuredTest {
    private TweetAPIClientRuna tweetAPIClient;
    @BeforeClass
    public void setUpPostsAPI() {
        this.tweetAPIClient = new TweetAPIClientRuna();
    }

    @Test
    public void setUpTweetAPI() {
        TwiterApiaAutomationWithRestAssured obj = new TwiterApiaAutomationWithRestAssured(110, "test title", "test body");
        ValidatableResponse response = this.tweetAPIClient.createPost(obj);
        response.statusCode(400);
        System.out.println(response.extract().body().asPrettyString());
    }

//public void getDirectmassageTest(){
//    ValidatableResponse response = this.tweetAPIClient.getDircteMassage();
// System.out.println(response.extract().body().asPrettyString());
//
//}


}
