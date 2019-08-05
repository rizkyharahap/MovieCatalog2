package com.example.submission2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.submission2.R;
import com.example.submission2.activity.DetailMovieActivity;
import com.example.submission2.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private ArrayList<Movie> list;
    private Context context;

    public MovieAdapter(ArrayList<Movie> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new MovieAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        holder.moviePoster.setImageResource(list.get(position).getPoster());
        holder.movieTitle.setText(list.get(position).getTitle());
        holder.movieRating.setText(list.get(position).getRating());
        holder.movieYear.setText(list.get(position).getYear());
        holder.movieDescription.setText(list.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView movieTitle
                , movieRating
                , movieYear
                , movieDescription;
        ImageView moviePoster;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            moviePoster = itemView.findViewById(R.id.iv_poster);
            movieTitle = itemView.findViewById(R.id.tv_title);
            movieRating = itemView.findViewById(R.id.tv_rating);
            movieYear = itemView.findViewById(R.id.tv_year);
            movieDescription = itemView.findViewById(R.id.tv_description);

//            onClickListener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Intent intent = new Intent(context, DetailMovieActivity.class);
                    intent.putExtra("movies", list.get(position));
                    context.startActivity(intent);
                }
            });
        }
    }
}
