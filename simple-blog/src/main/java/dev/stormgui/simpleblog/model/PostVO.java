package dev.stormgui.simpleblog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PostVO(String id,
                     String image,
                     Integer likes,
                     List<String> tags, String text, LocalDateTime publishDate) {
}
