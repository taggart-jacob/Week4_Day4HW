package com.example.week4_day4hw;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

public class CelebListFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    public CelebListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CelebListFragment newInstance() {
        CelebListFragment fragment = new CelebListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<CelebrityModel> models = new ArrayList<>();
        View view = inflater.inflate(R.layout.fragment_celebrity_list, container, false);
        models.add(new CelebrityModel("Steve Buscemi", "62", "Actor", R.drawable.tony_blundetto));
        models.add(new CelebrityModel("Trey Anastasio", "54", "Musician", R.drawable.trey_anastasio));
        models.add(new CelebrityModel("Mike Gordon", "54", "Musician", R.drawable.cactus));
        models.add(new CelebrityModel("Michael Imperioli", "53", "Actor", R.drawable.christopher));
        models.add(new CelebrityModel("Jon Fishman", "54", "Musician", R.drawable.jon_fishman));
        models.add(new CelebrityModel("Tony Sirico", "76", "Actor", R.drawable.paullie));
        models.add(new CelebrityModel("James Gandolfini", "Deceased", "Actor", R.drawable.tony_soprano));
        models.add(new CelebrityModel("Page McConnell", "56", "Musician", R.drawable.chairman_of_the_boards));
        models.add(new CelebrityModel("Steven Van Zandt", "68", "Actor/Musician", R.drawable.silvio));



        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new CelebrityRecyclerViewAdapter(models, mListener));
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        void sendCelebrityToDetail(CelebrityModel item);
    }
}
