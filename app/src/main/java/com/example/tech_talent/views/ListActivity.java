package com.example.tech_talent.views;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tech_talent.R;
import com.example.tech_talent.adapters.ProjectsAdapter;
import com.example.tech_talent.model.Projects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListActivity extends AppCompatActivity {
    TextView projectList;
    RequestQueue requestQueue;
    private static final String url = "https://tech-talent.hasura.app/api/rest/projects";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        projectList = findViewById (R.id.rvListProject);
        requestQueue = Volley.newRequestQueue (this);
        jsonObjectRequest ();
    }
    private void jsonObjectRequest(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest (
                Request.Method.GET, url, null, new Response.Listener<JSONObject> () {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray ("projects");
                    for (int i = 0; i < jsonArray.length (); i++){
                        JSONObject projects = jsonArray.getJSONObject (i);
                        String id = projects.getString ("id");
                        String title = projects.getString ("title");
                        String description = projects.getString ("description");
                        String start_date = projects.getString ("start_date");
                        String expected_end_date = projects.getString ("expected_end_date");
                        String amount_people = projects.getString ("amount_people");
                        projectList.append ("ID: "+ id +", \n" + "Projeto: " + title + ", \n"+"Descrição: " + description + ", \n"+"Data Inicial: "
                                + start_date + ", \n" +"Data Prevista: "+ expected_end_date + ", \n"+"Quantidade Pessoa: " + amount_people + "\n\n");

                    }
                } catch (JSONException e) {
                    e.printStackTrace ();
                }
            }
        }, new Response.ErrorListener () {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap header = new HashMap<>();
                header.put("Content-Type", "application/json");
                header.put("x-hasura-access-key", "CQOsnv00PT6e7E8UY06ti0tmFgs4GGT7DZrnZvJqS649gBVFUSH1dmiRpmIJdsd4");

                return header;
            }
        };
        requestQueue.add (jsonObjectRequest);
    }
}



