package edu.hzuapps.androidlabs.Com1614080901208;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.cnt.textapplication.BR;
import com.example.cnt.textapplication.R;

import java.util.List;

/**
 * Created by cnt on 2018/5/12.
 */

public class MainRVAdapter extends RecyclerView.Adapter<MainRVAdapter.ViewHolder> implements View.OnClickListener {
    private List<RVBean> list;

    private OnItemClickListener mOnItemClickListener;


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null)
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
    }

    public MainRVAdapter(List<RVBean> list) {
        this.list = list;
    }

    //缓存器
    static class ViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding binding;

        public ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.main_rv_item, parent, false);
        binding.getRoot().setOnClickListener(this);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewDataBinding binding = holder.binding;
        MainRVViewMode viewModel = new MainRVViewMode(list.get(position));
        binding.setVariable(BR.vm, viewModel);
        binding.setVariable(BR.adapter, this);
        //立即重新绑定数据
        binding.getRoot().setTag(position);
        binding.executePendingBindings();

        Animation animation = AnimationUtils.loadAnimation(binding.getRoot().getContext(),R.anim.anim_item);
        animation.setDuration(500);
        holder.binding.getRoot().setAnimation(animation);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
