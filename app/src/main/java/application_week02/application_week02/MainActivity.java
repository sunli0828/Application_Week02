package application_week02.application_week02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ListView list_film;
    private MyBaseAdapter adapter;
    private Button btn_urlConnection;
    private EditText edit_name;
    private String UrlStr="https://v.juhe.cn/movie/index?key=f5a73701d49ec4b6d2f7b0fd81bd3b20&title";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_film = findViewById(R.id.list_film);
        btn_urlConnection = findViewById(R.id.btn_urlConnection);
        edit_name = findViewById(R.id.edit_name);

        adapter = new MyBaseAdapter(getBaseContext());
        list_film.setAdapter(adapter);

        btn_urlConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "12345", Toast.LENGTH_LONG).show();

            Util.getInstance().
                getRequest(UrlStr+edit_name.getText().toString(),MyBean.class,new Util.Callback<MyBean>(){
                    @Override
                    public void onSuccess(MyBean myBean) {
                        adapter.setList(myBean.getResult());
                    }
                });
            }
        });

    }
}
