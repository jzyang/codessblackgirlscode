package com.codess.microsoft.blackgirlscode;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Julia on 10/11/14.
 */
public class DateFragment extends DialogFragment
{
  public static final String EXTRA_DATE =
      "com.codess.microsoft.blackgirlscode.date";

  private Date mDate;

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState)
  {
    View view = getActivity().getLayoutInflater().
        inflate(R.layout.dialog_date, null);

    mDate = (Date) getArguments().getSerializable(EXTRA_DATE);

    // Create a Calendar to get the year, month and day
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(mDate);
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    int month = calendar.get(Calendar.MONTH);
    int year = calendar.get(Calendar.YEAR);

    DatePicker datePicker = (DatePicker) view.findViewById(R.id.dialog_datePicker);
    datePicker.init(year, month, day, new DatePicker.OnDateChangedListener()
    {
      @Override
      public void onDateChanged(DatePicker view,
                                final int year, final int monthOfYear, final int dayOfMonth)
      {
        // Translate year, month, day into a Date object using a calendar
        mDate = new GregorianCalendar(year, monthOfYear, dayOfMonth).getTime();

        // Update argument to preserve selected value on rotation
        getArguments().putSerializable(EXTRA_DATE, mDate);
      }
    });

    return new AlertDialog.Builder(getActivity()).
        setView(view).
        setTitle(R.string.date_picker_title).
        setPositiveButton(android.R.string.ok,
            new DialogInterface.OnClickListener()
            {
              @Override
              public void onClick(DialogInterface dialog, int which)
              {
                sendResult(Activity.RESULT_OK);
              }
            }).
        create();
  }

  public static DateFragment newInstance(Date date)
  {
    Bundle args = new Bundle();
    args.putSerializable(EXTRA_DATE, date);

    DateFragment fragment = new DateFragment();
    fragment.setArguments(args);

    return fragment;
  }

  private void sendResult(int resultCode)
  {
    if (getTargetFragment() == null)
    {
      return;
    }

    Intent intent = new Intent();
    intent.putExtra(EXTRA_DATE, mDate);

    getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
  }
}
