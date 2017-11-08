package com.example.ratha.alertdialogdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ratha.alertdialogdemo.dialog.CustomDialog;
import com.example.ratha.alertdialogdemo.dialog.ListDialog;
import com.example.ratha.alertdialogdemo.dialog.MultipleChoiceDialog;
import com.example.ratha.alertdialogdemo.dialog.SigaleChoiceDialog;
import com.example.ratha.alertdialogdemo.dialog.SimpleDialog;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSimpleDialog)
    public void SimpleDialog(View view){
        new SimpleDialog().show(getFragmentManager(),"simple dialog");
    }

    @OnClick(R.id.btnListDialog)
    public void ListDialog(View view){
        new ListDialog().show(getFragmentManager(),"List dialog");
    }

    @OnClick(R.id.btnSigaleShoiceDialog)
    public void SigaleChoiceDialog(View view){
        new SigaleChoiceDialog().show(getFragmentManager(),"Single choice dialog");
    }
    @OnClick(R.id.btnMulitpleChoiceDialog)
    public void multipleChoiceDialog(View view){
        new MultipleChoiceDialog().show(getFragmentManager(),"Multiple Choice dialog");
    }

    @OnClick(R.id.btnCustomDialog)
    public void customChoiceDialog(View view){
        new CustomDialog().show(getFragmentManager(),"Multiple Choice dialog");
    }
}
