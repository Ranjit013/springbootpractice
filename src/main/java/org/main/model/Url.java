package org.main.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Url {
    private final String url;
    private final String name;
    private final String type;
    private final String ext;

    @JsonCreator
    public Url(@JsonProperty("url") String url,
               @JsonProperty("name") String name,
               @JsonProperty("type") String type,
               @JsonProperty("ext") String ext) {
        this.url = url;
        this.name = name;
        this.type = type;
        this.ext = ext;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getExt() {
        return ext;
    }
}
