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

    private TypedArray moviePoster;
    private String[] movieTitle
            , movieRating
            , movieYear
            , movieReleaseDate
            , movieDuration
            , movieGenre
            , movieDescription;
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

        for (int i = 0; i <movieTitle.length; i++) {
            Movie movie = new Movie();
            movie.setPoster(moviePoster.getResourceId(i, -1));
            movie.setTitle(movieTitle[i]);
            movie.setRating(movieRating[i]);
            movie.setYear(movieYear[i]);
            movie.setReleaseDate(movieReleaseDate[i]);
            movie.setDuration(movieDuration[i]);
            movie.setGenre(movieGenre[i]);
            movie.setDescription(movieDescription[i]);
            movies.add(movie);
        }
    }

    private void resource() {
        moviePoster = getResources().obtainTypedArray(R.array.movie_poster);
        movieTitle = getResources().getStringArray(R.array.movie_title);
        movieRating = getResources().getStringArray(R.array.movie_rating);
        movieYear = getResources().getStringArray(R.array.movie_year);
        movieReleaseDate = getResources().getStringArray(R.array.movie_release_date);
        movieDuration = getResources().getStringArray(R.array.movie_duration);
        movieGenre = getResources().getStringArray(R.array.movie_genre);
        movieDescription = getResources().getStringArray(R.array.movie_description);
    }

}
