package octodevs.gamevault.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import octodevs.gamevault.entities.game.Game;
import octodevs.gamevault.entities.review.Review;
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

    public List<Review> readArrayReviewFromJson(String fileName) {
        try {
            Resource resource = resourceLoader.getResource("classpath:scripts/" + fileName);
            InputStream inputStream = resource.getInputStream();
            return objectMapper.readValue(inputStream, new TypeReference<List<Review>>() {} );
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file", e);
        }
    }
    public List<Game> readArrayGameFromJson(String fileName) {
        try {
            Resource resource = resourceLoader.getResource("classpath:scripts/" + fileName);
            InputStream inputStream = resource.getInputStream();
            return objectMapper.readValue(inputStream, new TypeReference<List<Game>>() {} );
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file", e);
        }
    }
}