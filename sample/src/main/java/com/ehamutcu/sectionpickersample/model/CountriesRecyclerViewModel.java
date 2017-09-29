package com.ehamutcu.sectionpickersample.model;

import android.support.annotation.Nullable;

/**
 * Created by EgemenH on 02.06.2017.
 */

public class CountriesRecyclerViewModel {
    private Country country;
    private String letter;
    private int type;

    public CountriesRecyclerViewModel(@Nullable Country country, String letter, int type) {
        this.country = country;
        this.letter = letter;
        this.type = type;
    }

    @Nullable
    public Country getCountry() {
        return country;
    }

    public String getLetter() {
        return letter;
    }

    public int getType() {
        return type;
    }
}
