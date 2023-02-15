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

public class AmolErList extends AppCompatActivity {

    ImageView imageView;

    RecyclerView recyclerView;

    String amol_Number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amol_er_list);

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
        amol_Number = intent.getStringExtra("amol_Number");



        recyclerView = (RecyclerView) findViewById(R.id.allAyatA);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("আমল").child("আমলের_বিষয়বস্তু").child(amol_Number);
        FirebaseRecyclerOptions<AmolAyat> options =
                new FirebaseRecyclerOptions.Builder<AmolAyat>()
                        .setQuery(query, AmolAyat.class)
                        .build();


        FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<AmolAyat, AmolErList.PackageViewHolder>(options) {
            @Override
            public AmolErList.PackageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.single_shura_row, parent, false);
                return new AmolErList.PackageViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(AmolErList.PackageViewHolder holder, int position, AmolAyat amolAyat) {
                holder.setarbi(amolAyat.getArbi());
                holder.setortho(amolAyat.getOrtho());
                holder.ucharon(amolAyat.getUcharon());
                holder.tottho(amolAyat.getTottho());

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
    //nice nice






}




