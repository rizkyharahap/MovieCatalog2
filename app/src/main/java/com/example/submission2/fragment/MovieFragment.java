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
import com.example.submission2.adapter.MovieAdapter;
import com.example.submission2.model.Movie;

import java.util.ArrayList;

public class MovieFragment extends Fragment {

    private TypedArray tvPoster;
    private String[] tvTitle
            , tvRating
            , tvYear
            ,tvDescription;
    private ArrayList<Movie> movies;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie, container, false);

        resource();
        itemList();

//        inialisasi adapter
        MovieAdapter movieAdapter = new MovieAdapter(movies, getActivity());

//        show recycler view
        RecyclerView recyclerView = rootView.findViewById(R.id.list_movie);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setHasFixedSize(true);


        return rootView;
    }

    private void itemList() {

        movies = new ArrayList<>();

        for (int i = 0; i <tvTitle.length; i++) {
            Movie movie = new Movie();
            movie.setPoster(tvPoster.getResourceId(i, -1));
            movie.setTitle(tvTitle[i]);
            movie.setYear(tvYear[i]);
            movie.setRating(tvRating[i]);
            movie.setDescription(tvDescription[i]);
            movies.add(movie);
        }
    }

    private void resource() {
        tvPoster = getResources().obtainTypedArray(R.array.movie_poster);
        tvTitle = getResources().getStringArray(R.array.movie_title);
        tvRating = getResources().getStringArray(R.array.movie_rating);
        tvYear = getResources().getStringArray(R.array.movie_year);
        tvDescription = getResources().getStringArray(R.array.movie_description);
    }

}
