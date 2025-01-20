# EllipsizingTextView

A custom `TextView` for Android that ellipsizes each line individually.

## Features
- Ellipsize each line of text separately.
- Support for multiline text.

## How to Use
1. Add the library to your project:
   ```gradle
   implementation 'com.example:ellipsizingtextview:1.0.0'
2. Use EllipsizingTextView in your layout example:
   ```
   <com.example.ellipsizetextview.EllipsizeTextView
        android:id="@+id/twoLineText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:maxLines="2"
        android:ellipsize="end"
        android:singleLine="false"
        android:lines="2"
        android:padding="16dp"
        android:text="This is a long line 1 that ncscseeds  to  be truncated
         This is a long line 2 that also needs truncation"
        android:textAppearance="?attr/textAppearanceBody1" />

[![](https://jitpack.io/v/SyedAbdullahHashmi/Ellipsize_TextView.svg)](https://jitpack.io/#SyedAbdullahHashmi/Ellipsize_TextView)
