package edu.hzuapps.androidlabs.com1614080901238.mostbeautifulwallpaper.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.hzuapps.androidlabs.com1614080901238.mostbeautifulwallpaper.R;
import edu.hzuapps.androidlabs.com1614080901238.mostbeautifulwallpaper.WallpaperItemActivity;
import edu.hzuapps.androidlabs.com1614080901238.mostbeautifulwallpaper.entity.ItemContent;

/**
 * Created by 陈梓聪 on 2018/5/13.
 */

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.ViewHolder> {


    public WallpaperAdapter(List<ItemContent> itemContents, Context context) {
        this.itemContents = itemContents;
        this.context = context;
    }

    private List<ItemContent> itemContents;

    private Context context;

    static class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private final TextView itemText;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            itemText = (TextView) view.findViewById(R.id.item);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.itemText.setText(itemContents.get(position).getTitle());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WallpaperItemActivity.class);
                intent.putExtra("itemContent", itemContents.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemContents.size();
    }

}
