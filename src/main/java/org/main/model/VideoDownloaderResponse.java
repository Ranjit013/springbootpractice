package org.main.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoDownloaderResponse {
    private final List<Url> url;
    private final Meta meta;
    private final String thumb;
    private final String sd;
    private final String hosting;
    private final String timeStamp;

    @JsonCreator
    public VideoDownloaderResponse(@JsonProperty("url") List<Url> url, @JsonProperty("meta") Meta meta, @JsonProperty("thumb") String thumb, @JsonProperty("sd") String sd, @JsonProperty("hosting") String hosting, @JsonProperty("timeStamp") String timeStamp) {
        this.url = url;
        this.meta = meta;
        this.thumb = thumb;
        this.sd = sd;
        this.hosting = hosting;
        this.timeStamp = timeStamp;
    }

    public List<Url> getUrl() {
        return url;
    }

    public Meta getMeta() {
        return meta;
    }

    public String getThumb() {
        return thumb;
    }

    public String getSd() {
        return sd;
    }

    public String getHosting() {
        return hosting;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}
