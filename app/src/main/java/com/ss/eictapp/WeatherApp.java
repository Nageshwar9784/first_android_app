package com.ss.eictapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ss.eictapp.model.WeatherResponse;
import com.ss.eictapp.util.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApp extends AppCompatActivity implements View.OnClickListener {
    TextView tv;
    Button getweather;
    EditText pincode;
    final public static String BASE_URL="http://api.openweathermap.org/";
    final public static String API_KEY="e36681777cd1f809b3e5691c61863744";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_app);
        tv=findViewById(R.id.weather);
        getweather=findViewById(R.id.getweather);
        pincode=findViewById(R.id.pincode);
        getweather.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        getWeather(pincode.getText().toString()+",IN");

    }

    private void getWeather(String value) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        WeatherService service=retrofit.create(WeatherService.class);
        Call<WeatherResponse> call=service.getWeatherData(value, API_KEY);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                Toast.makeText(WeatherApp.this, "INVOKED", Toast.LENGTH_SHORT).show();
                if(response.code()==200)
                {
                    WeatherResponse response1=response.body();
                    String weather="Country: "+response1.getSys().getCountry()+"\n"+
                            "City: "+response1.getName()+"\n"+
                            "Description: "+response1.getWeather().get(0).getDescription()+"\n"+
                            "Current Temp.: "+convertTemp(response1.getMain().getTemp())+"°C\n"+
                            "Humidity: "+response1.getMain().getHumidity()+"\n"+
                            "Pressure: "+response1.getMain().getPressure()+"\n"+
                            "Max Temp.: "+convertTemp(response1.getMain().getTempMax())+"°C\n"+
                            "Min Temp.: "+convertTemp(response1.getMain().getTempMin())+"°C\n"+
                            "Wind Speed: "+response1.getWind().getSpeed()+"\n";
                    tv.setText(weather);
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Toast.makeText(WeatherApp.this, "ERROR: "+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
            public double convertTemp(double value)
            {
                double a;
                a=value-273.15;
                return a;
            }
        });
    }
}