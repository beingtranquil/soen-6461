import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPClient {
    public static String sendGETRequest(String url) throws IOException {
        HttpURLConnection connection = null;
        try {
            URL getUrl = new URL(url);
            connection = (HttpURLConnection) getUrl.openConnection();

            // Set HTTP method to GET
            connection.setRequestMethod("GET");

            // Read response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            return response.toString();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public static String sendPOSTRequest(String url, String postData) throws IOException {
        HttpURLConnection connection = null;
        try {
            URL postUrl = new URL(url);
            connection = (HttpURLConnection) postUrl.openConnection();

            // Set HTTP method to POST
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // Write POST data
            OutputStream os = connection.getOutputStream();
            os.write(postData.getBytes());
            os.flush();
            os.close();

            // Read response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            return response.toString();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
