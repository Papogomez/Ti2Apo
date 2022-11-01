package model;

public class Pais {
    private String id;
    private String  name;
    private double population;
    private String countryCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
