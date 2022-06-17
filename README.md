## PROJECT NAME
  # EMPLOYEE REIMBURSEMENT SYSTEM
  
## Project Description
  ## Allow employees to login or register and view previous reimbursements and submit new reimbursements for work related expenses.Managers can view all reimbursements that have been submitted and process those reimbursements either approving or denying them.
  Reimbursement and User data persists on an AWS RDS database.
  
## Technologies Used
  * Javalin
  * Java VERSION 8
  * HTML
  * CSS
  * Bootstrap
  * JDBC
  * AWS RDS
  * JavaScript
  * PostgreSQL
  * Postman
 
## Features
  * Interactive Web Page
    * Login and Register
    * Veiw reimbursement by user id
    * Veiw all reimbursments as manager
    * Submit new reimbursement
    * Process reimbursement
  * Backend CLI menu
    * Login and Register
    * Veiw reimbursement by user id
    * Veiw all reimbursments as manager
    * Submit new reimbursement
    * Process reimbursement 

To-do list:
* Adjust CSS values for all HTML pages so that the apperances look well on other type of devices.

## Getting Started
You will need the following programs installed in your computer in oder to make this project run:
### * Git
### * Java
### * Spring Tool Suite 4
### * Maven
### * PostgreSQL
### * DBeaver
### * Postman

## Usage
After installing my project, you will need to create a databse connection in DBeaver and Requests in Postman

### Creating a database connection in DBeaver
* Launch DBeaver. Click on the Database tab and there will be an option to create a new database connection
* A pop up will appear. Select PostgreSQL
* After clicking next, it will display connection settings.
* In the host field, copy and paste the following end point: javafullstackaws.ceboc7nfkw4e.us-east-1.rds.amazonaws.com
* Additionally in the Authentication setting, input the correct username and password of the RDS(Which in this case should be postgress and password)
* Click on finish.

### Creating a new schema in DBeaver
With the database connected created, you'll have to make a schema next. Go to your newly created database, click on database and the drop down arrow. 
* Right click and hover over Create. Select Schema.
* For this project, name this schema p1schema

If there is no active connection
Click on the Select data source button and select your database you're using
Another way of doing is this is opening the schema folder in database navigator, right clicking the schema you want to work in, and select the option "set as default"

### Creating requests in Postman
In order for the front end to interact with the back end and our database, we'll be using requests, JavaScript and JDBC. 
* Launch Postman. Navigate to File and select New and choose New workspace
* Name your new creation and right click to add a folder (I named it P1)
* Now with in P1 folder, repeat the process and make folders for User and Reimbursement
* Right click on the User folder and click on the option to add a request. There are different types of request we will be using
* In order for the requests to go through, there are several parts you are required to fill out
* Change the request by selecting the drop down menu on the left. Then input the end point. This is presented in the launcher file, so copy and paste.
* Next click on body and change the option to raw. Each request has a different set of arguments passed in order to function.
* Change the raw option to JSON. The following images below show how each requests are set up and the arguments passed.

### Launching front end funtionality
Now with all that set up, we can now interact with my project! Launch STS and open the project. Click on run and there will be message in the console to notify that you are connected to Javalin. 
Next, open Visual studio and open the front end folder. Start with login.html and hit the F5 button to run it.

## Licenses
* license:	postgresql
* license: 	apache-2.0
