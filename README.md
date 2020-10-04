Case Conversion
===============

A plugin for JetBrain IDEs to convert between cases.

The plugin provides actions to convert to these cases:

- `snake_case`
- `dash-case`
- `camelCase`
- `PascalCase`
- `SCREAMING_SNAKE_CASE`
- `UPPER CASE`
- `lower case`
- `fLIP cASE`
- `Title Case`
- `Sentence case`
- `dot.case`

The Plugin was inspired by the [Case Conversion Plugin for SublimeText](https://packagecontrol.io/packages/Case%20Conversion).

How to use
----------

Select the text you want to convert and then invoke the desired action.
There are multiple ways to do this:

- Use the menu bar: The actions of this plugin can be found in
  "Edit" > "Convert Case"
- Use the Find Action feature: Bring up the "Find Action" search dialog
  (default keyboard shortcut is Ctrl+Shift+A) and type the name of the
  desired convert action (or type "Convert Case" to see all actions).
  Tip: This search uses fuzzy matching so you can just type "camcas" for
  "Convert Case: camelCase".
- Create a keyboard shortcut: Open Settings > Keymap and search for
  "Convert Case" and create a keyboard shortcut for the desired action.

Configuration
-------------

The plugin has a configuration page in the "Settings" window of the IDE.
You can find it under Tools > Case conversion.

Currently there is only one configuration option:

- **Treat newline as**: Can be either "White space" in which case selected
  line breaks will be treated like every other white space (i.e. as a word
  separator), or it can be "Record separator" in which case each line will
  be converted individually. The default is "White space".

Contributing
------------

You can send patches, bugreports or feature-requests to laria-code at laria dot me. You can also go to the mirrored GitHub repo (<https://github.com/silvasur/idea_caseconv>) and create a pull request.
