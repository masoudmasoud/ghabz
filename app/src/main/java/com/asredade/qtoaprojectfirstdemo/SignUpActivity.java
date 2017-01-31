package com.asredade.qtoaprojectfirstdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {



    private PopupWindow pwindo;
    Button btnClosePopup;
    Button btnCreatePopup;


    User user=new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);
        View view = getSupportActionBar().getCustomView();
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.imageButton);

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initiatePopupWindow();
            }
        });






    }


    private void initiatePopupWindow() {
        try {
// We need to get the instance of the LayoutInflater
            LayoutInflater inflater = (LayoutInflater) SignUpActivity.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popup_activity,
                    (ViewGroup) findViewById(R.id.popup_element));
            pwindo = new PopupWindow(layout, 1000, 800, true);
            pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);

            btnClosePopup = (Button) layout.findViewById(R.id.btn_close_popup);
            btnClosePopup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pwindo.dismiss();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void btnSignUp_Clicked(View v) throws InterruptedException {


        user.name=((EditText)findViewById(R.id.txtFullName)).getText().toString();
        user.userName=((EditText)findViewById(R.id.txtUserName)).getText().toString();
        user.password=((EditText)findViewById(R.id.txtPassword)).getText().toString();
        user.email=((EditText)findViewById(R.id.txtEmail)).getText().toString();
        user.cellPhone=((EditText)findViewById(R.id.txtCellPhone)).getText().toString();
        Toast.makeText(this,"لینک فعالسازی به ایمیل شما ارسال گردید",Toast.LENGTH_LONG).show();

        Intent i=new Intent(this,ConfirmSignUpActivity.class);
        i.putExtra("User",user);
        startActivity(i);

    }





}