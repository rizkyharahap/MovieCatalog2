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
import com.example.submission2.activity.DetailTvShowActivity;
import com.example.submission2.model.TvShow;

import java.util.ArrayList;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.ViewHolder> {

    private ArrayList<TvShow> list;
    private Context context;

    public TvShowAdapter(ArrayList<TvShow> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvPoster.setImageResource(list.get(position).getPoster());
        holder.tvTitle.setText(list.get(position).getTitle());
        holder.tvYear.setText(list.get(position).getYear());
        holder.tvDescription.setText(list.get(position).getYear());
        holder.tvGenre.setText(list.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView tvPoster;
        TextView tvTitle
                , tvYear
                , tvDescription
                , tvGenre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPoster = itemView.findViewById(R.id.image_movie);
            tvTitle = itemView.findViewById(R.id.title);
            tvYear = itemView.findViewById(R.id.year);
            tvDescription = itemView.findViewById(R.id.description);
            tvGenre = itemView.findViewById(R.id.genre);

//          onClickListener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Intent intent = new Intent(context, DetailTvShowActivity.class);
                    intent.putExtra("tvShows", list.get(position));
                    context.startActivity(intent);
                }
            });
        }
    }
}
