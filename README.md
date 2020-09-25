# ToDoList
To-Do List web Application.

This is a project I made for a coding interview assignemnt.
The project was to build a simple online To-Do list with a basic web interface that can be used in
all popular web browsers. The application has to be able to support multiple users, store necessary
data in an in-memory database and be built with J2EE technology.

The technologies I used in creating this project were Java 8, JSP, Servlet, JDBC, MySQL, Apache Tomcat and MAMP.

I created a basic UI using just some simple HTML, CSS and Bootstrap in the JSP files.

Tools: 

I used Eclipse Java EE edition to develop the code for the Web Application. I used MAMP to create a local database where I could create the tables in the SQL file to work along the code. Apache Tomcat is the server of choice I used when developing and running the code locally so I could see the application on Localhost:8080. 

Configuration to run: 

You will need to configure Apache Tomcat to work with your IDE of choice. The other configuration you have to do will be within the JDBCUtils.java file. In that file you will have to update the database connection URL, username and password.

Application: 

Once you have the application up and running, you will be able to create new users, log in and each user will be able to create, update or delete tasks on their To-Do List that is unique to them that they themselves have created. 





