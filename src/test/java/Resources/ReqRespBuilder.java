package Resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReqRespBuilder 
{
	public static RequestSpecification req;
	public static ResponseSpecification respo;
	static Properties prop;
	static FileInputStream fis;

	
	public RequestSpecification setBaseSpec() throws IOException
	{
		if(req==null)
		{
			
			PrintStream pstream= new PrintStream(new FileOutputStream("Logs.txt"));
	      req=new RequestSpecBuilder().setBaseUri(getProperties("baseUri")).addQueryParam("key","qaclick123")
			.addFilter(RequestLoggingFilter.logRequestTo(pstream))
			.addFilter(ResponseLoggingFilter.logResponseTo(pstream))
			.setContentType(ContentType.JSON)
			.build();	
	return req;
		}
		return req;
	
	}
	
	public ResponseSpecification setResponseSpec()
	{
		respo=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();		
				//(ResponseLoggingFilter.logResponseTo(new PrintStream(new FileOutputStream("Logs.txt"))));
		
		return respo;
	}
	
	public static String getProperties(String key) throws IOException
	{
		fis=new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\APIFramework\\src\\test\\java\\Resources\\global.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	
}
