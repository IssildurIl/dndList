package com.example.dndlist.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.dndlist.R;
import com.example.dndlist.model.User;
import com.example.dndlist.repository.DbUtil;
import com.google.android.material.textfield.TextInputLayout;

import lombok.var;

public class Authorization extends Fragment {
    private final static String TAG = "Authorization";

    TextInputLayout email_field, psw_field;
    NavController navController;

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
        email_field = view.findViewById(R.id.mailField);
        psw_field = view.findViewById(R.id.passwordField);
        return view;
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DbUtil.init(getContext());
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.valid_btn).setOnClickListener(view12 -> {
            User user = new User();
            user.setEmail(email_field.getEditText().getText().toString());
            user.setPassword(psw_field.getEditText().getText().toString());
            new LogInTask().execute(user);
        });
        getActivity().findViewById(R.id.bottom_navigation).setVisibility(View.GONE);
        new CheckLogInTask().execute();
        view.findViewById(R.id.reg_btn).setOnClickListener(view1 -> navController.navigate(R.id.go_to_reg));
    }


    private class LogInTask extends AsyncTask<User, Void, User> {
        @Override
        protected User doInBackground(User... users) {
            var db = DbUtil.getInstance().userDAO();
            db.insert(users[0]);
            return users[0];
        }

        @Override
        protected void onPostExecute(User user) {
            if (user != null) {
                navController.navigate(R.id.action_authorization_to_charactersMenu);
            }
        }

    }


    private class CheckLogInTask extends AsyncTask<Void, Void, User> {
        @Override
        protected User doInBackground(Void... voids) {
            var db = DbUtil.getInstance().userDAO();
            return db.getUser();
        }

        @Override
        protected void onPostExecute(User user) {
            if (user != null) {
                navController.navigate(R.id.action_authorization_to_charactersMenu);
            }
        }
    }

}