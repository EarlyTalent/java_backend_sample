Create a simple REST application for serving a blog. <br>
It uses Spring Framework, Java 11, Lombok and a Mongo database.

Currently the application has 2 endpoints:
    
    1) To add a blog post - Post at /blog/post
    2) To get a blog post by id - Get at /blog/{id}
       
Your task is to add a commenting feature.

You should add two new endpoints.

    1) Post at /blog/post/{1}/comment - which should create a new comment for a post with passed {id}
    
    2) Get at /blog/post/{1}/comment - which should return all comments for a post with passed {id}

Write acceptable test coverage for the the new endpoints.

Under the resources folder are example json files for both a Blog and a Comment.

Feel free to modify existing files or create new files.  You may add new dependencies if you choose. Please follow the conventions in place throughout the project.

You should not spend more than 4 hours on this task.

Below are a few links to documentation that may be helpful:<br>
Spring - https://docs.spring.io/spring-framework/docs/current/reference/html/index.html

Mongo - https://docs.mongodb.com/guides/server/install/ : https://docs.mongodb.com/guides/

Maven - https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

Lombok - https://projectlombok.org/features/all

Junit - https://junit.org/junit5/docs/current/user-guide/

Mockito - https://site.mockito.org/
