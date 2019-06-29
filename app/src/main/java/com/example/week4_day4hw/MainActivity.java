package com.example.week4_day4hw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CelebListFragment.OnListFragmentInteractionListener, CelebrityDetailFragment.OnFragmentInteractionListener {

    FragmentManager fragmentManager;
    CelebListFragment celebListFragment;
    CelebrityDetailFragment celebrityDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        celebListFragment = CelebListFragment.newInstance();
        celebrityDetailFragment = CelebrityDetailFragment.newInstance();

        fragmentManager.beginTransaction().add(R.id.frmHolderCelebList, celebListFragment).commit();
        fragmentManager.beginTransaction().add(R.id.frmHolderCelebDetails, celebrityDetailFragment).commit();
    }

    @Override
    public void sendCelebrityToDetail(CelebrityModel item) {
        celebrityDetailFragment.setCelebDetail(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
