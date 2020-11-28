package tweet;

import base.RestAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class TweetAPIClientRuna extends RestAPI {
    private final String CREATE_TWEET_ENDPOINT = "/statuses/update.json";
    private final String DELETE_TWEET_ENDPOINT = "/statuses/destroy.json";
    private final String GET_USER_TWEET_ENDPOINT = "/statuses/home_timeline.json";
    private final String CREATE_TWEETER_ENDPOINT = "/statuses/update.json";
    private final String DELETE_TWEETER_ENDPOINT = "/statuses/destroy/:id.json";
    private final String GET_USER_TWEETER_ENDPOINT = "/statuses/show.json";
    private final String CREATE_CollECTIONLIST_ENDPOINT = "/collections/create.json";
    private final String DELETE_CollECTIONLIST_ENDPOINT = "/collections/destroy.json";
    private final String GET_CollECTIONLIST_TWEETER_ENDPOINT = "/collections/list.json";
    private final String CREATE_DIRECT_MASSAGE_ENDPOINT = "/direct_messages/events/new.json";
    private final String GET_DIRECT_MASSAGE_ENDPOINT = "/direct_messages/events/list.json";
    private final String CREATE_DIRECT_MEDIA_ENDPOINT = "statuses/update_with_media.json";
    private final String GET_TRENDS_PLACE_ENDPOINT = "/trends/place.json";
    private final String GET_FoLLOWERLIST_ENDPOINT = "/followers/list.json";
    private final String CREATE_FoLLOWERLIST_ENDPOINT = "/friendships/create.json";
    private final String DELETE_FoLLOWERLIST_ENDPOINT = "/friendships/destroy.json";
    private final String GET_TRENDS_ENDPOINT = "/trends/available.json";
    private final String GET_GEO_ENDPOINT = "/geo/id/:place_id.json";
    private final String DELETE_FAVORITES_ENDPOINT = "/favorites/destroy.json";
    private final String GET_TRENDS_AVALIABLE_ENDPOINT = "/trends/available.json";
    private final String CREATE_MEDIA_ENDPOINT = "/media/upload.json";
    private final String GET_MEDIA_ENDPOINT = "/media/upload.json";
    private final String GET_MEDIA_SUBTITLE_ENDPOINT = "/media/subtitles/create.json";
    private final String POST_MEDIA_UPLOAD_SUBTITLE_ENDPOINT = "/media/upload.json";
    private final String POST_COLLECTIONS_CRETATE_ENDPOINT = "/collections/create.json";
    private final String GET_COLLECTIONS_ENDPOINT = "/users/lookup.json";
    private final String GET_USER_UPLOAD_LOOKUP_ENDPOINT = "/media/upload.json";
    private final String GET_USER_SHOW_ENDPOINT = "/users/show.json";
    private final String CREATE_FRIENDSHIPS_ENDPOINT = "/friendships/create.json";
    private final String DELETE_FRIENDSHIPS_ENDPOINT = "/friendships/destroy.json";


    public ValidatableResponse getUserTimeTweet() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_TRENDS_AVALIABLE_ENDPOINT)
                .then();
    }

    public ValidatableResponse getUserUploadLookUp() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_USER_UPLOAD_LOOKUP_ENDPOINT)
                .then();
    }

    public ValidatableResponse getUserUserShowTweet() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_USER_SHOW_ENDPOINT)
                .then();
    }

    public ValidatableResponse getTrendsAvaliable() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_TRENDS_AVALIABLE_ENDPOINT)
                .then();
    }

    public ValidatableResponse getTRENDSTweet() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_TRENDS_ENDPOINT)
                .then();
    }

    public ValidatableResponse getGeoTweet() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_GEO_ENDPOINT)
                .then();
    }

    public ValidatableResponse createTweet(String tweet) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", tweet)
                .when().post(this.baseUrl + this.CREATE_TWEET_ENDPOINT)
                .then();
    }

    public ValidatableResponse createFriendShipTweet(String tweet) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", tweet)
                .when().post(this.baseUrl + this.CREATE_FRIENDSHIPS_ENDPOINT)
                .then();
    }

    public ValidatableResponse deleteTweet(Long tweetId) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", tweetId)
                .when().post(this.baseUrl + this.DELETE_TWEET_ENDPOINT)
                .then();
    }

    public ValidatableResponse deleteFriendShipTweet(String tweet) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("message", tweet)
                .when().post(this.baseUrl + this.DELETE_FRIENDSHIPS_ENDPOINT)
                .then();
    }

    public ValidatableResponse getUserTimeFromTweter() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_USER_TWEETER_ENDPOINT)
                .then();
    }

    public ValidatableResponse createTweeter(String tweeter) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", tweeter)
                .when().post(this.baseUrl + this.CREATE_TWEETER_ENDPOINT)
                .then();
    }

    public ValidatableResponse userCanDeleFromTweet(Long tweetId) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", tweetId)
                .when().post(this.baseUrl + this.DELETE_TWEETER_ENDPOINT)
                .then();
    }

    public ValidatableResponse getUserFromCollectionList() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_CollECTIONLIST_TWEETER_ENDPOINT)
                .then();
    }

    public ValidatableResponse createUserCollection(String tweeto) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", tweeto)
                .when().post(this.baseUrl + this.CREATE_CollECTIONLIST_ENDPOINT)
                .then();
    }

    public ValidatableResponse userCanDeleFromCollectionList(String errors) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("errors", "message")
                .when().post(this.baseUrl + this.DELETE_CollECTIONLIST_ENDPOINT)
                .then();
    }

    public ValidatableResponse getUserDirectMessages() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_DIRECT_MASSAGE_ENDPOINT)
                .then();
    }

    public ValidatableResponse createDirectMassageFromUser(String twitt) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", twitt)
                .when().post(this.baseUrl + this.CREATE_DIRECT_MASSAGE_ENDPOINT)

                .then();
    }

    public ValidatableResponse createMediaFromUser(String twitt) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", twitt)
                .when().post(this.baseUrl + this.CREATE_DIRECT_MEDIA_ENDPOINT)
                .then();
    }

    public ValidatableResponse getTrendsPlace() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_TRENDS_PLACE_ENDPOINT)
                .then();
    }

    public ValidatableResponse responseMediaTime() {
        System.out.println(given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_TRENDS_PLACE_ENDPOINT)
                .timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_TRENDS_PLACE_ENDPOINT)
                .then();
    }

    public void mediaHeaderValue() {
        System.out.println(given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_TRENDS_PLACE_ENDPOINT)
                .then().extract().headers());
    }

    public void PropertyValueCheck() {
        Response response = given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_CollECTIONLIST_TWEETER_ENDPOINT);
        JsonPath pathEvaluator = response.jsonPath();
        String createdAt = pathEvaluator.get("id");
        System.out.println(createdAt);
    }

    public ValidatableResponse createPost(Object json) {
        return given().header("Content-type", "application/json").body(json)
                .when().post(this.baseUrl + CREATE_TWEET_ENDPOINT).then();
    }

    public ValidatableResponse getFollowerList() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_FoLLOWERLIST_ENDPOINT)
                .then();
    }

    public ValidatableResponse UserCreateFollowerList(String mediaTweet) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", mediaTweet)
                .when().post(this.baseUrl + this.CREATE_FoLLOWERLIST_ENDPOINT)
                .then();
    }

    public void followerHeaderValue() {
        System.out.println(given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.CREATE_FoLLOWERLIST_ENDPOINT)
                .then().extract().headers());
    }

    public void followerBodyValue() {
        System.out.println(given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.CREATE_FoLLOWERLIST_ENDPOINT)
                .then().extract().body());
    }

    public ValidatableResponse UsergetTimeLineId(Long Id) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", Id)
                .when().post(this.baseUrl + this.CREATE_TWEET_ENDPOINT)
                .then();
    }

    public ValidatableResponse deleteTweetValided(Long tweetId) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", tweetId)
                .when().post(this.baseUrl + this.DELETE_TWEET_ENDPOINT)
                .then();
    }

    public ValidatableResponse createFavorites(String tweet) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", tweet)
                .when().post(this.baseUrl + this.CREATE_TWEET_ENDPOINT)
                .then();
    }

    public ValidatableResponse favoritesDelete(Long tweetId) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", tweetId)
                .when().post(this.baseUrl + this.DELETE_FAVORITES_ENDPOINT)
                .then();
    }

    public ValidatableResponse createMediaTweet(String mediatweet) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", mediatweet)
                .when().post(this.baseUrl + this.CREATE_MEDIA_ENDPOINT)
                .then();
    }

    public ValidatableResponse getMediaTweet() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_MEDIA_ENDPOINT)
                .then();
    }

    public ValidatableResponse CreatemediaSubTitlle(String tweet) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", tweet)
                .when().post(this.baseUrl + this.GET_MEDIA_SUBTITLE_ENDPOINT)
                .then();
    }

    public ValidatableResponse createMediaUpload(String tweet) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", tweet)
                .when().post(this.baseUrl + this.POST_MEDIA_UPLOAD_SUBTITLE_ENDPOINT)
                .then();
    }

    public ValidatableResponse createCollectionLsst(String tweet) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", tweet)
                .when().post(this.baseUrl + this.POST_COLLECTIONS_CRETATE_ENDPOINT)
                .then();
    }

    public ValidatableResponse getcollectionsTweet() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_COLLECTIONS_ENDPOINT)
                .then();
    }

    public void collectionHeaderValue() {
        System.out.println(given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_COLLECTIONS_ENDPOINT)
                .then().extract().headers());

    }

    public void collectionBodyValue() {
        System.out.println(given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + this.GET_COLLECTIONS_ENDPOINT)
                .then().extract().body());

    }
}
