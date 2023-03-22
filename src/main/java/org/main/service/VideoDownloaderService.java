package org.main.service;

import org.main.model.Link;
import org.main.model.VideoDownloaderResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoDownloaderService {

    private final String url;
    private final RestTemplate restTemplate;

    public VideoDownloaderService(@Value("${download.url}") String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    public List<VideoDownloaderResponse> downloadVideos(List<Link> links) {
        return links.stream().map(link -> restTemplate.postForObject(url, link, VideoDownloaderResponse.class)).collect(Collectors.toList());

    }
}
