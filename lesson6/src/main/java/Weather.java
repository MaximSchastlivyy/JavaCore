import okhttp3.*;
import java.io.IOException;

public class Weather {

    public static void main(String[] args) throws IOException {

        OkHttpClient okHttpClient = new OkHttpClient();

        final String APIKEY = "f9e3dc9a-9b5a-462e-9191-9ed177f37278";

        Request requestWeather = new Request.Builder()
                .url("https://api.weather.yandex.ru/v2/forecast?lat=59.93863&lon=30.31413&limit=5")
                .addHeader("X-Yandex-API-Key", APIKEY)
                .build();

        Response responseWeather = okHttpClient.newCall(requestWeather).execute();
        System.out.println(responseWeather.code());
        System.out.println(responseWeather.headers());
        System.out.println(responseWeather.body().string());
    }
}
