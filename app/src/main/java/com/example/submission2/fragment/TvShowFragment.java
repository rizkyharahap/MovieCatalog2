package com.example.submission2.fragment;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.submission2.R;
import com.example.submission2.adapter.TvShowAdapter;
import com.example.submission2.model.TvShow;

import java.util.ArrayList;

public class TvShowFragment extends Fragment {
    private TypedArray tvPoster;
    private String[] tvTitle
            , tvYear
            , tvDescription
            , tvGenre;
    private ArrayList<TvShow> tvShows;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tv, container, false);

        resource();
        itemList();

//        inialisasi adapter
        TvShowAdapter tvShowAdapter = new TvShowAdapter(tvShows, getActivity());

//        show recycler view
        RecyclerView recyclerView = rootView.findViewById(R.id.list_tv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(tvShowAdapter);
        recyclerView.setHasFixedSize(true);

        return rootView;
    }

    private void itemList() {

        tvShows = new ArrayList<>();

        for (int i = 0; i <tvTitle.length; i++) {
            TvShow tvShow = new TvShow();
            tvShow.setPoster(tvPoster.getResourceId(i, -1));
            tvShow.setTitle(tvTitle[i]);
            tvShow.setYear(tvYear[i]);
            tvShow.setGenre(tvGenre[i]);
            tvShow.setDescription(tvDescription[i]);
            tvShows.add(tvShow);
        }
    }

    private void resource() {
        tvPoster = getResources().obtainTypedArray(R.array.movie_poster);
        tvTitle = getResources().getStringArray(R.array.movie_title);
        tvYear = getResources().getStringArray(R.array.movie_rating);
        tvGenre = getResources().getStringArray(R.array.movie_year);
        tvDescription = getResources().getStringArray(R.array.movie_release_date);
    }

}