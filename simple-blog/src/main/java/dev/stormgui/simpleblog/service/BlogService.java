package dev.stormgui.simpleblog.service;

import dev.stormgui.simpleblog.model.PostVO;
import dev.stormgui.simpleblog.model.PostWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class BlogService {

    private final RestTemplate restTemplate;

    @Value("${user.app.key}")
    private String key;

    private static final String BASE_URL = "https://dummyapi.io/data/v1";

    public BlogService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public List<PostVO> getPosts() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("app-id", key);
        HttpEntity<PostWrapper> entity = new HttpEntity<>(headers);
        ResponseEntity<PostWrapper> response =
                restTemplate.exchange(BASE_URL + "/post?limit=10", HttpMethod.GET, entity, PostWrapper.class);


        return Objects.requireNonNull(response.getBody()).data();
    }

}
