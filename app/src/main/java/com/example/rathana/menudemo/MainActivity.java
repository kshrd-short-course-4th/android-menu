package com.example.rathana.menudemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvContextMenu;
    Button btnContextMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvContextMenu=findViewById(R.id.tvContextMenu);
        btnContextMenu=findViewById(R.id.button);
        registerForContextMenu(tvContextMenu);
        registerForContextMenu(btnContextMenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.place:
                this.showMessage("place clicked");
                return true;
            case R.id.share :
                this.showMessage("share clicked");
                return true;
            case  R.id.setting:
                Intent intent=new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://google.com.kh"));
                startActivity(intent);
                return true;
            case R.id.fb:
                this.showMessage(item.getTitle().toString());
                return true;
        }
        this.showMessage("menu item is clicked");
        return false;
    }

    //context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=getMenuInflater();
        if(v.getId()==R.id.tvContextMenu){
            menu.setHeaderTitle("Action");
            inflater.inflate(R.menu.context_menu,menu);
        }else if(v.getId()==R.id.button){
            menu.setHeaderTitle("second context menu");
            inflater.inflate(R.menu.context_2_menu,menu);
        }

        //menu.setHeaderIcon(R.drawable.settings);
        //getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    //set event to context menu items


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.copy:
                this.showMessage(item.getTitle().toString());
                return true;
            case R.id.cut:
                this.showMessage(item.getTitle().toString());
                return true;
        }
        return false;
    }

    private  void showMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
