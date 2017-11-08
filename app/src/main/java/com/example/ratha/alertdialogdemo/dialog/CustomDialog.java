package com.example.ratha.alertdialogdemo.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.SupportActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ratha.alertdialogdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ratha on 11/8/2017.
 */

public class CustomDialog extends DialogFragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Multiple Choice Dialog");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        LayoutInflater inflater= getActivity().getLayoutInflater();
        final View view =inflater.inflate(R.layout.custom_dialog_layout, null);
        final ViewHolder viewHolder= new ViewHolder(view);
        builder.setView(view);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name =viewHolder.username.getText().toString();
                String pass =viewHolder.pass.getText().toString();
                Log.e("user name",name);
                Log.e("user pass",pass);

                dialog.dismiss();
            }
        });
        return builder.create();
    }

    class ViewHolder{
        EditText username;
        EditText pass;
        public ViewHolder(View view){
            username=view.findViewById(R.id.tv_user_name);
            pass=view.findViewById(R.id.tv_user_pass);
        }
    }
}
