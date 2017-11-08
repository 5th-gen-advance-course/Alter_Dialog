package com.example.ratha.alertdialogdemo.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ratha.alertdialogdemo.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ratha on 11/8/2017.
 */

public class ListDialog extends DialogFragment {
    List<String> list= Arrays.asList("Red","Blue","Yellow","Ping");
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("List Dialog");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        /*.setItems(R.array.color_dialog_array, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), ""+which, Toast.LENGTH_SHORT).show();
            }
        });*/
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,getActivity().getResources().getStringArray(R.array.color_dialog_array));

        builder.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), ""+which, Toast.LENGTH_SHORT).show();
            }
        });

        return builder.create();
    }


}
