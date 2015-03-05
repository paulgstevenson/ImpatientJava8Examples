package com.impatient.pgs;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Chapter2 {

    public long countLongWords(String fileName) throws IOException, URISyntaxException {
        String contents = new String(Files.readAllBytes(Paths.get(this.getClass().getResource(fileName).toURI())), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]]+"));
        return words.stream().parallel().filter(w -> w.length() > 12).count();
    }
}
