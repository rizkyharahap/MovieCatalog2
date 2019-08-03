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
        holder.tvPoster.setImageResource(list.get(position).getPoster());
        holder.tvTitle.setText(list.get(position).getTitle());
        holder.tvRating.setText(list.get(position).getRating());
        holder.tvYear.setText(list.get(position).getYear());
        holder.tvDescription.setText(list.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView tvPoster;
        TextView tvTitle
                , tvRating
                , tvYear
                , tvDescription
                , tvGenre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPoster = itemView.findViewById(R.id.image_movie);
            tvTitle = itemView.findViewById(R.id.title);
            tvRating = itemView.findViewById(R.id.rating);
            tvYear = itemView.findViewById(R.id.year);
            tvDescription = itemView.findViewById(R.id.description);
            tvGenre = itemView.findViewById(R.id.genre);

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
