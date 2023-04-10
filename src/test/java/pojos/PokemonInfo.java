package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonInfo {

    private Abilities[] abilities;
    private Integer weight;

    public PokemonInfo() {}

    public PokemonInfo(Integer weight) {
        this.weight = weight;
    }

    public Abilities[] getAbilities() {
        return abilities;
    }

    public Integer getWeight() {
        return weight;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Abilities {
        private Ability ability;

        public Ability getAbility() {
            return ability;
        }

        public Abilities() {
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Ability {
            private String name;

            public Ability() {
            }

            public Ability(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }
        }
    }
}
