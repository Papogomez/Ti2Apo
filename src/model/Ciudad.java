package model;

public class Ciudad {

    private String id;
    private String  name;
    private double population;
    private String countryID;



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

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", countryID='" + countryID + '\'' +
                '}';
    }
}
