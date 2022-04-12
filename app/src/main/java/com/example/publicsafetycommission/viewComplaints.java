package com.example.publicsafetycommission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class viewComplaints extends AppCompatActivity {

   RecyclerView recycle;
   ImageView back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaints);
        recycle=findViewById(R.id.recycle);
        back=findViewById(R.id.btnBackk);

        SharedPreferences spref = getSharedPreferences("YOUR_PREF_NAME", 0);
        int userid = spref.getInt("user_id", 0);

        precessData(userid);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recycle.setLayoutManager(llm);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewComplaints.this,
                        HomeActivity.class);
                startActivity(intent);

            }
        });

    }
    private void precessData(int userid) {
        Call<Responsemodel> processData= apiController.getInstance()
                .getapi()
                .showDetail(userid);

        processData.enqueue(new Callback<Responsemodel>() {
            @Override
            public void onResponse(Call<Responsemodel> call, Response<Responsemodel> response) {
                if(response.isSuccessful()){
                    recycleradapter adapter = new recycleradapter(response.body().getComplaints());
                    recycle.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<Responsemodel> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
            }
        });
    }

    class recycleradapter extends RecyclerView.Adapter<recycleradapter.MyViewHolder>{
        List<Responsemodel.Complaint>list;

        public recycleradapter(List<Responsemodel.Complaint> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public recycleradapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout,null);
            recycleradapter.MyViewHolder viewHolder=new recycleradapter.MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull recycleradapter.MyViewHolder holder, int position) {
            holder.complaintCouncil.setText(list.get(position).getDistrictName());
            holder.category.setText(list.get(position).getComplaintCategoryName());
            holder.detail.setText(list.get(position).getComplaintDetail());
            holder.status.setText(list.get(position).getComplaintStatusTitle());
            holder.time.setText(list.get(position).getComplaintEntryTimestamp());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
        class MyViewHolder extends RecyclerView.ViewHolder{

            TextView complaintCouncil, category,detail, status, time;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                recycle=itemView.findViewById(R.id.recycle);
                complaintCouncil=itemView.findViewById(R.id.council);
                category=itemView.findViewById(R.id.category);
                detail=itemView.findViewById(R.id.detail);
                status=itemView.findViewById(R.id.status);
                time=itemView.findViewById(R.id.time);
            }
        }
    }

}