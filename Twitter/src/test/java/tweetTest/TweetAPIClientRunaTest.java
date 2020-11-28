package tweetTest;

import base.RestAPI;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tweet.TweetAPIClientRuna;


import java.util.UUID;


public class TweetAPIClientRunaTest {


    private TweetAPIClientRuna tweetAPIClient;

    @BeforeClass
    public void setUpTweetAPI() {
        this.tweetAPIClient = new TweetAPIClientRuna();
    }
    //1
    @Test(enabled = true)
    public void testUserCanTweetSuccessfully() {
        //1. User send a tweet
        String tweet = "with WeekdaysEvening_Selenium_NY_Summer2020" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClient.createTweet(tweet);
        //2. Verify that the tweet was successful
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }

    //2
    @Test(enabled = false)
    public void testUserCanNotTweetTheSameTweetTwiceInARow() {
        //1. User send a tweet
        //String tweet="We are learning Rest API Automation with WeekdaysEvening_Selenium_NY_Summer2020"+ UUID.randomUUID().toString();
        String tweet = "We are learning Rest API Automation with WeekdaysEvening_Selenium_NY_Summer202013";
        ValidatableResponse response = this.tweetAPIClient.createTweet(tweet);
        //2. Verify that the tweet was successful
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
        // User send same Tweet
        response = this.tweetAPIClient.createTweet(tweet);
        // Verify that the tweet was unsuccessful
        response.statusCode(403);
        System.out.println(response.extract().body().asPrettyString());
        String expectedMessage = "Status is a duplicate.";
        String actualMessage = response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualMessage, expectedMessage, "Message not match");
        Assert.assertNotSame("200", 403);
    }

    //3
    @Test(enabled = false)
    public void testDelete() {
        String tweet = "WeekdaysEvening_Selenium_NY_Summer2020";
        ValidatableResponse deleteResponse = this.tweetAPIClient.deleteTweet(1329235246051713024l);
        deleteResponse.statusCode(200);
        String actualTweet = deleteResponse.extract().body().path("text");
        Assert.assertEquals(tweet, actualTweet);
    }

    //4
    @Test(enabled = false)
    public void testGetmethod() {
        //1. User send a tweet
        String tweet = "home_timeline" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClient.getUserTimeTweet();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }

    //5
    @Test(enabled = false)
    public void getUserTimeFromTweterTest() {
        ValidatableResponse response = tweetAPIClient.getUserTimeFromTweter();
        System.out.println(response.extract().body().asPrettyString());
        String expectedMessage = "No status found with that ID.";
        String actualMessage = response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualMessage, expectedMessage, "Message not match");
    }

    //6
    @Test(enabled = false)
    public void userCanPostTweetSuccessfully() {
        String tweeter = "WE Are Doing  BootCamp" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClient.createTweeter(tweeter);
        //2. Verify that the tweet was successful
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweeter, "Tweet is not match");
    }

    //7
    @Test(enabled = false)
    public void userCanDeleFromTweetTest() {
        String tweeter = "WE Are Doing  BootCamp";
        ValidatableResponse response = this.tweetAPIClient.userCanDeleFromTweet(1332368617929838594l);
        response.statusCode(200);
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweeter, "Tweet is not match");
    }

    //8
    @Test(enabled = false)
    public void getUserCollectionTest() {
        ValidatableResponse response = tweetAPIClient.getUserFromCollectionList();
        System.out.println(response.extract().body().asPrettyString());
    }

    //9
    @Test(enabled = false)
    public void userCanCreateCollectionList() {
        String tweeterr = "If you do hard work success will knock your door" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClient.createUserCollection(tweeterr);
        //2. Verify that the tweet was successful
//response.statusCode(214);
        String expectedMessage = "Bad request.";
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualTweet, expectedMessage, "Tweet is not match");
    }

    //10
    @Test(enabled = false)
    public void userCandeleteCollectionList() {
        String tweet = "If you do hard work success will knock your door";
        ValidatableResponse deleteResponse = this.tweetAPIClient.userCanDeleFromCollectionList("message");
    }

    //11
    @Test(enabled = false)
    public void getUserDirectMassageTest() {
        ValidatableResponse response = tweetAPIClient.getUserDirectMessages();
        System.out.println(response.extract().body().asPrettyString());
    }

    //12
    @Test(enabled = false)
    public void createDirectMassageTest() {
        String tweeterr = "Do Practice Until you Gain The Moon";
        ValidatableResponse response = this.tweetAPIClient.createDirectMassageFromUser(tweeterr);
//    //2. Verify that the tweet was successful

//    String expectedMessage="Bad request.";
        System.out.println(response.extract().body().asPrettyString());
    }

    //13
    @Test(enabled = false)
    public void createMediaTest() {
        String tweeterr = "Do Practice Until you Gain The Moon" + UUID.randomUUID().toString();
        ;
        ValidatableResponse response = this.tweetAPIClient.createMediaFromUser(tweeterr);
        System.out.println(response.extract().body().asPrettyString());
    }

    //14
    @Test(enabled = false)
    public void getTrendsPlaceTest() {
        ValidatableResponse response = tweetAPIClient.getTrendsPlace();
        // System.out.println(response.extract().body().asPrettyString());
        response.statusCode(404);
        String expectedMessage = "Sorry, that page does not exist.";
        String actualMessage = response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualMessage, expectedMessage, "Sorry, that page does not exist.");
    }

    //15
    @Test(enabled = false)
    public void testResponseTime() {
        ValidatableResponse response = this.tweetAPIClient.responseMediaTime();
    }

    //16
    @Test(enabled = true)
    public void mediaHeaderValueTest() {
        this.tweetAPIClient.mediaHeaderValue();
    }

    //17
    @Test(enabled = false)
    public void testPropertyFromResponse() {
        String tweeter = "WE Are Doing  BootCamp" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClient.createTweeter(tweeter);
        System.out.println(response.extract().body().asPrettyString().contains("id"));
    }

    //18
    @Test(enabled = false)
    public void getFollowerListTest() {
        ValidatableResponse response = tweetAPIClient.getFollowerList();
        String expectedMessage = "null";
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("users[0].next_cursor");
        Assert.assertEquals(actualTweet, expectedMessage, "Tweet is not match");
    }

    //19
    @Test(enabled = true)
    public void UserCreateFollowerListTest() {
        String mediaTweet = "I Can Post anything";
        ValidatableResponse response = this.tweetAPIClient.UserCreateFollowerList(mediaTweet);
        System.out.println(response.extract().body().asPrettyString());
    }

    //20
    @Test(enabled = false)
    public void followerHeaderValueTest() {
        this.tweetAPIClient.followerHeaderValue();
    }

    //21
    @Test(enabled = false)
    public void followerBodyValue() {
        this.tweetAPIClient.followerBodyValue();
    }

    //22
    @Test(enabled = false)
    public void deleteTweetValidedTest() {

        String tweet = "We can do anything";
        ValidatableResponse deleteResponse = this.tweetAPIClient.deleteTweet(1332560319156285445l);
        deleteResponse.statusCode(200);
        String actualTweet = deleteResponse.extract().body().path("text");
        Assert.assertEquals(tweet, actualTweet);
    }

    //23
    @Test(enabled = false)
    public void getTRENDSTweetTesst() {
        ValidatableResponse response = this.tweetAPIClient.getTRENDSTweet();
        System.out.println(response.extract().body().asPrettyString());
    }

    //24
    @Test(enabled = false)
    public void getGeoTweettTesst() {
        ValidatableResponse response = this.tweetAPIClient.getGeoTweet();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(400);

    }

    //25
    @Test(enabled = false)
    public void createFavoritesTest() {
        String tweeterr = "I want to be success" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClient.createFavorites(tweeterr);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweeterr, "Tweet is not match");
    }

    //26
    @Test(enabled = false)
    public void favoritesDeleteTest() {
        String tweet = "I want to be success";
        ValidatableResponse deleteResponse = this.tweetAPIClient.favoritesDelete(1332577043377246208l);
        // deleteResponse.statusCode(200);
//        System.out.println(deleteResponse.extract().body().asPrettyString());
//        String actualTweet=deleteResponse.extract().body().path("text");
//        Assert.assertEquals(tweet,actualTweet);

    }

    //27
    @Test(enabled = false)
    public void getTrendsAvaliableTest() {
        ValidatableResponse response = tweetAPIClient.getTrendsAvaliable();
        System.out.println(response.extract().body().asPrettyString());
        String expectedMessage = "No status found with that ID.";
        response.statusCode(200);
    }

    //28
    @Test(enabled = false)
    public void userCanCreateMediaTweetTest() {
        String Mtweeterr = "Jastin biber new song hitted in the market" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClient.createMediaTweet(Mtweeterr);
        String expectedMessage = "Sorry, that page does not exist";
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualTweet, expectedMessage, "Tweet is not match");
    }

    //29
    @Test(enabled = false)
    public void getMediaTweetTest() {
        ValidatableResponse response = tweetAPIClient.getMediaTweet();
        System.out.println(response.extract().body().asPrettyString());
        // String expectedMessage="No status found with that ID.";
        // response.statusCode(200);
    }

    //30
    @Test(enabled = false)
    public void userCanCreateMediaSubTitleTest() {
        String Mtweeterr = "New JustinBiber son 2020" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClient.createMediaTweet(Mtweeterr);

        response.statusCode(404);
        String expectedMessage = "Sorry, that page does not exist";
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualTweet, expectedMessage, "Tweet is not match");
    }

    //31
    @Test(enabled = false)
    public void createMediaUploadTest() {
        String Mtweeterr = "Selina Gomos New song uploded" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClient.createMediaUpload(Mtweeterr);
        response.statusCode(404);
        String expectedMessage = "Sorry, that page does not exist";
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualTweet, expectedMessage, "Tweet is not match");
    }

    //32
    @Test(enabled = false)
    public void createCollectionLsstTest() {
        String Mtweeterr = "Post collection" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClient.createCollectionLsst(Mtweeterr);
        response.statusCode(400);
        String expectedMessage = "Bad request.";
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualTweet, expectedMessage, "Tweet is not match");
    }

    //33
    @Test(enabled = false)
    public void getcollectionsTweetTest() {
        ValidatableResponse response = this.tweetAPIClient.getcollectionsTweet();
        response.statusCode(400);
        String expectedMessage = "Bad request.";
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualTweet, expectedMessage, "Tweet is not match");
    }

    //34
    @Test(enabled = false)
    public void collectionHeaderValueTest() {
        this.tweetAPIClient.collectionHeaderValue();
    }

    //35
    @Test(enabled = false)
    public void collectionBodyValueTest() {
        this.tweetAPIClient.collectionBodyValue();
    }

    //36
    @Test(enabled = false)
    public void getUserUploadLookUpTest() {
        ValidatableResponse response = this.tweetAPIClient.getUserUploadLookUp();
        response.statusCode(404);
        String expectedMessage = "Sorry, that page does not exist";
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualTweet, expectedMessage, "Tweet is not match");
    }

    //37
    @Test(enabled = false)
    public void getUserUserShowTweetTest() {
        ValidatableResponse response = this.tweetAPIClient.getUserUserShowTweet();
        response.statusCode(404);
        String expectedMessage = "User not found.";
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualTweet, expectedMessage, "Tweet is not match");
    }

    //38
    @Test(enabled = false)
    public void createFriendShipTweetTest() {
        String Mtweeterr = "A best friend is a more than property " + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClient.createFriendShipTweet(Mtweeterr);
        response.statusCode(400);
        String expectedMessage = "Cannot find specified user.";
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualTweet, expectedMessage, "Tweet is not match");
    }

    //39
    @Test(enabled = true)
    public void deleteFriendShipTweetTest() {
        String tweet = "We can do anything";
        ValidatableResponse deleteResponse = this.tweetAPIClient.deleteFriendShipTweet(tweet);
    }

}































