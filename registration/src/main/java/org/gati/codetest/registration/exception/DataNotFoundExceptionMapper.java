package org.gati.codetest.registration.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.gati.codetest.registration.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errormessage = new ErrorMessage(ex.getMessage(),404,"This is a bad request");
		return Response.status(Status.NOT_FOUND).entity(errormessage).build();
	}

}