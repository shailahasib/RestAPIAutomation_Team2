package tweetTest;

import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sadiawelcom.WelcomeMessageSadia;
import tweet.BaseUpload;
import tweet.TweetAPIClient;
import tweet.UploadImage;

import java.io.FileNotFoundException;
import java.util.UUID;

public class TweetAPIClientTest {

    private TweetAPIClient tweetAPIClient;
    private TweetAPIClient tweetAPIClientSadia;


    @BeforeClass
    public void setUpTweetAPI() {
        this.tweetAPIClient = new TweetAPIClient();
    }


    @Test(enabled = true)
    public void testUserTweetSuccessfully() {
        String tweet = "We are learning Rest API Automation with fall Team2" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClient.createTweet(tweet);
        response.statusCode(200);
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }

    @Test(enabled = true)
    public void testUserCanNotTweetTheSameTweetTwiceInARow() {
        String tweet = "We are learning Rest API Automation with Mahmud " + UUID.randomUUID().toString();
        ;
        ValidatableResponse response = this.tweetAPIClient.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
        response = this.tweetAPIClient.createTweet(tweet);
        response.statusCode(403);
        System.out.println(response.extract().body().asPrettyString());
        String expectedMessage = "Status is a duplicate.";
        String actualMessage = response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualMessage, expectedMessage, "Message not match");
        Assert.assertNotSame("200", 403);
    }

    @Test
    public void testDelete() {
        String tweet = "Tweet with Team 2";
        ValidatableResponse deleteResponse = this.tweetAPIClient.deleteTweet(1329235246051713024l);
        deleteResponse.statusCode(200);
        String actualTweet = deleteResponse.extract().body().path("text");
        Assert.assertEquals(tweet, actualTweet);

    }


    @Test
    public void testResponseTime() {
        ValidatableResponse response = this.tweetAPIClient.responseTime();
    }

    @Test
    public void testHeaderValue() {
        this.tweetAPIClient.headerValue();
    }

    @Test
    public void testPropertyFromResponse() {
        String tweet = "Hello everyone" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClient.createTweet(tweet);
        System.out.println(response.extract().body().asPrettyString().contains("id"));
    }

    @Test
    public void testPostStatus() {
        this.tweetAPIClient.postStatus("forever sadia");
    }

    @Test
    public void testDeleteStatus() {
        this.tweetAPIClient.deleteStatus("1335675369614176256");
    }

    @Test
    public void testGetStatus() {
        this.tweetAPIClient.getStatues("1335682007179943939");
    }

    @Test
    public void testStatusLookup() {
        ValidatableResponse response = this.tweetAPIClient.getStatuesLookup("1335700614647590913");
    }

    @Test
    public void testPostSRetweet() {
        this.tweetAPIClient.postStatuesRetweet("1335707850207846401");
    }

    @Test
    public void testPostUnRetweetRetweet() {
        this.tweetAPIClient.postUnRetweet("1335719289152802819");
    }

    @Test
    public void testGetRetweet() {
        this.tweetAPIClient.getStatusRetweet("1335723341894868995");
    }

    @Test
    public void testGetRetweetOfMe() {
        this.tweetAPIClient.getStatusRetweetOfMe("1335723341894868995");
    }

    @Test
    public void testCreateFavorite() {
        this.tweetAPIClient.postCreateFavorite("1335735408479662080");
    }

    @Test
    public void testFavoriteDelete() {
        this.tweetAPIClient.postDeleteFavorite("1335735408479662080");
    }

    @Test
    public void testFavoriteList() {
        this.tweetAPIClient.getFavoriteLists("1335735408479662080");
    }

    @Test
    public void testPostStatues() {
        this.tweetAPIClient.postStatuesUpdate("how are you?");
    }

    @Test
    public void testTimeLine() {
        ValidatableResponse response = this.tweetAPIClient.getStatuesHome("");
    }

    @Test
    public void testGetMentionsTimeLine() {
        ValidatableResponse response = this.tweetAPIClient.getStatuesMentions();
    }

    @Test
    public void testGetUserTimeLine() {
        ValidatableResponse response = this.tweetAPIClient.getStatuesUserTimeLine();
    }

    @Test
    public void testStatusFilter() {
        ValidatableResponse response = this.tweetAPIClient.getFilter();
    }

    @Test
    public void testStatusSimple() {
        ValidatableResponse response = this.tweetAPIClient.getStatuesSimple();
    }

    @Test
    public void testCollectionEntries() {
        ValidatableResponse response = this.tweetAPIClient.getCollectionsEntries("");
    }

    @Test
    public void testCreateMessage() throws FileNotFoundException {
        ValidatableResponse response = this.tweetAPIClient.createMessage();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test
    public void testCreateSecondMessage() throws FileNotFoundException {
        ValidatableResponse response = this.tweetAPIClient.createSecondMessage();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test
    public void testAccountSetting() {
        ValidatableResponse response = this.tweetAPIClient.getAccountSetting();
        response.statusCode(200);
    }

    @Test
    public void testAccountVerify() {
        ValidatableResponse response = this.tweetAPIClient.getAccountVerifyCredentials();
        response.statusCode(200);
    }

    @Test
    public void testUserBanner() {
        long userId = 6253282;
        ValidatableResponse response = this.tweetAPIClient.getUsersProfileBanner(userId);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test
    public void testAccountRemove() {
        ValidatableResponse response = this.tweetAPIClient.postRemoveAccount();
        response.statusCode(200);
    }

    @Test
    public void testAccountSettings() {
        ValidatableResponse response = this.tweetAPIClient.postAccountSetting();
        response.statusCode(200);
    }

    @Test
    public void testAccountUpdateProfile() {
        ValidatableResponse response = this.tweetAPIClient.postAccountUpdateProfile();
        response.statusCode(200);
    }

    @Test
    public void testSaveSearchesLists() {
        ValidatableResponse response = this.tweetAPIClient.postSavedSearchesList();
        response.statusCode(200);
    }

    @Test
    public void testSaveSearchesListsShow() {
        ValidatableResponse response = this.tweetAPIClient.postSavedSearch("I love sandwiches");
        response.statusCode(200);
    }

    @Test
    public void testSaveSearchesDelete() {
        ValidatableResponse response = this.tweetAPIClient.postSavedSearchesDelete("1335828230096510977");
        response.statusCode(200);
    }

    @Test
    public void testUploadProfileImage() {
        ValidatableResponse response = this.tweetAPIClient.uploadProfileImage(BaseUpload.cuteBalloons());
        response.statusCode(200);
    }

    @Test
    public void testImageUpload() {
        ValidatableResponse response = this.tweetAPIClient.uploadPostImage(UploadImage.prettyBeord());
        response.assertThat().statusCode(200);
        System.out.println(response.extract().body().asPrettyString());

    }

    @Test
    public void testWelcomeMessage() throws FileNotFoundException {
        ValidatableResponse response = this.tweetAPIClient.createWelcomeMessage(WelcomeMessageSadia.postWelcomeMessage(), WelcomeMessageSadia.flowerImage());
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

}
