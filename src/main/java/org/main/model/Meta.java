package org.main.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Meta {
    private final String title;
    private final String source;

    @JsonCreator
    public Meta(@JsonProperty("title") String title,
                @JsonProperty("source") String source) {
        this.title = title;
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public String getSource() {
        return source;
    }
}
