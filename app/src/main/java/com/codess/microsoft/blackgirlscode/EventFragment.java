package com.codess.microsoft.blackgirlscode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;
import java.util.UUID;

/**ß
 * Created by Julia on 10/11/14.
 */
public class EventFragment extends Fragment
{
  private static final String TAG = "EventFragment";

  public static final String EXTRA_EVENT_ID =
      "com.codess.android.blackgirlscode.event_id";

  public static final int REQUEST_DATE = 0;
  public static final int REQUEST_TIME = 1;

  public static final String DIALOG_DATE = "date";

  private Event mEvent;
  private TextView mTitleField;
  private Button mDateButton;

  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    UUID eventId = (UUID)getArguments().
        getSerializable(EXTRA_EVENT_ID);

    mEvent = EventsBook.get(getActivity()).getEvent(eventId);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState)
  {
    // Inflate the view with the fragment layout, the parent of the view, false indicating
    // to not add this view to the view's parent; false is passed because you will add the
    // view in the activity's code.
    View view = inflater.inflate(R.layout.event_fragment, parent, false);

    mTitleField = (TextView) view.findViewById(R.id.event_title);
    mTitleField.setText(mEvent.getTitle());

    mDateButton = (Button)view.findViewById(R.id.event_date);
    updateDate();

    return view;
  }

  public static EventFragment newInstance(UUID eventId)
  {
    Bundle args = new Bundle();
    args.putSerializable(EXTRA_EVENT_ID, eventId);

    EventFragment fragment = new EventFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data)
  {
    if (resultCode != Activity.RESULT_OK)
    {
      return;
    }

    if (requestCode == REQUEST_DATE)
    {
      Date date = (Date) data.getSerializableExtra(DateFragment.EXTRA_DATE);
      mEvent.setEventDate(date);
      updateDate();
    }

    if (requestCode == REQUEST_TIME)
    {
      Date date = (Date) data.getSerializableExtra(DateFragment.EXTRA_DATE);
      mEvent.setEventDate(date);
      updateDate();
    }
  }

  private void updateDate()
  {
    mDateButton.setText(mEvent.getEventDate().toString());
  }
}
