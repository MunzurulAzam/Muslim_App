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

public class QuranErDua extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView imageView;
    //intent data
    String suraNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_quran_er_dua);

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

        recyclerView = (RecyclerView) findViewById(R.id.reQuranErDua);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("কুরানের_দোয়া").child("কুরানের_দোয়া_তালিকা");
        FirebaseRecyclerOptions<SuraShumoho> options =
                new FirebaseRecyclerOptions.Builder<SuraShumoho>()
                        .setQuery(query, SuraShumoho.class)
                        .build();


        FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<SuraShumoho, QuranErDua.PackageViewHolder>(options) {
            @Override
            public QuranErDua.PackageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_design, parent, false);
                return new QuranErDua.PackageViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(QuranErDua.PackageViewHolder holder, int position, SuraShumoho suraShumoho) {
                holder.setQuran_Er_Dua_name(suraShumoho.getQuran_Er_Dua_name());
                holder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    //recycler view pull page
                    public void onClick(View v) {
                        System.out.println(String.valueOf(holder.getBindingAdapterPosition()+1));
                        Intent myIntent = new Intent(QuranErDua.this,SingleSuraAyat.class);
                        myIntent.putExtra("shuraNumber",String.valueOf(holder.getBindingAdapterPosition()+1));
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

        public void setQuran_Er_Dua_name(String shura_name_txt) {
            TextView shura_name = (TextView) mView.findViewById(R.id.sura);
            shura_name.setText(shura_name_txt);
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

