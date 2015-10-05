package org.activityplanner.restservices;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.activityplanner.dao.UserAccountAlreadyExistException;
import org.activityplanner.dao.UserDao;
import org.activityplanner.entity.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
 
@Path("/login")
@Controller
public class UserResource {
 
   @Autowired
	private UserDao userDao;
	
      @GET @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public User findById(@PathParam("id") String id) {
      User emp =   new User();
    	emp.setEmail("email");
      emp.setPassword("passowrd");
    	return emp;
    }
 
    
    @POST 
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON })
    public AuthenticationResponse authentication(User user) {
    	 AuthenticationResponse response = new AuthenticationResponse();
 		
    	UserEntity entity = userDao.authenticateUser(user.getEmail(),user.getPassword());
		if(entity == null){
			response.setResponseCode(ResponseCode.VALIDATION_FAILED);
			response.setResponseMessage("Invalid UserName or Password");
			return response;
		}
		
		response.setUser(user);
    	 return response;
    }
   
}