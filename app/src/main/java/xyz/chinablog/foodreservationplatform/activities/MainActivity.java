package xyz.chinablog.foodreservationplatform.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import xyz.chinablog.foodreservationplatform.R;
import xyz.chinablog.foodreservationplatform.model.FoodTruck;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url="https://chinablog.xyz/api/v1/foodtruck";
        final ArrayList<FoodTruck> foodTruckList=new ArrayList<>();

        final JsonArrayRequest getTruck = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                System.out.println(response.toString());

                try{
                    JSONArray foodTrucks = response;
                    for(int x = 0;x<foodTrucks.length();x++){
                        JSONObject foodTruck = foodTrucks.getJSONObject(x);
                        String name = foodTruck.getString("name");
                        String id = foodTruck.getString("_id");
                        String foodType = foodTruck.getString("foodtype");
                        Double avgCost = foodTruck.getDouble("avgcost");

                        FoodTruck newFoodTruck =new FoodTruck(id, name, foodType, avgCost);
                        foodTruckList.add(newFoodTruck);
                    }
                }catch(JSONException e){
                    Log.v("JSON","EXC"+e.getLocalizedMessage());
                }
                System.out.println("This is the food truck name"+foodTruckList.get(0).getName());
                }
            }, new Response.ErrorListener() {
                public void onErrorResponse(VolleyError error){
                    Log.v("API","ERR"+error.getLocalizedMessage());
                }
        });

        Volley.newRequestQueue(this).add(getTruck);
    }
}
