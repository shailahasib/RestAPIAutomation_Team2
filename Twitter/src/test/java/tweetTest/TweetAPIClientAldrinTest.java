package tweetTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import payload.aldrinsPayloadFiles;
import payload.copyOfAldrinsPayload;
import tweet.TweetAPIClientAldrin;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class TweetAPIClientAldrinTest {

    private TweetAPIClientAldrin tweetAPIClientAldrin;

    @BeforeClass
    public void setUpTweetAPI() throws FileNotFoundException {
        this.tweetAPIClientAldrin = new TweetAPIClientAldrin();
    }

    @Test
    public void testUserCanGetStatus() {
        long id = 1333250857756893185L;
        ValidatableResponse response = this.tweetAPIClientAldrin.getStatusesWithID(id);
        response.statusCode(200);

    }

    @DataProvider(name = "TweetsToPost")
    public Object[] getTweetData() {
        return new Object[]{
                "The exact number of grain of sands are: \n",
                "Trump Lost, get over it. \n",
                "If you didn't know what to do, don't start before you learn. \n",
                "Coding is usually not boring. \n",
                "It is required to be an assh#t sometimes. \n",
                "If I am being honest, I am not sleepy at all. \n"
        };
    }
    @Test (dataProvider = "TweetsToPost" )
    public void testPostingTweets(String tweet) throws InterruptedException {
        ValidatableResponse response = this.tweetAPIClientAldrin.createTweet(tweet+UUID.randomUUID().toString());
        response.log().all().statusCode(200);
        String postedTweet = response.extract().body().path("text");

        System.out.println("The posted tweet is: \n" + postedTweet);



        String postedTweetID = response.extract().body().path("id_str");
        ValidatableResponse deleteResponse = this.tweetAPIClientAldrin.deleteTweet(postedTweetID);
        int statusCodeDeleted = response.extract().statusCode();
        System.out.println("Status code is: " + statusCodeDeleted);
    }


    @Test
    public void testDeletePostedTweet() {
        String id = "1333248449744162816";
        ValidatableResponse deleteResponse = this.tweetAPIClientAldrin.deleteTweet(id);
        deleteResponse.statusCode(200);
    }


    @Test
    public void testRetweetById() {
        String id = "1333155246068084737";
        ValidatableResponse response = this.tweetAPIClientAldrin.getStatusRetweeters(id);
        response.statusCode(200);
        int statusCodeDeleted = response.extract().statusCode();
        System.out.println("Status code is: " + statusCodeDeleted);

    }

    @Test
    public void testRetweet() {
        String id = "1333155246068084737";
        ValidatableResponse response = this.tweetAPIClientAldrin.postRetweet(id);
        response.statusCode(200);
    }

    @DataProvider(name = "TwitterHandles")
    public Object[] getData() {
        return new Object[]{
                "Astro_Soichi",
                "Software%20Automation",
                "AOC",
                "elonmusk",
                "nytimes",
                "JoeBiden"
        };
    }

    @Test(dataProvider = "TwitterHandles")
    public void testShowRecentTweetsOfID(String handleID) {
        String searchQuery = "?q=" + handleID + "&result_type=recent";
        ValidatableResponse response = this.tweetAPIClientAldrin.searchTweetsOfID(searchQuery);
        response.log().all().statusCode(200);
    }

    @Test
    public void testRemoveRetweet() {
        String id = "1332788670471036932";
        ValidatableResponse response = this.tweetAPIClientAldrin.removeRetweet(id);
        response.statusCode(200);
    }

    @Test (enabled = false)
    public void testLikeATweet() {
        Long id = 1332057147614531585L;
        ValidatableResponse response = this.tweetAPIClientAldrin.likeATweet(id);
        response.statusCode(200);
    }

    @Test (enabled = false)
    public void testUnlikeATweet() {
        Long id = 1332057147614531585L;
        ValidatableResponse response = this.tweetAPIClientAldrin.unlikeATweet(id);
        response.statusCode(200);
    }

    @Test
    public void testResponseTime() {
        ValidatableResponse response = this.tweetAPIClientAldrin.responseTime();
        response.extract().statusCode();
        response.statusCode(200);
    }

    @Test
    public void testResponseTimeForCreatingTweet() {
        String tweet = "Testing response time again" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClientAldrin.responseTimeForCreateTweet(tweet);
        response.statusCode(200);
    }

    @Test
    public void testRemoveDM() {
        Long id = 1333211166915571715L;
        ValidatableResponse deleteResponse = this.tweetAPIClientAldrin.deleteMessageUsingId(id);
        deleteResponse.statusCode(200);
    }

    @Test
    public void testGetSavedSearches() {
        ValidatableResponse response = this.tweetAPIClientAldrin.getSavedSearches();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test
    public void testChangeProfilePicture() throws IOException {
        String proPic = new String(Files.readAllBytes((Paths.get("assetsRepo/base64/weddingPortrait.txt"))));
        ValidatableResponse response = this.tweetAPIClientAldrin.uploadProPic(proPic);

        response.statusCode(200);
        System.out.println("Here's the log in brief! "+response.extract().body().asPrettyString());

    }

    @Test
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

    @Test
    public void testGetProfileBanner() {
        long userId = 500226111;
        ValidatableResponse response = this.tweetAPIClientAldrin.getProfileBanner(userId);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test
    public void testCreateCollection() {
        ValidatableResponse response = this.tweetAPIClientAldrin.createCollectionOfTweets();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());

    }

    @Test
    public void testGetTrends() {
        Long id = 2347591l;
        ValidatableResponse response = this.tweetAPIClientAldrin.getTrendsLocation();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }


    @Test
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
        ValidatableResponse response = this.tweetAPIClientAldrin.createWelcomeMessage(aldrinsPayloadFiles.cuteBaby(), aldrinsPayloadFiles.workIsHard());
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test
    public void testCreateList() {
        ValidatableResponse response = this.tweetAPIClientAldrin.createList();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }


}
