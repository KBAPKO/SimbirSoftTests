package tests.api;

import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.PokemonInfo;
import pojos.PokemonList;

import java.util.Arrays;
import java.util.List;

import static tests.api.PokemonRequests.getPokemonInfo;
import static tests.api.PokemonRequests.getPokemonList;

public class PokeTests {

    @Test(description = "Сравнение способностей и веса покемонов")
    public void comparisonPokemonAttributes() {
        PokemonInfo rattataInfo = getPokemonInfo("rattata");
        PokemonInfo pidgeottoInfo = getPokemonInfo("pidgeotto");
        Assert.assertTrue(pidgeottoInfo.getWeight()
                > rattataInfo.getWeight());
        Assert.assertTrue(Arrays.stream(rattataInfo.getAbilities())
                .anyMatch(s -> s.getAbility().getName().equals("run-away")));
        Assert.assertFalse(Arrays.stream(pidgeottoInfo.getAbilities())
                .anyMatch(s -> s.getAbility().getName().equals("run-away")));
    }

    @Test(description = "Проверка колличества элементов в списке, проверка наличия имени")
    public void checkLimitAndNames() {
        List<PokemonList> pokemonsList = getPokemonList();
        Assert.assertEquals(pokemonsList.size(), 20, "Список ограничен не верно");
        Assert.assertTrue(pokemonsList.stream().anyMatch(s -> s.getName().length()>0));
    }
}
