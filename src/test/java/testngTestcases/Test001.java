package testngTestcases;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.premsaka.practice.browserutility.BrowserUtility;

import dev.failsafe.internal.util.Assert;

public class Test001 {
	
	@DataProvider(name="TestSample")
	public Object[][] dataProb(){
		return new Object[][]{{"first-value"},{"second-value"}};
	}
	
	@Test(dataProvider = "TestSample")
	public  void Test1(String value) {
		System.out.println(value);
	}
	
	@DataProvider(name="method-parameter")
	public Object[][] calculator(Method m){
		switch(m.getName()) {
		case "sum":
			return new Object[][] {{1,2,2},{3,3,4}};
		case "diff":
			return new Object[][] {{2,3,4},{6,7,8}};
		}
		return null;
	}
	
	@Test(dataProvider="method-parameter")
	public void sum(int a,int b,int result) {
		int sum=a+b;
		System.out.println(sum+ " "+result);
	}
	
	@Test
	public void checkInt() {
		int i=5;
		int k=++i;
		int m=i++;
		System.out.println(k);
		System.out.println(m);
	}
	
	@Test
	public void reverseString() {
		String s="Prem";
		String rev="";
		for(int i=s.length()-1;i>=0;i--){
				rev+=s.charAt(i);
		}
		System.out.println(rev);
	}
}
