# StylingInAndroid
You've seen that View elements with similar characteristics can be styled together in the styles.xml file.

To apply a theme to an activity instead of the entire application, place the theme attribute in the <Activity> tag instead of the <application> tag. For more information on themes and styles,

 The Android framework provides a theme that is designed exactly for this: The DayNight theme.

This theme has built-in options that allow you to control the colors in your app programmatically: either by setting it to change automatically by time, or by user command.

The DayNight theme uses the AppCompatDelegate class to set the night mode options in your Activity. To learn more about this theme
