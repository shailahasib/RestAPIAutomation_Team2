package base;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class RestAPI {

    protected String apiKey;
    protected String apiSecretKey;
    protected String accessToken;
    protected String accessTokenSecret;
    protected String googleApiKey;
    protected Properties properties;
    protected InputStream inputStream;
    protected String baseUrl;
    protected String uploadBase;

    protected String googleBase;

    public RestAPI() {
        this.uploadBase = "https://upload.twitter.com/1.1";
        this.baseUrl = "https://api.twitter.com/1.1";
        this.googleBase = "https://www.google.com/maps/embed/v1";
        this.properties = new Properties();
        inputStream = null;
        try {
            // Path of the Secret.properties file
            this.inputStream = new FileInputStream("../Twitter/secret.properties");
            this.properties.load(this.inputStream);
            this.apiKey = this.properties.getProperty("apiKey");
            this.apiSecretKey = this.properties.getProperty("apiSecretKey");
            this.accessToken = this.properties.getProperty("accessToken");
            this.accessTokenSecret = this.properties.getProperty("accessTokenSecret");
            this.googleApiKey= this.properties.getProperty("googleApiKey");
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
