package com.tokoonline.ban.onlineshop.Jenisproduk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.tokoonline.ban.onlineshop.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class Search extends AppCompatActivity {
    private ImageView ivImage;
    private MaterialBetterSpinner spinner;
    private static final String[] periodList = new String[]{"Blok", "Nama", "RT"};
    private DatabaseProvider db;
    private EditText etMeteran;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        db = DatabaseProvider.getInstance();
        spinner = findViewById(R.id.android_material_design_spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, periodList);
        spinner.setAdapter(arrayAdapter);
        ivImage = findViewById(R.id.iv_image);
        etMeteran = findViewById(R.id.et_meteran);
        Button updateBtn=(Button)findViewById(R.id.updateBtn);
        updateBtn.setOnClickListener(v -> {
           // FormRecordModel formRecordModel = db.getRecordByName(etMeteran.getText().toString());
         //   Log.e("", "onCreate: " + formRecordModel.getImagePath() );
           // ivImage.setImageURI(Uri.parse(formRecordModel.getImagePath()));
                finish();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}
