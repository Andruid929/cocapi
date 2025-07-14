package net.druidlabs.cocapi.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class InputStreamCollector {

    private InputStreamCollector() {
    }

    public static String collectStreamData(InputStream inputStream) {
        if (inputStream == null) {
            System.err.println("Null input stream, check your endpoint configuration");
            return "";
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
        }

        return stringBuilder.toString();
    }
}
