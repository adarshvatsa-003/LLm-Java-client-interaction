package scoremecl;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class LlamaClient {
    private static final String SERVER_URL = "http://localhost:5001/generate"; // Updated to port 5001

    public List<String> generateText(List<String> texts) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost request = new HttpPost(SERVER_URL);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(Map.of("texts", texts));
        StringEntity entity = new StringEntity(json);
        request.setEntity(entity);
        request.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = httpClient.execute(request);
        String responseBody = EntityUtils.toString(response.getEntity());
        Map<String, List<String>> responseMap = objectMapper.readValue(responseBody, Map.class);
        httpClient.close();

        return responseMap.get("responses");
    }

    public static void main(String[] args) {
        try {
            LlamaClient client = new LlamaClient();
            List<String> texts = List.of("Hello, how are you today?");
            List<String> responses = client.generateText(texts);

            for (String response : responses) {
                System.out.println("Response: " + response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

