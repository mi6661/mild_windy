package com.example.weather;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ImageButton ib_document;    //文件按钮
    private ImageButton ib_settting;    //设置按钮
    private LinearLayout ll_cities;     //城市横向布局滑动布局对象
    private TextView tv_temperature;    //温度文本组件
    private TextView tv_weather;        //天气信息文本组件
    private TextView tv_suggestion;     //建议信息文本组件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ib_document = findViewById(R.id.ib_document);
        ib_settting = findViewById(R.id.ib_setting);
        ll_cities = findViewById(R.id.ll_cities);
        tv_temperature = findViewById(R.id.tv_temperature);
        tv_weather = findViewById(R.id.tv_weather);
        tv_suggestion = findViewById(R.id.tv_suggestion);


    }
}