package azam.islamic_app;

import static androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Dua extends AppCompatActivity {

    ImageView imageView;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_dua);

        setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(this.getResources().getColor(R.color.white));


        //        start hook
        imageView = findViewById(R.id.quranerDuyaBackbtn);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
//        hooks end

        //        start code

        recyclerView = (RecyclerView) findViewById(R.id.reDuaa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("দোয়া").child("দোয়া_তালিকা");
        FirebaseRecyclerOptions<Dua_list_info> options =
                new FirebaseRecyclerOptions.Builder<Dua_list_info>()
                        .setQuery(query, Dua_list_info.class)
                        .build();


        FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<Dua_list_info, Dua.PackageViewHolder>(options) {
            @Override
            public Dua.PackageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_design, parent, false);
                return new Dua.PackageViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(Dua.PackageViewHolder holder, int position, Dua_list_info dua_list_info) {
                holder.setdua_name(dua_list_info.getDua_name());
                holder.setdua_Number(dua_list_info.getDua_Number());
                holder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    //recycler view pull page
                    public void onClick(View v) {
                        System.out.println(String.valueOf(holder.getBindingAdapterPosition()+1));
                        Intent myIntent = new Intent(Dua.this,Dua_er_list.class);
                        myIntent.putExtra("amol_Number",String.valueOf(holder.getBindingAdapterPosition()+1));
                        startActivity(myIntent);

                    }
                });

                //recycler view pull page end
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.startListening();

    }



    public static class PackageViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public PackageViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setdua_name(String dua_name_txt) {
            TextView dua_name = (TextView) mView.findViewById(R.id.sura);
            dua_name.setText(dua_name_txt);
        }

        public void setdua_Number(String dua_Number_txt) {
            TextView dua_Number = (TextView) mView.findViewById(R.id.counter);
            dua_Number.setText(dua_Number_txt);
        }


//        public void setarabic(String arabic_txt) {
//            TextView arabic = (TextView) mView.findViewById(R.id.arabicTxtView);
//            arabic.setText(arabic_txt);
//        }

//        public void setuccharon(String uccharon_txt) {
//            TextView uccharon = (TextView) mView.findViewById(R.id.ucharonTxtView);
//            uccharon.setText(uccharon_txt);
//        }
//
//        public void setbanglameaning(String banglameaning_txt) {
//            TextView banglameaning = (TextView) mView.findViewById(R.id.anubadTxtView);
//            banglameaning.setText(banglameaning_txt);
//        }

    }






}

