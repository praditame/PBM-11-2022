package com.example.pertemuan11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    ImageView detailPoster;
    TextView detailJudul, detailDate, detailDesc, detailReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailPoster = findViewById(R.id.detail_poster);
        detailJudul = findViewById(R.id.detail_judul);
        detailDate = findViewById(R.id.detail_release_date);
        detailDesc = findViewById(R.id.detail_deskripsi);
        detailReview = findViewById(R.id.detail_review);

        //ambil paket EXTRA_MOVIE dari Adapter
        Movies movies = getIntent().getParcelableExtra(EXTRA_MOVIE);

        detailJudul.setText(movies.getTitle());
        detailDate.setText(movies.getReleased_date());
        detailDesc.setText(movies.getDesc());
        detailReview.setText(movies.getReview());

        //set gambar
        Glide.with(DetailActivity.this).load(movies.getPoster())
                .apply(new RequestOptions().override(350, 550))
                .into(detailPoster);
    }
}