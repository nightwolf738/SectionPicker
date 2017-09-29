package com.ehamutcu.sectionpickersample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ehamutcu.sectionpicker.SectionPicker;
import com.ehamutcu.sectionpickersample.adapter.CountriesRecyclerViewAdapter;
import com.ehamutcu.sectionpickersample.model.CountriesRecyclerViewModel;
import com.ehamutcu.sectionpickersample.model.Country;
import com.ehamutcu.sectionpickesample.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CountriesRecyclerViewAdapter.RowClickListener {

    private List<CountriesRecyclerViewModel> countriesRecyclerViewModels;
    private RecyclerView recyclerViewCountries;
    private SectionPicker sectionPickerCountries;
    private TextView textViewSection;
    private CountriesRecyclerViewAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSection = (TextView) findViewById(R.id.textview_section);
        sectionPickerCountries = (SectionPicker) findViewById(R.id.sectionpicker_countries);
        recyclerViewCountries = (RecyclerView) findViewById(R.id.recyclerview_countries);

        setRecyclerViewLayoutManager();
        populateRecyclerView();
        initSectionPicker();
    }

    public void setRecyclerViewLayoutManager() {
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewCountries.setLayoutManager(linearLayoutManager);
    }

    private void populateRecyclerView() {
        List<Country> countries = new ArrayList<>();

        // TODO DUMMY
        countries.add(new Country("ATurkey", "TR"));
        countries.add(new Country("ATurkey", "TR"));
        countries.add(new Country("ATurkey", "TR"));
        countries.add(new Country("ATurkey", "TR"));
        countries.add(new Country("ATurkey", "TR"));
        countries.add(new Country("ATurkey", "TR"));
        countries.add(new Country("ATurkey", "TR"));
        countries.add(new Country("ATurkey", "TR"));

        countries.add(new Country("BTurkey", "TR"));
        countries.add(new Country("BTurkey", "TR"));
        countries.add(new Country("BTurkey", "TR"));
        countries.add(new Country("BTurkey", "TR"));
        countries.add(new Country("BTurkey", "TR"));
        countries.add(new Country("BTurkey", "TR"));
        countries.add(new Country("BTurkey", "TR"));
        countries.add(new Country("BTurkey", "TR"));
        countries.add(new Country("BTurkey", "TR"));
        countries.add(new Country("BTurkey", "TR"));

        countries.add(new Country("CTurkey", "TR"));
        countries.add(new Country("CTurkey", "TR"));
        countries.add(new Country("CTurkey", "TR"));
        countries.add(new Country("CTurkey", "TR"));
        countries.add(new Country("CTurkey", "TR"));
        countries.add(new Country("CTurkey", "TR"));
        countries.add(new Country("CTurkey", "TR"));
        countries.add(new Country("CTurkey", "TR"));

        countries.add(new Country("DTurkey", "TR"));
        countries.add(new Country("DTurkey", "TR"));
        countries.add(new Country("DTurkey", "TR"));
        countries.add(new Country("DTurkey", "TR"));
        countries.add(new Country("DTurkey", "TR"));
        countries.add(new Country("DTurkey", "TR"));
        countries.add(new Country("DTurkey", "TR"));
        countries.add(new Country("DTurkey", "TR"));

        countries.add(new Country("ETurkey", "TR"));
        countries.add(new Country("ETurkey", "TR"));
        countries.add(new Country("ETurkey", "TR"));
        countries.add(new Country("ETurkey", "TR"));
        countries.add(new Country("ETurkey", "TR"));
        countries.add(new Country("ETurkey", "TR"));
        countries.add(new Country("ETurkey", "TR"));
        countries.add(new Country("ETurkey", "TR"));

        countries.add(new Country("FTurkey", "TR"));
        countries.add(new Country("FTurkey", "TR"));
        countries.add(new Country("FTurkey", "TR"));
        countries.add(new Country("FTurkey", "TR"));
        countries.add(new Country("FTurkey", "TR"));
        countries.add(new Country("FTurkey", "TR"));
        countries.add(new Country("FTurkey", "TR"));
        countries.add(new Country("FTurkey", "TR"));

        countries.add(new Country("GTurkey", "TR"));
        countries.add(new Country("GTurkey", "TR"));
        countries.add(new Country("GTurkey", "TR"));
        countries.add(new Country("GTurkey", "TR"));
        countries.add(new Country("GTurkey", "TR"));
        countries.add(new Country("GTurkey", "TR"));
        countries.add(new Country("GTurkey", "TR"));
        countries.add(new Country("GTurkey", "TR"));

        countries.add(new Country("HTurkey", "TR"));
        countries.add(new Country("HTurkey", "TR"));
        countries.add(new Country("HTurkey", "TR"));
        countries.add(new Country("HTurkey", "TR"));
        countries.add(new Country("HTurkey", "TR"));
        countries.add(new Country("HTurkey", "TR"));
        countries.add(new Country("HTurkey", "TR"));
        countries.add(new Country("HTurkey", "TR"));

        countries.add(new Country("ITurkey", "TR"));
        countries.add(new Country("ITurkey", "TR"));
        countries.add(new Country("ITurkey", "TR"));
        countries.add(new Country("ITurkey", "TR"));
        countries.add(new Country("ITurkey", "TR"));
        countries.add(new Country("ITurkey", "TR"));
        countries.add(new Country("ITurkey", "TR"));
        countries.add(new Country("ITurkey", "TR"));

        countries.add(new Country("JTurkey", "TR"));
        countries.add(new Country("JTurkey", "TR"));
        countries.add(new Country("JTurkey", "TR"));
        countries.add(new Country("JTurkey", "TR"));
        countries.add(new Country("JTurkey", "TR"));
        countries.add(new Country("JTurkey", "TR"));
        countries.add(new Country("JTurkey", "TR"));
        countries.add(new Country("JTurkey", "TR"));

        countries.add(new Country("KTurkey", "TR"));
        countries.add(new Country("KTurkey", "TR"));
        countries.add(new Country("KTurkey", "TR"));
        countries.add(new Country("KTurkey", "TR"));
        countries.add(new Country("KTurkey", "TR"));
        countries.add(new Country("KTurkey", "TR"));
        countries.add(new Country("KTurkey", "TR"));
        countries.add(new Country("KTurkey", "TR"));

        countries.add(new Country("LTurkey", "TR"));
        countries.add(new Country("LTurkey", "TR"));
        countries.add(new Country("LTurkey", "TR"));
        countries.add(new Country("LTurkey", "TR"));
        countries.add(new Country("LTurkey", "TR"));
        countries.add(new Country("LTurkey", "TR"));
        countries.add(new Country("LTurkey", "TR"));
        countries.add(new Country("LTurkey", "TR"));

        countries.add(new Country("MTurkey", "TR"));
        countries.add(new Country("MTurkey", "TR"));
        countries.add(new Country("MTurkey", "TR"));
        countries.add(new Country("MTurkey", "TR"));
        countries.add(new Country("MTurkey", "TR"));
        countries.add(new Country("MTurkey", "TR"));
        countries.add(new Country("MTurkey", "TR"));
        countries.add(new Country("MTurkey", "TR"));

        countries.add(new Country("NTurkey", "TR"));
        countries.add(new Country("NTurkey", "TR"));
        countries.add(new Country("NTurkey", "TR"));
        countries.add(new Country("NTurkey", "TR"));
        countries.add(new Country("NTurkey", "TR"));
        countries.add(new Country("NTurkey", "TR"));
        countries.add(new Country("NTurkey", "TR"));
        countries.add(new Country("NTurkey", "TR"));

        countries.add(new Country("OTurkey", "TR"));
        countries.add(new Country("OTurkey", "TR"));
        countries.add(new Country("OTurkey", "TR"));
        countries.add(new Country("OTurkey", "TR"));
        countries.add(new Country("OTurkey", "TR"));
        countries.add(new Country("OTurkey", "TR"));
        countries.add(new Country("OTurkey", "TR"));
        countries.add(new Country("OTurkey", "TR"));

        countries.add(new Country("PTurkey", "TR"));
        countries.add(new Country("PTurkey", "TR"));
        countries.add(new Country("PTurkey", "TR"));
        countries.add(new Country("PTurkey", "TR"));
        countries.add(new Country("PTurkey", "TR"));
        countries.add(new Country("PTurkey", "TR"));
        countries.add(new Country("PTurkey", "TR"));
        countries.add(new Country("PTurkey", "TR"));

        countries.add(new Country("RTurkey", "TR"));
        countries.add(new Country("RTurkey", "TR"));
        countries.add(new Country("RTurkey", "TR"));
        countries.add(new Country("RTurkey", "TR"));
        countries.add(new Country("RTurkey", "TR"));
        countries.add(new Country("RTurkey", "TR"));
        countries.add(new Country("RTurkey", "TR"));
        countries.add(new Country("RTurkey", "TR"));

        countries.add(new Country("STurkey", "TR"));
        countries.add(new Country("STurkey", "TR"));
        countries.add(new Country("STurkey", "TR"));
        countries.add(new Country("STurkey", "TR"));
        countries.add(new Country("STurkey", "TR"));
        countries.add(new Country("STurkey", "TR"));
        countries.add(new Country("STurkey", "TR"));
        countries.add(new Country("STurkey", "TR"));

        countries.add(new Country("Turkey", "TR"));
        countries.add(new Country("Turkey", "TR"));
        countries.add(new Country("Turkey", "TR"));
        countries.add(new Country("Turkey", "TR"));
        countries.add(new Country("Turkey", "TR"));
        countries.add(new Country("Turkey", "TR"));
        countries.add(new Country("Turkey", "TR"));
        countries.add(new Country("Turkey", "TR"));

        countries.add(new Country("UTurkey", "TR"));
        countries.add(new Country("UTurkey", "TR"));
        countries.add(new Country("UTurkey", "TR"));
        countries.add(new Country("UTurkey", "TR"));
        countries.add(new Country("UTurkey", "TR"));
        countries.add(new Country("UTurkey", "TR"));
        countries.add(new Country("UTurkey", "TR"));
        countries.add(new Country("UTurkey", "TR"));

        countries.add(new Country("VTurkey", "TR"));
        countries.add(new Country("VTurkey", "TR"));
        countries.add(new Country("VTurkey", "TR"));
        countries.add(new Country("VTurkey", "TR"));
        countries.add(new Country("VTurkey", "TR"));
        countries.add(new Country("VTurkey", "TR"));
        countries.add(new Country("VTurkey", "TR"));
        countries.add(new Country("VTurkey", "TR"));

        countries.add(new Country("YTurkey", "TR"));
        countries.add(new Country("YTurkey", "TR"));
        countries.add(new Country("YTurkey", "TR"));
        countries.add(new Country("YTurkey", "TR"));
        countries.add(new Country("YTurkey", "TR"));
        countries.add(new Country("YTurkey", "TR"));
        countries.add(new Country("YTurkey", "TR"));
        countries.add(new Country("YTurkey", "TR"));

        countries.add(new Country("ZTurkey", "TR"));
        countries.add(new Country("ZTurkey", "TR"));
        countries.add(new Country("ZTurkey", "TR"));
        countries.add(new Country("ZTurkey", "TR"));
        countries.add(new Country("ZTurkey", "TR"));
        countries.add(new Country("ZTurkey", "TR"));
        countries.add(new Country("ZTurkey", "TR"));
        countries.add(new Country("ZTurkey", "TR"));
        // TODO DUMMY END

        adapter = new CountriesRecyclerViewAdapter(transformCountriesForRecyclerView(countries), this, this);
        recyclerViewCountries.setAdapter(adapter);
    }

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

    private List<CountriesRecyclerViewModel> transformCountriesForRecyclerView(List<Country> countries) {
        countriesRecyclerViewModels = new ArrayList<>();
        if ((countries != null) && !countries.isEmpty()) {
            String letter = "";
            for (Country country : countries) {
                String countryLetter = country.getName().substring(0, 1);
                if (TextUtils.isEmpty(letter) || !letter.equals(countryLetter)) {
                    countriesRecyclerViewModels.add(new CountriesRecyclerViewModel(null, countryLetter, CountriesRecyclerViewAdapter.TYPE_LETTER));
                    letter = countryLetter;
                }
                countriesRecyclerViewModels.add(new CountriesRecyclerViewModel(country, null, CountriesRecyclerViewAdapter.TYPE_COUNTRY));
            }
        }
        return countriesRecyclerViewModels;
    }

    @Override
    public void onRowClick(View view, int position) {
        CountriesRecyclerViewModel countriesRecyclerViewModel = countriesRecyclerViewModels.get(position);
        Country country = countriesRecyclerViewModel.getCountry();
        if (country != null) {
            Toast.makeText(this, country.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
