package com.tokoonline.ban.onlineshop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity{
    private static final String EMAIL = "email";
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    TextInputLayout txtusername;
    TextInputLayout txtpassword;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cetakhash();
        dialog = new ProgressDialog(LoginActivity.this);
        pref = getSharedPreferences("login", MODE_PRIVATE);
        //cetakhash();
        /*
        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().build();
        final GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(LoginActivity.this, signInOptions);
        SignInButton googleSignButton = findViewById(R.id.sign_in_button);
        googleSignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("lala3", "onActivityResult: ");
                Intent intent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(intent, 997);
            }
        });
        */
        txtusername = (TextInputLayout) findViewById(R.id.txtusername);
        txtpassword = (TextInputLayout) findViewById(R.id.txtpassword);
        Button btnlogin = (Button) findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = txtusername.getEditText().getText().toString().trim();
                final String password = txtpassword.getEditText().getText().toString().trim();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "please fill my heart first to send a request :(", Toast.LENGTH_SHORT).show();
                } else {

                    editor = pref.edit();
                    editor.putInt("userid", 1);
                    editor.apply();
                    Intent in = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(in);
                    finish();


                    /*
                    dialog.setMessage("Login process");
                    dialog.show();
                    String token = getSharedPreferences("firebase_token", MODE_PRIVATE).getString("firebase_token", "");
                    BookingService bookingService = BookingClient.getRetrofit().create(BookingService.class);
                    Call<BookingResponse> call = bookingService.login(username, password, token);
                    call.enqueue(new Callback<BookingResponse>() {
                        @Override
                        public void onResponse(Call<BookingResponse> call, Response<BookingResponse> response) {
                            try {
                                boolean success = response.body().getSuccess();
                                if (response.isSuccessful()) {
                                    if (success) {
                                        editor = pref.edit();
                                        editor.putInt("userid", response.body().getUserId());
                                        editor.apply();
                                        Log.d("iduser", "onResponse: " + response.body().getUserId());
                                        Intent in = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(in);
                                        finish();
                                    } else {
                                        Toast.makeText(LoginActivity.this, "Something wrong is happen", Toast.LENGTH_SHORT).show();
                                    }
                                    if (dialog.isShowing()) {
                                        dialog.dismiss();
                                    }
                                }
                                Log.e("Tag", "onResponse: " + response.code());
                            }
                            catch (Exception e){
                                if (dialog.isShowing()) {
                                    dialog.dismiss();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<BookingResponse> call, Throwable t) {
                            if (dialog.isShowing()) {
                                dialog.dismiss();
                            }
                            t.printStackTrace();
                            Toast.makeText(LoginActivity.this, "Cannot connect to server", Toast.LENGTH_SHORT).show();
                        }
                    });
                    */
                }
            }
        });

    }
    public void cetakhash() {
        PackageInfo info;
        try {
            info = getPackageManager().getPackageInfo("com.tangria.spa.bookingku", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                //String something = new String(Base64.encodeBytes(md.digest()));
                Log.e("hashkey", something);
            }
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e("name not found", e1.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("no such an algorithm", e.toString());
        } catch (Exception e) {
            Log.e("exception", e.toString());
        }
    }

}

