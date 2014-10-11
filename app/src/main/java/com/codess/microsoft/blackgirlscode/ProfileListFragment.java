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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Julia on 10/11/14.
 */
public class ProfileListFragment extends ListFragment
{
  private static final String TAG = "ProfileListFragment";

  private List<Person> mProfiles;

  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    getActivity().setTitle(R.string.events_title);

    mProfiles = ProfilesBook.get(getActivity()).getProfiles();

    ProfileAdapter adapter = new ProfileAdapter(mProfiles);
    setListAdapter(adapter);
  }

  @Override
  public void onListItemClick(ListView listView, View view, int position, long id)
  {
    Person person = ((ProfileAdapter) getListAdapter()).getItem(position);
    Log.d(TAG, person.getName() + " was clicked");

    // Start EventActivity
    Intent intent = new Intent(getActivity(), ProfilePageActivity.class);
    intent.putExtra(ProfileFragment.EXTRA_PROFILE_ID, person.getId());
    startActivity(intent);
  }

  public List<Person> getProfiles()
  {
    return mProfiles;
  }

  /**
   * Reload the list.
   */
  @Override
  public void onResume()
  {
    super.onResume();
    ((ProfileAdapter) getListAdapter()).notifyDataSetChanged();
  }

  @Override
  public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
  {
    super.onCreateOptionsMenu(menu, inflater);
  }

  private class ProfileAdapter extends ArrayAdapter<Person>
  {
    public ProfileAdapter(List<Person> people)
    {
      // 0 is the layout ID; it will be non-0 if
      // using a predefined layout.
      super(getActivity(), 0, people);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
      // If we weren't given a view, inflate one.
      if (convertView == null)
      {
        convertView = getActivity().getLayoutInflater()
            .inflate(R.layout.list_profiles, null);
      }

      // Configure the view for this Event
      Person person = getItem(position);

      TextView nameTextView =
          (TextView) convertView.findViewById(R.id.profile_list_item_name);
      nameTextView.setText(person.getName());
      TextView statusTextView =
          (TextView) convertView.findViewById(R.id.profile_list_item_status);
      statusTextView.setText("online");
      ImageView iconImageView =
          (ImageView) convertView.findViewById(R.id.profile_icon);

      Log.d(TAG, "View id = " + convertView.getId());

      return convertView;
    }
  }
}
