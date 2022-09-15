package com.example.nyuuwa;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.nyuuwa.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    ArrayList data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        // ListViewに表示する初期値
//         data.add("\uD83E\uDDD4 　部長の田中です");

        // リスト項目とListViewを対応付けるArrayAdapterを用意する
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);

        // ListViewにArrayAdapterを設定する
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    /** button クリック時 */
    public void sendMessage(View view) {
        // 入力されたテキストをListViewの項目に追加
        EditText editText = (EditText) findViewById(R.id.msg);
        String value = editText.getText().toString();
        if(value.length() == 0) {
            // 入力テキストがない場合
            return;
        }
        // アイコンと名前を追加
        data.add("\uD83E\uDDD4　" + value);

        // リスト項目とListViewを対応付けるArrayAdapterを用意する
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);

        // ListViewにArrayAdapterを設定する
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // 入力テキストを削除
        editText.getText().clear();
    }
}