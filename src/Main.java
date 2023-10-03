import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Main [URL] [POST_DATA (optional)]");
            return;
        }

        String url = args[0];
        String postData = args.length > 1 ? args[1] : null;

        try {
            if (postData != null) {
                String response = HTTPClient.sendPOSTRequest(url, postData);
                System.out.println("POST Response:\n" + response);
            } else {
                String response = HTTPClient.sendGETRequest(url);
                System.out.println("GET Response:\n" + response);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
