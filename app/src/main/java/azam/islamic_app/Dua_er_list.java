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
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Dua_er_list extends AppCompatActivity {

    String dua_Number;

    ImageView imageView;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua_er_list);

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


        Intent intent = getIntent();
        dua_Number = intent.getStringExtra("dua_Number");



        recyclerView = (RecyclerView) findViewById(R.id.allAyatd);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("দোয়া").child("দোয়ার_বিষয়বস্তু").child(dua_Number);
        FirebaseRecyclerOptions<DuaAyat> options =
                new FirebaseRecyclerOptions.Builder<DuaAyat>()
                        .setQuery(query, DuaAyat.class)
                        .build();


        FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<DuaAyat, Dua_er_list.PackageViewHolder>(options) {
            @Override
            public Dua_er_list.PackageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.single_shura_row, parent, false);
                return new Dua_er_list.PackageViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(Dua_er_list.PackageViewHolder holder, int position, DuaAyat duaAyat) {
                holder.setarbi(duaAyat.getArbi());
                holder.setortho(duaAyat.getOrtho());
                holder.ucharon(duaAyat.getUcharon());
                holder.tottho(duaAyat.getTottho());

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

//        public void setshura_name(String shura_name_txt) {
//            TextView shura_name = (TextView) mView.findViewById(R.id.sura);
//            shura_name.setText(shura_name_txt);
//        }


        public void setarbi(String arabic_txt) {
            TextView arabic = (TextView) mView.findViewById(R.id.arabicTxtView);
            arabic.setText(arabic_txt);
        }

        public void setortho(String uccharon_txt) {
            TextView uccharon = (TextView) mView.findViewById(R.id.anubadTxtView);
            uccharon.setText(uccharon_txt);
        }

        public void ucharon(String banglameaning_txt) {
            TextView banglameaning = (TextView) mView.findViewById(R.id.ucharonTxtView);
            banglameaning.setText(banglameaning_txt);
        }


        public void tottho(String tottho_txt) {
            TextView tottho = (TextView) mView.findViewById(R.id.totthoTxtView);
            tottho.setText(tottho_txt);
        }

    }
    //nice






}
