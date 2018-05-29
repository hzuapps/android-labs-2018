package edu.hzuapps.androidlabs.soft1614080902221;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PlayerDataAdapter extends RecyclerView.Adapter<PlayerDataAdapter.ViewHolder> {

    private List<PlayerData> mPlayerData = null;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView player_name = null;
        TextView player_sex = null;
        TextView player_character = null;
        TextView player_time = null;

        public ViewHolder(View view) {
            super(view);
            player_name = (TextView) view.findViewById(R.id.player_name);
            player_sex = (TextView) view.findViewById(R.id.player_sex);
            player_character = (TextView) view.findViewById(R.id.player_character);
            player_time = (TextView) view.findViewById(R.id.player_time);
        }

    }

    public PlayerDataAdapter(List<PlayerData> playerDataList) {
        mPlayerData = playerDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //设置RecyclerView的子项布局为playerdata_item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.playerdata_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PlayerData playerData = mPlayerData.get(position);
        holder.player_name.setText(playerData.getPlayerName());
        holder.player_sex.setText(playerData.getSex());
        holder.player_character.setText(playerData.getGameCharacters());
        int mTime = playerData.getTime();
        holder.player_time.setText("" + mTime + " S");
    }

    @Override
    public int getItemCount() {
        return mPlayerData.size();
    }
}