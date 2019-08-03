package com.example.submission2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.submission2.R;
import com.example.submission2.model.Movie;

public class DetailMovieActivity extends AppCompatActivity {

    Movie movie;
    private TextView tvJudul;
    private ImageView ivGambar;
    private TextView tvDeskripsi;
    private TextView tvTanggalrilis;
    private TextView tvGenre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        initView();
        movie = getIntent().getParcelableExtra("movies");
        assert movie != null;
        tvJudul.setText(movie.getTitle());
        tvDeskripsi.setText(movie.getDescription());
        tvTanggalrilis.setText(movie.getReleaseDate());
        tvGenre.setText(movie.getGenre());
        ivGambar.setImageResource(movie.getPoster());
    }

    private void initView() {
        //Deklarasi
        tvJudul = findViewById(R.id.tv_title);
        ivGambar = findViewById(R.id.iv_image);
        tvDeskripsi = findViewById(R.id.tv_description);
        tvTanggalrilis = findViewById(R.id.tv_release_date);
        tvGenre = findViewById(R.id.tv_genre);
    }
}
