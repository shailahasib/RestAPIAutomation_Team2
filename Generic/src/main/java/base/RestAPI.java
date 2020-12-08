package base;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class RestAPI {

    protected String apiKey;
    protected String apiSecretKey;
    protected String accessToken;
    protected String ClientID;
    protected String ClientSecret;
    protected String accessTokenSecret;
    protected Properties properties;
    protected InputStream inputStream;
    protected String baseUrl;
    protected FileInputStream jsonMessage;
    protected FileInputStream UpdatePlayList;
    protected FileInputStream ChangeDetails;

    public RestAPI() {
        this.baseUrl = "https://api.twitter.com/1.1";
        this.baseUrl = "https://api.spotify.com/v1";
        this.baseUrl = "https://slack.com";
        this.properties = new Properties();
        inputStream = null;
        jsonMessage = null;
        ChangeDetails = null;
        UpdatePlayList = null;
        try {
            // Path of the Secret.properties file
            this.inputStream = new FileInputStream("../Twitter/src/test/secret.properties");
            this.inputStream = new FileInputStream("../secret.properties");
            this.inputStream = new FileInputStream("../SlackAPI_Testing/secret_Slack.properties");
            this.properties.load(this.inputStream);
            this.apiKey = this.properties.getProperty("apiKey");
            this.apiSecretKey = this.properties.getProperty("apiSecretKey");
            this.accessToken = this.properties.getProperty("accessToken");
            this.accessTokenSecret = this.properties.getProperty("accessTokenSecret");
            this.ClientID = this.properties.getProperty("ClientID");
            this.ClientSecret = this.properties.getProperty("ClientSecret");
            this.jsonMessage = new FileInputStream("../Spotify/jsonFiles/jsonFile.json");
            this.UpdatePlayList = new FileInputStream("../Spotify/jsonFiles/Update_Playlist_jsonFile.json");
            this.ChangeDetails = new FileInputStream("../Spotify/jsonFiles/ChangePlayListDetails.json");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File not load Properly");
        } finally {
            try {
                this.inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


}
