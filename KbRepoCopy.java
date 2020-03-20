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

public class KbRepoCopy {
	Connection con = null;
	
	public KbRepoCopy() {
		String url = "jdbc:postgresql://localhost:5432/test1";
		String username = "postgres";
		String password = "postgres";
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url,username,password);
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
	}
	
	public void create(InputStream k1) throws JsonParseException, IOException {
		
		//String json1 = "{\"domain\":\"stu\",\"context\":\"c1\",\"type\":\"contribution\",\"operation\":\"create\",\"data\":\"dataaa\",\"object\":\"o2\",\"submittedOn\":\"6789\",\"nativeAskID\":\"nat67\"}";
		JsonParser jParser = new JsonFactory().createParser(k1);
		String context = null;
		String id = null;
		String type = null;
		String meta = null;
		String attributes = null;
		String relationships = null;
		String data_id = null;
		String data_type = null;
		String data_operation = null;
		String data_submittedOn = null;
		String attributes_data = null;
		String ask_id = null;
		String ask_type = null;
		String targetObject_id =null;
		String targetObject_type =null;
		String targetContribution_id = null;
		String targetContribution_type = null;
		 
		JsonToken token = jParser.nextToken(); //Reads start object {
		
		while (token != JsonToken.END_OBJECT) 
		{
		    
		    
		    //Reading meta - nested JSON Object
		     if (token == JsonToken.FIELD_NAME && "meta".equals(jParser.getCurrentName()))
		    {
		    	token = jParser.nextToken(); //Reads {
		    	token = jParser.nextToken(); //Reads field name
		    	if(token==JsonToken.FIELD_NAME && "context".equals(jParser.getCurrentName()))
		    	{
		    		token = jParser.nextToken(); //Reads value 
		    		context=jParser.getText();
		    		token=jParser.nextToken(); //Reads }
		    	}
		    }
		    
		     
		     
		     
		    //Reading included - Array of JSON Objects
		    if (token == JsonToken.FIELD_NAME && "included".equals(jParser.getCurrentName())) 
		    {
		    	token = jParser.nextToken(); // Reads [
		    	token=jParser.nextToken(); //Reads {
		    	while(token == JsonToken.START_OBJECT)
		    	{
		    		
//		    		HashMap<String,String> included_map=new HashMap<>();
		    		token = jParser.nextToken();//Reads field name
					 //Reading id - String
					  if (token == JsonToken.FIELD_NAME && "id".equals(jParser.getCurrentName()))
					    {
					    	token = jParser.nextToken();//Reads value
					    	id=jParser.getText();
				    		token = jParser.nextToken(); //Reads field name
					    }
					    //Reading type - String
					    if (token == JsonToken.FIELD_NAME && "type".equals(jParser.getCurrentName()))
					    {
					    	token = jParser.nextToken();//Reads value
					    	type=jParser.getText();
				    		token = jParser.nextToken(); //Reads field name
					    }
					    //Reading meta - String
					    if (token == JsonToken.FIELD_NAME && "meta".equals(jParser.getCurrentName()))
					    {
					    	token = jParser.nextToken();//Reads value
					    	meta=jParser.getText();
				    		token = jParser.nextToken(); //Reads field name
					    }
					    //Reading attributes - String
					    if (token == JsonToken.FIELD_NAME && "attributes".equals(jParser.getCurrentName()))
					    {
					    	token = jParser.nextToken();//Reads value
				    		attributes=jParser.getText();
				    		token = jParser.nextToken(); //Reads field name
					    }
					    //Reading relationships - String
					    if (token == JsonToken.FIELD_NAME && "relationships".equals(jParser.getCurrentName()))
					    {
					    	token = jParser.nextToken();//Reads value
					    	relationships=jParser.getText();
					    	token = jParser.nextToken(); //Reads field name
					    }
					     
					
					token = jParser.nextToken(); //Reads }
		    	}  	
		    	token = jParser.nextToken(); //Reads field name
		    }
		    
		    
		    //Reading data - Array of JSON Objects
		    if (token == JsonToken.FIELD_NAME && "data".equals(jParser.getCurrentName())) 
		    {
		    	token = jParser.nextToken(); // Reads [
		    	token=jParser.nextToken(); //Reads {
		    	while(token == JsonToken.START_OBJECT)
		    	{
		    		
		    	    token = jParser.nextToken(); //Reads field name
		    	    //Reading id - String
					    if (token == JsonToken.FIELD_NAME && "id".equals(jParser.getCurrentName()))
					    {
					    	token = jParser.nextToken(); //Reads value
					    	data_id=jParser.getText();
					    	token = jParser.nextToken(); //Reads field name
					    	
					    }
					  //Reading type - String
					    if (token == JsonToken.FIELD_NAME && "type".equals(jParser.getCurrentName()))
					    {
					    	token = jParser.nextToken(); //Reads value
					    	data_type=jParser.getText();
					    	token = jParser.nextToken(); //Reads field name
					    }
					    //Reading meta - Nested Json object
					    if (token == JsonToken.FIELD_NAME && "meta".equals(jParser.getCurrentName()))
					    {
					    	token = jParser.nextToken(); //Reads {
					    	token = jParser.nextToken(); //Reads field name
					    	if(token==JsonToken.FIELD_NAME && "operation".equals(jParser.getCurrentName()))
					    	{
					    		token = jParser.nextToken(); //Reads value
					    		data_operation=jParser.getText();;
					    		token = jParser.nextToken();//Reads field name
					    	}
					    	if(token==JsonToken.FIELD_NAME && "submittedOn".equals(jParser.getCurrentName()))
					    	{
					    		token = jParser.nextToken(); //Reads value
					    		data_submittedOn=jParser.getText();
					    		token = jParser.nextToken(); //Reads }
					    	}
					    	token = jParser.nextToken(); //Reads field name
					    }
					    
					  //Reading attributes - Nested Json object
					    if (token == JsonToken.FIELD_NAME && "attributes".equals(jParser.getCurrentName()))
					    {
					    	token = jParser.nextToken(); //Reads {
					    	token = jParser.nextToken(); //Reads field name
					    	if(token==JsonToken.FIELD_NAME && "data".equals(jParser.getCurrentName()))
					    	{
					    		token = jParser.nextToken();//Reads value
					    		attributes_data=jParser.getText();
					    		token = jParser.nextToken(); //Reads }
					    	}
					    	token = jParser.nextToken();	//Reads field name
					    }
					    
					  //Reading relationships - Nested Json object
					    if (token == JsonToken.FIELD_NAME && "relationships".equals(jParser.getCurrentName()))
					    {
					    	token = jParser.nextToken(); //Reads {
					    	token = jParser.nextToken(); //Reads field name
					    	if(token==JsonToken.FIELD_NAME && "ask".equals(jParser.getCurrentName()))
					    	{
					    		token = jParser.nextToken(); //Reads {
					    		token = jParser.nextToken(); //Reads field name
					    		if(token==JsonToken.FIELD_NAME && "id".equals(jParser.getCurrentName()))
					    		{
					    			token = jParser.nextToken(); //Reads value
					    			ask_id=jParser.getText();
					    			token = jParser.nextToken(); //Reads field name
					    		}
					    		if(token==JsonToken.FIELD_NAME && "type".equals(jParser.getCurrentName()))
					    		{
					    			token = jParser.nextToken(); //Reads value
					    			ask_type=jParser.getText();
					    			token = jParser.nextToken(); //Reads }
					    		}
					    		token = jParser.nextToken(); //Reads field name
					    	}
					    	
					    	
					    	if(token==JsonToken.FIELD_NAME && "targetObject".equals(jParser.getCurrentName()))
					    	{
					    		token = jParser.nextToken(); //Reads {
					    		token = jParser.nextToken(); //Reads field name
					    		if(token==JsonToken.FIELD_NAME && "id".equals(jParser.getCurrentName()))
					    		{
					    			token = jParser.nextToken(); //Reads value
					    			targetObject_id=jParser.getText();
					    			token = jParser.nextToken(); //Reads field name
					    		}
					    		if(token==JsonToken.FIELD_NAME && "type".equals(jParser.getCurrentName()))
					    		{
					    			token = jParser.nextToken(); //Reads value
					    			targetObject_type=jParser.getText();
					    			token = jParser.nextToken(); //Reads}
					    		}
					    		token = jParser.nextToken(); //Reads field name
					    	}
					    	
					    	if(token==JsonToken.FIELD_NAME && "targetContribution".equals(jParser.getCurrentName()))
					    	{
					    		token = jParser.nextToken(); //Reads {
					    		token = jParser.nextToken(); //Reads field name
					    		if(token==JsonToken.FIELD_NAME && "id".equals(jParser.getCurrentName()))
					    		{
					    			token = jParser.nextToken(); //Reads value
					    			targetContribution_id=jParser.getText();
					    			token = jParser.nextToken(); //Reads field name
					    		}
					    		if(token==JsonToken.FIELD_NAME && "type".equals(jParser.getCurrentName()))
					    		{
					    			token = jParser.nextToken(); //Reads value
					    			targetContribution_type=jParser.getText();
					    			token = jParser.nextToken(); //Reads }
					    		}
					    		token = jParser.nextToken(); //Reads }
					    	}			
					    	token = jParser.nextToken(); //Reads }
					    }
					    
					 token = jParser.nextToken(); //Reads ]
		    		}
					
		    }	
		    token = jParser.nextToken(); //Reads }
		    
		}  
		String sql = "INSERT INTO contributions VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, context);
			st.setString(2, id);
			st.setString(3, type);
			st.setString(4, meta);
			st.setString(5, attributes);
			st.setString(6, relationships);
			st.setString(7, data_id);
			st.setString(8, data_type);
			st.setString(9, data_operation);
			st.setString(10, data_submittedOn);
			st.setString(11, attributes_data);
			st.setString(12, ask_id);
			st.setString(13, ask_type);
			st.setString(14, targetObject_id);
			st.setString(15, targetObject_type);
			st.setString(16, targetContribution_id);
			st.setString(17, targetContribution_type);
			st.executeUpdate();
		}
		 catch (SQLException e) {
				System.out.println(e);
			}
	}
}