package tweet;

import base.RestAPI;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class TwiterApiaAutomationWithRestAssured extends RestAPI {
//    private final String CREATE_DIRECT_MASSAGE_ENDPOINT = "/direct_messages/events/new.json";
//    private final String DELETE_DIRECT_MASSAGE_ENDPOINT = "/direct_messages/events/destroy.json";
//    private final String GET_DIRECT_MASSAGE_ENDPOINT = "/direct_messages/events/show.json";

    private int id;
    private String title;
    private String body;

    public TwiterApiaAutomationWithRestAssured(int id, String title, String body) {

    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


//    public ValidatableResponse getDircteMassage() {
//        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
//                .when().get(this.baseUrl + this.GET_DIRECT_MASSAGE_ENDPOINT)
//                .then();
//    }


}
