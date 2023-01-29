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

public class ZikirListInfo extends AppCompatActivity {

    RecyclerView recyclerView;

    String key;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zikir_list_info);

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
        key = intent.getStringExtra("key");



        recyclerView = (RecyclerView) findViewById(R.id.allAyatz);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("জিকির").child("প্রতিদিনের জিকির").child(key).child("জিকির সমূহ");
        FirebaseRecyclerOptions<ZikirAyat> options =
                new FirebaseRecyclerOptions.Builder<ZikirAyat>()
                        .setQuery(query, ZikirAyat.class)
                        .build();


        FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<ZikirAyat, ZikirListInfo.PackageViewHolder>(options) {
            @Override
            public ZikirListInfo.PackageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.single_shura_row, parent, false);
                return new ZikirListInfo.PackageViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(ZikirListInfo.PackageViewHolder holder, int position, ZikirAyat zikirAyat) {
                holder.setarbi(zikirAyat.getArbi());
                holder.setortho(zikirAyat.getOrtho());
                holder.ucharon(zikirAyat.getUcharon());

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
            TextView uccharon = (TextView) mView.findViewById(R.id.ucharonTxtView);
            uccharon.setText(uccharon_txt);
        }

        public void ucharon(String banglameaning_txt) {
            TextView banglameaning = (TextView) mView.findViewById(R.id.anubadTxtView);
            banglameaning.setText(banglameaning_txt);
        }

    }
    //nice






}

