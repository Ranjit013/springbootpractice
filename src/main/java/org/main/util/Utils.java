package org.main.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.main.model.Link;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static void readExcel(String filePath) {
        File file = new File(filePath);
        try {
            FileInputStream inputStream = new FileInputStream(file);
            Workbook baeuldungWorkBook = new XSSFWorkbook(inputStream);
            for (Sheet sheet : baeuldungWorkBook) {
                int firstRow = sheet.getFirstRowNum();
                int lastRow = sheet.getLastRowNum();
                for (int index = firstRow + 1; index <= lastRow; index++) {
                    Row row = sheet.getRow(index);
                }
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
