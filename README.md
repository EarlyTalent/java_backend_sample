# Arham Siddiqui Endava Interview

This is my attempt at the Endava Technical Assessment.

## Setup

### MongoDB

The database and user need to be set up for the MongoDB database.

```javascript
use levvel_assignment 
db.createUser({ 
    user: "levvel",
    pwd: "levvel",
    roles: [{ role: "dbOwner", db: "levvel_assignment" }]
})
```

## Changes Done

1. [**Blog**](./src/main/java/levvel/io/model/Blog.java) - A list of `Comment`s were added with an `@DBRef` annotation
to associate blogs to comments.
2. [**BlogNotExistException**](./src/main/java/levvel/io/exception/BlogNotExistException.java) - A custom exception 
class to denote that a blog does not exist.
3. [**BlogService**](./src/main/java/levvel/io/service/BlogService.java) (and its subsequent 
[implementation class](./src/main/java/levvel/io/service/BlogServiceImpl.java)) - The `getBlog(String)` method was
updated to have a possibility to throw `BlogNotExistException`s.
4. [**BlogServiceTests**](./src/test/java/levvel/io/BlogServiceTests.java) - The unit tests for testing the existing 
functionality of adding and getting blogs.
   * Tests success when adding posts.
   * Tests success when fetching posts with existing ID.
   * Tests failure when fetching posts with an ID that is unknown.
5. [**BlogController**](./src/main/java/levvel/io/controller/BlogController.java) - The `getBlog(String)` endpoint was
updated to throw a `ResponseEntity#notFound()` if a `BlogNotExistException` occurs.
6. [**Comment**](./src/main/java/levvel/io/model/Comment.java) - A model class of the document representing comments.
7. [**CommentRepository**](./src/main/java/levvel/io/data/CommentRepository.java) - This repository exists to store the
   individual comment documents.
8. [**CommentController**](./src/main/java/levvel/io/controller/CommentController.java) - This controller contains the
newly added endpoints for the assignment and invokes the `CommentService` for doing the logic of each endpoint.
9. [**CommentService**](./src/main/java/levvel/io/service/CommentService.java) (and its subsequent 
[implementation class](./src/main/java/levvel/io/service/CommentServiceImpl.java)) - The service class that implements 
the business logic for adding and getting comments.
10. [**CommentServiceTests**](./src/test/java/levvel/io/CommentServiceTests.java) - The unit tests for testing the new
functionality of adding and getting comments on blog posts.
    * Tests success when adding comment to blog post with existing ID.
    * Tests failure when adding comment to blog post with an ID that is unknown.
    * Tests success when fetching comments for blog post with existing ID.
    * Tests failure when fetching comments for blog post with an ID that is unknown.