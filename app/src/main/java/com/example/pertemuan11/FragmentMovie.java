package com.example.pertemuan11;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;


public class FragmentMovie extends Fragment {

    private RecyclerView rvMovies;
    private final ArrayList<Movies> listMovies = new ArrayList<>();

    public FragmentMovie() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        rvMovies = view.findViewById(R.id.rv_movies);
        rvMovies.setHasFixedSize(true);

        listMovies.addAll(getListDataMovies());
        showRecyclerViewMovie();
        return view;
    }

    private void showRecyclerViewMovie() {
        rvMovies.setLayoutManager(new LinearLayoutManager(this.getContext()));
        MovieAdapter cardViewMovieAdapter = new MovieAdapter(this.getContext());
        cardViewMovieAdapter.setListMovies(listMovies);
        rvMovies.setAdapter(cardViewMovieAdapter);
    }

    private ArrayList<Movies> getListDataMovies() {
        String[] movieTitle = getResources().getStringArray(R.array.mv_titles);
        String[] movieReleased = getResources().getStringArray(R.array.mv_released);
        String[] movieDesc = getResources().getStringArray(R.array.mv_description);
        String[] movieReview = getResources().getStringArray(R.array.mv_reviews);
        @SuppressLint("Recycle") TypedArray moviePoster = getResources().obtainTypedArray(R.array.mv_poster);

        ArrayList<Movies> listMovies = new ArrayList<>();
        for (int i = 0; i < movieTitle.length; i++) {
            Movies movies = new Movies();
            movies.setTitle(movieTitle[i]);
            movies.setReleased_date(movieReleased[i]);
            movies.setDesc(movieDesc[i]);
            movies.setReview(movieReview[i]);
            movies.setPoster(moviePoster.getResourceId(i, -1));
            listMovies.add(movies);
        }

        return listMovies;
    }


}
