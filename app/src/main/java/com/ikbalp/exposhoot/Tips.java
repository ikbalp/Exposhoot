package com.ikbalp.exposhoot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class Tips extends AppCompatActivity {

    //widgets
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    FirebaseRecyclerOptions<DataTips> options;
    FirebaseRecyclerAdapter<DataTips,DataTipsViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipss);

        //Init and Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //set home selected
        bottomNavigationView.setSelectedItemId(R.id.tips);

        //perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.camera:
                        startActivity(new Intent(getApplicationContext(),Camera.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.tips:
                        return true;

                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),About.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });

        recyclerView = findViewById(R.id.recyclerViewtips);
        recyclerView.setHasFixedSize(true);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Tips");

        options = new FirebaseRecyclerOptions.Builder<DataTips>().setQuery(databaseReference, DataTips.class).build();

        adapter = new FirebaseRecyclerAdapter<DataTips, DataTipsViewHolder>(options) {
            @Override
            protected void onBindViewHolder(DataTipsViewHolder holder, final int position, DataTips model) {
                Picasso.get().load(model.getImage()).into(holder.i1, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();

                    }

                });

                holder.t1.setText(model.getJudul());

                //detail camera
                holder.v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Tips.this,ActivityDetailTips.class);
                        intent.putExtra("TipsKey",getRef(position).getKey());
                        startActivity(intent);
                    }
                });

            }

            @NonNull
            @Override
            public DataTipsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tips_row, parent, false);

                return new DataTipsViewHolder(view);
            }
        };
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onStart() {
        super.onStart();
        if (adapter!=null)
            adapter.startListening();
    }

    @Override
    public void onStop() {
        if (adapter!=null)
            adapter.stopListening();
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter!=null)
            adapter.startListening();
    }

}
