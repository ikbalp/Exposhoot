package com.ikbalp.exposhoot;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class DataCameraViewHolder extends RecyclerView.ViewHolder{

    public TextView t1;
    public TextView h1;
    public ImageView i1;
    View v;

    public DataCameraViewHolder(View itemView) {
        super(itemView);
        t1 = (TextView)itemView.findViewById(R.id.judull);
        h1 = (TextView)itemView.findViewById(R.id.hargaa);
        i1 = (ImageView) itemView.findViewById(R.id.gambar);
        v=itemView;
    }
}
