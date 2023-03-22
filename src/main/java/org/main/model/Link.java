package org.main.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Link {

    private final String url;

    @JsonCreator
    public Link(@JsonProperty("url") String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
