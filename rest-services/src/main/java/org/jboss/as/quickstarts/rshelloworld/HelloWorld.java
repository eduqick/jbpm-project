/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.rshelloworld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */

@Path("/")
public class HelloWorld {

    @GET
    @Path("/approver")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getApproverId(@QueryParam("company") String company) {

        if (company == null || company.isEmpty()) {
            return Response.status(Status.BAD_REQUEST).entity("company parameter is required").build();
        }

        String domain = company.replace(" ", "").toLowerCase();

        String approver = null;
        if (domain.contains("redhat")) {
            approver = "jane";
        } else {
            return Response.status(Status.NOT_FOUND).entity("company " + company + " not found").build();
        }

        Map<String, String> response = new HashMap<String, String>();
        response.put("email", approver + "@redhat.com");
        response.put("manager", approver);
        return Response.ok(response).build();
    }

}
