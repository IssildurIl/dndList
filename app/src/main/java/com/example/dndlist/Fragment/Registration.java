package com.example.dndlist.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dndlist.R;

public class Registration extends Fragment {
    private final static String TAG = "Registration";

    private final static int createAccount_id = R.id.reg_btn;
    private final static int linkLogin_id = R.id.return_to_auth;
    Button createAccount_btn,linkLogin_btn;

    /* Текстовые поля */
    private final static int email_field_id = R.id.mailFieldTxt;
    private final static int email_re_field_id = R.id.mailRepeatFieldTxt;
    private final static int psw_field_id = R.id.passwordHintTxt;
    private final static int psw_re_field_id = R.id.passwordRepeatHintTxt;
    EditText email_field, email_re_field, psw_field, psw_re_field;


    public Registration() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        createAccount_btn = (Button) view.findViewById(createAccount_id);
        linkLogin_btn = (Button) view.findViewById(linkLogin_id);

        email_field = (EditText) view.findViewById(email_field_id);
        email_re_field = (EditText) view.findViewById(email_re_field_id);
        psw_field = (EditText) view.findViewById(psw_field_id);
        psw_re_field = (EditText) view.findViewById(psw_re_field_id);
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);
        view.findViewById(R.id.reg_btn).setOnClickListener(view1 -> {
            register();
            navController.navigate(R.id.go_to_chars);
        });
        view.findViewById(R.id.return_to_auth).setOnClickListener(view12 -> navController.navigate(R.id.action_registration_to_authorization2));
    }

    protected void register() {
        Log.d(TAG, "start register");
        String email = email_field.getText().toString();
        String email_re = email_re_field.getText().toString();
        String psw = psw_field.getText().toString();
        String psw_re = psw_re_field.getText().toString();
        Log.d(TAG, String.format("Entered data: Name: %s, Email: %s, Psw: %s, PswRe: %s", email, email_re, psw, psw_re));

        /* TODO: После появления api добавить функционал*/
    }
}