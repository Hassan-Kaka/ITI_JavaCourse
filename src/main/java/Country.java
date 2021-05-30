public class Country {

    /**
     * @param args the command line arguments
     */
    private String countryCode, country, continent;
    private int population, countryNumber;

    public Country(String countryCode, String country, String continent, int population, int countryNumber) {
        this.countryCode = countryCode;
        this.country = country;
        this.continent = continent;
        this.population = population;
        this.countryNumber = countryNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountry() {
        return country;
    }

    public String getContinent() {
        return continent;
    }

    public int getPopulation() {
        return population;
    }

    public int getCountryNumber() {
        return countryNumber;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setCountryNumber(int countryNumber) {
        this.countryNumber = countryNumber;
    }

    @Override
    public String toString() {
        return "Country{" + "countryCode=" + countryCode + ", country name=" + country + ", continent=" + continent + ", population=" + population + ", countryNumber=" + countryNumber + '}';
    }
    
    
}
