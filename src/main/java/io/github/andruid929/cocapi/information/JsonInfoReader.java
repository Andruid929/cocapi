package io.github.andruid929.cocapi.information;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import io.github.andruid929.cocapi.Config;

import java.util.Objects;

/**
 * Class to handle JSON string reading. This class was created to
 * check for a specific attribute and gracefully handle the error when
 * the attribute cannot be found.
 *
 * @author Andrew Jones
 * @version 1.1
 * @since 1.1.0-beta.2
 */

public abstract class JsonInfoReader {

    /**
     * The number of times this class has read JSON info.
     * Added to give each instance of this class a unique identity.
     *
     * @since 1.1.0-beta,3
     */

    protected static long numberOfReads;

    /**
     * The JSON string to be read which contains all the information about
     * a specific response.
     */

    protected String jsonString;

    /**
     * Returned when the {@link JsonInfoReader} cannot find a specified attribute.
     */

    public static final String NON_EXISTENT_ATTRIBUTE = "Attribute not found";

    /**
     * Tell the JSON reader where to read attributes from.
     *
     * @param jsonString the JSON string for the attributes.
     */

    protected void setJsonString(String jsonString) {
        this.jsonString = jsonString;

        numberOfReads++;
    }

    /**
     * Get the root element from which attributes can be read.
     *
     * @return root element for attributes.
     */

    protected JsonObject data() {
        try {

            return JsonParser.parseString(jsonString).getAsJsonObject();
        } catch (JsonSyntaxException e) {

            switch (Config.getExceptionHandleMode()) {
                case 0:
                    System.err.println("Cannot parse JSON String");

                    return new JsonObject();

                case 2:
                    return new JsonObject();

                default:
                    throw e;
            }
        }
    }

    /**
     * Attempt to get a String attribute from the JSON string.
     *
     * @param attrName the name of attribute to get.
     * @return the attribute String or {@link #NON_EXISTENT_ATTRIBUTE}
     * if the attribute does not exist.
     */

    protected String getStringIfPresent(String attrName) {
        try {

            return data().get(attrName).getAsString();
        } catch (NullPointerException e) {

            switch (Config.getExceptionHandleMode()) {
                case 0:
                    printErrorMessage(attrName);

                    return NON_EXISTENT_ATTRIBUTE;

                case 2:
                    return NON_EXISTENT_ATTRIBUTE;

                default:
                    throw e;
            }
        }
    }

    /**
     * Attempt to get a number attribute from the JSON string.
     *
     * @param attrName the name of attribute to get.
     * @return the attribute int or {@code -1}
     * if the attribute does not exist.
     */

    protected int getIntIfPresent(String attrName) {
        try {

            return data().get(attrName).getAsInt();
        } catch (NullPointerException e) {

            switch (Config.getExceptionHandleMode()) {
                case 0:
                    printErrorMessage(attrName);

                    return -1;

                case 2:
                    return -1;

                default:
                    throw e;
            }
        }
    }

    /**
     * Attempt to get an array attribute from the JSON string.
     *
     * @param attrName the name of attribute to get.
     * @return the attribute array as {@link JsonArray} or
     * an empty {@link JsonArray} if the attribute does not exist.
     */

    protected JsonArray getJsonArrayIfPresent(String attrName) {
        try {

            return data().get(attrName).getAsJsonArray();
        } catch (NullPointerException e) {

            switch (Config.getExceptionHandleMode()) {
                case 0:
                    printErrorMessage(attrName);

                    return new JsonArray();

                case 2:
                    return new JsonArray();

                default:
                    throw e;
            }
        }
    }

    /**
     * Attempt to get a special attribute from the JSON string.
     * <p>Special attributes have child attributes within them.
     *
     * @param attrName the name of attribute to get.
     * @return the attribute as {@link JsonObject} or
     * an empty {@link JsonObject} if the attribute does not exist.
     */

    protected JsonObject getJsonObjectIfPresent(String attrName) {
        try {

            return data().get(attrName).getAsJsonObject();
        } catch (NullPointerException e) {

            switch (Config.getExceptionHandleMode()) {
                case 0:
                    printErrorMessage(attrName);

                    return new JsonObject();

                case 2:
                    return new JsonObject();

                default:
                    throw e;
            }
        }
    }

    /**
     * Print a message to the terminal when an attribute cannot be found in a JSON element.
     *
     * @param attrName the attribute that cannot be found.
     * */

    protected void printErrorMessage(String attrName) {
        String output = "\"".concat(attrName).concat("\" attribute not found");

        System.err.println(output);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        JsonInfoReader that = (JsonInfoReader) o;
        return Objects.equals(jsonString, that.jsonString);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(jsonString);
    }

    @Override
    public String toString() {
        return jsonString;
    }
}
