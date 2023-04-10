package tests.api;

import helpers.PropertiesProvider;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import pojos.PokemonInfo;
import pojos.PokemonList;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PokemonRequests {

    static {
        RestAssured.baseURI = PropertiesProvider.getProperty("pokemonURL");
    }

    @Step("получение информации о покемоне {pokemonName}")
    public static PokemonInfo getPokemonInfo(String pokemonName) {
        return given()
                .when()
                .get(baseURI + pokemonName)
                .then().extract().body().as(PokemonInfo.class);

    }

    @Step("Получить список покемонов")
    public static List<PokemonList> getPokemonList() {
        return given()
                .when()
                .get(baseURI)
                .then().extract().jsonPath().getList("results", PokemonList.class);
    }
}
