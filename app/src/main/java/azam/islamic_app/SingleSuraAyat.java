package azam.islamic_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class SingleSuraAyat extends AppCompatActivity {
    RecyclerView recyclerView;
    String shuraNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_sura_ayat);
        Intent intent = getIntent();
        shuraNumber = intent.getStringExtra("shuraNumber");

        recyclerView = (RecyclerView) findViewById(R.id.allAyat);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("কোরানের দোয়া").child("কোরানের সুরা").child(shuraNumber).child("ayat");
        FirebaseRecyclerOptions<ShuraAyat> options =
                new FirebaseRecyclerOptions.Builder<ShuraAyat>()
                        .setQuery(query, ShuraAyat.class)
                        .build();


        FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<ShuraAyat, SingleSuraAyat.PackageViewHolder>(options) {
            @Override
            public SingleSuraAyat.PackageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.single_shura_row, parent, false);
                return new SingleSuraAyat.PackageViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(SingleSuraAyat.PackageViewHolder holder, int position, ShuraAyat shuraAyat) {
                holder.setarabic(shuraAyat.getArabic());
                holder.setuccharon(shuraAyat.getUccharon());
                holder.setbanglameaning(shuraAyat.getBanglameaning());

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


        public void setarabic(String arabic_txt) {
            TextView arabic = (TextView) mView.findViewById(R.id.arabicTxtView);
            arabic.setText(arabic_txt);
        }

        public void setuccharon(String uccharon_txt) {
            TextView uccharon = (TextView) mView.findViewById(R.id.ucharonTxtView);
            uccharon.setText(uccharon_txt);
        }

        public void setbanglameaning(String banglameaning_txt) {
            TextView banglameaning = (TextView) mView.findViewById(R.id.anubadTxtView);
            banglameaning.setText(banglameaning_txt);
        }

    }
    //nice






}

