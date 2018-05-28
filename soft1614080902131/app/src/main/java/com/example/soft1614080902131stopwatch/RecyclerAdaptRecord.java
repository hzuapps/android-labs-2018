package com.example.soft1614080902131stopwatch;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

public class RecyclerAdaptRecord extends RecyclerView.Adapter<RecyclerAdaptRecord.ViewHolder>{

    private List<DateRecord> recyclerRecordList;

    private Activity currActivity;

    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout onClickLinear;
        ImageView imageView;
        TextView dateAndTimeTextView;
        TextView remarkTextView;
        ImageView pictureView;

        public ViewHolder(View itemView) {
            super(itemView);
            onClickLinear=(LinearLayout)itemView.findViewById(R.id.record_on_click_linear_layout);
            imageView=(ImageView)itemView.findViewById(R.id.recycler_record_image_view);
            dateAndTimeTextView=(TextView)itemView.findViewById(R.id.recycler_record_date_and_time_text_view);
            remarkTextView=(TextView)itemView.findViewById(R.id.recycler_record_remark_text_view);
            pictureView=(ImageView)itemView.findViewById(R.id.recycler_record_picture_view);

        }
    }

    public RecyclerAdaptRecord(List<DateRecord> recyclerRecordList,Activity activity){
        this.recyclerRecordList=recyclerRecordList;
        currActivity=activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_record_layout,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DateRecord dateRecord=recyclerRecordList.get(position);
        holder.onClickLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(currActivity,Soft1614080902131QueryActivity.class);
                intent.putExtra("currId",dateRecord.getId());
                currActivity.startActivity(intent);
                Toast.makeText(currActivity,"传输OK"+dateRecord.getId(),Toast.LENGTH_LONG).show();
            }
        });
        holder.imageView.setImageResource(R.drawable.sw_2_blue);
        holder.dateAndTimeTextView.setText(dateRecord.getDate()+"  "+dateRecord.getTime());
        holder.remarkTextView.setText(dateRecord.getRemark());
        if(dateRecord.isHavePicture()==false){
            holder.pictureView.setImageResource(R.drawable.sw_2_blue);
        }else{


            String mFilePath = Environment.getExternalStorageDirectory().getPath();// 获取SD卡路径
            mFilePath = mFilePath + "/aPicture/" + "p" + dateRecord.getId() + ".jpg";// 指定路径
            Uri photoUri = Uri.fromFile(new File(mFilePath));

            Glide.with(currActivity)
                    .load(photoUri)
                    .into(holder.pictureView);
        }
    }

    @Override
    public int getItemCount() {
        return recyclerRecordList.size();
    }

    public void setCurrActivity(Activity currActivity) {
        this.currActivity = currActivity;
    }
}
