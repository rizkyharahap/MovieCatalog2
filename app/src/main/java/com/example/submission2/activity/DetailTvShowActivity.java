package com.example.submission2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.submission2.R;
import com.example.submission2.model.TvShow;

public class DetailTvShowActivity extends AppCompatActivity {

    TvShow tvShow;
    private TextView tvJudul;
    private ImageView ivGambar;
    private TextView tvDeskripsi;
    private TextView tvTanggalrilis;
    private TextView tvGenre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);
        initView();
        tvShow = getIntent().getParcelableExtra("tvShows");
        assert tvShow != null;
        tvJudul.setText(tvShow.getTitle());
        tvDeskripsi.setText(tvShow.getDescription());
        tvGenre.setText(tvShow.getGenre());
        ivGambar.setImageResource(tvShow.getPoster());
    }

    private void initView() {
        //Deklarasi
        tvJudul = findViewById(R.id.tv_title);
        ivGambar = findViewById(R.id.iv_image);
        tvDeskripsi = findViewById(R.id.tv_description);
        tvGenre = findViewById(R.id.tv_genre);
    }
}
