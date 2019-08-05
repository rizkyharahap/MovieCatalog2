package com.example.submission2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.submission2.R;
import com.example.submission2.model.Movie;

public class DetailMovieActivity extends AppCompatActivity {

    TextView movieTitle
            , movieRating
            , movieYear
            , movieReleaseDate
            , movieDuration
            , movieGenre
            , movieDescription;
    ImageView moviePoster
            , movieBackdrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        initView();
        Movie movie = getIntent().getParcelableExtra("movies");

        assert movie != null;
        movieBackdrop.setImageResource(movie.getPoster());
        moviePoster.setImageResource(movie.getPoster());
        movieTitle.setText(movie.getTitle());
        movieRating.setText(movie.getRating());
        movieYear.setText(movie.getYear());
        movieReleaseDate.setText(movie.getReleaseDate());
        movieDuration.setText(movie.getDuration());
        movieGenre.setText(movie.getGenre());
        movieDescription.setText(movie.getDescription());
    }

    private void initView() {
        //Deklarasi
        movieBackdrop = findViewById(R.id.iv_backdrop);
        moviePoster = findViewById(R.id.iv_poster);
        movieTitle = findViewById(R.id.tv_title);
        movieRating =findViewById(R.id.tv_rating);
        movieYear = findViewById(R.id.tv_year);
        movieReleaseDate = findViewById(R.id.tv_release_date);
        movieDuration = findViewById(R.id.tv_duration);
        movieGenre = findViewById(R.id.tv_genre);
        movieDescription = findViewById(R.id.tv_description);
    }
}
