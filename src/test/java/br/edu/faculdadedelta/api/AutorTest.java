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
public class AutorTest {
	
	@BeforeClass
	public static void iniciarCenario() {
		String maujor = "{\"nome\":\"Maujor\",\"sexo\": \"MASCULINO\"}";
		given().contentType("application/json").body(maujor).when().post("/autores").then().statusCode(201);
		
		String martin = "{\"nome\":\"Martin\",\"sexo\": \"MASCULINO\"}";
		given().contentType("application/json").body(martin).when().post("/autores").then().statusCode(201);
	}

	@Test
	public void inserirAutor() {
		String loiane = "{\"nome\":\"Loiane\",\"sexo\": \"FEMININO\"}";
		given().contentType("application/json").body(loiane).when().post("/autores").then().statusCode(201);
	}
	
	@Test
	public void alterarAutor() {
		String alteracao = "{\"nome\":\"Chaui\",\"sexo\": \"FEMININO\"}";
		given().contentType("application/json").body(alteracao).when().put("/autores/1").then().statusCode(200);
	}
	
	@Test
	public void autorPorId() {
		get("/autores/2").then().statusCode(200).assertThat().body("nome", equalTo("Maujor")).body("sexo", equalTo("MASCULINO"));
	}

	@Test
	public void deletarAutor() {
		given().contentType("application/json").when().delete("/autores/3").then().statusCode(204);
	}

	@AfterClass
	public static void remover() {
		given().contentType("application/json").when().delete("/autores/4").then().statusCode(204);
	}

}
