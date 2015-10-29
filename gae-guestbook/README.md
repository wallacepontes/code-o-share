guestbook: Guestbook Example
===============================
Author: Wallace Pontes
Level: Beginner
Technologies: Google App Engine, JSP Templates, Servlets
Summary: Basic example of Google App Engine that can be used for education

What is it?
-----------

This example demonstrates the use of GAE, Java and Maven.

System requirements
-------------------

All you need to build this project is Java 7 (Java SDK 7) or better, Maven 3.2 or better.

What you'll learn
-----------------
In this tutorial, you will learn how to do the following:

    * Use Apache Maven to create an App Engine project with the required layout and files.
    * Write servlet code and JSP templates that respond to user requests.
    * Integrate the app with Google Accounts for user authentication.
    * Save data to Google Cloud Datastore.
    * Build and test your app in the local development server.
    * Deploy the app to Google App Engine.
    * This example uses the Objectify library, a Java data modeling library for the Datastore. 

Commands useful
------------------

mvn archetype:generate -Dappengine-version=1.9.26 -Dapplication-id=meu-primeiro-projeto-1082 -Dfilter=com.google.appengine.archetypes:

mvn clean install
mvn appengine:devserver
mvn appengine:update
mvn help:describe -Dplugin=appengine


appengine-skeleton
------------------

This is a generated application from the appengine-skeleton archetype.


More about
------------------

Follow these links for more details:

https://cloud.google.com/appengine/docs/java/gettingstarted/introduction

https://github.com/GoogleCloudPlatform/appengine-java-guestbook-multiphase

http://stackoverflow.com/questions/tagged/google-app-engine

https://github.com/objectify/objectify
