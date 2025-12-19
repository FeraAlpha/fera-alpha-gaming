package com.feraalpha.gaming;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.DataOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView status = findViewById(R.id.statusText);

        if (hasRoot()) {
            status.setText("Root detectado\nExecutando painel...");
            executePanel();
        } else {
            status.setText("Root NÃO detectado");
        }
    }

    private boolean hasRoot() {
        try {
            Process process = Runtime.getRuntime().exec("su");
            DataOutputStream os = new DataOutputStream(process.getOutputStream());
            os.writeBytes("exit\n");
            os.flush();
            process.waitFor();
            return process.exitValue() == 0;
        } catch (Exception e) {
            return false;
        }
    }

    private void executePanel() {
        try {
            Runtime.getRuntime().exec(
                new String[]{"su", "-c", "sh /data/adb/modules/painel-latencia/painel"}
            );
        } catch (Exception ignored) {
        }
    }
}
