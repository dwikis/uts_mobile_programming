package com.e.kuis;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class daftar extends AppCompatActivity implements ListView.OnItemClickListener{
    private ListView listView;
    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        getJSON();
    }


    private void showEmployee(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String kode = jo.getString(konfigurasi.TAG_KODE);
                String nama = jo.getString(konfigurasi.TAG_NAMA);

                HashMap<String,String> employees = new HashMap<>();
                employees.put(konfigurasi.TAG_KODE,kode);
                employees.put(konfigurasi.TAG_NAMA,nama);
                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                daftar.this, list, R.layout.list_item,
                new String[]{konfigurasi.TAG_KODE,konfigurasi.TAG_NAMA},
                new int[]{R.id.id, R.id.kode});

        listView.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(daftar.this,"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showEmployee();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_ALL);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, tampilan.class);
        HashMap<String,String> map =(HashMap)parent.getItemAtPosition(position);
        String empKode = map.get(konfigurasi.TAG_KODE).toString();
        intent.putExtra(konfigurasi.EMP_KODE,empKode);
        startActivity(intent);
    }
}
