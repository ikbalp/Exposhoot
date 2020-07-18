package com.ikbalp.exposhoot;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class DataTipsViewHolder extends RecyclerView.ViewHolder {

    public TextView t1;
    public ImageView i1;
    public View v;

    public DataTipsViewHolder(View itemView) {
        super(itemView);
        t1 = (TextView)itemView.findViewById(R.id.post_title);
        i1 = (ImageView) itemView.findViewById(R.id.post_image);
        v=itemView;
    }
}
