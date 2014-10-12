package com.codess.microsoft.blackgirlscode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julia on 10/11/14.
 */
public class EventListFragment extends ListFragment
{
  private static final String TAG = "EventListFragment";

  private ArrayList<Event> mEvents;

  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    getActivity().setTitle(R.string.events_title);

    mEvents = EventsBook.get(getActivity()).getEvents();

    EventAdapter adapter = new EventAdapter(mEvents);
    setListAdapter(adapter);
  }

  @Override
  public void onListItemClick(ListView listView, View view, int position, long id)
  {
    Event event = ((EventAdapter) getListAdapter()).getItem(position);
    Log.d(TAG, event.getTitle() + " was clicked");

    // Start EventActivity
    Intent intent = new Intent(getActivity(), EventActivity.class);
    intent.putExtra(EventFragment.EXTRA_EVENT_ID, event.getId());
    startActivity(intent);
  }

  public List<Event> getEvents()
  {
    return mEvents;
  }

  /**
   * Reload the list.
   */
  @Override
  public void onResume()
  {
    super.onResume();
    ((EventAdapter) getListAdapter()).notifyDataSetChanged();
  }

  @Override
  public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
  {
    super.onCreateOptionsMenu(menu, inflater);
  }

  public static EventListFragment newInstance()
  {
    Bundle args = new Bundle();

    EventListFragment fragment = new EventListFragment();
    fragment.setArguments(args);
    return fragment;
  }

  private class EventAdapter extends ArrayAdapter<Event>
  {
    public EventAdapter(ArrayList<Event> events)
    {
      // 0 is the layout ID; it will be non-0 if
      // using a predefined layout.
      super(getActivity(), 0, events);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
      // If we weren't given a view, inflate one.
      if (convertView == null)
      {
        convertView = getActivity().getLayoutInflater()
            .inflate(R.layout.list_event, null);
      }

      // Configure the view for this Event
      Event event = getItem(position);

      TextView titleTextView =
          (TextView) convertView.findViewById(R.id.event_list_item_titleTextView);
      titleTextView.setText(event.getTitle());
      TextView dateTextView =
          (TextView) convertView.findViewById(R.id.event_list_item_dateTextView);
      dateTextView.setText(event.getEventDate().toString());

      Log.d(TAG, "View id = " + convertView.getId());

      return convertView;
    }
  }
}
