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

public class KbRepo {
	Connection con = null;
	
	public KbRepo() {
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
		
//		JSONObject json = new JSONObject(k1);
//		String input = json.toString();
	
		
		//readJson("book.json");
		//String json1 = "{\"domain\":\"stu\",\"context\":\"c1\",\"type\":\"contribution\",\"operation\":\"create\",\"data\":\"dataaa\",\"object\":\"o2\",\"submittedOn\":\"6789\",\"nativeAskID\":\"nat67\"}";
		//String json1 = k1.toString();
//		JsonReader reader = Json.createReader(new InputStreamReader(k1, "UTF-8"));
		
		JsonParser jParser = new JsonFactory().createParser(k1);
		
		
		
//		JsonFactory jfactory = new JsonFactory();
//		JsonParser jParser = jfactory.createParser(k1);
		String domain = null;
		String context = null;
		String type = null;
		String operation = null;
		String data = null;
		String object = null;
		String submittedOn = null;
		String nativeAskID = null;
		
		while (jParser.nextToken() != JsonToken.END_OBJECT) {
		    String fieldname = jParser.getCurrentName();
		    if ("domain".equals(fieldname)) {
		        jParser.nextToken();
		        domain = jParser.getText();
		    }
		    if ("context".equals(fieldname)) {
		        jParser.nextToken();
		        context = jParser.getText();
		    }
		    if ("type".equals(fieldname)) {
		        jParser.nextToken();
		        type = jParser.getText();
		    }if ("operation".equals(fieldname)) {
		        jParser.nextToken();
		        operation = jParser.getText();
		    }if ("data".equals(fieldname)) {
		        jParser.nextToken();
		        data = jParser.getText();
		    }if ("object".equals(fieldname)) {
		        jParser.nextToken();
		        object = jParser.getText();
		    }if ("submittedOn".equals(fieldname)) {
		        jParser.nextToken();
		        submittedOn = jParser.getText();
		    }if ("nativeAskID".equals(fieldname)) {
		        jParser.nextToken();
		        nativeAskID = jParser.getText();
		    }
		    
		 
		    
		    
		}
		//jParser.close();
		
		
		
		
		
		String sql = "INSERT INTO contribution VALUES (?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, domain);
			st.setString(2, context);
			st.setString(3, type);
			st.setString(4, operation);
			st.setString(5, data);
			st.setString(6, object);
			st.setString(7, submittedOn);
			st.setString(8, nativeAskID);
			
//			st.setString(1, k1.getDomain());
//			st.setString(2, k1.getContext());
//			st.setString(3, k1.getType());
//			st.setString(4, k1.getOperation());
//			st.setString(5, k1.getContribution_data());
//			st.setString(6, k1.getObject());
//			st.setString(7, k1.getSubmittedOn());
//			st.setString(8, k1.getNativeAskID());
//			
			st.executeUpdate();
		}
		 catch (SQLException e) {
				System.out.println(e);
			}
		
//		return k1;
	}
}