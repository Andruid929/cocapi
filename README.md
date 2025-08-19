# C.O.C.A.P.I

This is a library for making simple Clash of clans API **GET** requests.

## Getting started

- Add the library dependency to your project.

**Maven**

```xml

<dependency>
    <groupId>io.github.andruid929</groupId>
    <artifactId>cocapi</artifactId>
    <version>1.1.0-beta.2</version>
</dependency>
```

**Gradle**

```groovy
implementation 'io.github.andruid929:cocoapi:1.1.0'
```

### Note: Clash of clans API requires a JSON token to validate requests.

So, either

Visit [Clash of Clans API](https://developer.clashofclans.com/#/getting-started) to learn how to acquire a token for
yourself.

OR

If you already have an API token, proceed with:

1. In your project folder, create a Java class with any name you want.
2. Create a ``public static String`` field with any name of your choosing. This field can be ``final`` or not but **MUST
   **
   be ``public`` and ``static``
   otherwise it will not be detected.
3. Assign your API token to this field.
4. Annotate this field with [@ApiToken](src/main/java/io/github/andruid929/cocapi/annotation/ApiToken.java). This
   annotation
   marks the field as the API token which is required for
   requests

Here's what the field should look like

 ```java

@ApiToken
public static final String MY_API_TOKEN = "api.token.here";
 ```

### Important things to note

- Any issues with the field annotated as the API token will come back to bite you,
  so make sure the field is not empty, null and accurately reflects your API token.

- If you have multiple fields annotated with ```@ApiToken```, the program will only take the first one it finds and stop
  there.
  Field scanning is done from top to bottom.

- Once you've declared this field, you're done with the mandatory configuration.
  The only thing left to do is to tell the program what your configuration file is. 
- Call
  ```Config.setConfigurationClass(YourConfigClass.class);```
  and pass in your Java class instead of ```YourConfigClass```.

With that being said, you're all set to start making requests.

### Optional config

*Exception handling*

- You can configure the program to automatically handle exceptions when they are thrown, particulary those that occur
  when a method is trying to return something.

  By default, the program will catch an exception, log down what went wrong in the terminal then returns a default value
  instead of the actual value.

- This behaviour can be changed by setting the exception handling mode:
  ```Config.setExceptionHandlingMode(ExceptionHandleMode mode);```

You can select one of three modes
in [ExceptionHandlingMode.java](src/main/java/io/github/andruid929/cocapi/errorhandling/ExceptionHandleMode.java)

#### LOG

Default, prints error message to terminal, methods return default values.

#### SILENT

Methods return default value, no error messages logged.

#### THROW

Throws the exception, no value returned.

## What can you request?

### Player info

```java
PlayerInfo.getPlayerInfo(playerId);
```

Get info for the player specified in the playerID parameter, this is returned as a JSON string.
This JSON string can be parsed manually or passed into the
[Player](src/main/java/io/github/andruid929/cocapi/information/Player.java) constructor.
