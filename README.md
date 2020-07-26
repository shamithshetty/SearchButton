# SearchButton
[![platform](https://img.shields.io/badge/Platform-Android-yellow.svg?style=flat-square)](https://www.android.com)
[![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat-square)](https://android-arsenal.com/api?level=16s)
 
Search Button is an Android library that can be used to make animated search button.

# Usage
Add it in your root build.gradle at the end of repositories:
```
allprojects {
		allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  
Add the dependency
```
dependencies {
	        implementation 'com.github.shamithshetty:SearchButton:Tag'
	}
  ```
  
## Example Usage 1 (Simple)
### XML

```
    <com.example.searchbutton.SearchButton
        android:id="@+id/btn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:borderWidthSize="5dp"
        app:backColor="#09ef3e"
        app:textColor="#ffffff"
        app:length="200dp"
        app:borderColor="#0e60a7"
        android:layout_marginLeft="20dp">
    </com.example.searchbutton.SearchButton>

```
### Demo with border width 6

<div align="center"><img src="clockpic.gif"/></div>

### Java

```

btn.open(); manually open the search button
btn.close(); manually close the search button
btn.getText(); get textbox value
btn.setText(); set textbox

```

###### Attr of XML
```
<declare-styleable name="TextView">
        <attr name="backColor" format="color|reference"/>
        <attr name="placeHolder" format="string"/>
        <attr name="textColor" format="color|reference" />
        <attr name="borderColor" format="color|reference" />
        <attr name="borderWidthSize" format="dimension" />
        <attr name="textSize" format="dimension" />
        <attr name="length" format="dimension" />
    </declare-styleable>
```
#### functions
```
 public float getTextSize() {
        return textSize;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public int getBackColor() {
        return backColor;
    }

    public void setBackColor(int backColor) {
        this.backColor = backColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(int borderColor) {
        this.borderColor = borderColor;
    }

    public float getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(float borderWidth) {
        this.borderWidth = borderWidth;
    }

    public String getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }

```






###### License
This library is composed by other open source libraries, if used, must include all the license files.

```
Copyright 2020 shamith h shetty

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
