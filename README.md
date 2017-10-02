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

Suppose we have a RecyclerView. We need to implement SectionIndexer in our RecyclerView.Adapter:

```java
public class CountriesRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements SectionIndexer {
public static final int TYPE_COUNTRY = 0;
public static final int TYPE_LETTER = 1;

private List<CountriesRecyclerViewModel> countries;
...
}
```

```TYPE_COUNTRY``` and ```TYPE_LETTER``` are view types. You can see it in demo. 

SectionIndexer will implement 3 methods: ```getSections(), getPositionForSection(int sectionIndex), getSectionForPosition(int position)```. We will need all of them:

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

- ```getSections()``` determines the section list which will show up at the right of the screen. Our sections are listed in ```countries``` with the view type ```TYPE_LETTER```.

- ```getPositionForSection(int sectionIndex)``` returns position of the section in the list. It uses char values to determine the right position of the section

- ```getSectionForPosition(int position)``` returns section position in the list. We need to find the right section by using position parameter
