package com.tech.ab.butler.elements;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.WindowManager;

import java.util.Calendar;

/**
 * Created by Ankita on 26-Jan-17.
 */

public class TimePickerDialogFragment extends DialogFragment {

    private Context context;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;

    public TimePickerDialogFragment() {
    }

    public TimePickerDialogFragment(TimePickerDialog.OnTimeSetListener callback, Context context) {
        mTimeSetListener = callback;
        this.context = context;
    }
    TimePickerDialog timePickerDialog;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();

        timePickerDialog = new TimePickerDialog(getContext(), mTimeSetListener, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), true);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        return timePickerDialog;
    }
}
