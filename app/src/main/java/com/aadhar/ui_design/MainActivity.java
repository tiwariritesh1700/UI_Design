package com.aadhar.ui_design;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnInfo, btnSuccess, btnWarning, btnAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindButton();

    }


    private void bindButton() {
        btnInfo = findViewById(R.id.btn_info);
        btnSuccess = findViewById(R.id.btn_success);
        btnWarning = findViewById(R.id.btn_warning);
        btnAlert = findViewById(R.id.btn_alert);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDialog appCompatDialog = getDialog(MainActivity.this, DialogType.INFO, "Title Info", "This is content of info dialog",
                        R.string.ok, R.string.canceal, R.string.more, new MyCallback() {
                            @Override
                            public void onClickDialog(int buttontype) {
                                switch (buttontype) {
                                    case DialogInterface.BUTTON_POSITIVE:
                                        Toast.makeText(MainActivity.this, "Clicked on OK button", Toast.LENGTH_SHORT).show();
                                        break;
                                    case DialogInterface.BUTTON_NEGATIVE:
                                        Toast.makeText(MainActivity.this, "Clicked on Canceal button", Toast.LENGTH_SHORT).show();
                                        break;
                                    case DialogInterface.BUTTON_NEUTRAL:
                                        Toast.makeText(MainActivity.this, "Clicked on More button", Toast.LENGTH_SHORT).show();
                                        break;
                                }
                            }
                        });

                appCompatDialog.show();
            }
        });
        btnSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDialog appCompatDialog = getDialog(MainActivity.this, DialogType.SUCCESS, "Title Success", "This is content of Success dialog",
                        R.string.ok, R.string.canceal, R.string.more, new MyCallback() {
                            @Override
                            public void onClickDialog(int buttontype) {
                                switch (buttontype) {
                                    case DialogInterface.BUTTON_POSITIVE:
                                        Toast.makeText(MainActivity.this, "Clicked on OK button", Toast.LENGTH_SHORT).show();
                                        break;
                                    case DialogInterface.BUTTON_NEGATIVE:
                                        Toast.makeText(MainActivity.this, "Clicked on Canceal button", Toast.LENGTH_SHORT).show();
                                        break;
                                    case DialogInterface.BUTTON_NEUTRAL:
                                        Toast.makeText(MainActivity.this, "Clicked on More button", Toast.LENGTH_SHORT).show();
                                        break;
                                }
                            }
                        });

                appCompatDialog.show();
            }
        });
        btnWarning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDialog appCompatDialog = getDialog(MainActivity.this, DialogType.WARNING, "Title Warning", "This is content of Warning dialog",
                        R.string.ok, R.string.canceal, R.string.more, new MyCallback() {
                            @Override
                            public void onClickDialog(int buttontype) {
                                switch (buttontype) {
                                    case DialogInterface.BUTTON_POSITIVE:
                                        Toast.makeText(MainActivity.this, "Clicked on OK button", Toast.LENGTH_SHORT).show();
                                        break;
                                    case DialogInterface.BUTTON_NEGATIVE:
                                        Toast.makeText(MainActivity.this, "Clicked on Canceal button", Toast.LENGTH_SHORT).show();
                                        break;
                                    case DialogInterface.BUTTON_NEUTRAL:
                                        Toast.makeText(MainActivity.this, "Clicked on More button", Toast.LENGTH_SHORT).show();
                                        break;
                                }
                            }
                        });

                appCompatDialog.show();
            }
        });
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDialog appCompatDialog = getDialog(MainActivity.this, DialogType.ALERT, "Title Alert", "This is content of Alert dialog",
                        R.string.ok, R.string.canceal, R.string.more, new MyCallback() {
                            @Override
                            public void onClickDialog(int buttontype) {
                                switch (buttontype) {
                                    case DialogInterface.BUTTON_POSITIVE:
                                        Toast.makeText(MainActivity.this, "Clicked on OK button", Toast.LENGTH_SHORT).show();
                                        break;
                                    case DialogInterface.BUTTON_NEGATIVE:
                                        Toast.makeText(MainActivity.this, "Clicked on Canceal button", Toast.LENGTH_SHORT).show();
                                        break;
                                    case DialogInterface.BUTTON_NEUTRAL:
                                        Toast.makeText(MainActivity.this, "Clicked on More button", Toast.LENGTH_SHORT).show();
                                        break;
                                }
                            }
                        });

                appCompatDialog.show();
            }
        });

    }

    public enum DialogType {

        INFO,
        SUCCESS,
        WARNING,
        ALERT
    }


    public interface MyCallback {

        void onClickDialog(int buttontype);
    }

    private AppCompatDialog getDialog(Context context, DialogType dialogType, String title, String message,
                                      int buttonPositiveResId, int buttonNegativeButtonResId, int buttonNeutralButtonResId, final MyCallback myCallback) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.layout_dialog, null);

        LinearLayout lltitle = view.findViewById(R.id.ll_title);

        TextView tvTitle, tvMessage;

        tvTitle = view.findViewById(R.id.tv_title);
        tvMessage = view.findViewById(R.id.tv_message);

        tvTitle.setText(title);
        tvMessage.setText(message);

        AlertDialog.Builder builder;

        switch (dialogType) {

            case INFO:
                builder = new AlertDialog.Builder(context, R.style.InfoTheme);
                lltitle.setBackgroundColor(context.getResources().getColor(R.color.info));
                break;
            case ALERT:
                builder = new AlertDialog.Builder(context, R.style.AlertTheme);
                lltitle.setBackgroundColor(context.getResources().getColor(R.color.alert));
                break;
            case SUCCESS:
                builder = new AlertDialog.Builder(context, R.style.SucessTheme);
                lltitle.setBackgroundColor(context.getResources().getColor(R.color.sucess));
                break;
            case WARNING:
                builder = new AlertDialog.Builder(context, R.style.WarningTheme);
                lltitle.setBackgroundColor(context.getResources().getColor(R.color.warning));
                break;
            default:
                builder = new AlertDialog.Builder(context, R.style.InfoTheme);
                lltitle.setBackgroundColor(context.getResources().getColor(R.color.info));
                break;
        }

        builder.setView(view);

        if (buttonPositiveResId != -1) {

            builder.setPositiveButton(buttonPositiveResId, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    if (myCallback != null) {

                        myCallback.onClickDialog(DialogInterface.BUTTON_POSITIVE);
                    }
                }
            });
        }

        if (buttonNegativeButtonResId != -1) {

            builder.setNegativeButton(buttonNegativeButtonResId, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    if (myCallback != null) {

                        myCallback.onClickDialog(DialogInterface.BUTTON_NEGATIVE);
                    }
                }
            });
        }

        if (buttonNeutralButtonResId != -1) {

            builder.setNeutralButton(buttonNeutralButtonResId, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    if (myCallback != null) {

                        myCallback.onClickDialog(DialogInterface.BUTTON_NEUTRAL);
                    }
                }
            });
        }

        AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);

        return alertDialog;
    }


}
