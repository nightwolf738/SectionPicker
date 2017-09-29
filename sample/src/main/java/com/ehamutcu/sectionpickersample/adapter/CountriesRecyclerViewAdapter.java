package com.ehamutcu.sectionpickersample.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.ehamutcu.sectionpickersample.model.CountriesRecyclerViewModel;
import com.ehamutcu.sectionpickersample.model.Country;
import com.ehamutcu.sectionpickesample.R;
import com.jwang123.flagkit.FlagKit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EgemenH on 02.06.2017.
 */

public class CountriesRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements SectionIndexer {
    public static final int TYPE_COUNTRY = 0;
    public static final int TYPE_LETTER = 1;

    private List<CountriesRecyclerViewModel> countries;
    private Context context;
    private final RowClickListener rowClickListener;

    public CountriesRecyclerViewAdapter(@NonNull List<CountriesRecyclerViewModel> countries, @NonNull Context context, @NonNull RowClickListener rowClickListener) {
        this.countries = countries;
        this.context = context;
        this.rowClickListener = rowClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        switch (viewType) {
            case TYPE_COUNTRY: {
                View view = LayoutInflater.from(context).inflate(R.layout.row_recyclerview_country, parent, false);
                final CountryViewHolder viewHolder = new CountryViewHolder(view);

                viewHolder.textViewCountry.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = viewHolder.getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            rowClickListener.onRowClick(v, position);
                        }
                    }
                });

                return viewHolder;
            }
            case TYPE_LETTER: {
                View view = LayoutInflater.from(context).inflate(R.layout.row_recyclerview_country, parent, false);
                return new LetterViewHolder(view);
            }
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CountriesRecyclerViewModel countriesRecyclerViewModel = countries.get(position);
        if (countriesRecyclerViewModel != null) {
            switch (getItemViewType(position)) {
                case TYPE_COUNTRY: {
                    Country country = countriesRecyclerViewModel.getCountry();
                    if (country != null) {
                        ((CountryViewHolder) holder).bindTo(countriesRecyclerViewModel.getCountry(), context);
                    }
                    break;
                }
                case TYPE_LETTER: {
                    ((LetterViewHolder) holder).bindTo(countriesRecyclerViewModel.getLetter());
                    break;
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return (countries != null) ? countries.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        CountriesRecyclerViewModel country = countries.get(position);
        if (country != null) {
            return country.getType();
        }
        return super.getItemViewType(position);
    }

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

    public static class CountryViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCountry;

        public CountryViewHolder(View itemView) {
            super(itemView);
            textViewCountry = (TextView) itemView.findViewById(R.id.textview_country);
        }

        public void bindTo(@NonNull Country country, @NonNull Context context) {
            textViewCountry.setText(country.getName());
            textViewCountry.setCompoundDrawablesWithIntrinsicBounds(FlagKit.drawableWithFlag(context, country.getCountryCode().toLowerCase()), null, null, null);
        }
    }

    public static class LetterViewHolder extends RecyclerView.ViewHolder {

        TextView textViewLetter;

        public LetterViewHolder(View itemView) {
            super(itemView);
            textViewLetter = (TextView) itemView.findViewById(R.id.textview_country);
        }

        public void bindTo(@NonNull String letter) {
            textViewLetter.setText(letter);
        }
    }

    public interface RowClickListener {
        void onRowClick(View view, int position);
    }
}