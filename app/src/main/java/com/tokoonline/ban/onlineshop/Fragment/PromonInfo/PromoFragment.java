package com.tokoonline.ban.onlineshop.Fragment.PromonInfo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tokoonline.ban.onlineshop.Fragment.Base.BaseFragment;
import com.tokoonline.ban.onlineshop.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class PromoFragment extends BaseFragment {
//    ArrayList<Gambar> arrayku;
//    public RecyclerView recycler_view_list_film;
//    public ArrayList<Time> listFilm = new ArrayList<>();
//    public SectionListDataAdapter adapterAllTipe;
//    private Slider slider;
//    private ShimmerFrameLayout mShimmerViewContainer;

    private MaterialBetterSpinner spinner;

    @Override
    protected int getLayout() {
        return R.layout.promoninfo;
    }


    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button updateBtn=view.findViewById(R.id.updateBtn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(view.getContext())
                        .setTitle("Sinkron data")
                        .setMessage("Apakah anda yakin ingin Sinkron data ?")
                        .setNegativeButton("Tidak", null)
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(view.getContext(),"Data sukses sinkron",Toast.LENGTH_LONG).show();
                            }
                        }).create().show();
            }
        });
    }
}
