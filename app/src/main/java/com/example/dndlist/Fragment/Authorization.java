package com.example.dndlist.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.dndlist.R;

public class Authorization extends Fragment {
    private final static String TAG = "Authorization";

    EditText email_field , psw_field;

    public Authorization() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_authorization, container, false);
        email_field = view.findViewById(R.id.mailFieldTxt);
        psw_field = view.findViewById(R.id.passwordFieldTxt);

        return inflater.inflate(R.layout.fragment_authorization, container, false);
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);
        view.findViewById(R.id.valid_btn).setOnClickListener(view12 -> {
            navController.navigate(R.id.action_authorization_to_charactersMenu);
            login();
        });

        view.findViewById(R.id.reg_btn).setOnClickListener(view1 -> navController.navigate(R.id.go_to_reg));
    }


    protected void login() {
        Log.d(TAG, "start login");
        Log.d(TAG, email_field.toString());
        String email = email_field.getText().toString();
        String psw = psw_field.getText().toString();
        Log.d(TAG, String.format("Entered data: Email: %s,  Psw: %s", email, psw));
        /* TODO: После появления api добавить функционал*/
    }

}