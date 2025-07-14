package net.druidlabs.cocapi.util;

public final class UrlValidate {

    private UrlValidate() {
    }

    public static String trimSlashes(String url) {
        String leading = trimLeadingSlash(url);

        return trimTrailingSlash(leading);
    }

    private static String trimTrailingSlash(String url) {
        if (url.endsWith("/")) {

            return url.substring(0, url.length() - 1);
        }

        return url;
    }

    private static String trimLeadingSlash(String url) {
        if (url.startsWith("/")) {

            return url.substring(1);
        }

        return url;
    }
}
