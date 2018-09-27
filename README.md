# Steve Sokasits Individual Project

## Problem Statement

For years software engineers have relayed on managers and/or administrators to
 produce fair production support schedules.  Most schedules produced end up
  lacking fairness and transparency to the engineer's that they serve. 
   Schedules usually don’t cover the following items:

* Recognition for Holidays worked
* Recognition for volunteer help
* Explanation into how schedule was determined
* Fair distribution between primary and secondary support
* Ability for engineers to modify scheduled

To remedy the issues documented above I plan to create an application called
 “SUPPORT:it”  This site will put the power back into the engineers hands 
 and will establish rules all team members can live with.

### Project Technologies/Techniques 

* Security/Authentication
  * Tomcat's JDBC Realm Authentication
  * Admin role: create/update resouces, create teams, create/update schedules
  * User role: update profile info, set schedule user preferences, 
  view team schedules, request schedule changes
  * All: view team schedules (user must login)
* Database
  * MySQL
  * Store users and roles
  * Store all data for user and schedules
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* Web Services consumed using Java
  * ????? for hoidays within calendar schedule
* CSS 
  * Bootstrap or Materialize
* Data Validation
  * Bootstrap Validator for front end
  * Explore Hibernate's validation
* Logging
  * Configurable logging using Log4J2. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting. 
* Hosting
  * AWS
* Independent Research Topic/s
  * CI tools in AWS
  * Materialize
  * Google Maps API
  * Hibernate Validation
  * Hibernat Search
* Project Lombok to eliminate boilerplate code like getters/setters/equals
* Unit Testing
  * JUnit tests to achieve 80%+ code coverage 
* IDE: IntelliJ IDEA


### Design

* 
[Screen Design](designDocuments/wireframes/screenDesign.md)
* [Database Design](DesignDocuments/databaseDiagram.png)

### [Project Plan](ProjectPlan.md)

### [Development Journal](Journal.md)