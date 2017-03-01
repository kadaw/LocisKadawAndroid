package com.example.user.locistest.Api;

import android.os.AsyncTask;

import com.example.user.locistest.CreateRoomActivity;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by User on 01.03.2017.
 */

public class CreateRoomTask extends AsyncTask {
    CreateRoomActivity activity;
    String roomLabel;
    String token;
    int responseCode;

    public CreateRoomTask(String roomLabel){
        this.roomLabel = roomLabel;
    }

    public static String convertStreamToString(InputStream is) throws IOException {
        InputStreamReader r = new InputStreamReader(is);
        StringWriter sw = new StringWriter();
        char[] buffer = new char[1024];
        try {
            for (int n; (n = r.read(buffer)) != -1;)
                sw.write(buffer, 0, n);
        }
        finally{
            try {
                is.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return sw.toString();
    }

    @Override
    protected Object doInBackground(Object[] params) {
        activity = (CreateRoomActivity) params[0];
        try{
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("Name",roomLabel);

            String jsonString = jsonObject.toString();
            URL url = new URL("http://locis.lod-misis.ru/user");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type","application/json");
            connection.connect();
            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
            wr.write(jsonString);
            wr.flush();
            responseCode = connection.getResponseCode();
            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            token = convertStreamToString(is);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        if (activity != null & token!=null){
            activity.getToken(token,responseCode);

        }
    }
}















