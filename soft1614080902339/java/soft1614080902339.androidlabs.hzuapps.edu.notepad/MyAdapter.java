package soft1614080902339.androidlabs.hzuapps.edu.notepad;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private List<Database> databaseArrayList;
    private Activity currActivity;

    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout listLinearLayout;
        TextView titleTextView;
        TextView contentTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            listLinearLayout=(LinearLayout)itemView.findViewById(R.id.list_linear_layout);
            titleTextView=(TextView)itemView.findViewById(R.id.recycler_title_text_view);
            contentTextView=(TextView)itemView.findViewById(R.id.recycler_content_text_view);
        }
    }

    public MyAdapter(List<Database> databaseArrayList, Activity activity) {
        this.databaseArrayList = databaseArrayList;
        currActivity=activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Database database=databaseArrayList.get(position);
        holder.titleTextView.setText(database.getTitle());
        holder.contentTextView.setText(database.getContent());
        holder.listLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(currActivity,Main3Activity.class);
                intent.putExtra("currId",database.getId());
                currActivity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return databaseArrayList.size();
    }
}
