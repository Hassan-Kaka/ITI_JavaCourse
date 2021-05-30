import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CityAndCountry {

    //Get List of Countries
    public Country getdata(String[] data){
        
        int population = Integer.parseInt(data[3]);
        int codeNumber = Integer.parseInt(data[4]);
        Country c1 = new Country(data[0], data[1], data[2], population, codeNumber);
        return c1;
    }
    public List<Country> listOfCountry (String fileName){
        List<Country> listOfCountry = new ArrayList<>();
        File f1 = new File(fileName);
        List<String> lines = new ArrayList<>();
        try{
            lines = Files.readAllLines(f1.toPath());
        }
        catch (Exception ex){
            System.out.println("There is error occurred" + ex);
        }
        for (int index = 1; index < lines.size(); index++) {
            String line = lines.get(index);
            String fields[] = line.split(",");
            listOfCountry.add(getdata(fields));
        }
        return listOfCountry;
    }
    
    //Get list of cities
    public City getCityData(String []fields){
        int cityCode = Integer.valueOf(fields[0]);
        int population = Integer.valueOf(fields[4]);
        City c1 = new City(cityCode, fields[1], fields[2], fields[3], population);
        return c1;
    }
    public List<City> listOfCity (String fileName){
           List<City> cityLists = new ArrayList<>();
           File f1 = new File(fileName);
           List<String> lines = new ArrayList<>();
           try{
               lines = Files.readAllLines(f1.toPath());
           }
           catch (Exception ex){
               ex.printStackTrace();
           }
           for (int index = 1; index < lines.size(); index++) {
            String line = lines.get(index);
            String alllines[] = line.split(",");
            cityLists.add(getCityData(alllines));
        }
           return cityLists;
    }
}
