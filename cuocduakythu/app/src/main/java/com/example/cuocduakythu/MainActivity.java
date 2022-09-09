package com.example.cuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtDiem;
    CheckBox cb1, cb2, cb3;
    SeekBar sb1, sb2, sb3;
    ImageButton ibtnplay;
    int soDiem = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        sb1.setEnabled(false);
        sb2.setEnabled(false);
        sb3.setEnabled(false);

        txtDiem.setText(soDiem + "");

        CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long l) {
                int number = 4;
                Random rand = new Random();
                int one = rand.nextInt(number);
                int two = rand.nextInt(number);
                int three = rand.nextInt(number);

                //kiem tra win
                if(sb1.getProgress() >= sb1.getMax()){
                    this.cancel();
                    ibtnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "One Win", Toast.LENGTH_SHORT).show();
                    // kiểm tra đặt cược
                    if(cb1.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Correct + 10 point", Toast.LENGTH_SHORT).show();
                    }else {
                        soDiem -= 5;
                        Toast.makeText(MainActivity.this, "Incorrect - 5 ponit", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }
                if(sb2.getProgress() >= sb2.getMax()){
                    this.cancel();
                    ibtnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Two Win", Toast.LENGTH_SHORT).show();
                    if(cb2.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Correct + 10 point", Toast.LENGTH_SHORT).show();
                    }else {
                        soDiem -= 5;
                        Toast.makeText(MainActivity.this, "Incorrect - 5 ponit", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }
                if(sb3.getProgress() >= sb3.getMax()){
                    this.cancel();
                    ibtnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Three Win", Toast.LENGTH_SHORT).show();
                    if(cb3.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Correct + 10 point", Toast.LENGTH_SHORT).show();
                    }else {
                        soDiem -= 5;
                        Toast.makeText(MainActivity.this, "Incorrect - 5 ponit", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }
                sb1.setProgress(sb1.getProgress() + one);
                sb2.setProgress(sb2.getProgress() + two);
                sb3.setProgress(sb3.getProgress() + three);

            }

            @Override
            public void onFinish() {

            }
        };
        ibtnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb1.isChecked() || cb2.isChecked() || cb3.isChecked()){
                    sb1.setProgress(0);
                    sb2.setProgress(0);
                    sb3.setProgress(0);

                    ibtnplay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();

                    DisaleCheckBox();
                }else{
                    Toast.makeText(MainActivity.this, "Vui lòng đặt cược trước khi chơi", Toast.LENGTH_SHORT).show();
                }

            }
        });
// chọn animal đặt cược
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });

        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    cb1.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });

        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cb1.setChecked(false);
                    cb2.setChecked(false);
                }
            }
        });
    }

    private  void EnableCheckBox(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
    }

    private void DisaleCheckBox(){
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }
    private void AnhXa(){
        txtDiem = (TextView) findViewById(R.id.textviewDiemSo);
        ibtnplay = (ImageButton) findViewById(R.id.play_btn);
        cb1 = (CheckBox) findViewById(R.id.checkbox1);
        cb2 = (CheckBox) findViewById(R.id.checkbox2);
        cb3 = (CheckBox) findViewById(R.id.checkbox3);
        sb1 = (SeekBar) findViewById(R.id.seekbar1);
        sb2 = (SeekBar) findViewById(R.id.seekbar2);
        sb3 = (SeekBar) findViewById(R.id.seekbar3);

    }
}