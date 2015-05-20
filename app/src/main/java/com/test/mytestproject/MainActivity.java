package com.test.mytestproject;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private JniResource mJniRes;
    private EditText mEditText1;
    private EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText1 = (EditText) findViewById(R.id.edt_1);
        mEditText2 = (EditText) findViewById(R.id.edt_2);
        mJniRes = new JniResource(this);
        TextView tv = (TextView) findViewById(R.id.tv_t);
        tv.setText(mJniRes.hello());
        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(mEditText1.getText().toString())||TextUtils.isEmpty(mEditText2.getText().toString())){
                    Toast.makeText(MainActivity.this, "内容不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                mJniRes.showAddToast(Integer.valueOf(mEditText1.getText().toString()),Integer.valueOf(mEditText2.getText().toString()));
            }
        });
        findViewById(R.id.btn_del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mEditText1.getText().toString()) || TextUtils.isEmpty(mEditText2.getText().toString())) {
                    Toast.makeText(MainActivity.this, "内容不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                mJniRes.showDelToast(Integer.valueOf(mEditText1.getText().toString()), Integer.valueOf(mEditText2.getText().toString()));
            }
        });
    }

}
