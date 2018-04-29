# GitHub-Repository-Info
REST service which returns details of given Github repository.
## What can you do?

It's a service that accepts HTTP GET requests at:

```
http://localhost:8080/
```

and respond with a JSON representation of a greeting:

```
{
    "fullName": "...",
    "description": "...",
    "cloneUrl": "...",
    "stars": 0,
    "createdAt": "..."
}
```

You must customize the greeting with `owner` & `repository-name` parameters in the query string:

```
http://localhost:8080/repositories/{owner}/{repository-name}
```

