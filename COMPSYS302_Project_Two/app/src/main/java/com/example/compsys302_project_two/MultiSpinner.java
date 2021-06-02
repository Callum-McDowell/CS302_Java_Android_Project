/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell, Woolha's Ivan Andriato
    Date:   June 2021

    Summary

        Adapted from https://www.woolha.com/tutorials/android-multi-select-spinner-example
        Spinner with checkbox format. Creates an alarm dialogue.
*/
package com.example.compsys302_project_two;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

import androidx.appcompat.widget.AlertDialogLayout;
import androidx.appcompat.widget.AppCompatSpinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiSpinner extends AppCompatSpinner implements
        DialogInterface.OnMultiChoiceClickListener {

    List<CategoryType> options;
    boolean[] selections;
    ArrayAdapter adapter;

    Context mContext;

    public MultiSpinner(Context context) {
        super(context);
        mContext = context;

        adapter = new ArrayAdapter(context, android.R.layout.simple_spinner_item);
        super.setAdapter(adapter);
    }

    public MultiSpinner(Context context, AttributeSet attributes) {
        super(context, attributes);
        mContext = context;

        adapter = new ArrayAdapter(context, android.R.layout.simple_spinner_item);
        super.setAdapter(adapter);
    }

    // Perform when an item is selected/unselected
    @Override
    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
        if (selections  != null && which < selections.length) {
            selections[which] = isChecked;

                    //@TODO
        } else {
            throw new IllegalArgumentException("selection out of bounds");
        }
    }
    // Perform when the spinner is opened
    @Override
    public boolean performClick() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        String[] optionsString = new String[options.size()];
        for (int i = 0; i < options.size(); i++) {
            optionsString[i] = options.get(i).name();
        }

        builder.setMultiChoiceItems(optionsString, selections, this);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // When "Ok" is clicked...
                if (mContext instanceof SearchActivity) {
                    ((SearchActivity)mContext).searchAuto();
                }
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                // When clicked outside of...
                if (mContext instanceof SearchActivity) {
                    ((SearchActivity)mContext).searchAuto();
                }
            }
        });

        builder.show();
        return true;
    }
    // Disables changing the adapter
    @Override
    public void setAdapter(SpinnerAdapter adapter) {
        throw new RuntimeException("setAdapter disabled");
    }
    // Set options for multispinner box
    public void setOptions(List<CategoryType> options) {
        this.options = options;
        selections = new boolean[this.options.size()];
        Arrays.fill(selections, false);

        // Set tooltip
        adapter.clear();
        adapter.add("Categories");
    }
    // Get options that have been selected
    public List<CategoryType> getSelectedOptions() {
        List<CategoryType> selectedOptions = new ArrayList<CategoryType>();

        for (int i = 0; i < options.size(); i++) {
            if (selections[i]) {
                selectedOptions.add(options.get(i));
            }
        }
        return selectedOptions;
    }

}
