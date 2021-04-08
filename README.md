# employee_test_app

This is to demostrate,

To build the secure Spring boot app with the JWT
Connecting Spring Boot and AngularJS on the same server & port

URL: http://localhost:7079
The above url will load the web page built using AngularJS and it populates the data from H2 DB 

It uses the JWT authentication method which reduces the risk of CSRF.

If you want to try accessing the URLs from any dev test tools like Postman then,
Send the request to get the authentication token: http://localhost:7079/authenticate (POST) with the content 
{
    "userName": "admin@test.com",
    "password": "adminPasswd"
}
It will return the Bearer Access Token.
Then you can access any of the request like GET/POST/PUT by applying Bearer token in the header.
Eg: http://localhost:7079/employees (GET) (Authorization:Bearer sjdsd...sdsd)

Note: During the startup, server loads few of the Employee and Users data to H2 DB.