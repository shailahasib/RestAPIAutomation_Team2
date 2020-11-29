package tweet;

public class Payload {

    public static String dirMessage(){
        return "{\n" +
                "  \"event\": {\n" +
                "    \"type\": \"message_create\",\n" +
                "    \"message_create\": {\n" +
                "      \"target\": {\n" +
                "        \"recipient_id\": \"500226111\"\n" +
                "      },\n" +
                "      \"message_data\": {\n" +
                "        \"text\": \"Eat dirts too...\"\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";
    }


}
