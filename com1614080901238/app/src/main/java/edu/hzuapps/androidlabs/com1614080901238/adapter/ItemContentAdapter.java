package edu.hzuapps.androidlabs.com1614080901238.mostbeautifulwallpaper.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.hzuapps.androidlabs.com1614080901238.mostbeautifulwallpaper.R;

/**
 * Created by 陈梓聪 on 2018/5/19.
 */

public class ItemContentAdapter extends RecyclerView.Adapter<ItemContentAdapter.ViewHolder> {
    private List<String> comments;

    public ItemContentAdapter(List<String> comments) {
        this.comments = comments;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView comment;
        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            comment = view.findViewById(R.id.comment);
        }
    }
    @Override
    public ItemContentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemContentAdapter.ViewHolder holder, int position) {
            holder.comment.setText(comments.get(position));
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

}
