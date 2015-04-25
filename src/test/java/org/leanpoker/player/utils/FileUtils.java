package org.leanpoker.player.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author octavian
 * @since 25.04.2015
 */
public class FileUtils {
    public static String readAllContent(String path) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path));
        StringBuilder content = new StringBuilder();
        for (String line : lines) {
            content.append(line);
            content.append("\n");
        }
        return content.toString();
    }
}