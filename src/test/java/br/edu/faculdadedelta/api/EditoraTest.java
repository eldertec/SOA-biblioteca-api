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
public class EditoraTest {

	@BeforeClass
	public static void iniciarCenario() {
		String alta = "{\"nome\":\"Alta Books\"}";
		given().contentType("application/json").body(alta).when().post("/editoras").then().statusCode(201);

		String casa = "{\"nome\":\"Casa do Código\"}";
		given().contentType("application/json").body(casa).when().post("/editoras").then().statusCode(201);
	}

	@Test
	public void inserirEditora() {
		String saraiva = "{\"nome\":\"Saraiva\"}";
		given().contentType("application/json").body(saraiva).when().post("/editoras").then().statusCode(201);
	}
	
	@Test
	public void alterarEditora() {
		String alteracao = "{\"nome\":\"FTD\"}";
		given().contentType("application/json").body(alteracao).when().put("/editoras/1").then().statusCode(200);
	}

	@Test
	public void editoraPorId() {
		get("/editoras/2").then().statusCode(200).assertThat().body("nome", equalTo("Alta Books"));
	}

	@Test
	public void deletarEditora() {
		given().contentType("application/json").when().delete("/editoras/3").then().statusCode(204);
	}

	@AfterClass
	public static void remover() {
		given().contentType("application/json").when().delete("/editoras/4").then().statusCode(204);
	}

}
