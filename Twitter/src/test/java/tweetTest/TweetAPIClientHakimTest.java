package tweetTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tweet.TweetAPIClientHakim;
import static base.RestAPI.*;

import java.util.UUID;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class TweetAPIClientHakimTest extends TweetAPIClientHakim {


    private TweetAPIClientHakim tweetAPIClient;

    @BeforeClass
    public void setUpTweetAPI() {
        this.tweetAPIClient = new TweetAPIClientHakim();
    }


    @Test(enabled = false)
    public void testUserCanTweetSuccessfully() {
        String message = "hello there !! if you are interested to learn API testing I'll be here to help !" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClient.createTweet(message);
        response.statusCode(200);
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(actualTweet, message, "Tweet is not match");
    }

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
        String expectedMessage="Status is a duplicate.";
        String actualMessage=response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualMessage,expectedMessage,"Message not match");
        Assert.assertNotSame("200",403);
    }

    @Test
    public void testDelete(){
        String tweet = "We are learning Rest API Automation with WeekdaysEvening_Selenium_NY_Summer2020";
        ValidatableResponse deleteResponse =this.tweetAPIClient.deleteTweet(1329235246051713024l);
        deleteResponse.statusCode(200);
        String actualTweet=deleteResponse.extract().body().path("text");
        Assert.assertEquals(tweet,actualTweet);

    }


    @Test(enabled = false)
    public void testResponseTime() {
        ValidatableResponse response = this.tweetAPIClient.responseTime();
    }
    @Test(enabled = false)
    public void testHeaderValue() {
        this.tweetAPIClient.headerValue();
    }

    @Test(enabled = false)
    public void testPropertyFromResponse() {
        //1. User send a tweet
        String tweet = "We are learning Rest API Automation with WeekdaysEvening_Selenium_NY_Summer2020" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClient.createTweet(tweet);
        //2. Verify that the tweet was successful
        // response.statusCode(200);

        //this.tweetAPIClient.checkProperty();
        //JsonPath pathEvaluator=response.;
        //System.out.println(response.extract().body().asPrettyString());
        System.out.println(response.extract().body().asPrettyString().contains("id"));

        //String actualTweet = response.extract().body().path("text");
        //Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }
























    @Test
    public void test_1() {
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[0]", equalTo(7));
    }
@Test
    public void test_2() {

        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[1]", equalTo(8))
                .log().all();
    }

    @Test
    public void test_3() {
        given()
                .param("Key", "values")
                .header("key", "value")
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .log().all()
                .body("data.first_name", hasItems("Michael","Lindsay"));
    }


    @Test(dataProvider = "DataForPost")
    public void test_post(String firstName, String lastName, int subjectId) {
        org.json.simple.JSONObject request = new JSONObject();
        request.put("firstName",firstName);
        request.put("lastName",lastName);
        request.put("subjectId", subjectId);
        baseURI = "http://localhost:3000/";
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
               // header("Content-Type", "application/json").
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).
                log().all();
    }

    @Test
    public void test_get() {

        baseURI = "http://localhost:3000/";
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                when().
                get("/users").
                then().
                statusCode(200).
                log().all();

    }






}






