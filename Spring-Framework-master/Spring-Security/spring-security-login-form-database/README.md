Technologies used:
Spring 3.2.8.RELEASE
Spring Security 3.2.3.RELEASE
HSQLDB 2.3.1
Maven 3
JDK 1.6
STS 3.7
Tomcat 6.x


URL Examples
1.Welcome Page
http://localhost:8080/SpringSecurityDatabase/

2. Try to access /admin page, only “softtek” ROLE_ADMIN is allowed to access.
http://localhost:8080/SpringSecurityDatabase/admin

3. If username and password is incorrect, error messages will be displayed, and Spring will redirect to this URL /login?error.

4. If username and password are correct, Spring will redirect to the original requested URL and display the page.
http://localhost:8080/SpringSecurityDatabase/admin
Use user:softtek and password:123456

5.
Try to log out, it will redirect to /login?logout page.

6. If “user” is try to access /admin, 403 access denied page is displayed.
http://localhost:8080/SpringSecurityDatabase/admin
Use user:user and password:123456

7. “user” in default page, show the use of sec:authorize
http://localhost:8080/SpringSecurityDatabase/
