package com.tokoonline.ban.onlineshop.Fragment.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;

import com.tokoonline.ban.onlineshop.Fragment.Base.BaseFragment;
import com.tokoonline.ban.onlineshop.Jenisproduk.Massage;
import com.tokoonline.ban.onlineshop.R;


public class HomeFragment extends BaseFragment {
//    public List<data_item_spa> arrayList = new ArrayList<>();
//    private RecyclerView recyclerView;
//    private ProgressBar pg;
//    private SwipeRefreshLayout swipeRefreshLayout;
//    private adapter_list_item_spa adapter;


    @Override
    protected int getLayout() {
        return R.layout.activity_homedashboard;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        CardView cardkuspa1=(CardView)view.findViewById(R.id.cardkuspa1);
        cardkuspa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(view.getContext(), Massage.class);
                in.putExtra("category","perum1");
                startActivity(in);
            }
        });

        CardView cardku2=(CardView)view.findViewById(R.id.cardku2);
        cardku2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent in=new Intent(view.getContext(), Massage.class);
//                in.putExtra("category","perum2");
//                startActivity(in);
            }
        });

    }

}