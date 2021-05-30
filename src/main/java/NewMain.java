import java.util.*;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import sun.security.x509.EDIPartyName;
/**
 *
 * @author Hassan_Kaka
 */
public class NewMain {

    public static void main(String[] args) {
        // TODO code application logic here
        List<Country> listCountries = new ArrayList<>();
        CityAndCountry cc = new CityAndCountry();
        listCountries = cc.listOfCountry("Country.csv");
        System.out.println("\t\t!---------------------List of countries---------------------!");
        for (Country coun : listCountries) {
            System.out.println(coun);
        }
        System.out.println("=====================================================================================");
        List<City> listCities = new ArrayList<>();
        System.out.println("\t\t!---------------------List of Cities---------------------!");
        listCities = cc.listOfCity("City.csv");
        
        for (City ci : listCities) {
            System.out.println(ci);
        }
        System.out.println("==============================================================================================");
        System.out.println("\t\t!---------------------Country Code and List of cities in Each Country---------------------!\t\t");
        Map< String, List<City>> map1 = new HashMap<>();

            for(City c1: listCities){
                if(map1.containsKey(c1.getCountryCode())){
                    map1.get(c1.getCountryCode()).add(c1);
                }
                else{
                    List<City> lst = new ArrayList<>();
                    lst.add(c1);
                    //map1.get(c1.getCountryCode()).add(c1.getCityName());
                    map1.put(c1.getCountryCode(), lst);
                }
            }  
                map1.forEach((k,v) ->
                      System.out.println(k + " "+ v));
                List<Integer> result = new ArrayList<>();
                for (City cit : listCities){
                    result.add(cit.getPopulation());
                }
                List<Integer> final_res = result.stream().sorted().collect(toList());
                System.out.println("Max population is "+final_res.get(final_res.size()-1));
                /*-------------------------------------------------------------------------*/
                
                System.out.println("!--------------------------Better String--------------------------!");
                CompareStrings compare = new CompareStrings();
                String betterString = compare.CompareTwoStrings("Abdelrahman", "Mohamed", (str1,str2) -> str1.length() > str2.length());
                System.out.println(betterString);
                /*--------------------------------------------------------------------------*/
                
                System.out.println("!--------------------------Check Alphabets of String--------------------------!");
                boolean checkalphabet = compare.checkString("Hassan", (str) ->{
                    for (int i = 0; i < str.length(); i++) {
                        if(!Character.isLetter( str.charAt(i) ) )
                            return false;
                    }
                    return true;
                });
                System.out.println(checkalphabet);
                /*--------------------------------------------------------------------------*/
                Map <String, List<City>> collect = listCities.stream()
                        .collect(Collectors.groupingBy(City::getCountryCode));
                
                for( Map.Entry<String, List<City>> entry : collect.entrySet() ){
                    System.out.println( entry.getKey() + " => " + entry.getValue() );
                }
        List<Optional<Integer>> higherPopualtonEachCountry =    
        collect.values()
        .stream()
        .map(list1 -> list1.stream().map( City::getPopulation).max(Integer::compare) )
        .collect(Collectors.toList());
        Map<String, List<City>> ccmap
                = listCities.stream().collect(Collectors.groupingBy(c -> c.getContinent(), toList()));
        ccmap.forEach((k, v) -> {
            System.out.println("Continent is " + k + " and Highest population city is " + v.stream().mapToInt(c -> c.getPopulation()).max().orElse(0));
        });
        }
}  

