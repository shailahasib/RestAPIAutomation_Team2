package slack_API_testing;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import slack_API.Slack_API_Client;

public class Slack_API_Client_testing {
    private Slack_API_Client slack_api_client;

    @BeforeClass
    public void setUpTweetAPI() {
        this.slack_api_client = new Slack_API_Client();
    }

    @Test(enabled = false)
    public void TestPOSTTextMessageSlack() {
        ValidatableResponse response = this.slack_api_client.POSTMessageOnWorkSpace();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }
    @Test(enabled = true)
    public void TestPOSTCreateChannel() {
        ValidatableResponse response = this.slack_api_client.POSTCreateChannel();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }
}
