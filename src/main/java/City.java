/**
 *
 * @author Hassan_Kaka
 */
public class City {
    private int cityCode, population;
    private String countryCode, cityName, continent;

    public City(int cityCode, String countryCode, String cityName, String continent, int population) {
        this.cityCode = cityCode;
        this.countryCode = countryCode;
        this.population = population;
        this.cityName = cityName;
        this.continent = continent;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public int getPopulation() {
        return population;
    }
    
    public void setCountryCode(String countryCode){
        this.countryCode = countryCode;
    }
    public String getCountryCode(){
        return countryCode;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
    
    @Override
    public String toString(){
        return "City{" + "city code=" + cityCode + ", country code="+ countryCode+ ", city name=" + cityName + 
               ", continent=" + continent + ", population=" +population + "}"; 
    }
    
    
    
}
