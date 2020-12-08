package slack_API;

import base.RestAPI;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class Slack_API_Client extends RestAPI {
    private final String POST_Send_Message_ENDPOINT = "/api/chat.postMessage";
    private final String POST_CREATE_CHANNEL_ENDPOINT = "/api/conversations.create";

    public ValidatableResponse POSTMessageOnWorkSpace() {
        return given()
                .header("Authorization", Helper.UserToken)
                .param("channel", "weekdaysevening_selenium_ny_summer2020")
                .param("pretty", "1")
                .param("text", "Sorry!Just Testing")
                .when().post(this.baseUrl + this.POST_Send_Message_ENDPOINT)
                .then().log().all();
    }

    public ValidatableResponse POSTCreateChannel() {
        return given()
                .header("Authorization", Helper.UserToken)
                .param("name", "testinapi2020")
                .param("pretty", "1")
                .when().post(this.baseUrl + this.POST_CREATE_CHANNEL_ENDPOINT)
                .then().log().all();
    }

}
