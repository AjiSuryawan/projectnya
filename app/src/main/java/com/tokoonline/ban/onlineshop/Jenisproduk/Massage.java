package com.tokoonline.ban.onlineshop.Jenisproduk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.tokoonline.ban.onlineshop.Network.BookingClient;
import com.tokoonline.ban.onlineshop.Network.BookingService;
import com.tokoonline.ban.onlineshop.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class Massage extends AppCompatActivity {
    public List<data_item_spa> arrayList = new ArrayList<>();
    String data;
    Call<List<data_item_spa>> call;
    private RecyclerView recyclerView;
    private ShimmerFrameLayout mShimmerViewContainer;
    private SwipeRefreshLayout swipeRefreshLayout;
    private adapter_list_item_spa adapter;
    private Toolbar toolbar;
    private TextView tvTitleToolbar;
    private String title;
    RelativeLayout layoutkosong;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_notification) {
            startActivity(new Intent(getApplicationContext(), Search.class));
        }
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            data = extras.getString("category");
        }
        layoutkosong=(RelativeLayout)findViewById(R.id.layoutkosong);
        toolbar = findViewById(R.id.toolbar);
        tvTitleToolbar = findViewById(R.id.tv_title);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        mShimmerViewContainer = (ShimmerFrameLayout) findViewById(R.id.shimmer_view_container);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycle_view_list);

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                arrayList = new ArrayList<>();
                load_data();
            }
        });

        load_data();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    private void load_data() {
        recyclerView.setVisibility(View.GONE);
        mShimmerViewContainer.setVisibility(View.VISIBLE);
        mShimmerViewContainer.startShimmerAnimation();
        BookingService bookingService = BookingClient.getRetrofit().create(BookingService.class);
        Log.e("Massage", "load_data: " + data);
        if (data.equalsIgnoreCase("perum1")) {
            call = bookingService.getPackageTreatment();
            title = "Perumahan 1";
            tvTitleToolbar.setText(title);
        } else if (data.equalsIgnoreCase("perum2")) {
            call = bookingService.getAlaCarteTreatment();
            title = "Perumahan 2";
            tvTitleToolbar.setText(title);
        }


        for (int i = 0; i <10 ; i++) {
            data_item_spa data1=new data_item_spa();
            data1.setName("Rumah "+i+"xxx");
            data1.setDescription("Alamat rumah / deskripsi produk / pembayaran bulan lalu");
            arrayList.add(data1);
        }



        recyclerView.setVisibility(View.VISIBLE);
        swipeRefreshLayout.setRefreshing(false);
        swipeRefreshLayout.setVisibility(View.VISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new adapter_list_item_spa(getApplicationContext(), arrayList);
        recyclerView.setAdapter(adapter);
        Log.e("hasilnya", "onResponse: " + arrayList);
        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        /*
        call.enqueue(new Callback<List<data_item_spa>>() {
            @Override
            public void onResponse(Call<List<data_item_spa>> call, Response<List<data_item_spa>> response) {

                try {
                    arrayList.clear();
                    arrayList.addAll(response.body());
                    if (arrayList.size()==0 || arrayList.isEmpty() || arrayList ==null){
                        Log.d("masuk1", "onResponse: ");

                        layoutkosong.setVisibility(View.VISIBLE);
                        layoutkosong.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                layoutkosong.setVisibility(View.GONE);
                                Toast.makeText(getApplicationContext(),"makan",Toast.LENGTH_LONG).show();
                                load_data();
                            }
                        });
                        mShimmerViewContainer.setVisibility(View.GONE);
                    }else{
                        recyclerView.setVisibility(View.VISIBLE);
                        swipeRefreshLayout.setRefreshing(false);
                        swipeRefreshLayout.setVisibility(View.VISIBLE);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        adapter = new adapter_list_item_spa(getApplicationContext(), arrayList);
                        recyclerView.setAdapter(adapter);
                        Log.e("hasilnya", "onResponse: " + arrayList);
                        mShimmerViewContainer.stopShimmerAnimation();
                        mShimmerViewContainer.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                    }


                    

                } catch (Exception e) {
                    Log.d("masuk1", "onResponse: ");
                    layoutkosong.setVisibility(View.VISIBLE);
                    layoutkosong.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getApplicationContext(),"makan",Toast.LENGTH_LONG).show();
                            layoutkosong.setVisibility(View.GONE);
                            load_data();
                        }
                    });
                    mShimmerViewContainer.setVisibility(View.GONE);
                    Log.d("masuk2", "onResponse: ");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<data_item_spa>> call, Throwable t) {
                Log.d("masuk3", "onResponse: ");
                t.printStackTrace();
                Log.e("TAG", "onFailure: " + t.getMessage());
                Toast.makeText(Massage.this, t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
        */
    }
}
