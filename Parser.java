//package com.kb;
//
//import java.io.IOException;
//import java.util.*;
//
//import com.fasterxml.jackson.core.*;
//
//
//
///**
// * Input json
// * {
//  "meta": {
//    "context": "some_context"
//  },
//  "included": [
//    {
//      "id": "o1",
//      "type": "some_type",
//      "meta": "some_meta",
//      "attributes": "some_attributes",
//      "relationships": "parent"
//    },
//    {
//      "id": "o2",
//      "type": "some_type",
//      "meta": "some_meta",
//      "attributes": "some_attributes",
//      "relationships": "ancestor"
//    }
//  ],
//  "data": [
//    {
//      "id": null,
//      "type": "some_type",
//      "meta": {
//        "operation": "create",
//        "submittedOn": "09:00:00"
//      },
//      "attributes": {
//        "data": "data1"
//      },
//      "relationships": {
//        "ask": {
//          "id": "some_id",
//          "type": "some_type"
//        },
//        "targetObject": {
//          "id": "some_id",
//          "type": "some_type"
//        },
//        "targetContribution": {
//          "id": "some_id",
//          "type": "some_type"
//        }
//      }
//    },
//    {
//      "id": "c1",
//      "type": "some_type",
//      "meta": {
//        "operation": "modify",
//        "submittedOn": "19:00:00"
//      },
//      "attributes": {
//        "data": "data1"
//      },
//      "relationships": {
//        "ask": {
//          "id": "some_id",
//          "type": "some_type"
//        },
//        "targetObject": {
//          "id": null,
//          "type": null
//        },
//        "targetContribution": {
//          "id": "some_id",
//          "type": "some_type"
//        }
//      }
//    }
//  ]
//}
// *
// */
//
//public class Parser {
//
//	public static void main(String[] args) {
//		
//		String input = "{\"meta\":{\"context\":\"some_context\"},\"included\":[{\"id\":\"o1\",\"type\":\"some_type\",\"meta\":\"some_meta\",\"attributes\":\"some_attributes\",\"relationships\":\"parent\"},{\"id\":\"o2\",\"type\":\"some_type\",\"meta\":\"some_meta\",\"attributes\":\"some_attributes\",\"relationships\":\"ancestor\"}],\"data\":[{\"id\":null,\"type\":\"some_type\",\"meta\":{\"operation\":\"create\",\"submittedOn\":\"09:00:00\"},\"attributes\":{\"data\":\"data1\"},\"relationships\":{\"ask\":{\"id\":\"some_id\",\"type\":\"some_type\"},\"targetObject\":{\"id\":\"some_id\",\"type\":\"some_type\"},\"targetContribution\":{\"id\":\"some_id\",\"type\":\"some_type\"}}},{\"id\":\"c1\",\"type\":\"some_type\",\"meta\":{\"operation\":\"modify\",\"submittedOn\":\"19:00:00\"},\"attributes\":{\"data\":\"data1\"},\"relationships\":{\"ask\":{\"id\":\"some_id\",\"type\":\"some_type\"},\"targetObject\":{\"id\":null,\"type\":null},\"targetContribution\":{\"id\":\"some_id\",\"type\":\"some_type\"}}}]}";
//		JsonFactory jFactory = new JsonFactory();
//		JsonParser parser;
//	
//		String meta = "";
//		ArrayList<HashMap<String,String>> included_array = new ArrayList<>();
//		ArrayList<HashMap<String,String>> data_array = new ArrayList<>();
//		
//		try {
//			parser = jFactory.createParser(input);
//			
//			JsonToken token = parser.nextToken(); //Reads start object {
//			
//			while (token != JsonToken.END_OBJECT) 
//			{
//			    
//			    
//			    //Reading meta - nested JSON Object
//			     if (token == JsonToken.FIELD_NAME && "meta".equals(parser.getCurrentName()))
//			    {
//			    	token = parser.nextToken(); //Reads {
//			    	token = parser.nextToken(); //Reads field name
//			    	if(token==JsonToken.FIELD_NAME && "context".equals(parser.getCurrentName()))
//			    	{
//			    		//token = parser.nextToken(); //Reads value 
//			    		meta=parser.nextTextValue();
//			    		token=parser.nextToken(); //Reads }
//			    	}
//			    }
//			    
//			     
//			     
//			     
//			    //Reading included - Array of JSON Objects
//			    if (token == JsonToken.FIELD_NAME && "included".equals(parser.getCurrentName())) 
//			    {
//			    	token = parser.nextToken(); // Reads [
//			    	token = parser.nextToken(); //Reads {
//			    	while(token == JsonToken.START_OBJECT)
//			    	{
//			    		
//			    		HashMap<String,String> included_map=new HashMap<>();
//			    		token = parser.nextToken();//Reads field name
//						 //Reading id - String
//						  if (token == JsonToken.FIELD_NAME && "id".equals(parser.getCurrentName()))
//						    {
//							  included_map.put("id", parser.nextTextValue());
//							  //token = parser.nextToken();//Reads value
//					    		//included_map.put("id", parser.getText());
//					    		token = parser.nextToken(); //Reads field name
//						    }
//						    //Reading type - String
//						    if (token == JsonToken.FIELD_NAME && "type".equals(parser.getCurrentName()))
//						    {
//						    	included_map.put("type", parser.nextTextValue());
////						    	token = parser.nextToken();//Reads value
////					    		included_map.put("type", parser.getText());
//					    		token = parser.nextToken(); //Reads field name
//						    }
//						    //Reading meta - String
//						    if (token == JsonToken.FIELD_NAME && "meta".equals(parser.getCurrentName()))
//						    {
//						    	included_map.put("meta", parser.nextTextValue());
////						    	token = parser.nextToken();//Reads value
////					    		included_map.put("meta", parser.getText());
//					    		token = parser.nextToken(); //Reads field name
//						    }
//						    //Reading attributes - String
//						    if (token == JsonToken.FIELD_NAME && "attributes".equals(parser.getCurrentName()))
//						    {
//						    	included_map.put("attributes", parser.nextTextValue());
////						    	token = parser.nextToken();//Reads value
////					    		included_map.put("attributes", parser.getText());
//					    		token = parser.nextToken(); //Reads field name
//						    }
//						    //Reading relationships - String
//						    if (token == JsonToken.FIELD_NAME && "relationships".equals(parser.getCurrentName()))
//						    {
//						    	included_map.put("relationships", parser.nextTextValue());
////						    	token = parser.nextToken();//Reads value
////					    		included_map.put("relationships", parser.getText());
//					    		token = parser.nextToken(); //Reads field name
//						    }
//						     
//						included_array.add(included_map);
//						token = parser.nextToken(); //Reads }
//			    	}  	
//			    	token = parser.nextToken(); //Reads field name
//			    }
//			    
//			    
//			    //Reading data - Array of JSON Objects
//			    if (token == JsonToken.FIELD_NAME && "data".equals(parser.getCurrentName())) 
//			    {
//			    	token = parser.nextToken(); // Reads [
//			    	token=parser.nextToken(); //Reads {
//			    	while(token == JsonToken.START_OBJECT)
//			    	{
//			    		
//			    		HashMap<String,String> data_map=new HashMap<>();
//			    	    token = parser.nextToken(); //Reads field name
//			    	    //Reading id - String
//						    if (token == JsonToken.FIELD_NAME && "id".equals(parser.getCurrentName()))
//						    {
//						    	//included_map.put("id", parser.nextTextValue());
//						    	//token = parser.nextToken(); //Reads value
//						    	data_map.put("id", parser.nextTextValue());
//						    	token = parser.nextToken(); //Reads field name
//						    	
//						    }
//						  //Reading type - String
//						    if (token == JsonToken.FIELD_NAME && "type".equals(parser.getCurrentName()))
//						    {
////						    	token = parser.nextToken(); //Reads value
////						    	data_map.put("type", parser.getText());
//						    	data_map.put("type", parser.nextTextValue());
//						    	token = parser.nextToken(); //Reads field name
//						    }
//						    //Reading meta - Nested Json object
//						    if (token == JsonToken.FIELD_NAME && "meta".equals(parser.getCurrentName()))
//						    {
//						    	token = parser.nextToken(); //Reads {
//						    	token = parser.nextToken(); //Reads field name
//						    	if(token==JsonToken.FIELD_NAME && "operation".equals(parser.getCurrentName()))
//						    	{
////						    		token = parser.nextToken(); //Reads value
////						    		data_map.put("operation", parser.getText());
//						    		data_map.put("operation", parser.nextTextValue());
//						    		token = parser.nextToken();//Reads field name
//						    	}
//						    	if(token==JsonToken.FIELD_NAME && "submittedOn".equals(parser.getCurrentName()))
//						    	{
////						    		token = parser.nextToken(); //Reads value
////						    		data_map.put("submittedOn", parser.getText());
//						    		data_map.put("submittedOn", parser.nextTextValue());
//						    		token = parser.nextToken(); //Reads }
//						    	}
//						    	token = parser.nextToken(); //Reads field name
//						    }
//						    
//						  //Reading attributes - Nested Json object
//						    if (token == JsonToken.FIELD_NAME && "attributes".equals(parser.getCurrentName()))
//						    {
//						    	token = parser.nextToken(); //Reads {
//						    	token = parser.nextToken(); //Reads field name
//						    	if(token==JsonToken.FIELD_NAME && "data".equals(parser.getCurrentName()))
//						    	{
////						    		token = parser.nextToken();//Reads value
////						    		data_map.put("contribution_data", parser.getText());
//						    		data_map.put("contribution_data", parser.nextTextValue());
//						    		token = parser.nextToken(); //Reads }
//						    	}
//						    	token = parser.nextToken();	//Reads field name
//						    }
//						    
//						  //Reading relationships - Nested Json object
//						    if (token == JsonToken.FIELD_NAME && "relationships".equals(parser.getCurrentName()))
//						    {
//						    	token = parser.nextToken(); //Reads {
//						    	token = parser.nextToken(); //Reads field name
//						    	if(token==JsonToken.FIELD_NAME && "ask".equals(parser.getCurrentName()))
//						    	{
//						    		token = parser.nextToken(); //Reads {
//						    		token = parser.nextToken(); //Reads field name
//						    		if(token==JsonToken.FIELD_NAME && "id".equals(parser.getCurrentName()))
//						    		{
////						    			token = parser.nextToken(); //Reads value
////						    			data_map.put("ask_id", parser.getText());
//						    			data_map.put("ask_id", parser.nextTextValue());
//						    			token = parser.nextToken(); //Reads field name
//						    		}
//						    		if(token==JsonToken.FIELD_NAME && "type".equals(parser.getCurrentName()))
//						    		{
////						    			token = parser.nextToken(); //Reads value
////						    			data_map.put("ask_type", parser.getText());
//						    			data_map.put("ask_type", parser.nextTextValue());
//						    			token = parser.nextToken(); //Reads }
//						    		}
//						    		token = parser.nextToken(); //Reads field name
//						    	}
//						    	
//						    	
//						    	if(token==JsonToken.FIELD_NAME && "targetObject".equals(parser.getCurrentName()))
//						    	{
//						    		token = parser.nextToken(); //Reads {
//						    		token = parser.nextToken(); //Reads field name
//						    		if(token==JsonToken.FIELD_NAME && "id".equals(parser.getCurrentName()))
//						    		{
////						    			token = parser.nextToken(); //Reads value
////						    			data_map.put("targetObject_id", parser.getText());
//						    			data_map.put("targetObject_id", parser.nextTextValue());
//						    			token = parser.nextToken(); //Reads field name
//						    		}
//						    		if(token==JsonToken.FIELD_NAME && "type".equals(parser.getCurrentName()))
//						    		{
//						    			token = parser.nextToken(); //Reads value
//						    			data_map.put("targetObject_type", parser.getText());
//						    			token = parser.nextToken(); //Reads}
//						    		}
//						    		token = parser.nextToken(); //Reads field name
//						    	}
//						    	
//						    	if(token==JsonToken.FIELD_NAME && "targetContribution".equals(parser.getCurrentName()))
//						    	{
//						    		token = parser.nextToken(); //Reads {
//						    		token = parser.nextToken(); //Reads field name
//						    		if(token==JsonToken.FIELD_NAME && "id".equals(parser.getCurrentName()))
//						    		{
//						    			token = parser.nextToken(); //Reads value
//						    			data_map.put("targetContribution_id", parser.getText());
//						    			token = parser.nextToken(); //Reads field name
//						    		}
//						    		if(token==JsonToken.FIELD_NAME && "type".equals(parser.getCurrentName()))
//						    		{
//						    			token = parser.nextToken(); //Reads value
//						    			data_map.put("targetContribution_type", parser.getText());
//						    			token = parser.nextToken(); //Reads }
//						    		}
//						    		token = parser.nextToken(); //Reads }
//						    	}			
//						    	token = parser.nextToken(); //Reads }
//						    }
//						    
//						 data_array.add(data_map);
//						 token = parser.nextToken(); //Reads ]
//			    		}
//						
//			    }	
//			    token = parser.nextToken(); //Reads }
//			    
//			}  
//			
//			System.out.println("Meta: "+ meta);
//			System.out.println("Included: ");
//			    for (int i = 0; i < included_array.size();i++) 
//			      { 		      
//			          System.out.println(included_array.get(i)); 		
//			      } 
//			    System.out.println("Data: ");
//			    for (int i = 0; i < data_array.size();i++) 
//			      { 		      
//			          System.out.println(data_array.get(i)); 		
//			      } 
//			   
//			   
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//
//	}
//}




package com.kb;

import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.core.*;



/**
 * Input json
 * {
  "meta": {
    "context": "some_context"
  },
  "included": [
    {
      "id": "o1",
      "type": "some_type",
      "meta": "some_meta",
      "attributes": "some_attributes",
      "relationships": "parent"
    },
    {
      "id": "o2",
      "type": "some_type",
      "meta": "some_meta",
      "attributes": "some_attributes",
      "relationships": "ancestor"
    }
  ],
  "data": [
    {
      "id": null,
      "type": "some_type",
      "meta": {
        "operation": "create",
        "submittedOn": "09:00:00"
      },
      "attributes": {
        "data": "data1"
      },
      "relationships": {
        "ask": {
          "id": "some_id",
          "type": "some_type"
        },
        "targetObject": {
          "id": "some_id",
          "type": "some_type"
        },
        "targetContribution": {
          "id": "some_id",
          "type": "some_type"
        }
      }
    },
    {
      "id": "c1",
      "type": "some_type",
      "meta": {
        "operation": "modify",
        "submittedOn": "19:00:00"
      },
      "attributes": {
        "data": "data1"
      },
      "relationships": {
        "ask": {
          "id": "some_id",
          "type": "some_type"
        },
        "targetObject": {
          "id": null,
          "type": null
        },
        "targetContribution": {
          "id": "some_id",
          "type": "some_type"
        }
      }
    }
  ]
}
 *
 */

public class Parser {

	public static void main(String[] args) {
		
		String input = "{\"meta\":{\"context\":\"some_context\"},\"included\":[{\"id\":\"o1\",\"type\":\"some_type\",\"meta\":\"some_meta\",\"attributes\":\"some_attributes\",\"relationships\":\"parent\"},{\"id\":\"o2\",\"type\":\"some_type\",\"meta\":\"some_meta\",\"attributes\":\"some_attributes\",\"relationships\":\"ancestor\"}],\"data\":[{\"id\":null,\"type\":\"some_type\",\"meta\":{\"operation\":\"create\",\"submittedOn\":\"09:00:00\"},\"attributes\":{\"data\":\"data1\"},\"relationships\":{\"ask\":{\"id\":\"some_id\",\"type\":\"some_type\"},\"targetObject\":{\"id\":\"some_id\",\"type\":\"some_type\"},\"targetContribution\":{\"id\":\"some_id\",\"type\":\"some_type\"}}},{\"id\":\"c1\",\"type\":\"some_type\",\"meta\":{\"operation\":\"modify\",\"submittedOn\":\"19:00:00\"},\"attributes\":{\"data\":\"data1\"},\"relationships\":{\"ask\":{\"id\":\"some_id\",\"type\":\"some_type\"},\"targetObject\":{\"id\":null,\"type\":null},\"targetContribution\":{\"id\":\"some_id\",\"type\":\"some_type\"}}}]}";
		JsonFactory jFactory = new JsonFactory();
		JsonParser parser;
	
		String meta = "";
		ArrayList<HashMap<String,String>> included_array = new ArrayList<>();
		ArrayList<HashMap<String,String>> data_array = new ArrayList<>();
		
		try {
			parser = jFactory.createParser(input);
			
			JsonToken token = parser.nextToken(); //Reads start object {
			
			while (token != JsonToken.END_OBJECT) 
			{
			    
			    
			    //Reading meta - nested JSON Object
			     if (token == JsonToken.FIELD_NAME && "meta".equals(parser.getCurrentName()))
			    {
			    	token = parser.nextToken(); //Reads {
			    	token = parser.nextToken(); //Reads field name
			    	if(token==JsonToken.FIELD_NAME && "context".equals(parser.getCurrentName()))
			    	{
			    		token = parser.nextToken(); //Reads value 
			    		meta=parser.getText();
			    		token=parser.nextToken(); //Reads }
			    	}
			    }
			    
			     
			     
			     
			    //Reading included - Array of JSON Objects
			    if (token == JsonToken.FIELD_NAME && "included".equals(parser.getCurrentName())) 
			    {
			    	token = parser.nextToken(); // Reads [
			    	token=parser.nextToken(); //Reads {
			    	while(token == JsonToken.START_OBJECT)
			    	{
			    		
			    		HashMap<String,String> included_map=new HashMap<>();
			    		token = parser.nextToken();//Reads field name
						 //Reading id - String
						  if (token == JsonToken.FIELD_NAME && "id".equals(parser.getCurrentName()))
						    {
						    	token = parser.nextToken();//Reads value
					    		included_map.put("id", parser.getText());
					    		token = parser.nextToken(); //Reads field name
						    }
						    //Reading type - String
						    if (token == JsonToken.FIELD_NAME && "type".equals(parser.getCurrentName()))
						    {
						    	token = parser.nextToken();//Reads value
					    		included_map.put("type", parser.getText());
					    		token = parser.nextToken(); //Reads field name
						    }
						    //Reading meta - String
						    if (token == JsonToken.FIELD_NAME && "meta".equals(parser.getCurrentName()))
						    {
						    	token = parser.nextToken();//Reads value
					    		included_map.put("meta", parser.getText());
					    		token = parser.nextToken(); //Reads field name
						    }
						    //Reading attributes - String
						    if (token == JsonToken.FIELD_NAME && "attributes".equals(parser.getCurrentName()))
						    {
						    	token = parser.nextToken();//Reads value
					    		included_map.put("attributes", parser.getText());
					    		token = parser.nextToken(); //Reads field name
						    }
						    //Reading relationships - String
						    if (token == JsonToken.FIELD_NAME && "relationships".equals(parser.getCurrentName()))
						    {
						    	token = parser.nextToken();//Reads value
					    		included_map.put("relationships", parser.getText());
					    		token = parser.nextToken(); //Reads field name
						    }
						     
						included_array.add(included_map);
						token = parser.nextToken(); //Reads }
			    	}  	
			    	token = parser.nextToken(); //Reads field name
			    }
			    
			    
			    //Reading data - Array of JSON Objects
			    if (token == JsonToken.FIELD_NAME && "data".equals(parser.getCurrentName())) 
			    {
			    	token = parser.nextToken(); // Reads [
			    	token=parser.nextToken(); //Reads {
			    	while(token == JsonToken.START_OBJECT)
			    	{
			    		
			    		HashMap<String,String> data_map=new HashMap<>();
			    	    token = parser.nextToken(); //Reads field name
			    	    //Reading id - String
						    if (token == JsonToken.FIELD_NAME && "id".equals(parser.getCurrentName()))
						    {
						    	token = parser.nextToken(); //Reads value
						    	data_map.put("id", parser.getText());
						    	token = parser.nextToken(); //Reads field name
						    	
						    }
						  //Reading type - String
						    if (token == JsonToken.FIELD_NAME && "type".equals(parser.getCurrentName()))
						    {
						    	token = parser.nextToken(); //Reads value
						    	data_map.put("type", parser.getText());
						    	token = parser.nextToken(); //Reads field name
						    }
						    //Reading meta - Nested Json object
						    if (token == JsonToken.FIELD_NAME && "meta".equals(parser.getCurrentName()))
						    {
						    	token = parser.nextToken(); //Reads {
						    	token = parser.nextToken(); //Reads field name
						    	if(token==JsonToken.FIELD_NAME && "operation".equals(parser.getCurrentName()))
						    	{
						    		token = parser.nextToken(); //Reads value
						    		data_map.put("operation", parser.getText());
						    		token = parser.nextToken();//Reads field name
						    	}
						    	if(token==JsonToken.FIELD_NAME && "submittedOn".equals(parser.getCurrentName()))
						    	{
						    		token = parser.nextToken(); //Reads value
						    		data_map.put("submittedOn", parser.getText());
						    		token = parser.nextToken(); //Reads }
						    	}
						    	token = parser.nextToken(); //Reads field name
						    }
						    
						  //Reading attributes - Nested Json object
						    if (token == JsonToken.FIELD_NAME && "attributes".equals(parser.getCurrentName()))
						    {
						    	token = parser.nextToken(); //Reads {
						    	token = parser.nextToken(); //Reads field name
						    	if(token==JsonToken.FIELD_NAME && "data".equals(parser.getCurrentName()))
						    	{
						    		token = parser.nextToken();//Reads value
						    		data_map.put("contribution_data", parser.getText());
						    		token = parser.nextToken(); //Reads }
						    	}
						    	token = parser.nextToken();	//Reads field name
						    }
						    
						  //Reading relationships - Nested Json object
						    if (token == JsonToken.FIELD_NAME && "relationships".equals(parser.getCurrentName()))
						    {
						    	token = parser.nextToken(); //Reads {
						    	token = parser.nextToken(); //Reads field name
						    	if(token==JsonToken.FIELD_NAME && "ask".equals(parser.getCurrentName()))
						    	{
						    		token = parser.nextToken(); //Reads {
						    		token = parser.nextToken(); //Reads field name
						    		if(token==JsonToken.FIELD_NAME && "id".equals(parser.getCurrentName()))
						    		{
						    			token = parser.nextToken(); //Reads value
						    			data_map.put("ask_id", parser.getText());
						    			token = parser.nextToken(); //Reads field name
						    		}
						    		if(token==JsonToken.FIELD_NAME && "type".equals(parser.getCurrentName()))
						    		{
						    			token = parser.nextToken(); //Reads value
						    			data_map.put("ask_type", parser.getText());
						    			token = parser.nextToken(); //Reads }
						    		}
						    		token = parser.nextToken(); //Reads field name
						    	}
						    	
						    	
						    	if(token==JsonToken.FIELD_NAME && "targetObject".equals(parser.getCurrentName()))
						    	{
						    		token = parser.nextToken(); //Reads {
						    		token = parser.nextToken(); //Reads field name
						    		if(token==JsonToken.FIELD_NAME && "id".equals(parser.getCurrentName()))
						    		{
						    			token = parser.nextToken(); //Reads value
						    			data_map.put("targetObject_id", parser.getText());
						    			token = parser.nextToken(); //Reads field name
						    		}
						    		if(token==JsonToken.FIELD_NAME && "type".equals(parser.getCurrentName()))
						    		{
						    			token = parser.nextToken(); //Reads value
						    			data_map.put("targetObject_type", parser.getText());
						    			token = parser.nextToken(); //Reads}
						    		}
						    		token = parser.nextToken(); //Reads field name
						    	}
						    	
						    	if(token==JsonToken.FIELD_NAME && "targetContribution".equals(parser.getCurrentName()))
						    	{
						    		token = parser.nextToken(); //Reads {
						    		token = parser.nextToken(); //Reads field name
						    		if(token==JsonToken.FIELD_NAME && "id".equals(parser.getCurrentName()))
						    		{
						    			token = parser.nextToken(); //Reads value
						    			data_map.put("targetContribution_id", parser.getText());
						    			token = parser.nextToken(); //Reads field name
						    		}
						    		if(token==JsonToken.FIELD_NAME && "type".equals(parser.getCurrentName()))
						    		{
						    			token = parser.nextToken(); //Reads value
						    			data_map.put("targetContribution_type", parser.getText());
						    			token = parser.nextToken(); //Reads }
						    		}
						    		token = parser.nextToken(); //Reads }
						    	}			
						    	token = parser.nextToken(); //Reads }
						    }
						    
						 data_array.add(data_map);
						 token = parser.nextToken(); //Reads ]
			    		}
						
			    }	
			    token = parser.nextToken(); //Reads }
			    
			}  
			
			System.out.println("Meta: "+ meta);
			System.out.println("Included: ");
			    for (int i = 0; i < included_array.size();i++) 
			      { 		      
			          System.out.println(included_array.get(i)); 		
			      } 
			    System.out.println("Data: ");
			    for (int i = 0; i < data_array.size();i++) 
			      { 		      
			          System.out.println(data_array.get(i)); 		
			      } 
			   
			   
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
}
