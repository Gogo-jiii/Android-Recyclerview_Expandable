package com.example.recyclerviewexpandable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ModelClass> arrayList;

    public MyAdapter(MainActivity context, ArrayList<ModelClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ModelClass modelClass = arrayList.get(position);
        holder.textView.setText(modelClass.getName());
        if (modelClass.isShouldShowImageview()) {
            holder.imageView.setVisibility(View.VISIBLE);
        } else {
            holder.imageView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ConstraintLayout rowItem;
        private ImageView imageView, imageViewArrow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.textView = itemView.findViewById(R.id.textView);
            this.rowItem = itemView.findViewById(R.id.rowitem);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.imageViewArrow = itemView.findViewById(R.id.imageViewArrow);

            rowItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, String.valueOf(arrayList.get(getAdapterPosition())),
                            Toast.LENGTH_SHORT).show();
                }
            });

            imageViewArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (arrayList.get(getAdapterPosition()).isShouldShowImageview()) {
                        arrayList.get(getAdapterPosition()).setShouldShowImageview(false);
                    } else {
                        arrayList.get(getAdapterPosition()).setShouldShowImageview(true);
                    }
                    notifyDataSetChanged();
                }
            });
        }
    }
}
