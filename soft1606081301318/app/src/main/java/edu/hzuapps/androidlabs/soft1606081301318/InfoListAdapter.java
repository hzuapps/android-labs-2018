package androidlabs.hzuapps.edu.soft1606081301318;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class InfoListAdapter extends RecyclerView.Adapter<InfoListAdapter.InfoViewHolder> {
    private ArrayList<ItemBean> mData;
    private Context mContext;
    private OnItemClickListener mItemClickListener;
    InfoViewHolder holder=null;

    public InfoListAdapter(ArrayList<ItemBean> data,Context context) {

        this.mData = data;
        this.mContext=context;
    }

    public interface OnItemClickListener{
        public void onItemClick(View view, int postion);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mItemClickListener = onItemClickListener;
    }
    @Override
    public InfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        holder=new InfoViewHolder(LayoutInflater.from(mContext).inflate(R.layout.info_item,parent,false));
        return holder;

    }


    @Override
    public void onBindViewHolder(final InfoViewHolder holder, int position) {

        holder.title.setText(mData.get(position).getTitle());
        Glide.with(mContext).load(mData.get(position).getImgurl()).into(holder.img);

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClickListener.onItemClick(holder.itemView, holder.getLayoutPosition());
            }
        });
    }


    @Override
    public int getItemCount() {

        return mData.size();
    }

    class InfoViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView img;

        public InfoViewHolder(View itemView) {

            super(itemView);
            title= (TextView) itemView.findViewById(R.id.item_title);
            img= (ImageView) itemView.findViewById(R.id.item_image);

        }
    }
}