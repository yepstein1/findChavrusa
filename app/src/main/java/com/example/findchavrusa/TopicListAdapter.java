package com.example.findchavrusa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopicListAdapter extends RecyclerView.Adapter<TopicListAdapter.UserViewHolder> {
    private final LayoutInflater mInflater;
    private List<Topics_studied> mTopics;

    public TopicListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        if (mTopics != null) {
            Topics_studied current = mTopics.get(position);
            holder.userItemView.setText(current.getUserName());
        } else {
            // Covers the case of data not being ready yet.
            holder.userItemView.setText("No Users");
        }
    }

    void setTopics(List<Topics_studied> topics) {
        mTopics = topics;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mTopics != null)
            return mTopics.size();
        else
            return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private final TextView userItemView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            userItemView = itemView.findViewById(R.id.textView);
        }
    }
}
