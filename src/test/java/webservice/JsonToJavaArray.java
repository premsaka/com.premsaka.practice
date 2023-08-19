package webservice;

import org.testng.annotations.Test;

import dataobjects.Book;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonToJavaArray {
		
		@Test
		public void validateJsonArray() {
			RestAssured.baseURI = "https://reqres.in/api/users?page=2";
			RequestSpecification request = RestAssured.given();

			Response response = request.get();
			System.out.println("Response Body -> " + response.body().asString());

			Book[] books=response.jsonPath().getObject("data",Book[].class);
			
			for(Book book:books) {
				System.out.println(book.getEmail());
			}
		}
}
