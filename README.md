# Simple Settings Activity
![Android CI](https://github.com/marcauberer/simple-settings/workflows/Android%20CI/badge.svg)
[![API](https://img.shields.io/badge/API-21%2B-red.svg?style=flat)](https://android-arsenal.com/api?level=21)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com)

Simple Settings is a library, which provides a simple to use, lightweight solution to create a settings screen without any boilerplate code. This behaviour saves cost, time and effort.

## Screenshots

## Try it
If you want to test the library, please visit the sample app on [https://play.google.com/store/apps/details?id=com.chillibits.simplesettingssample](Google Play)!

## Usage
The first step for using this library is, to add it to the dependency section in your project:
```gradle
implementation 'com.chillibits:simple-settings:1.0.0-alpha01'
```

The library accepts two different ways, for providing the settings screen information.

### Provide items programmatically
You can create the settings items, by using the `show()` method with the callback like this:
```kotlin
val settings = SimpleSettings(this, config).show {
    Section {
        title = "Test section"
        for (i in 0..4) {
            SimpleSwitchPref {
                title = "Test 1.$i"
                summary = "This is a Test 1.$i"
                defaultValue = if(i % 2 == 0) SimpleSwitchPreference.ON else SimpleSwitchPreference.OFF
            }
        }
        if(true) {
            SimpleTextPref {
                title = "Test 2"
                summary = "This is a Test 2"
            }
        }
    }
    Section {
        SimpleInputPref {
            title = "Test 3"
            summary = "This is a Test 3"
        }
    }
}
```
This is especially useful, when you need to generate your preferences at runtime. You can use loops and conditions as you can see above.

You can optionally pass an object of `SimpleSettingsConfig` to the constructor of your `SimpleSettings` instance, to customize the appearance of the settings activity. The different customization options are listed [#customization](below).

### Provide items with xml file
You also can specify your preference screen [https://developer.android.com/guide/topics/ui/settings#create_a_hierarchy](as an usual xml file):
```xml
<PreferenceScreen
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <PreferenceCategory
        app:key="preference_category"
        app:title="Preference category">

        <Preference
            app:key="preference_test"
            app:title="Test"
            app:summary="This is a test preference"/>

        <SwitchPreferenceCompat
            app:key="test"
            app:defaultValue="true"
            app:title="Test"
            app:summary="This is a test"/>
    </PreferenceCategory>
</PreferenceScreen>
```

to build the settings screen in its default configuration, you can simply call the `show` method of SimpleSettings and pass the prepared xml resource file to it.

```kotlin
SimpleSettings(this@MainActivity).show(R.xml.preferences)
```

## Customization
The library offers a few customization options. For applying those options, you have to pass an object of `SimpleSettingsConfig` to the constructor of your `SimpleSettings` instance.

| Method                            | Description                                                                                                                                    |
|-----------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------|
| `setActivityTitle(String)`        | Sets the toolbar title for the SettingsActivity. The default value is 'Settings', translated to all supported languages                        |
| `setActivityTitle(Context, Int)`  | Sets the toolbar title for the SettingsActivity with a string resource. The default value is 'Settings', translated to all supported languages |
| `displayHomeAsUpEnabled(Boolean)` | Enables or disables the arrow icon in the top left corner of the activity to return to the calling activity. Default is `true`                 |
| `showResetOption(Boolean)`        | Enables or disables an options menu item for resetting all preferences to the default values. Default is `false`                               |

If you miss a customization option, please let us know, by opening an issue.

## Supported languages
Here are the currently supported languages for this library.

- English
- German

New translations are highly appreciated. If you want to translate the lib, please open a pr.

## Contribute to the project
If you want to contribute to this project, please feel free to send us a pull request.

## Credits
Thanks to all contributors and translators!

© Marc Auberer 2020