package tw.com.pcschool.t090405;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
}
