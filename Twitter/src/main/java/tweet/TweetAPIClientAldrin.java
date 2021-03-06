package tweet;

import base.RestAPI;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class TweetAPIClientAldrin extends RestAPI {


    private final String POST_TWEET_EP = "/statuses/update.json";
    private final String REMOVE_TWEET_EP = "/statuses/destroy.json";
    private final String RETWEET_EP = "/statuses/retweet/";
    private final String UNRETWEET_EP = "/statuses/unretweet/";
    private final String GET_POSTED_TWEETS_EP = "/statuses/home_timeline.json";
    private final String GET_STATUSES_ID_ENDPOINT = "/statuses/show.json";
    private final String LIKE_A_TWEET = "/favorites/create.json";
    private final String UNLIKE_A_TWEET = "/favorites/destroy.json";
    private final String RETWEET_IDs_EP = "/retweeters/ids.json";
    private final String JSON = ".json";
    private final String FILTER_STATUSES_EP = "/statuses/filter.json";
    private final String SEND_MESSAGE_EP = "/direct_messages/events/new.json";
    private final String LIST_FOLLOWERS_EP = "/followers/list.json";
    private final String CREATE_MEDIA_ENDPOINT = "/media/upload.json";
    private final String GET_PROFILE_BANNER = "/users/profile_banner.json";
    private final String COLLECTION_EP = "/collections/create.json";
    private final String GET_TRENDS_ENDPOINT = "/trends/place.json";
    private final String CREATE_FRIENDSHIPS_ENDPOINT = "/friendships/create.json";
    private final String GET_SAVED_SEARCHES_ENDPOINT = "/saved_searches/list.json";
    private final String FOLLOW_USER_EP = "/friendships/show.json";
    private final String DELETE_MESSAGE_EP = "/direct_messages/events/destroy.json";
    private final String CHAT_WELCOME_MG_EP = "/direct_messages/welcome_messages/new.json";
    private final String CREATE_LIST_ENDPOINT = "/lists/create.json";
    private final String SEARCH_STANDARD_EP = "/search/tweets.json";
    private final String CHANGE_PROFILE_PIC_EP = "/account/update_profile_image.json";

    String jsonPath = "Twitter/jsonFileInput/jsonMessage.json";


    public ValidatableResponse getStatusRetweeters(String id) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("id_str", id)
                .when().get(this.baseUrl + this.RETWEET_IDs_EP)
                .then();
    }

    public ValidatableResponse searchTweetsOfID(String searchQuery) {
        return given().log().all().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.SEARCH_STANDARD_EP + searchQuery)
                .then();
    }

    public ValidatableResponse postRetweet(String id) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().post(this.baseUrl + this.RETWEET_EP + id + JSON)
                .then();
    }

    public ValidatableResponse removeRetweet(String id) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().post(this.baseUrl + this.RETWEET_EP + id + JSON)
                .then();
    }


    public ValidatableResponse getUserTimeTweet() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_POSTED_TWEETS_EP)
                .then();
    }


    public ValidatableResponse likeATweet(Long id) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("id", id)
                .when().post(this.baseUrl + this.LIKE_A_TWEET)
                .then();
    }

    public ValidatableResponse unlikeATweet(Long id) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", id)
                .when().post(this.baseUrl + this.UNLIKE_A_TWEET)
                .then();
    }



    public ValidatableResponse deleteTweet(String tweetId) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("id_str", tweetId)
                .when().post(this.baseUrl + this.REMOVE_TWEET_EP)
                .then();
    }


    public ValidatableResponse getStatusesWithID(long id) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("id", id)
                .when().get(this.baseUrl + this.GET_POSTED_TWEETS_EP)
                .then();
    }


    public ValidatableResponse createTweet(String tweet) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", tweet)
                .when()
                .post(this.baseUrl + this.POST_TWEET_EP)
                .then();
    }

    public ValidatableResponse responseTime() {
        System.out.println(given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_POSTED_TWEETS_EP)
                .timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_POSTED_TWEETS_EP)
                .then();

    }

    public ValidatableResponse responseTimeForCreateTweet(String tweet) {
        System.out.println(given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.POST_TWEET_EP)
                .timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", tweet)
                .when().post(this.baseUrl + this.POST_TWEET_EP)
                .then();
    }

    public Object createJson() {
        JSONObject j = new JSONObject();
        j.put("type", "message_create");
        j.put("message_create.target.recipient_id", "50022611");
        j.put("message_create.message_data", "hey whats up");
        return j;
    }

    public ValidatableResponse createWelcomeMessage() throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream("../Twitter/jsonFileInput/welcomeMessage.json");

        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .log().all()
                .accept(ContentType.JSON)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(inputStream)
                .when().post(this.baseUrl + this.CHAT_WELCOME_MG_EP)
                .then();
    }
    public ValidatableResponse sendDMwithTextFile() throws IOException {
        String proPic = new String(Files.readAllBytes((Paths.get("assetsRepo/base64/weddingPortrait.txt"))));
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
//                .accept(ContentType.JSON)
                .header("Content-Type", "application/json")
//                .contentType(ContentType.JSON)
                .body(proPic)
                .when().post(this.baseUrl + this.SEND_MESSAGE_EP)
                .then();
    }

    public ValidatableResponse messageCreateSecond() throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream("../Twitter/jsonFileInput/jsonMessage.json");
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .accept(ContentType.JSON)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(inputStream)
                .when().post(this.baseUrl + this.SEND_MESSAGE_EP)
                .then();
    }


    public ValidatableResponse getFollowersList(Long id) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("id", id)
                .when().get(this.baseUrl + this.LIST_FOLLOWERS_EP)
                .then();
    }

    public ValidatableResponse deleteMessageUsingId(Long id) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("id", id)
                .when().post(this.baseUrl + this.DELETE_MESSAGE_EP)
                .then();
    }


    public ValidatableResponse uploadImage(String base64) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("media", base64)
                .param("shared", "1")
                .when().post(this.uploadBase + this.CREATE_MEDIA_ENDPOINT)
                .then().log().all();
    }

    public ValidatableResponse uploadImageFlower(String base64) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("media", base64)
                .param("shared", "true")
                .when().post(this.uploadBase + this.CREATE_MEDIA_ENDPOINT)
                .then().log().all();
    }

    public ValidatableResponse getProfileBanner(Long id) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("user_id", id)
                .when().get(this.baseUrl + this.GET_PROFILE_BANNER)
                .then();
    }

    public ValidatableResponse createCollectionOfTweets() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("name", "Collection")
                .when().post(this.baseUrl + this.COLLECTION_EP)
                .then();
    }

    public ValidatableResponse getTrendsLocation() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_TRENDS_ENDPOINT)
                .then();
    }


    public ValidatableResponse followId() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().post(this.baseUrl + this.CREATE_FRIENDSHIPS_ENDPOINT)
                .then();
    }

    public ValidatableResponse getMentionsTimeline() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)

                .when().post(this.baseUrl + this.CREATE_FRIENDSHIPS_ENDPOINT)
                .then();
    }

    public ValidatableResponse getSavedSearches() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().post(this.baseUrl + this.GET_SAVED_SEARCHES_ENDPOINT)
                .then();
    }


    public ValidatableResponse getFriendships(String paramUserHandle, String paramFriendHandle) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("source_screen_name", paramUserHandle).param("target_screen_name", paramFriendHandle)
                .when().post(this.baseUrl + this.FOLLOW_USER_EP)
                .then();
    }

    public ValidatableResponse createMediaUpload() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("commands", "INIT")
                .when().post(this.uploadBase + this.FOLLOW_USER_EP)
                .then();
    }

    public ValidatableResponse createList() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("name", "PowerRangers")
                .param("mode", "public")
                .param("description", "Forever21")
                .when().post(this.baseUrl + this.CREATE_LIST_ENDPOINT)
                .then().log().all();
    }


    public ValidatableResponse dmGivenID() throws FileNotFoundException {
        FileInputStream jsonMessage = new FileInputStream("../Twitter/jsonFileInput/jsonMessage.json");
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .accept(ContentType.JSON)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(jsonMessage)
                .when().post(this.baseUrl + this.SEND_MESSAGE_EP)
                .then().log().all();
  }

public ValidatableResponse uploadProPic(String impageBase64){
    return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("image",impageBase64)
            .when().post(this.baseUrl+this.CHANGE_PROFILE_PIC_EP)
            .then().log().all();

}
}