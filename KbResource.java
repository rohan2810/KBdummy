package com.kb;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;


@Path("knowledge")
public class KbResource{
	KbRepoCopy repo = new KbRepoCopy();
	
	@POST
	@Path("know")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public InputStream createKnowledge(InputStream k1) throws SQLException {
		try {
			repo.create(k1);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k1;
	}
}