# Smart-IoT-Hub
Project Discription:
====
This project is to build a smart hub for Internet of Things (IoT) using full stack web application frameworks based on Java11. This project is used for each independent IoT smart switch module. After passing the identity verification, the user can monitor the state and power consumption of each switch in real time through the web page. At the same time, After the user can get into the dashboard page, and the user can see the real-time information of plugs, and also can click the button in webpage to control them directly.  Then, after click these button, it will send different HTTP request such as post or get or put. Then we configure different service such as updating power, switch on/off, add/delete plug or grouping them. 
Code Discription:
----

- public
 -- index.html.               //The index page of the frontend webpage.  
 -- setGroup.html             //A test page for Grouping functions  
 -- Web                     //Front-end pages using ReactJS  
- src  
 -- main  
  --- java/zayn
  
    ---- iot_hub          //SpringBoot Application with Restful Service, Connect to Mysql database through Hibernate with Spring Data JPA  
    ---- iot_sim          //Server side(Received MQTT message and relative functions)  
     ----- http_server  //HTTP server folder  
  --- resources  
 -- test/java/zayn  
  --- test                     //Unit test folder  

- data 

  -- myIoTHub.db         //sqlite3 database file
