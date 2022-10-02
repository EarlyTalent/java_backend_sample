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