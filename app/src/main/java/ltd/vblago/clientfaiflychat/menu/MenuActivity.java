package ltd.vblago.clientfaiflychat.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ltd.vblago.clientfaiflychat.R;

public class MenuActivity extends AppCompatActivity implements MenuView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public void showError(String error) {

    }
}
