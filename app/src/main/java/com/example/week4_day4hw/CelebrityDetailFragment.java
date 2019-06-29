package com.example.week4_day4hw;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CelebrityDetailFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    TextView tvCelebrityName;
    TextView tvCelebrityAge;
    TextView tvCelebrityProfession;
    ImageView imgCeleb;
    TextView tvCaption;

    private OnFragmentInteractionListener mListener;

    public CelebrityDetailFragment() {
        // Required empty public constructor
    }

    public static CelebrityDetailFragment newInstance() {
        CelebrityDetailFragment fragment = new CelebrityDetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_celebrity_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvCelebrityName = view.findViewById(R.id.tvCelebName);
        tvCelebrityAge = view.findViewById(R.id.tvCelebAge);
        tvCelebrityProfession = view.findViewById(R.id.tvCelebProfession);
        imgCeleb = view.findViewById(R.id.imgCeleb);
        tvCaption = view.findViewById(R.id.tvCaption);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setCelebDetail(CelebrityModel item){
        tvCaption.setVisibility(View.INVISIBLE);
        tvCelebrityName.setText(item.getName());
        tvCelebrityAge.setText(item.getAge());
        tvCelebrityProfession.setText(item.getProfession());
        imgCeleb.setImageResource(item.getPicture());
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
