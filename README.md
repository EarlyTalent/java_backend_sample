# Levvel Technical Interview

## Project Setup
- **Fork** the repository
- Clone the forked repository and open the project locally
- Run the project from the WorkSampleApplication class
- The application will start on [http://localhost:8080](http://localhost:8080)

## Existing State
This is a simple REST application for serving a blog. <br>
It uses Spring Framework, Maven, Java 11, Lombok and data is stored in a Mongo database.

Currently the application has 2 endpoints:
    
    1) To add a blog post - Post at /blog/post
    2) To get a blog post by id - Get at /blog/post/{id}
       
## Task
Your task is to add a commenting feature.

You should add two new endpoints.

    1) Post at /blog/post/{1}/comment - which should create a new comment for a post with passed {id}
    
    2) Get at /blog/post/{1}/comment - which should return all comments for a post with passed {id}

Under the resources folder are example json files for both a Blog and a Comment.

Feel free to modify existing files or create new files.  You may add new dependencies if you choose. Please follow the conventions in place throughout the project.

**Please spend no more than 4 hours on this task**

## Resources
You may use any internet sources to aid your implementation.<br><br>
Below are a few links to documentation that may be helpful:<br><br>
Spring - https://docs.spring.io/spring-framework/docs/current/reference/html/index.html

Mongo - https://docs.mongodb.com/guides/server/install/ : https://docs.mongodb.com/guides/

Maven - https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

Lombok - https://projectlombok.org/features/all

Junit - https://junit.org/junit5/docs/current/user-guide/

Mockito - https://site.mockito.org/

## Submitting Your Work (IMPORTANT)
When you are finished, create a Pull Request in Github for the forked repository. Email the link to your Pull Request to nicole.chini@levvel.io **at least 24 hours prior to your technical interview**

Please make sure your Pull Request is for your forked repo, NOT the original repo
