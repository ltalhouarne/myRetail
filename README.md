#my Retail [![Build Status](https://jenkins-ltalhouarne.rhcloud.com/job/myRetail/7/badge/icon)](https://jenkins-ltalhouarne.rhcloud.com/job/myRetail/7/)
 
 ![alt](https://github.com/ltalhouarne/myRetail/blob/master/myRetail.PNG)
 
##Running Instructions:
 --------------------
 
 * You can download the war directly from my private nexus [repository](http://nexus-ltalhouarne.rhcloud.com/#view-repositories;releases~browsestorage)
  or you can:
 
  Run "mvn package" at the root of the project directory (Java release 1.7).

* Deploy it to a tomcat server.

* The app will be availabe at the following url:

```
http://localhost:8080/
```

(If you would like to run it with an embedded tomcat server, head over to the [tomcat-embedded](https://github.com/ltalhouarne/myRetail/tree/tomcat-embedded) branch. 


##Technology Stack:
 ----------------
 
Spring boot

Hibernate

HSQLDB

Angular JS

Bootstrap

Jquery
