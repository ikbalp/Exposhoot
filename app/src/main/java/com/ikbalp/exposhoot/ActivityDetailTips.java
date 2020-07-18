package com.ikbalp.exposhoot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ActivityDetailTips extends AppCompatActivity {

    private ImageView imageView;
    TextView textView_jdtips, textView_sdtips;

    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tips);

        imageView=findViewById(R.id.gambar_detail_tips);
        textView_jdtips=findViewById(R.id.judull_detail_tips);
        textView_sdtips=findViewById(R.id.spek_detail_tips);

        ref= FirebaseDatabase.getInstance().getReference().child("Tips");

        String TipsKey=getIntent().getStringExtra("TipsKey");

        ref.child(TipsKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists())
                {

                    String JudulTips=snapshot.child("judul").getValue().toString();
                    String Desc=snapshot.child("desc").getValue().toString();
                    String ImgTips=snapshot.child("image").getValue().toString();

                    Picasso.get().load(ImgTips).into(imageView);
                    textView_jdtips.setText(JudulTips);
                    textView_sdtips.setText(Desc);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}