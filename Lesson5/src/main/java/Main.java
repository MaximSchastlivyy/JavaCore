import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<AppData> appDataArrayList = new ArrayList<>();
        ArrayList<AppData> appDataArrayList1 = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("values.csv"))) {
            String tempString = bufferedReader.readLine();
            String[] values = tempString.split(";");
            String tempData;
            appDataArrayList.add(new AppData(values));

            while ((tempData = bufferedReader.readLine()) != null) {
                String[] data = tempData.split(";");
                appDataArrayList1.add(new AppData(data));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter out = new PrintWriter("values_new.csv")) {
            for (AppData appData : appDataArrayList) {
                out.println(appData);
            }
            for (AppData appData : appDataArrayList1) {
                out.println(appData);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

