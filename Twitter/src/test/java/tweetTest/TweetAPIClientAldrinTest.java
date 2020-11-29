package tweetTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payload.aldrinsPayloadFiles;
import tweet.TweetAPIClientAldrin;


import java.io.FileNotFoundException;
import java.util.UUID;

public class TweetAPIClientAldrinTest {

    private TweetAPIClientAldrin tweetAPIClientAldrin;

    @BeforeClass
    public void setUpTweetAPI() throws FileNotFoundException {
        this.tweetAPIClientAldrin = new TweetAPIClientAldrin();
    }

    @Test
    public void testUserCanGetStatus() {
        long id = 1212891076715057153L;
        ValidatableResponse response = this.tweetAPIClientAldrin.getStatusesWithID(id);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test
    public void testUserCanTweetSuccessfully() {
        //1. User send a tweet
        String tweet = "There are a minimum of " + UUID.randomUUID().toString() +" ants roaming the earth right now! You can count, if you dont believe me.";
        ValidatableResponse response = this.tweetAPIClientAldrin.createTweet(tweet);
        response.statusCode(200);
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet does not match expected");
    }


    @Test
    public void testDelete() {
        long id = 1331667960369475589L;
        String tweet = "Tweeting this 0d13f749-c84b-4563-b7fd-2f38c2e42128";
        ValidatableResponse deleteResponse = this.tweetAPIClientAldrin.deleteTweet(id);
        deleteResponse.statusCode(200);
        String actualTweet = deleteResponse.extract().body().path("text");
        Assert.assertEquals(tweet, actualTweet);
    }

    @Test
    public void testStatusRetweeters() {
        Long id = 1331762798687293441L;
        ValidatableResponse response = this.tweetAPIClientAldrin.getStatusRetweeters(id);
        response.statusCode(200);
        //System.out.println(response.extract().body().asPrettyString());
    }

    @Test
    public void testRetweet() {
        String id = "1332788670471036932";
        ValidatableResponse response = this.tweetAPIClientAldrin.postRetweet(id);
        response.statusCode(200);
    }

    @Test
    public void testDeleteRetweet() {
        String id = "1332788670471036932";
        ValidatableResponse response = this.tweetAPIClientAldrin.deleteRetweet(id);
        response.statusCode(200);
    }

    @Test
    public void testFavoriteOrLike() {
        Long id = 1331721099785220099L;
        ValidatableResponse response = this.tweetAPIClientAldrin.postFavoritesOrCreate(id);
        response.statusCode(200);
    }

    @Test
    public void testDeleteFavoriteOrLike() {
        Long id = 1331721099785220099L;
        ValidatableResponse response = this.tweetAPIClientAldrin.deleteFavorites(id);
        response.statusCode(200);
    }

    @Test
    public void testResponseTime() {
        ValidatableResponse response = this.tweetAPIClientAldrin.responseTime();
        response.statusCode(200);
    }

    @Test
    public void testResponseTimeForCreatingTweet() {
        String tweet= "Testing response time again" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClientAldrin.responseTimeForCreateTweet(tweet);
        response.statusCode(200);
    }

    @Test
    public void testDeleteMessage() {
        Long id = 500226111l;
        ValidatableResponse deleteResponse = this.tweetAPIClientAldrin.deleteMessageUsingId(id);
        deleteResponse.statusCode(200);
    }

    @Test//not working
    public void testGetSavedSearches() {
        ValidatableResponse response = this.tweetAPIClientAldrin.getSavedSearches();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test//not working
    public void testGetFriendships() {
        ValidatableResponse response = this.tweetAPIClientAldrin.getFriendships();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }



    @Test
    public void testFollowerList() {
        long id = 500226111L;
        ValidatableResponse response = this.tweetAPIClientAldrin.getFollowersList(id);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test
    public void testImageUpload() {
        ValidatableResponse response = this.tweetAPIClientAldrin.uploadImage(aldrinsPayloadFiles.cuteBaby());
        response.assertThat().statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test
    public void testImageFlower() {
        ValidatableResponse response = this.tweetAPIClientAldrin.uploadImageFlower(aldrinsPayloadFiles.workIsHard());
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test//not working
    public void testGetProfileBanner() {
        long userId = 500226111;
        ValidatableResponse response = this.tweetAPIClientAldrin.getProfileBanner(userId);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test//not working
    public void testCreateCollection() {
        ValidatableResponse response = this.tweetAPIClientAldrin.createCollectionOfTweets();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());

    }

    @Test//not working
    public void testGetTrends() {
        Long id = 2347591l;
        ValidatableResponse response = this.tweetAPIClientAldrin.getTrendsLocation();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }


    @Test//not working
    public void testFollowGivenID() {
        String userId = "258793489";
        ValidatableResponse response = this.tweetAPIClientAldrin.followId();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test
    public void testDmFunctionality() throws FileNotFoundException {
        ValidatableResponse response = this.tweetAPIClientAldrin.dmGivenID();
        response.assertThat().statusCode(200).extract().body().asPrettyString();//.assertThat().header();
        JsonPath js = new JsonPath(String.valueOf(response)); //to parse the json input/output of method
        //String id = js.getString("event.type");
        //System.out.println(id);

    }


    @Test// working
    public void testDirectMessageSecond() throws FileNotFoundException {
        ValidatableResponse response = this.tweetAPIClientAldrin.messageCreateSecond();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test// working
    public void testWelcomeMessage() {
        ValidatableResponse response = this.tweetAPIClientAldrin.createWelcomeMessage(aldrinsPayloadFiles.cuteBaby(),aldrinsPayloadFiles.workIsHard());
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test// working
    public void testCreateList() {
        ValidatableResponse response = this.tweetAPIClientAldrin.createList();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }




}
