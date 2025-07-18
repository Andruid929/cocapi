# C.O.C.A.P.I

This is a library for making simple Clash of clans API **GET** requests.

## Getting started

- Go to [GitHub releases](https://github.com/Andruid929/cocapi/releases)
- Download the jar (Sources are optional but recommended for documentation)
- Add the jar as a dependency to your project

### Note: Clash of clans API requires a JSON token to validate requests.

So, either

Visit [Clash of Clans API](https://developer.clashofclans.com/#/getting-started) to learn how to acquire a token for yourself.

OR

If you already have an API token, proceed with:

1. In your project folder, create a Java class with any name you want.
2. Create a ``public static String`` field with any name of your choosing. This field can be ``final`` or not but **MUST**
   be ``public`` and ``static``
   otherwise it will not be detected.
3. Assign your API token to this field.
4. Annotate this field with [@ApiToken](src/main/java/net/druidlabs/cocapi/annotation/ApiToken.java). This annotation
   marks the field as the API token which is required for
   requests

Here's what the field should look like

 ```
     @ApiToken
     public static final String MY_API_TOKEN = "api.token.here";
 ```

### Important things to note

- Any issues with the field annotated as the API token will come back to bite you,
so make sure the field is not empty, null and accurately returns your API token.

- If you have multiple fields annotated with ```@ApiToken```, the program will only take the first one it finds and stop
there.
Field scanning is done from top to bottom.

- Once you've declared this field, you're done with the configuration class.
The only thing left to do is to tell the program what your configuration file is. Call ```Info.setConfigurationClass(YourConfigClass.class);```
and pass in your Java class instead of ```YourConfigClass```.

With that being said, you're all set to start making requests.

## What can you request?

### Player info

```PlayerInfo.getPlayerInfo(playerId);```

Gets info for the player specified in the playerID parameter.
