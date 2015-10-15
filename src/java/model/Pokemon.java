
package model;

public class Pokemon {
    private int pokemonID;
    private String pokemonName;
    private int baseExp;
    private String type;
    private String species;
    private String region;

public Pokemon() {
        this.pokemonID = 0;
        this.pokemonName = "";
        this.baseExp = 0;
        this.type = "";
        this.species = "";
        this.region = "";
    }

    public Pokemon(int pokemonID, String pokemonName, int baseExp, String type, String species, String region) {
        this.pokemonID = pokemonID;
        this.pokemonName = pokemonName;
        this.baseExp = baseExp;
        this.type = type;
        this.species = species;
        this.region = region;
    }

    public int getPokemonID() {
        return pokemonID;
    }

    public void setPokemonID(int pokemonID) {
        this.pokemonID = pokemonID;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public int getBaseExp() {
        return baseExp;
    }

    public void setBaseExp(int baseExp) {
        this.baseExp = baseExp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "pokemonID=" + pokemonID + ", pokemonName=" + pokemonName + ", baseExp=" + baseExp + ", type=" + type + ", species=" + species + ", region=" + region + '}';
    }

    
}
