package com.example.submission2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.submission2.R;
import com.example.submission2.model.TvShow;

public class DetailTvShowActivity extends AppCompatActivity {

    TextView tvTitle
            , tvReleaseDate
            , tvDescription
            , tvGenre;
    ImageView tvPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);
        initView();
        TvShow tvShow = getIntent().getParcelableExtra("tvShows");
        assert tvShow != null;

        tvPoster.setImageResource(tvShow.getPoster());
        tvTitle.setText(tvShow.getTitle());
        tvReleaseDate.setText(tvShow.getReleaseDate());
        tvDescription.setText(tvShow.getDescription());
        tvGenre.setText(tvShow.getGenre());
    }

    private void initView() {
        //Deklarasi
        tvPoster = findViewById(R.id.iv_poster);
        tvTitle = findViewById(R.id.tv_title);
        tvReleaseDate = findViewById(R.id.tv_release_date);
        tvDescription = findViewById(R.id.tv_description);
        tvGenre = findViewById(R.id.tv_genre);
    }
}
