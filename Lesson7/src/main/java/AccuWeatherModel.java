import Entity.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;

public class AccuWeatherModel implements WeatherModel {
    private static final String PROTOKOL = "http";
    private static final String API_KEY = "vCxNl4tOT7A8xeqR2yC0U2cSAMkoN5DM";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_V1 = "v1";
    private static final String LOCATIONS_ENDPOINT = "locations";
    private static final String CITIES_ENDPOINT = "cities";
    private static final String AUTOCOMPLETE_ENDPOINT = "autocomplete";
    private static final String FORECASTS_ENDPOINT = "forecasts";
    private static final String DAILY_ENDPOINT = "daily";
    private static final String FIVE_DAYS_ENDPOINT = "5day";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void getWeather(Period period, String selectedCity) throws IOException {
        String cityKey = detectCityKey(selectedCity);
        if (period == Period.NOW) {
            HttpUrl httpUrl = new HttpUrl.Builder()
                    .scheme(PROTOKOL)
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_V1)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(httpUrl)
                    .build();

            Response response = okHttpClient.newCall(request).execute();
            String responseString = response.body().string();

            String whatTimeIs = objectMapper.readTree(responseString).get(0).at("/LocalObservationDateTime").asText();
            String whatWeatherIs =  objectMapper.readTree(responseString).get(0).at("/WeatherText").asText();
            String whatTempperatureIs =  objectMapper.readTree(responseString).get(0).at("/Temperature")
                    .at("/Metric").at("/Value").asText();
            System.out.println("Прогноз погоды в этом городе на " + whatTimeIs + " - " + whatWeatherIs + ". Температура: " + whatTempperatureIs + " °C.");

            String city = selectedCity;
            String localDate = objectMapper.readTree(responseString).get(0).at("/LocalObservationDateTime").asText();
            String weatherText = objectMapper.readTree(responseString).get(0).at("/WeatherText").asText();
            Double temperature = objectMapper.readTree(responseString).get(0).at("/Temperature/Metric/Value").asDouble();
            DataBaseRepository dataBaseRepository = new DataBaseRepository();
            try {
                dataBaseRepository.saveWeatherData(new Weather(city, localDate, temperature, weatherText));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (period == Period.FIVE_DAYS) {
            HttpUrl httpUrl = new HttpUrl.Builder()
                    .scheme(PROTOKOL)
                    .host(BASE_HOST)
                    .addPathSegment(FORECASTS_ENDPOINT)
                    .addPathSegment(API_V1)
                    .addPathSegment(DAILY_ENDPOINT)
                    .addPathSegment(FIVE_DAYS_ENDPOINT)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(httpUrl)
                    .build();
            Response response = okHttpClient.newCall(request).execute();

            String responseString = response.body().string();
            System.out.println(responseString);
        }
    }

    public void getSavedWeatherData() {
        DataBaseRepository dataBaseRepository = new DataBaseRepository();
        try {
            dataBaseRepository.getSavedWeatherData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String detectCityKey(String selectedCity) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS_ENDPOINT)
                .addPathSegment(API_V1)
                .addPathSegment(CITIES_ENDPOINT)
                .addPathSegment(AUTOCOMPLETE_ENDPOINT)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();

        return cityKey;
    }
}
