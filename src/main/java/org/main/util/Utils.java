package org.main.util;

import org.apache.commons.lang3.StringUtils;
import org.main.model.Link;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static List<Link> readCsv(Path filePath) {
        try {
            List<String> strings = Files.readAllLines(filePath, StandardCharsets.UTF_16);
            return strings.stream().skip(1).map(Utils::mapper).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Link mapper(String data) {
        String[] strings = StringUtils.splitPreserveAllTokens(data, ",");
        return new Link(strings[0]);
    }
}
