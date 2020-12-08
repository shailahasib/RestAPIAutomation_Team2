package spotify;

import base.RestAPI;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;
import static spotify.Helper.*;

public class Spotify_APIClient extends RestAPI {

    private final String CREATE_PlayList_ENDPOINT = "/users/Kramoun/playlists";
    private final String GET_PlayList_CREATED_ENDPOINT = "/playlists/2d2vvWerwXBGfrmzlkiGfk";
    private final String DELET_PlayLists_ENDPOINT = "/playlists/4jWES2VzakJqZcmwNM1dDu/followers";
    private final String SEARCH_SONG_ENDPOINT = "/search";
    private final String PUT_Playlist_Image_ENDPOINT = "/playlists/4jWES2VzakJqZcmwNM1dDu/images";
    private final String GET_Playlist_Image_ENDPOINT = "/playlists/4jWES2VzakJqZcmwNM1dDu/images";
    private final String PUT_Change_Details_PlayList = "/playlists/4jWES2VzakJqZcmwNM1dDu";
    private final String POST_ADD_ITEM_TO_Playlist = "/playlists/4jWES2VzakJqZcmwNM1dDu/tracks";
    private final String GET_AN_ARTIST_ALBUMS = "/artists/0GgY7hjMoGDsX8ZDe2mwds/albums";
    private final String GET_AN_ARTIST_Top_Track = "/artists/0GgY7hjMoGDsX8ZDe2mwds/top-tracks";
    private final String PUT_FOLLOW_AN_ARTIST_OR_USERS = "/me/following";
    private final String GET_ALBUM_TRACKS = "/albums/3Gq2Dme9nesdgoqNNlcN8O/tracks";
    private final String PUT_Updated_Playlist_Name = "/playlists/295TfaQO15QHEYye52fcCn";
    private final String GET_Followed_Artists = "/me/following";
    private final String PUT_Follow_A_Playlist = "/playlists/3oSOXKzuwTtqY2F1L6JyXV/followers";
    private final String Get_Current_User_Profile = "/me";
    private final String Get_User_Profile = "/users/kramoun";
    private final String Get_Audio_Analysis_for_Track = "/audio-analysis/0BD9boQC7jUTWkAoib4Z0d";
    private final String Get_Several_Tracks = "/tracks";

    public ValidatableResponse playListCreate() throws FileNotFoundException, FileNotFoundException {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", createPlayListToken)
                .body(this.jsonMessage)
                .when().post(this.baseUrl + this.CREATE_PlayList_ENDPOINT)
                .then().log().all();
    }

    public ValidatableResponse GETPlayListCreated() throws FileNotFoundException, FileNotFoundException {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", GetPlayListToken)
                .when().get(this.baseUrl + this.GET_PlayList_CREATED_ENDPOINT)
                .then().log().all();
    }

    public ValidatableResponse deletePlayList() throws FileNotFoundException, FileNotFoundException {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", deletePlayListToken)
                .when().delete(this.baseUrl + this.DELET_PlayLists_ENDPOINT)
                .then().log().all();
    }

    public ValidatableResponse searchSong() throws FileNotFoundException, FileNotFoundException {
        return given()
                .log().all()
                .param("q", "Soulking")
                .param("type", "artist")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", SearchSongToken)
                .when().get(this.baseUrl + this.SEARCH_SONG_ENDPOINT)
                .then().log().all();
    }

    public ValidatableResponse PUTCoverImagePlaylist(String image) throws FileNotFoundException, FileNotFoundException {
        return given()
                .log().all()
                .header("Authorization", CoverImageToken)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .param("image", "IMAGE_JPEG")
                .when().put(this.baseUrl + this.PUT_Playlist_Image_ENDPOINT)
                .then().log().all();
    }

    public ValidatableResponse GETCoverImagePlaylist() throws FileNotFoundException, FileNotFoundException {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", getCoverImageToken)
                .when().get(this.baseUrl + this.GET_Playlist_Image_ENDPOINT)
                .then();
    }

    public ValidatableResponse PUTChangePlaylistDetails() throws FileNotFoundException, FileNotFoundException {
        return given()
                .log().all()
                .body(this.ChangeDetails)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", putDetailsToken)
                .when().put(this.baseUrl + this.PUT_Change_Details_PlayList)
                .then().log().all();
    }

    public ValidatableResponse GetAnArtistAlbums() throws FileNotFoundException, FileNotFoundException {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", GetArtistAlbumsToken)
                .when().get(this.baseUrl + this.GET_AN_ARTIST_ALBUMS)
                .then().log().all();
    }

    public ValidatableResponse GetAnArtistsTopTracks() throws FileNotFoundException, FileNotFoundException {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", artistTopTrackToken)
                .queryParam("market", "US")
                .when().get(this.baseUrl + this.GET_AN_ARTIST_Top_Track)
                .then().log().all();
    }

    public ValidatableResponse PutFollowArtistsOrUsers() throws FileNotFoundException, FileNotFoundException {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", followArtistToken)
                .queryParam("type", "Artist")
                .queryParam("ids", "0GgY7hjMoGDsX8ZDe2mwds")
                .when().put(this.baseUrl + this.PUT_FOLLOW_AN_ARTIST_OR_USERS)
                .then().log().all();
    }

    public ValidatableResponse GetAlbumTracks() throws FileNotFoundException, FileNotFoundException {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParam("market", "US")
                .header("Authorization", albumTracksToken)
                .when().get(this.baseUrl + this.GET_ALBUM_TRACKS)
                .then().log().all();
    }

    public ValidatableResponse POSTaddItemsToPlaylist() throws FileNotFoundException, FileNotFoundException {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", getCoverImageToken)
                .when().get(this.baseUrl + this.POST_ADD_ITEM_TO_Playlist)
                .then();
    }

    public ValidatableResponse PUTUpdatedPlaylistName() throws FileNotFoundException, FileNotFoundException {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", PUT_Updated_Playlist_NameToken)
                .body(this.UpdatePlayList)
                .when().put(this.baseUrl + this.PUT_Updated_Playlist_Name)
                .then();
    }

    public ValidatableResponse GETFollowedArtists() throws FileNotFoundException, FileNotFoundException {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", GET_Followed_ArtistsToken)
                .param("type", "artist")
                .param("genres", "french hip hop")
                .when().get(this.baseUrl + this.GET_Followed_Artists)
                .then();
    }

    public ValidatableResponse PUTFollowAPlaylist() throws FileNotFoundException, FileNotFoundException {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", GET_Followed_ArtistsToken)
                .when().put(this.baseUrl + this.PUT_Follow_A_Playlist)
                .then();
    }

    public ValidatableResponse GetCurrentUserProfile() throws FileNotFoundException, FileNotFoundException {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", GET_Followed_ArtistsToken)
                .when().get(this.baseUrl + this.Get_Current_User_Profile)
                .then();
    }

    public ValidatableResponse GetUserProfile() throws FileNotFoundException, FileNotFoundException {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", GET_Followed_ArtistsToken)
                .when().get(this.baseUrl + this.Get_User_Profile)
                .then();
    }

    public ValidatableResponse GetAudioAnalysisForTrack() throws FileNotFoundException, FileNotFoundException {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", GET_Followed_ArtistsToken)
                .when().get(this.baseUrl + this.Get_Audio_Analysis_for_Track)
                .then();
    }

    public ValidatableResponse GetSeveralTracks() throws FileNotFoundException, FileNotFoundException {
        return given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", GET_Followed_ArtistsToken)
                .param("ids", "0BD9boQC7jUTWkAoib4Z0d")
                .when().get(this.baseUrl + this.Get_Several_Tracks)
                .then();
    }

}
