package com.kb;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class main {

	public static void main(String[] args) throws JsonParseException, IOException {
		String json1 = "{\"meta\":{\"context\":\"some_context\"},\"included\":[{\"id\":\"o1\",\"type\":\"some_type\",\"meta\":\"some_meta\",\"attributes\":\"some_attributes\",\"relationships\":\"parent\"},{\"id\":\"o2\",\"type\":\"some_type\",\"meta\":\"some_meta\",\"attributes\":\"some_attributes\",\"relationships\":\"ancestor\"}],\"data\":[{\"id\":null,\"type\":\"some_type\",\"meta\":{\"operation\":\"create\",\"submittedOn\":\"09:00:00\"},\"attributes\":{\"data\":\"data1\"},\"relationships\":{\"ask\":{\"id\":\"some_id\",\"type\":\"some_type\"},\"targetObject\":{\"id\":\"some_id\",\"type\":\"some_type\"},\"targetContribution\":{\"id\":\"some_id\",\"type\":\"some_type\"}}},{\"id\":\"c1\",\"type\":\"some_type\",\"meta\":{\"operation\":\"modify\",\"submittedOn\":\"19:00:00\"},\"attributes\":{\"data\":\"data1\"},\"relationships\":{\"ask\":{\"id\":\"some_id\",\"type\":\"some_type\"},\"targetObject\":{\"id\":null,\"type\":null},\"targetContribution\":{\"id\":\"some_id\",\"type\":\"some_type\"}}}]}";

	       JsonParser jParser = new JsonFactory().createParser(json1);
	       
	       String fieldname = jParser.getCurrentName();
	       JsonToken token = jParser.nextToken();
//	       token = jParser.nextToken();
//	       token = jParser.nextValue();
//	       token = jParser.nextValue();
//	      token =  jParser.nextValue();
//jParser.nextToken();   //prints {
//jParser.nextToken();   //prints domain
//jParser.nextValue();   //prints stu
//jParser.nextTextValue(); //prints domain
//jParser.nextToken();  // prints stu
//jParser.nextToken();
//jParser.nextValue();  

//jParser.nextTextValue();

System.out.println(jParser.getCurrentName());

	}

}
