package com.example.pruebaretrofit2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder>{

    private List<Question> mData;
    private LayoutInflater mInflater;


    // data is passed into the constructor
    QuestionAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        mData = new ArrayList<Question>();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvQuestionText;
        TextView tvPubDate;


        ViewHolder(View itemView) {
            super(itemView);
            tvQuestionText = itemView.findViewById(R.id.tvQuestionText);
            tvPubDate = itemView.findViewById(R.id.tvPubDate);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }



    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_listado_questions_linea, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(QuestionAdapter.ViewHolder holder, int position) {
        Question info = mData.get(position);
        Question q = mData.get(position);
        holder.tvQuestionText.setText(info.getQuestion_text());
        holder.tvPubDate.setText(info.getPub_date());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addData(ArrayList<Question> info) {
        mData.addAll(info);
        notifyDataSetChanged();
    }

    // convenience method for getting data at click position
    Question getItem(int id) {
        return mData.get(id);
    }

    private QuestionAdapter.ItemClickListener mClickListener;

    // allows clicks events to be caught
    void setClickListener(QuestionAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
