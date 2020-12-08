package tweet;

import base.RestAPI;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.given;

public class TweetAPIClientHelen extends RestAPI {

    private final String CREATE_TWEET_ENDPOINT="/statuses/update.json";
    private final String DELETE_TWEET_ENDPOINT="/statuses/destroy.json";
    private final String GET_USER_TWEET_ENDPOINT="/statuses/home_timeline.json";
    private final String GET_WELCOME_MESSAGE_ENDPOINT="/direct_messages/welcome_messages/list.json";
    private final String WELCOME_MESSAGE_ENDPOINT="/direct_messages/welcome_messages/new.json";



    public ValidatableResponse getuserTimeTweet(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken, this.accessTokenSecret).when()
                .get(this.baseUrl+this.GET_USER_TWEET_ENDPOINT)
                .then();
    }
    public ValidatableResponse createTweet(String tweet){
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .param("status",tweet)
                .when().post(this.baseUrl+this.CREATE_TWEET_ENDPOINT)
                .then();

    }

    public ValidatableResponse deleteTweet(Long tweetId){
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .queryParam("id",tweetId)
                .when().post(this.baseUrl+this.DELETE_TWEET_ENDPOINT)
                .then();
    }
    public ValidatableResponse deleteTweet1(Long tweetId1){
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .queryParam("id",tweetId1)
                .when().post(this.baseUrl+this.DELETE_TWEET_ENDPOINT)
                .then();
    }
    public ValidatableResponse deleteTweet2(Long tweetId2) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", tweetId2)
                .when().post(this.baseUrl + this.GET_USER_TWEET_ENDPOINT)
                .then();
    }
    public ValidatableResponse deleteTweet3(Long tweetId3){
            return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                    .queryParam("id",tweetId3)
                    .when().post(this.baseUrl+this.GET_USER_TWEET_ENDPOINT)
                    .then();
    }
    public ValidatableResponse responseTime(){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_TWEET_ENDPOINT)
                .timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_TWEET_ENDPOINT)
                .then();

    }
    public void headerValue(){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_TWEET_ENDPOINT)
                .then().extract().headers());
    }
    public ValidatableResponse getWelcomeMessage(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.CREATE_TWEET_ENDPOINT)
                .then().log().all();
    }
}