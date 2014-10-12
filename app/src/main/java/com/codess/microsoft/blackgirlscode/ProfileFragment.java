package com.codess.microsoft.blackgirlscode;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by Julia on 10/11/14.
 */
public class ProfileFragment extends Fragment
{
  private static final String TAG = "ProfileFragment";

  public static final String EXTRA_PROFILE_ID =
      "com.codess.android.blackgirlscode.profile_id";

  public static final String DIALOG_DATE = "date";

  private Person mProfile;
  private ImageView mPersonIcon;
  private TextView mPersonName;
  private TextView mPersonStatus;
  private boolean mIsStudent;

  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    UUID personId = (UUID)getArguments().
        getSerializable(EXTRA_PROFILE_ID);

    mProfile = ProfilesBook.get(getActivity()).getProfile(personId);
    mIsStudent = personId.timestamp() % 2 == 0;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState)
  {
    // Inflate the view with the fragment layout, the parent of the view, false indicating
    // to not add this view to the view's parent; false is passed because you will add the
    // view in the activity's code.
    View view = inflater.inflate(R.layout.profile_fragment, parent, false);

    mPersonName = (TextView) view.findViewById(R.id.profile_list_item_name);
    mPersonName.setText(mProfile.getName());

    mPersonStatus = (TextView) view.findViewById(R.id.profile_list_item_status);
    mPersonStatus.setText("Online");

    mPersonIcon = (ImageView)view.findViewById(R.id.profile_icon);
    //mPersonIcon.setImageResource();

    if (mIsStudent)
    {
      mPersonIcon.setBackgroundColor(Color.GREEN);
    }
    else
    {
      mPersonIcon.setBackgroundColor(Color.BLUE);
    }

    return view;
  }

  public static EventFragment newInstance(UUID eventId)
  {
    Bundle args = new Bundle();
    args.putSerializable(EXTRA_PROFILE_ID, eventId);

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
  }
}
