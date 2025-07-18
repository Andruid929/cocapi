package net.druidlabs.cocapi.util;

import org.jetbrains.annotations.NotNull;

import java.io.*;

/**
 * Utility class providing methods of reading and returning JSON strings
 * from different sources.
 *
 * @author Andrew Jones
 * @version 1.0
 * @since 1.1.0-alpha.1
 */

public final class JsonCollector {

    public static final String FILE_NOT_FOUND = "File not found";

    public static final String NULL_STREAM = "Null input stream";

    public static final String ERROR_READING_DATA = "Error reading data";

    private JsonCollector() {
    }

    /**
     * Collect information from an API connection stream.
     *
     * @param inputStream the stream to collect data from.
     * @return - the data in the {@code inputStream} or
     * <p> {@link #NULL_STREAM} if the {@code inputStream} is null or
     * <p> {@link #ERROR_READING_DATA} if there's any issues reading from the {@code inputStream}.
     * @since 1.0
     */

    public static @NotNull String getJsonString(InputStream inputStream) {
        if (inputStream == null) {
            System.err.println("Null input stream, check your endpoint configuration");

            return NULL_STREAM;
        }

        StringBuilder stringBuilder = new StringBuilder();

        try (InputStreamReader isr = new InputStreamReader(inputStream);
             BufferedReader reader = new BufferedReader(isr)) {

            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

        } catch (IOException e) {
            System.err.println("Encountered error reading stream data:");
            System.err.println(e.getMessage());

            return ERROR_READING_DATA;
        }

        return stringBuilder.toString();
    }

    /**
     * Collect information from a file.
     *
     * @param file the file to read from.
     * @return the contents of the File specified by {@code file} or
     * <p>{@link #ERROR_READING_DATA} if there's any issues reading from the file or
     * <p>{@link #FILE_NOT_FOUND} if the file cannot be found.
     * @since 1.1.0-alpha.1
     */

    public static @NotNull String getJsonString(@NotNull File file) {
        if (!file.exists()) {
            System.err.println("\"".concat(file.getName()).concat("\"") + " could not be found.");

            return FILE_NOT_FOUND;
        }

        StringBuilder stringBuilder = new StringBuilder();

        try (FileReader fileReader = new FileReader(file);
             BufferedReader reader = new BufferedReader(fileReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

        } catch (IOException e) {
            System.err.println("Encountered error reading from file:");
            System.err.println(e.getMessage());

            return ERROR_READING_DATA;
        }

        return stringBuilder.toString();
    }

}
