package tweetTest;
import static org.hamcrest.Matchers.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payload.PayloadForShaila;
import tweet.TweetAPIClientShaila;

import java.io.FileNotFoundException;
import java.util.UUID;

public class TweetAPIClientShailaTest {

    private TweetAPIClientShaila tweetAPIClientShaila;

    @BeforeClass
    public void setUpTweetAPI() throws FileNotFoundException {
        this.tweetAPIClientShaila = new TweetAPIClientShaila();
    }

    @Test//working
    public void testUserCanGetStatus() {
        long id = 1212891076715057153L;
        ValidatableResponse response = this.tweetAPIClientShaila.getStatusesWithID(id);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test//working
    public void testUserCanTweetSuccessfully() {
        //1. User send a tweet
        String tweet = "Testing once again " + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClientShaila.createTweet(tweet);
        response.statusCode(200);
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet does not match expected");
    }


    @Test//working
    public void testDelete() {
        long id = 1331667960369475589L;
        String tweet = "Tweeting this 0d13f749-c84b-4563-b7fd-2f38c2e42128";
        ValidatableResponse deleteResponse = this.tweetAPIClientShaila.deleteTweet(id);
        deleteResponse.statusCode(200);
        String actualTweet = deleteResponse.extract().body().path("text");
        Assert.assertEquals(tweet, actualTweet);
    }

    @Test//working
    public void testStatusRetweeters() {
        Long id = 1331762798687293441L;
        ValidatableResponse response = this.tweetAPIClientShaila.getStatusRetweeters(id);
        response.statusCode(200);
        //System.out.println(response.extract().body().asPrettyString());
    }

    @Test//working
    public void testRetweet() {
        String id = "1332788670471036932";
        ValidatableResponse response = this.tweetAPIClientShaila.postRetweet(id);
        response.statusCode(200);
    }

    @Test//working
    public void testDeleteRetweet() {
        String id = "1332788670471036932";
        ValidatableResponse response = this.tweetAPIClientShaila.deleteRetweet(id);
        response.statusCode(200);
    }

    @Test//working
    public void testFavoriteOrLike() {
        Long id = 1331721099785220099L;
        ValidatableResponse response = this.tweetAPIClientShaila.postFavoritesOrCreate(id);
        response.statusCode(200);
    }

    @Test//working
    public void testDeleteFavoriteOrLike() {
        Long id = 1331721099785220099L;
        ValidatableResponse response = this.tweetAPIClientShaila.deleteFavorites(id);
        response.statusCode(200);
    }

    @Test//working
    public void testResponseTime() {
        ValidatableResponse response = this.tweetAPIClientShaila.responseTime();
        response.statusCode(200);
    }

    @Test//working
    public void testResponseTimeForCreatingTweet() {
        String tweet= "Testing response time again" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClientShaila.responseTimeForCreateTweet(tweet);
        response.statusCode(200);
    }

    @Test//working
    public void testDeleteMessage() {
        Long id = 500226111l;
        ValidatableResponse deleteResponse = this.tweetAPIClientShaila.deleteMessageUsingId(id);
        deleteResponse.statusCode(200);
    }

    @Test//not working
    public void testGetSavedSearches() {
        ValidatableResponse response = this.tweetAPIClientShaila.getSavedSearches();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test//not working
    public void testGetFriendships() {
        ValidatableResponse response = this.tweetAPIClientShaila.getFriendships();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }



    @Test //working
    public void testFollowerList() {
        long id = 500226111L;
        ValidatableResponse response = this.tweetAPIClientShaila.getFollowersList(id);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test //working
    public void testImageUpload() {
        ValidatableResponse response = this.tweetAPIClientShaila.uploadImage(PayloadForShaila.myImage());
        response.assertThat().statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test //working
    public void testImageFlower() {
        ValidatableResponse response = this.tweetAPIClientShaila.uploadImageFlower(PayloadForShaila.flowerImage());
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test//not working
    public void testGetProfileBanner() {
        long userId = 500226111;
        ValidatableResponse response = this.tweetAPIClientShaila.getProfileBanner(userId);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test//not working
    public void testCreateCollection() {
        ValidatableResponse response = this.tweetAPIClientShaila.createCollectionOfTweets();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());

    }

    @Test//not working
    public void testGetTrends() {
        Long id = 2347591l;
        ValidatableResponse response = this.tweetAPIClientShaila.getTrendsLocation();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }


    @Test//not working
    public void testCreateFriendships() {
        String userId = "258793489";
        ValidatableResponse response = this.tweetAPIClientShaila.createFriendship();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test// working
    public void testDirectMessageCreate() throws FileNotFoundException {
        ValidatableResponse response = this.tweetAPIClientShaila.messageCreate();
        response.assertThat().statusCode(200).extract().body().asPrettyString();//.assertThat().header();
        JsonPath js = new JsonPath(String.valueOf(response)); //to parse the json input/output of method
        //String id = js.getString("event.type");
        //System.out.println(id);

    }


    @Test// working
    public void testDirectMessageSecond() throws FileNotFoundException {
        ValidatableResponse response = this.tweetAPIClientShaila.messageCreateSecond();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test// working
    public void testWelcomeMessage() {
        ValidatableResponse response = this.tweetAPIClientShaila.createWelcomeMessage(PayloadForShaila.postWelcomeMessage(),PayloadForShaila.flowerImage());
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test// working
    public void testCreateList() {
        ValidatableResponse response = this.tweetAPIClientShaila.createList();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }




}





