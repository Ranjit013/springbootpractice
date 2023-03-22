package org.main.controller;

import org.main.model.Link;
import org.main.model.VideoDownloaderResponse;
import org.main.service.VideoDownloaderService;
import org.main.util.Utils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ExcelFileController {

    private final VideoDownloaderService videoDownloaderService;

    public ExcelFileController(VideoDownloaderService videoDownloaderService) {
        this.videoDownloaderService = videoDownloaderService;
    }

    @PostMapping(value = "/download")
    public List<VideoDownloaderResponse> downloadAllVideos() {
        Path path = Paths.get(new File("src/main/resources/test.csv").toURI());
        List<Link> links = Utils.readCsv(path);
        return videoDownloaderService.downloadVideos(links);

    }
}

