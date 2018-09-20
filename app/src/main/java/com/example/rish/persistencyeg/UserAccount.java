package com.example.rish.persistencyeg;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.firebase.ui.auth.ui.AcquireEmailHelper.RC_SIGN_IN;

public class UserAccount extends AppCompatActivity {

    EditText name,pwd,email;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        name=findViewById(R.id.name);
        pwd=findViewById(R.id.pwd);
        email=findViewById(R.id.email);
        final SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(UserAccount.this);
        name.setText(sp.getString("Name",""));

        save=findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor= sp.edit();
                editor.putString("Name",name.getText().toString());
                editor.commit();
                Toast.makeText(UserAccount.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });



      }

    private void updateUI(FirebaseUser user) {


    }

}
