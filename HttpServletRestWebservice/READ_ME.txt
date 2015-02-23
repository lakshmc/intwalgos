Requirements:
Project that provides CRUD operations for storing documents via Rest endpoints and corresponding operations shown
below by using HttpServlet provided by Java. Should not use any frameworks such as Spring, Jersey,
Apache commons etc. THe project must be
implemented with
 only Java provided libraries.

Create - POST /storage/documents
All content types are supported
POST response is a unique alphanumeric document ID with a length of 20
HTTP response has a 201 Created status code

Query - GET /storage/documents/{docId}
success, a 200 OK response is sent.
A 404 Not Found HTTP response is returned if the document ID is invalid.

Update - PUT /storage/documents/{docId}
success: a 204 No Content response is sent.
A 404 Not Found HTTP response is returned if the document ID is invalid.


Delete - DELETE /storage/documents/{docId}
success: a 204 No Content response is sent.
A 404 Not Found HTTP response is returned if the document ID is invalid.


The code uses embedded Jetty server. To run the project, cd into project folder DocStorageRestWebservice and run
DocStorageRestWebservice$ mvn jetty:run

uri:
http://localhost:8080/storage/documents/{docId}

In Mac there is an issue for java 1.7 and maven. So <source> and <target> config are commented out in pom file.

Assumptions:
Document memory is not an issue.