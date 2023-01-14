package azam.islamic_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class QuranErDua extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_quran_er_dua);

//        start code

        recyclerView = (RecyclerView) findViewById(R.id.reQuranErDua);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("কোরানের দোয়া").child("কোরানের সুরা").child("1").child("ayat");
        FirebaseRecyclerOptions<ShuraAyat> options =
                new FirebaseRecyclerOptions.Builder<ShuraAyat>()
                        .setQuery(query, ShuraAyat.class)
                        .build();


        FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<ShuraAyat, QuranErDua.PackageViewHolder>(options) {
            @Override
            public QuranErDua.PackageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.single_shura_row, parent, false);
                return new QuranErDua.PackageViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(QuranErDua.PackageViewHolder holder, int position, ShuraAyat shuraAyat) {
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

        public void setarabic(String bazar_name) {
            TextView bazarname = (TextView) mView.findViewById(R.id.arabicTxtView);
            bazarname.setText(bazar_name);
        }

        public void setuccharon(String bazar_area) {
            TextView bazararea = (TextView) mView.findViewById(R.id.ucharonTxtView);
            bazararea.setText(bazar_area);
        }

        public void setbanglameaning(String bazar_district) {
            TextView bazardistrict = (TextView) mView.findViewById(R.id.anubadTxtView);
            bazardistrict.setText(bazar_district);
        }

    }






}

