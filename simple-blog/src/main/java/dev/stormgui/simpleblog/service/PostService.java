package dev.stormgui.simpleblog.service;

import dev.stormgui.simpleblog.model.Album;
import dev.stormgui.simpleblog.model.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class PostService {

    private final RestTemplate restTemplate;
    private static final String POST_URL = "https://jsonplaceholder.typicode.com/posts";
    private static final String ALBUM_URL = "https://jsonplaceholder.typicode.com/albums";

    public PostService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Post> getPosts() {
        ResponseEntity<Post[]> response = restTemplate.getForEntity(POST_URL, Post[].class);
        if (response.getBody() == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(response.getBody()).subList(0,10);
    }

    public List<Album> getAlbums() {
        ResponseEntity<Album[]> response = restTemplate.getForEntity(ALBUM_URL, Album[].class);
        if (response.getBody() == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(response.getBody()).subList(0,10);
    }
}
