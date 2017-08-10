package com.villip.ukrainiannutcompany;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    // Choose an arbitrary request code value
    private static final int RC_SIGN_IN = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.READ_SMS}, 1);*/

        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            // already signed in
        } else {
            // not signed in
            showSignInScreen();
        }
    }

    private void showSignInScreen() {
        startActivityForResult(
                // Get an instance of AuthUI based on the default app
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(
                                Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build()))
                        .setTheme(R.style.AppTheme)
                        .build(),
                RC_SIGN_IN);
        //.setTosUrl("https://superapp.example.com/terms-of-service.html")
        //.setPrivacyPolicyUrl("https://superapp.example.com/privacy-policy.html")
    }
}
