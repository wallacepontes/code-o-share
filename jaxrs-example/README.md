jaxrs-example: JAX-RS Example
===============================
Author: Wallace Pontes   
Level: Beginner   
Technologies: API for RESTfulWeb Services JAX-RS   
Summary: Basic example to using JAX-RS   

What is it?
-----------

This example demonstrates the use of   
1. Representational State Transfer (REST)    
http://www.ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm    
2. API for RESTfulWeb Services JAX-RS   
URI(Uniform Resource Identifier - http://tools.ietf.org/html/rfc3986)  

This example covers the following annotations:   

* `@Path`   
* `@GET`, `@PUT`, `@POST`, `@DELETE` and `@HEAD`   
* `@Produces(MediaType.TEXT_PLAIN)`   
* `@PathParam`   
* `@MatrixParam`   
* `@QueryParam`   
* `@FormParam`   
* `@HeaderParam`   
* `@CookieParam`   
* `@Context`   


System requirements
-------------------

All you need to build this project is Java 6.0 (Java SDK 1.6) or better, Maven 3.0 or better.

Build and Deploy 
-------------------------

_NOTE: The following build command assumes you have configured your Maven user settings. _  

1. Open a command line and navigate to the root directory of this project.  
2. Type this command to build the archive:  

        mvn clean package tomcat:run   

3. Test the example below:  
3.1. http://localhost:8080/jaxrs-example/rest/Cotacao/DollarToReal  
3.2. http://localhost:8080/jaxrs-example/rest/Cotacao/EuroToReal  
3.3. http://localhost:8080/jaxrs-example/rest/path-param/1/2  
3.4. http://localhost:8080/jaxrs-example/rest/path-param/java/csharp  
3.5. http://localhost:8080/jaxrs-example/rest/matrix-param;p1=1;p2=2  
3.6. http://localhost:8080/jaxrs-example/rest/matrix-param;p1=java;p2=csharp  
3.7. http://localhost:8080/jaxrs-example/rest/query-param?p1=1&p2=2  
3.8. http://localhost:8080/jaxrs-example/rest/query-param?p1=java&p2=csharp  
3.9. http://localhost:8080/jaxrs-example/rest/uri-matching/10/20  
3.10. http://localhost:8080/jaxrs-example/rest/uri-matching/107/3  
3.11. http://localhost:8080/jaxrs-example/rest/uri-matching/COS/10  
3.12. http://localhost:8080/jaxrs-example/rest/http-headers  
3.13. http://localhost:8080/jaxrs-example/rest/download/text  
3.14. http://localhost:8080/jaxrs-example/rest/download/image  
3.15. http://localhost:8080/jaxrs-example/rest/produtos/1/xml  
3.16. http://localhost:8080/jaxrs-example/rest/produtos/1/json  


