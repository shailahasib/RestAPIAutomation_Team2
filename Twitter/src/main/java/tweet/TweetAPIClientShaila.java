package tweet;

import base.RestAPI;

public class TweetAPIClientShaila extends RestAPI {

    // https://developer.twitter.com/en/docs/twitter-api/v1/tweets/post-and-engage/api-reference/post-statuses-update

    private final String CREATE_TWEET_ENDPOINT="/statuses/update.json";
    private final String DELETE_TWEET_ENDPOINT="/statuses/destroy.json";
    // https://developer.twitter.com/en/docs/twitter-api/v1/tweets/timelines/api-reference/get-statuses-home_timeline
    private final String GET_USER_TWEET_ENDPOINT="/statuses/home_timeline.json";


}
