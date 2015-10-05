package org.activityplanner.restservices;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

public class CustomResponseFilters implements ContainerResponseFilter {
	public ContainerResponse filter(ContainerRequest request,
			ContainerResponse response) {
		// After request processed
		response.getHttpHeaders().add("Access-Control-Allow-Origin",
				"*");
		response.getHttpHeaders().add("Access-Control-Allow-Methods",
				"PUT, GET, POST, DELETE, OPTIONS");
		response.getHttpHeaders().add("Access-Control-Allow-Headers",
				"Content-Type");
		return response;
	}
}