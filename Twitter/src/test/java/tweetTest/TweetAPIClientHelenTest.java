package tweetTest;

import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tweet.TweetAPIClientHelen;

import java.util.UUID;

public class TweetAPIClientHelenTest {
    private TweetAPIClientHelen tweetAPIClientHelen;

    @BeforeClass
    public void setUpTweetAPI() {
        this.tweetAPIClientHelen = new TweetAPIClientHelen();
    }

    @Test
    public void testTweetPost() {
        String tweet = "Hello World" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testTweetpost1() {
        String tweet = "Helen Konjo" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testTweetPost2() {
        String tweet = "Bella Bella Bella" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }

    @Test
    public void testTweetPost3() {
        String tweet = "THis is fun" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testTweetPost4() {
        String tweet = "Bella Gabby Bella" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testTweetPost5() {
        String tweet = "I love my daughters" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testTweetPost6() {
        String tweet = "I love my family" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testTweetPost7() {
        String tweet = "I need more time for this bootCamp" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testTweetPost8() {
        String tweet = "I need more time for this time management classes" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testUserCanNotTweetTheSameTweetTwiceInARow() {
        String tweet = "I will finish this BootCamp?";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
        response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(403);
        System.out.println(response.extract().body().asPrettyString());
        String expectedMessage="Status is a duplicate.";
        String actualMessage=response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualMessage,expectedMessage,"Message not match");
        Assert.assertNotSame("200",403);
    }
    @Test
    public void testTweetPost9() {
        String tweet = "Let's see if this works";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testUserCanNotTweetTheSameTweetTwiceInA1ow2() {
        String tweet = "I learn so much";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
        response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(403);
        System.out.println(response.extract().body().asPrettyString());
        String expectedMessage="Status is a duplicate.";
        String actualMessage=response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualMessage,expectedMessage,"Message not match");
        Assert.assertNotSame("200",403);
    }
    @Test
    public void testTweetPost10() {
        String tweet = "This is my world and everyone is just an Actor in it";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testTweetPost11() {
        String tweet = "Ethiopia is on my mind";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testUserCanNotTweetTheSameTweetTwiceInARow2() {
        String tweet = "Job market here I come";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
        response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(403);
        System.out.println(response.extract().body().asPrettyString());
        String expectedMessage="Status is a duplicate.";
        String actualMessage=response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualMessage,expectedMessage,"Message not match");
        Assert.assertNotSame("200",403);
    }
    @Test
    public void testTweetPost12() {
        String tweet = "Gonder Gonder yene Teddy Hager";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testTweetPost13() {
        String tweet = "Who minus Who..lol!!";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testUserCanNotTweetTheSameTweetTwiceInARow3() {
        String tweet = "I am ready";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
        response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(403);
        System.out.println(response.extract().body().asPrettyString());
        String expectedMessage="Status is a duplicate.";
        String actualMessage=response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualMessage,expectedMessage,"Message not match");
        Assert.assertNotSame("200",403);
    }
    @Test
    public void testTweetPost14() {
        String tweet = "love is all around you";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testUserCanNotTweetTheSameTweetTwiceInARow4() {
        String tweet = "come and go";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
        response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(403);
        System.out.println(response.extract().body().asPrettyString());
        String expectedMessage="Status is a duplicate.";
        String actualMessage=response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualMessage,expectedMessage,"Message not match");
        Assert.assertNotSame("200",403);
    }

    @Test
    public void testTweetPost15() {
        String tweet = "I could do this all day";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testUserCanNotTweetTheSameTweetTwiceInARow5() {
        String tweet = "I done with API";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
        response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(403);
        System.out.println(response.extract().body().asPrettyString());
        String expectedMessage="Status is a duplicate.";
        String actualMessage=response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualMessage,expectedMessage,"Message not match");
        Assert.assertNotSame("200",403);
    }
    @Test
    public void testTweetPost16() {
        String tweet = "I have to get back to BDD";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testTweetPost17() {
        String tweet = "I'm expert on post tweets and images and deleting?";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testTweetPost18() {
        String tweet = "well well all that end well";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testTweetPost19() {
        String tweet = "IT it really not that difficult";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testTweetPost20() {
        String tweet = "Who's up for a game of UNO";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testTweetPost21() {
        String tweet = "Ethiopia lezelalem to neru";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testTweetPost22() {
        String tweet = "Being Ethiopian is the best thing ever";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testTweetPost23() {
        String tweet = "Technicially everyone is Ethiopian";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testTweetPost24() {
        String tweet = "Peace for Africa";
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
    @Test
    public void testDelete(){
        String tweet = "We can finish this BootCamp";
        ValidatableResponse deleteResponse =this.tweetAPIClientHelen.deleteTweet(1333333596086673408L);
        deleteResponse.statusCode(200);
        String actualTweet=deleteResponse.extract().body().path("text");
        Assert.assertEquals(tweet,actualTweet);

    }
    @Test
    public void testDelete1(){
        String tweet = "Helen Konjo449e8b5b-6b8f-4451-9eab-12db96203272";
        ValidatableResponse deleteResponse =this.tweetAPIClientHelen.deleteTweet1(1333334892940300289L);
        deleteResponse.statusCode(200);
        String actualTweet=deleteResponse.extract().body().path("text");
        Assert.assertEquals(tweet,actualTweet);
    }
    @Test
    public void testDelete2(){
        String tweet = "Bella Bella Bella";
        ValidatableResponse deleteResponse =this.tweetAPIClientHelen.deleteTweet2(1333333601723817984L);
        deleteResponse.statusCode(200);
        String actualTweet=deleteResponse.extract().body().path("text");
        Assert.assertEquals(tweet,actualTweet);

    }
    @Test
    public void testDelete3(){
        String tweet = "THis is fun";
        ValidatableResponse response= this.tweetAPIClientHelen.createTweet(tweet);
        ValidatableResponse deleteResponse =this.tweetAPIClientHelen.deleteTweet3(1333333603128905728L);
        deleteResponse.statusCode(200);
        String actualTweet=deleteResponse.extract().body().path("text");
        Assert.assertEquals(tweet,actualTweet);

    }
    @Test
    public void testResponseTime() {

        ValidatableResponse response = this.tweetAPIClientHelen.responseTime();
    }
    @Test
    public void testHeaderValue() {

        this.tweetAPIClientHelen.headerValue();
    }

    @Test
    public void testPropertyFromResponse() {
        //1. User send a tweet
        String tweet = "We are learning Rest API Automation for Team 2" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClientHelen.createTweet(tweet);
        System.out.println(response.extract().body().asPrettyString().contains("id"));
    }
    @Test
    public void testdownloadImage(){
        String tweetImage="https://twitter.com/Asipita6/status/1331578361093771265/photo/1";
        ValidatableResponse response= this.tweetAPIClientHelen.createTweet(tweetImage);
        System.out.println(response.extract().body().asPrettyString().contains("image"));
    }
    @Test
    public void testdownloadImage1(){
        String tweetImage="https://twitter.com/Veganometry101/status/1332040877921988609/photo/1";
        ValidatableResponse response= this.tweetAPIClientHelen.createTweet(tweetImage);
        System.out.println(response.extract().body().asPrettyString().contains("image"));
    }
    @Test
    public void testdownloadImage2(){
        String tweetImage="https://twitter.com/flyethiopian/status/1332221119051554819/photo/1";
        ValidatableResponse response= this.tweetAPIClientHelen.createTweet(tweetImage);
        System.out.println(response.extract().body().asPrettyString().contains("image"));
    }
    @Test
    public void testdownloadImage3(){
        String tweetImage="https://twitter.com/Yemi___Cole/status/1330928873505247234/photo/1";
        ValidatableResponse response= this.tweetAPIClientHelen.createTweet(tweetImage);
        System.out.println(response.extract().body().asPrettyString().contains("image"));
    }
    @Test
    public void testdownloadImage4(){
        String tweetImage="https://twitter.com/utopia_tour/status/936240010969407488/photo/1";
        ValidatableResponse response= this.tweetAPIClientHelen.createTweet(tweetImage);
        System.out.println(response.extract().body().asPrettyString().contains("image"));
    }
    @Test
    public void testdownloadImage5(){
        String tweetImage="https://twitter.com/Seblework3/status/1218902795006435329/photo/1";
        ValidatableResponse response= this.tweetAPIClientHelen.createTweet(tweetImage);
        System.out.println(response.extract().body().asPrettyString().contains("image"));
    }
    @Test
    public void testdownloadImage6(){
        String tweetImage="https://twitter.com/fisseha_tegegn/status/1073468725779681282/photo/1";
        ValidatableResponse response= this.tweetAPIClientHelen.createTweet(tweetImage);
        System.out.println(response.extract().body().asPrettyString().contains("image"));
    }
    @Test
    public void testdownloadImage7(){
        String tweetImage="https://twitter.com/DerilloEyob/status/1170067597720805381/photo/1";
        ValidatableResponse response= this.tweetAPIClientHelen.createTweet(tweetImage);
        System.out.println(response.extract().body().asPrettyString().contains("image"));
    }
    @Test
    public void testdownloadImage8(){
        String tweetImage="https://twitter.com/DerilloEyob/status/1170067597720805381/photo/2";
        ValidatableResponse response= this.tweetAPIClientHelen.createTweet(tweetImage);
        System.out.println(response.extract().body().asPrettyString().contains("image"));
    }
    @Test
    public void testdownloadImage9(){
        String tweetImage="https://twitter.com/tititeklu/status/1132806198976061440/photo/2";
        ValidatableResponse response= this.tweetAPIClientHelen.createTweet(tweetImage);
        System.out.println(response.extract().body().asPrettyString().contains("image"));
    }
    @Test
    public void testdownloadImage10(){
        String tweetImage="https://twitter.com/tititeklu/status/1132806198976061440/photo/4";
        ValidatableResponse response= this.tweetAPIClientHelen.createTweet(tweetImage);
        System.out.println(response.extract().body().asPrettyString().contains("image"));
    }

    @Test
    public void testWelcomeMessagelist(){
        ValidatableResponse response= this.tweetAPIClientHelen.getWelcomeMessage();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());

    }




    }















