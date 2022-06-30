package com.example.pertemuan11;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private static Context context;
    private static ArrayList<Movies> listMovies;
    private Resources res;


    public MovieAdapter(Context context) {
        this.context = context;
    }

    public static ArrayList<Movies> getListMovies() {
        return listMovies;
    }

    public void setListMovies(ArrayList<Movies> listMovies) {
        this.listMovies = listMovies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_movie, viewGroup, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        Movies movie = getListMovies().get(i);
        Glide.with(context)
                .load(movie.getPoster())
                .apply(new RequestOptions().override(350, 550))
                .into(movieViewHolder.imageViewposter);


        movieViewHolder.textViewtitle.setText(movie.getTitle());
        movieViewHolder.textViewReleaseDate.setText(movie.getReleased_date());
        movieViewHolder.textViewdesc.setText(movie.getDesc());

    }

    @Override
    public int getItemCount() {
        return getListMovies().size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewposter;
        public TextView textViewtitle, textViewReleaseDate, textViewdesc;

        public MovieViewHolder(@NonNull final View itemView) {
            super(itemView);

            imageViewposter = itemView.findViewById(R.id.mv_poster);
            textViewtitle = itemView.findViewById(R.id.mv_name);
            textViewReleaseDate = itemView.findViewById(R.id.mv_release);
            textViewdesc = itemView.findViewById(R.id.mv_desc);

            itemView.setOnClickListener(view -> {
                //ambil posisi/index dari baris recyclerview
                int i = getBindingAdapterPosition();

                Movies m = getListMovies().get(i);

                m.setTitle(m.getTitle());
                m.setDesc(m.getDesc());
                m.setReleased_date(m.getReleased_date());

                //pindah halaman ke detail activity
                Intent detailIntent = new Intent(itemView.getContext(), DetailActivity.class);

                //kirim data dari intent ke halaman detail (data --> class parcelable)
                detailIntent.putExtra(DetailActivity.EXTRA_MOVIE, m);

                context.startActivity(detailIntent);

//                context.startActivity(new Intent(itemView.getContext(), DetailActivity.class));

            });
        }
    }


}
