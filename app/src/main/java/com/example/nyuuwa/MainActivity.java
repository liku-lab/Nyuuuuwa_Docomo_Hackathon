package com.example.nyuuwa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.provider.FontRequest;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.view.View.OnClickListener;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    static final String TAG = "ListViewTest";

    private EditText editText;

    static List<String> dataList = new ArrayList<String>();
    static ArrayAdapter<String> adapter;

    ListView listView;
    Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListeners();
        setAdapters();
    }

    protected void findViews(){
        listView = (ListView)findViewById(R.id.listView1);
        addButton = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.edit_text);
    }

    protected void setListeners(){
        addButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button:
                symbol2emoji();
                //break;
        }
    }

    protected void setAdapters(){
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                dataList);
        listView.setAdapter(adapter);
    }

//  記号を絵文字に変換
    protected void symbol2emoji(){
        String text  = editText.getText().toString();

//        文末に「。」追加
        char lastChar = text.charAt(text.length() - 1);
        if (lastChar == '。') {
        } else {
            if ((lastChar == '?') || (lastChar == '？')) {
            } else {
                text = text + "。";
            }
        }

//        「、」変換
        text = text.replace("、", "\uD83D\uDE04");
//        「。」変換
        text = text.replace("。", "\uD83D\uDE0A");
//        「? or ？」変換
        text = text.replace("?","\uD83E\uDD14");
        text = text.replace("？","\uD83E\uDD14");
        adapter.add(text);
    }
}
