package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonList {

    private String name;
    public PokemonList() {}
    public PokemonList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
