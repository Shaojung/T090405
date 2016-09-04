package tw.com.pcschool.t090405;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickWrite(View v)
    {
        File path = getFilesDir();
        // File f = new File(path.toString(), "mydata.txt");
        // String fName = f.toString();
        String fName = path.toString() + "/" + "mydata.txt";
        FileOutputStream fOut = null;
        try {

            fOut = openFileOutput("mydata.txt", MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);  // 寫入資料
            osw.write("She sell sea shells on the sea shore .");
            osw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void clickRead(View v)
    {
        char[] buffer = new char[1];
        FileReader fr = null;
        StringBuilder sb = new StringBuilder();
        File file = new File(getFilesDir() + "/" + "mydata.txt");

        try {
            fr = new FileReader(file);
            while (fr.read(buffer)!= -1) {
                sb.append(new String(buffer));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("READFILE", sb.toString());

    }

    public void clickShowJSON(View v)
    {
        JSONObject obj1 = new JSONObject();
        JSONObject obj2 = new JSONObject();
        JSONArray array = new JSONArray();
        try {
            obj1.put("name", "Bob");
            obj1.put("tel", "123");
            obj2.put("name", "Mary");
            obj2.put("tel", "456");
            Log.d("OBJ1", obj1.toString());
            array.put(obj1);
            array.put(obj2);
            Log.d("array", array.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
