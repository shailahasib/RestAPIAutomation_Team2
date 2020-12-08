package spotify_test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import spotify.Helper;
import spotify.Spotify_APIClient;

import java.io.FileNotFoundException;

public class Spotify_APIClient_Test {
    private Spotify_APIClient spotifyApiClient;

    @BeforeClass
    public void setUpTweetAPI() {
        this.spotifyApiClient = new Spotify_APIClient();
    }

    @Test(enabled = true)
    public void playListCreate() throws FileNotFoundException {
        ValidatableResponse response = this.spotifyApiClient.playListCreate();
        response.statusCode(201);
    }

    @Test(enabled = false)
    public void TestGETPlayListCreated() throws FileNotFoundException {
        String playListName = "AlaHits";
        ValidatableResponse response = this.spotifyApiClient.GETPlayListCreated();
        response.statusCode(200).assertThat().extract().body().asPrettyString();
        String actual = response.extract().body().path("name");
        Assert.assertEquals(actual, playListName, "Failed Assertion ");
    }

    @Test(enabled = false)
    public void deletePlayList() throws FileNotFoundException {
        ValidatableResponse response = this.spotifyApiClient.deletePlayList();
        response.statusCode(200);
    }

    @Test(enabled = false)
    public void searchAnTrack() throws FileNotFoundException {
        ValidatableResponse response = this.spotifyApiClient.searchSong();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test(enabled = false)
    public void TestPUTCoverImagePlaylist() throws FileNotFoundException {
        ValidatableResponse response = this.spotifyApiClient.PUTCoverImagePlaylist(Helper.IMAGE_JPEG());
        response.statusCode(202);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test(enabled = false)
    public void TestGETCoverImagePlaylist() throws FileNotFoundException {
        //String getCover = this.spotifyApiClient.GETCoverImagePlaylist().assertThat()
        //                .log().all().statusCode(200).extract().response().asString();
        //        JsonPath js = new JsonPath(getCover);
        //        String actual = js.getString("url");
        //        System.out.println(actual);
        //        Assert.assertEquals(actual,getCover,"Failed assertion " );
        //        System.out.println(response.extract().body().asPrettyString());
        ValidatableResponse response = this.spotifyApiClient.GETCoverImagePlaylist();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test(enabled = false)
    public void TestPOSTaddItemsToPlaylist() throws FileNotFoundException {
        ValidatableResponse response = this.spotifyApiClient.POSTaddItemsToPlaylist();
        response.statusCode(202);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test(enabled = false)
    public void TestPUTChangePlaylistDetails() throws FileNotFoundException {
        ValidatableResponse response = this.spotifyApiClient.PUTChangePlaylistDetails();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test(enabled = false)
    public void TestPUTCurrentUserProfile() throws FileNotFoundException {
        ValidatableResponse response = this.spotifyApiClient.PUTChangePlaylistDetails();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test(enabled = false)
    public void TestGetAnArtistAlbums() throws FileNotFoundException {
        String artistName = "Soolking";
        ValidatableResponse response = this.spotifyApiClient.GetAnArtistAlbums();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test(enabled = false)
    public void TestGetAnArtistsTopTracks() throws FileNotFoundException {
        ValidatableResponse response = this.spotifyApiClient.GetAnArtistsTopTracks();
        response.statusCode(200).assertThat().header("server", "envoy");
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test(enabled = true)
    public void TestPutFollowArtistsorUsers() throws FileNotFoundException {
        ValidatableResponse response = this.spotifyApiClient.PutFollowArtistsOrUsers();
        response.statusCode(204);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test(enabled = true)
    public void TestGetAlbumTracks() throws FileNotFoundException {
        ValidatableResponse response = this.spotifyApiClient.GetAlbumTracks();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test(enabled = true)
    public void TestPUTUpdatedPlaylistName() throws FileNotFoundException {
        ValidatableResponse response = this.spotifyApiClient.PUTUpdatedPlaylistName();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }


    @Test(enabled = true)
    public void TestGETFollowedArtists() throws FileNotFoundException {
        ValidatableResponse response = this.spotifyApiClient.GETFollowedArtists();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test(enabled = true)
    public void TestPUTFollowAPlaylist() throws FileNotFoundException {
        ValidatableResponse response = this.spotifyApiClient.PUTFollowAPlaylist();
        response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test(enabled = true)
    public void TestGetCurrentUserProfile() throws FileNotFoundException {
        String response = this.spotifyApiClient.GetCurrentUserProfile().assertThat()
                .log().all().statusCode(200).extract().response().asString();
        JsonPath js = new JsonPath(response);
        String actual = js.getString("display_name");
        System.out.println(actual);
        String expected = "kramoun";
        Assert.assertEquals(actual, expected, "Failed assertion ");
    }

    @Test(enabled = true)
    public void TestGetUserProfile() throws FileNotFoundException {
        String response = this.spotifyApiClient.GetUserProfile().assertThat()
                .log().all().statusCode(200).extract().response().asString();
        JsonPath js = new JsonPath(response);
        String actual = js.getString("id");
        System.out.println(actual);
        String expected = "kramoun";
        Assert.assertEquals(actual, expected, "Failed assertion ");
    }

    @Test(enabled = true)
    public void TestGetAudioAnalysisForTrack() throws FileNotFoundException {
        String response = this.spotifyApiClient.GetAudioAnalysisForTrack().assertThat()
                .log().all().statusCode(200).extract().response().asString();
        JsonPath js = new JsonPath(response);
        String actual = js.getString("meta");
        System.out.println(actual);
        String expected = "[analyzer_version:4.0.0, platform:Linux, detailed_status:OK, status_code:0, timestamp:1584941337, analysis_time:18.06936, input_process:libvorbisfile L+R 44100->22050]";
        Assert.assertEquals(actual, expected, "Failed assertion ");
    }

    @Test(enabled = true)
    public void TestGetSeveralTracks() throws FileNotFoundException {
        String response = this.spotifyApiClient.GetSeveralTracks().assertThat()
                .log().all().statusCode(200).extract().response().asString();
        JsonPath js = new JsonPath(response);
        String actual = js.getString("tracks.album.artists.name");
        System.out.println(actual);
        String expected = "[[Soolking]]";
        Assert.assertEquals(actual, expected, "Failed assertion ");
    }


}
