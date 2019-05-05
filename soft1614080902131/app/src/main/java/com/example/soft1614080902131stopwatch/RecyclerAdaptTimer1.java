package com.example.soft1614080902131stopwatch;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdaptTimer1 extends RecyclerView.Adapter<RecyclerAdaptTimer1.ViewHolder>{

    private List<Timer1Record> timer1RecordList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView rankTextView;
        TextView gradeTextView;


        public ViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.recycler_image_view);
            rankTextView=(TextView)itemView.findViewById(R.id.recycler_rank_text_view);
            gradeTextView=(TextView)itemView.findViewById(R.id.recycler_grade_text_view);
        }
    }

    public RecyclerAdaptTimer1(List<Timer1Record> recyclerTimer1s){
        this.timer1RecordList=recyclerTimer1s;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_timer1_layout,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Timer1Record timer1Record=timer1RecordList.get(position);
        holder.imageView.setImageResource(R.drawable.sw_2_blue);
        holder.rankTextView.setText(timer1Record.getRankN()+"");
        holder.gradeTextView.setText(timer1Record.getGrade());
    }

    @Override
    public int getItemCount() {
        return timer1RecordList.size();
    }
}
