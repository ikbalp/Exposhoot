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

public class ActivityDetailCamera extends AppCompatActivity {

    private ImageView imageView;
    TextView textView_jdcam, textView_hdcam, textView_sdcam;

    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_camera);

        imageView=findViewById(R.id.gambar_detail_cam);
        textView_jdcam=findViewById(R.id.judull_detail_cam);
        textView_hdcam=findViewById(R.id.hargaa_detail_cam);
        textView_sdcam=findViewById(R.id.spek_detail_cam);

        ref= FirebaseDatabase.getInstance().getReference().child("Camera");

        String CamKey=getIntent().getStringExtra("CamKey");

        ref.child(CamKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists())
                {

                    String TypeCam=snapshot.child("type").getValue().toString();
                    String Harga=snapshot.child("harga").getValue().toString();
                    String Spek=snapshot.child("spek").getValue().toString();
                    String Img=snapshot.child("img").getValue().toString();

                    Picasso.get().load(Img).into(imageView);
                    textView_hdcam.setText(Harga);
                    textView_sdcam.setText(Spek);
                    textView_jdcam.setText(TypeCam);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}