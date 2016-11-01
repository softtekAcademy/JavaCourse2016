Technologies used:
Spring 3.2.8.RELEASE
Spring Security 3.2.3.RELEASE
Maven 3
JDK 1.6
STS 3.7
Tomcat 6.x


URL Examples
1.Welcome Page
http://localhost:8080/SpringSecurityHelloWorld/welcome

2. Try to access /admin page, Spring Security will intercept the request and redirect to /spring_security_login, and a predefined login form is displayed. 
http://localhost:8080/SpringSecurityHelloWorld/admin

3. If username and password is incorrect, error messages will be displayed, and Spring will redirect to this URL /spring_security_login?login_error.

4. If username and password are correct, Spring will redirect the request to the original requested URL and display the page.
http://localhost:8080/SpringSecurityHelloWorld/admin
Use user:softtek and password:123456