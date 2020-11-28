package tweet;

import base.RestAPI;
import io.restassured.http.ContentType;
import io.restassured.internal.util.IOUtils;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class TweetAPIClientShaila extends RestAPI {


    private final String CREATE_TWEET_ENDPOINT = "/statuses/update.json";
    private final String DELETE_TWEET_ENDPOINT = "/statuses/destroy.json";
    private final String CREATE_RETWEET_ENDPOINT = "/statuses/retweet/";
    private final String GET_USER_TWEET_ENDPOINT = "/statuses/home_timeline.json";
    private final String GET_STATUSES_ID_ENDPOINT = "/statuses/show.json";
    private final String FAVORITES_CREATE_ENDPOINT = "/favorites/create.json";
    private final String DELETE_FAVORITES_ENDPOINT = "/favorites/destroy.json";
    private final String GET_RETWEETERS_ENDPOINT = "/retweeters/ids.json";
    private final String JSON = ".json";
    private final String GET_FILTERED_STATUS_ENDPOINT = "/statuses/filter.json";
    private final String CREATE_MESSAGE_ENDPOINT = "/direct_messages/events/new.json";
    private final String GET_FOLLOWERS_LIST = "/followers/list.json";
    private final String CREATE_MEDIA_ENDPOINT = "/media/upload.json";
    private final String GET_PROFILE_BANNER = "/users/profile_banner.json";
    private final String CREATE_COLLECTION_ENDPOINT = "/collections/create.json";
    private final String GET_TRENDS_ENDPOINT = "/trends/place.json";
    private final String CREATE_FRIENDSHIPS_ENDPOINT = "/friendships/create.json";


    public ValidatableResponse getStatusRetweeters(Long id) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("id", id)
                .when().get(this.baseUrl + this.GET_RETWEETERS_ENDPOINT)
                .then();
    }


    public ValidatableResponse postRetweet(String id) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().post(this.baseUrl + this.CREATE_RETWEET_ENDPOINT + id + JSON)
                .then();
    }


    public ValidatableResponse getUserTimeTweet() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_USER_TWEET_ENDPOINT)
                .then();
    }


    public ValidatableResponse postFavoritesOrCreate(Long id) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("id", id)
                .when().post(this.baseUrl + this.FAVORITES_CREATE_ENDPOINT)
                .then();
    }

    public ValidatableResponse deleteFavorites(Long id) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", id)
                .when().post(this.baseUrl + this.DELETE_FAVORITES_ENDPOINT)
                .then();
    }


    // Delete a tweet from users twitter
    public ValidatableResponse deleteTweet(Long tweetId) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("id", tweetId)
                .when().post(this.baseUrl + this.DELETE_TWEET_ENDPOINT)
                .then();
    }


    public ValidatableResponse getStatusesWithID(long id) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("id", id)
                .when().get(this.baseUrl + this.GET_USER_TWEET_ENDPOINT)
                .then();
    }


    public ValidatableResponse createTweet(String tweet) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", tweet)
                .when().post(this.baseUrl + this.CREATE_TWEET_ENDPOINT)
                .then();
    }


    // Response Time check
    public ValidatableResponse responseTime() {
        System.out.println(given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_USER_TWEET_ENDPOINT)
                .timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_USER_TWEET_ENDPOINT)
                .then();

    }

    public Object createJson() {
        JSONObject j = new JSONObject();
        j.put("type", "message_create");
        j.put("message_create.target.recipient_id", "50022611");
        j.put("message_create.message_data", "hey whats up");
        return j;
    }

    public ValidatableResponse messageCreate(String payload) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                //.accept(ContentType.JSON)
                .header("content-type", "application/json")
                //.contentType(ContentType.JSON)
                .body(payload)
                .when().post(this.baseUrl + this.CREATE_MESSAGE_ENDPOINT)
                .then();
    }


    public ValidatableResponse getFollowersList(Long id) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("id", id)
                .when().get(this.baseUrl + this.GET_FOLLOWERS_LIST)
                .then();
    }


    public ValidatableResponse uploadImage(String base64) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("media", base64)
                .when().post(this.uploadBase + this.CREATE_MEDIA_ENDPOINT)
                .then();
    }

    public ValidatableResponse getProfileBanner(Long id) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("user_id", id)
                .when().get(this.uploadBase + this.GET_PROFILE_BANNER)
                .then();
    }

    public ValidatableResponse createCollectionOfTweets() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("name", "Collection")
                .when().post(this.uploadBase + this.CREATE_COLLECTION_ENDPOINT)
                .then();
    }

    public ValidatableResponse getTrendsLocation() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                //.param("id",id)
                .when().get(this.uploadBase + this.GET_TRENDS_ENDPOINT)
                .then();
    }


    public ValidatableResponse createFriendship() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                //.param("user_id",userId)
                .when().post(this.uploadBase + this.CREATE_FRIENDSHIPS_ENDPOINT)
                .then();
    }





}
