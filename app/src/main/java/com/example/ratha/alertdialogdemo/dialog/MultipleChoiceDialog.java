package com.example.ratha.alertdialogdemo.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.ratha.alertdialogdemo.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ratha on 11/8/2017.
 */

public class MultipleChoiceDialog extends DialogFragment {
    // List<String> list= Arrays.asList("Red","Blue","Yellow","Ping");
    String items[];
    List<String> checkeds;
    static boolean[] itemIsChecked =new boolean[10];
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        items=getActivity().getResources().getStringArray(R.array.color_dialog_array);
        checkeds=new ArrayList<>();
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

        builder.setMultiChoiceItems(items,itemIsChecked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getActivity(), ""+which, Toast.LENGTH_SHORT).show();
                    checkeds.add(items[which]);
                    itemIsChecked[which]=true;
                }else{
                    checkeds.remove(items[which]);
                    itemIsChecked[which]=false;
                }

                MultipleChoiceDialog.this.display(checkeds);
            }

        });

        return builder.create();
    }

    private void display(List<String> list){
        String item="[";
        for(String s: list){
            item=item+s+ ",";
        }

        item=item+"]";
        Log.e("item",item);
    }

}
