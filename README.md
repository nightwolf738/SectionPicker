# SectionPicker
A Custom Android view for fast scroll with sections in lists. It uses [SectionIndexer](https://developer.android.com/reference/android/widget/SectionIndexer.html) android widget. It is nice to have in our lists with large size like contacts or a country list.

## Demo

![Demo](/art/demo.gif?raw=true)

## Download

Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency in your build.gradle in the app module:
```gradle
dependencies {
    compile 'com.github.egemenhamutcu:SectionPicker:1.0.0'
}
```

## Usage

Suppose we have a ```RecyclerView```. We need to implement ```SectionIndexer``` in our ```RecyclerView.Adapter```:

```java
public class CountriesRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements SectionIndexer {
public static final int TYPE_COUNTRY = 0;
public static final int TYPE_LETTER = 1;

private List<CountriesRecyclerViewModel> countries;
...
}
```

```TYPE_COUNTRY``` and ```TYPE_LETTER``` are view types. You can see it in demo. 

```SectionIndexer``` will implement 3 methods: ```getSections(), getPositionForSection(int sectionIndex), getSectionForPosition(int position)```. We will need all of them:

```java
@Override
public Object[] getSections() {
    List<String> sectionList = new ArrayList<>();

    for (CountriesRecyclerViewModel country : countries) {
        if (country.getType() == TYPE_LETTER) {
            sectionList.add(country.getLetter());
        }
    }

    return sectionList.toArray();
}

@Override
public int getPositionForSection(int sectionIndex) {
    for (int i = 0, size = countries.size(); i < size; i++) {
        CountriesRecyclerViewModel countriesRecyclerViewModel = countries.get(i);
        if (countriesRecyclerViewModel.getType() == TYPE_LETTER) {
            String sortStr = countriesRecyclerViewModel.getLetter();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == sectionIndex) {
                return i;
            }
        }
    }

    return -1;
}

@Override
public int getSectionForPosition(int position) {
    int realSize = getItemCount();
    if (position >= realSize) {
        position = realSize - 1;
    }

    CountriesRecyclerViewModel countriesRecyclerViewModel = countries.get(position);
    Object[] sectionArray = getSections();

    String letter = "";
    switch (countriesRecyclerViewModel.getType()) {
        case TYPE_COUNTRY: {
            Country country = countriesRecyclerViewModel.getCountry();
            if (country != null) {
                letter = country.getName().substring(0, 1);
            }
            break;
        }
        case TYPE_LETTER: {
            letter = countriesRecyclerViewModel.getLetter();
            break;
        }
    }

    for (int i = 0; i < sectionArray.length; i++) {
        if (sectionArray[i].toString().equals(letter)) {
            return i;
        }
    }
    return -1;
}
```

- ```getSections()``` determines the section list which will show up at the right of the screen. Our sections are listed in ```countries``` with the view type of ```TYPE_LETTER```.

- ```getPositionForSection(int sectionIndex)``` returns position of the section in the list. It uses char values to determine the right position of the section

- ```getSectionForPosition(int position)``` returns section position in the list. We need to find the right section by using position parameter

We can add SectionPicker in our xml layout like this:

```xml
<com.ehamutcu.sectionpicker.SectionPicker
        android:id="@+id/sectionpicker_countries"
        android:layout_width="26dp"
        android:layout_height="match_parent"
        android:layout_alignParentEnd="true"
        android:layout_alignParentRight="true"
        app:chosenColor="@android:color/holo_red_dark"
        app:chosenStyle="bold"
        app:textColor="@android:color/black"
        app:textSize="12sp" />
```

```app``` attributes are optional:
- ```textColor, textSize```: You can style text attributes with these
- ```chosenColor, chosenStyle```: When you slide your finger on sections, the chosen one can be styled by these attributes

Now we init the SectionPicker like this:

```java
private void initSectionPicker() {
    Object[] sectionsAsObject = adapter.getSections();
    String[] sections = Arrays.copyOf(sectionsAsObject, sectionsAsObject.length, String[].class);

    sectionPickerCountries.setTextViewIndicator(textViewSection);
    sectionPickerCountries.setSections(sections);
    sectionPickerCountries.setOnTouchingLetterChangedListener(new SectionPicker.OnTouchingLetterChangedListener() {
        @Override
        public void onTouchingLetterChanged(String s) {
            int position = adapter.getPositionForSection(s.charAt(0));

            if (position != -1) {
                linearLayoutManager.scrollToPositionWithOffset(position, 0);
            }
        }
    });
}
```

You may be confused of ```setTextViewIndicator(textViewSection)```. This method is optional. You can add any ```TextView``` to the ```SectionPicker```. It will show up when you slide your finger on sections. Please see demo.

To bind ```SectionPicker``` and ```RecyclerView``` we get the section array from adapter, and call ```setSections(sections)``` in ```SectionPicker```.

To enable fast scroll we need to implement ```SectionPicker.OnTouchingLetterChangedListener()```. It will give us a string containing the section that we are touching. We will use the string to find and scroll to the RecyclerView position of the chosen section.

## License
```
Copyright 2017 Egemen Hamutçu

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
