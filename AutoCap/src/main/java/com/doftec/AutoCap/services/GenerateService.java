package com.doftec.AutoCap.services;

import com.doftec.AutoCap.dto.CaptionResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class GenerateService {
    private final RestClient restClient;

    public GenerateService(RestClient restClient) {
        this.restClient = restClient;
    }

    public CaptionResponse callApi(String imageUrl) {
        String prompt = String.format("""
        Generate two captions for the following image URL: %s

        1. A SHORT caption (1–2 lines): Make it witty, fun, and suitable for a quick social media post.
        2. A LONG caption (3–5 lines): Be more expressive, emotional, poetic, or storytelling. Make it memorable and creative nut not too long keep it in category of caption only .

        Include hashtags at the end of each caption. Format them as:

        ### Short Caption: "..."
        ### Long Caption: "..."
        """, imageUrl);

        Map<String, Object> message = Map.of(
                "role", "user",
                "content", prompt
        );

        Map<String, Object> requestBody = Map.of(
                "model", "qwen/qwen2.5-vl-32b-instruct:free",
                "messages", List.of(message),
                "temperature", 0.9
        );

        ResponseEntity<String> responseEntity = restClient.post()
                .uri("/chat/completions")
                .contentType(MediaType.APPLICATION_JSON)
                .body(requestBody)
                .retrieve()
                .toEntity(String.class);

        if (responseEntity.getBody() == null) {
            return new CaptionResponse(null, null);
        }

        String responseBody = responseEntity.getBody();

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseBody);
            String fullContent = root.path("choices").get(0).path("message").path("content").asText();

            // Extract captions using the format hints
            String shortCaption = null;
            String longCaption = null;

            if (fullContent.contains("### Short Caption:") && fullContent.contains("### Long Caption:")) {
                String[] splitByShort = fullContent.split("### Short Caption:", 2);
                String[] splitByLong = splitByShort[1].split("### Long Caption:", 2);
                shortCaption = splitByLong[0].trim().replaceAll("^\"|\"$", "");
                longCaption = splitByLong[1].trim().replaceAll("^\"|\"$", "");
            }

            return new CaptionResponse(shortCaption, longCaption);

        } catch (Exception e) {
            e.printStackTrace();
            return new CaptionResponse(null, null);
        }
    }

}
