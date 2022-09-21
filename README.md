# My Approach
- I created a Comment class to represent comments, which have an author and the comment text.
- I updated Blog to store a List of Comment Objects. 
- When a Blog is instantiated it starts with 0 comments.
- I added the two new API endpoints in the controller
- You can add a comment to a post, which you find by Id
- You can retrieve all comments to a post, which you find by Id
- Notes: I used MongoDB Compass for ease of database use, and PostMan for Get and Post operations.

# Levvel Technical Interview

## Project Setup
- Fork the repository and clone it to your local machine. For documentation on how to do this, please visit: https://docs.github.com/en/get-started/quickstart/fork-a-repo
- Open the project locally
- Create a new branch in the newly forked repo using the naming convention **yourFirstName_yourLastName**. This is where you work should be saved.
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
When you are finished: 
- Create a Pull Request in Github for the forked repository. 
- This Pull Request should compare your created branch on the forked repo to the **main** branch on your forked repo. 
- Email the link to your Pull Request to nicole.niemczycki@endava.com **at least 24 hours prior to your technical interview**

Again, please make sure your Pull Request is comparing the new branch you created on your forked repo to the *main* branch on your forked repo. The initial repository you forked off of should NOT be referenced.
