package io.github.andruid929.cocapi.attributes;

import com.google.gson.JsonObject;
import io.github.andruid929.cocapi.information.JsonInfoReader;

/**
 * Container class for the label attribute.
 *
 * @author Andrew Jones
 * @version 1.0
 * @since 1.1.0-beta.2
 */

public final class Label extends JsonInfoReader {

    /**
     * JSON object containing data about a specific label.
     */

    private final JsonObject label;

    /**
     * Create a new label attribute object.
     *
     * @param label a JSON object representing a label attribute.
     */

    public Label(JsonObject label) {
        this.label = label;

        setJsonString("{\"name:\" \"label\"}");
    }

    @Override
    protected JsonObject data() {
        return label;
    }

    /**
     * Get the label ID.
     *
     * @return the label ID or {@code -1} if no "id" attribute can be found.
     */

    public int getId() {
        return getIntIfPresent("id");
    }

    /**
     * Get the label name.
     *
     * @return the name or {@link JsonInfoReader#NON_EXISTENT_ATTRIBUTE} if no "name" attribute can be found.
     */

    public String getName() {
        return getStringIfPresent("name");
    }

    /**
     * Get the icon URLs for this label.
     *
     * @return an object containing icon URLs if any.
     */

    public IconUrls getIconUrls() {
        JsonObject iconUrlsObject = getJsonObjectIfPresent("iconUrls");

        return new IconUrls(iconUrlsObject);
    }

    /**
     * Container class for label icon URls.
     *
     * @author Andrew Jones
     * @version 1.0
     * @since 1.1.0-beta.3
     */

    public static class IconUrls extends JsonInfoReader {

        private final JsonObject iconUrls;

        /**
         * Create a new object containing icon URLs if any.
         *
         * @param iconUrls the object containing icon URL data.
         */

        public IconUrls(JsonObject iconUrls) {
            this.iconUrls = iconUrls;
        }

        @Override
        protected JsonObject data() {
            return iconUrls;
        }

        /**
         * Get the small icon URL.
         *
         * @return the URL or {@link JsonInfoReader#NON_EXISTENT_ATTRIBUTE} if the
         * "small" attribute cannot be found.
         */

        public String getSmallIconUrl() {
            return getStringIfPresent("small");
        }

        /**
         * Get the medium icon URL.
         *
         * @return the URL or {@link JsonInfoReader#NON_EXISTENT_ATTRIBUTE} if the
         * "medium" attribute cannot be found.
         */

        public String getMediumIconUrl() {
            return getStringIfPresent("medium");
        }
    }
}
