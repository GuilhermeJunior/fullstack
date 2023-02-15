package dev.stormgui.simpleblog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Post(String title, String body) {

    public String title() {
        return this.title.substring(0,10);
    }
}
