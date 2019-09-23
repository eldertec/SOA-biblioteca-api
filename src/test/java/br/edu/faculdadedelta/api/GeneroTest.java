package br.edu.faculdadedelta.api;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GeneroTest {

	@BeforeClass
	public static void iniciarCenario() {
		String drama = "{\"descricao\":\"Drama\"}";
		given().contentType("application/json").body(drama).when().post("/generos").then().statusCode(201);

		String romance = "{\"descricao\":\"Romance\"}";
		given().contentType("application/json").body(romance).when().post("/generos").then().statusCode(201);
	}

	@Test
	public void inserirGenero() {
		String suspense = "{\"descricao\":\"Suspense\"}";
		given().contentType("application/json").body(suspense).when().post("/generos").then().statusCode(201);
	}
	
	@Test
	public void alterarGenero() {
		String alteracao = "{\"descricao\":\"Horror\"}";
		given().contentType("application/json").body(alteracao).when().put("/generos/1").then().statusCode(200);
	}

	@Test
	public void generoPorId() {
		get("/generos/2").then().statusCode(200).assertThat().body("descricao", equalTo("Drama"));
	}

	@Test
	public void deletarGenero() {
		given().contentType("application/json").when().delete("/generos/3").then().statusCode(204);
	}

	@AfterClass
	public static void remover() {
		given().contentType("application/json").when().delete("/generos/4").then().statusCode(204);
	}

}
