package rlbotexample.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Utility for reading a network port out of a config file. We're expecting a file that has only one line
 * that's just a number.
 */
public class PortReader {
    public static Integer readPortFromFile(String s) {
        Path path = Paths.get(s);

        try (Stream<String> lines = Files.lines(path)) {
            Optional<String> firstLine = lines.findFirst();
            return firstLine.map(Integer::parseInt).orElseThrow(() -> new RuntimeException("Port config file was empty!"));
        } catch (final IOException e) {
            throw new RuntimeException("Failed to read port file! Tried to find it at " + path.toAbsolutePath().toString());
        }
    }
}
