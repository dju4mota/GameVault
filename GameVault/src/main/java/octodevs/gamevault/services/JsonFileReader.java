package octodevs.gamevault.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import octodevs.gamevault.models.Review;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class JsonFileReader {

    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;

    public JsonFileReader(ResourceLoader resourceLoader, ObjectMapper objectMapper) {
        this.resourceLoader = resourceLoader;
        this.objectMapper = objectMapper;
    }

    public Review readJsonFile() {
        try {
            // Load the JSON file from the classpath
            Resource resource = resourceLoader.getResource("classpath:InitialData.json");
            InputStream inputStream = resource.getInputStream();

            // Parse the JSON file into a Review object
            return objectMapper.readValue(inputStream, Review.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file", e);
        }
    }

    public List<Review> readArrayReviewFromJson() {
        try {
            Resource resource = resourceLoader.getResource("classpath:InitialData.json");
            InputStream inputStream = resource.getInputStream();
            return objectMapper.readValue(inputStream, new TypeReference<List<Review>>() {} );
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file", e);
        }

    }
}