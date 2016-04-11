package io.sharif.prj1.st92106356.st92110238.prj1;

import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final int moveRightDistance = -15;
        final int moveLeftDistance = 15;
        final int moveUpDistance = 15;
        final int moveDownDistance = -15;

        final ImageView charater = (ImageView) findViewById(R.id.go_character);


        Button button_right = (Button) findViewById(R.id.button_right);
        Button button_left = (Button) findViewById(R.id.button_left);
        Button button_down = (Button) findViewById(R.id.button_down);
        Button button_up = (Button) findViewById(R.id.button_up);

        button_right.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                charater.setX(charater.getX() - moveRightDistance);
            }
        });

        button_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charater.setX(charater.getX() - moveLeftDistance);
            }
        });

        button_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charater.setY(charater.getY() - moveDownDistance);
            }
        });

        button_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charater.setY(charater.getY() - moveUpDistance);
            }
        });


        Button button_menu = (Button) findViewById(R.id.button_menu);

        button_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu menu = new PopupMenu(getApplicationContext(), v);
                getMenuInflater().inflate(R.menu.popup, menu.getMenu());
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        SharedPreferences sharedPreferences = getSharedPreferences("Save_Game_1", 0);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        if (item.getItemId() == R.id.new_game) {
                            LayoutInflater inflater = getLayoutInflater();
                            View layout = inflater.inflate(R.layout.toast_layout,
                                    (ViewGroup) findViewById(R.id.toast_layout_root));
                            TextView textView = (TextView) layout.findViewById(R.id.text);
                            textView.setText(R.string.new_game);
//                            String text = textView.getText().toString();
//                            SpannableString spannableString = new SpannableString(text);
//                            spannableString.setSpan(new RainbowSpan(),0,text.length());

                            Toast toast = new Toast(getApplicationContext());
                            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                            toast.setDuration(Toast.LENGTH_LONG);
                            toast.setView(layout);
                            toast.show();
                            charater.setX(0);
                            charater.setY(0);
                        }
                        if (item.getItemId() == R.id.save_game) {
                            editor.putFloat("x", charater.getX());
                            editor.putFloat("y", charater.getY());
                            editor.commit();
                        }
                        return false;
                    }
                });
                menu.show();
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences("Save_Game_1", 0);
        charater.setX(sharedPreferences.getFloat("x",0));
        charater.setY(sharedPreferences.getFloat("y",0));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_aboutus) {
            FragmentManager fragmentManager = getFragmentManager();
            AboutUs_DialogBox dialogAboutUs = new AboutUs_DialogBox();
            dialogAboutUs.show(fragmentManager, "DialogAboutUs");
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    protected void onStop() {
//        SharedPreferences sharedPreferences = getSharedPreferences("Save_Game_1", 0);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putFloat("x", charater.getX());
//        editor.putFloat("y", charater.getY());
//        editor.commit();
//        super.onStop();
//    }
}
