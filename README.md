# Database Resource Bundle

Demonstrates the ability to use a relational database table to back a language bundle for purposes of internationalization.

## How to execute the demo

The application is a Spring Boot application with an in-memory HSQL database.  On startup, the database table is populated and API endpoints are established.

To list all the items in the defaule language, execute the following command:

```bash
$> curl http://localhost:8080/
```

To list all the items in a particular language, execute the following command:

```bash
$> curl -H "Accept-Language: es" http://localhost:8080/
```

To execute the update function, which demonstrates that you can modify the data and then invalidate the resource bundle cache, execute the following:

```bash
$> curl -X POST http://localhost:8080/update
```

When you pull the items in the default language, you will see the updates.

## Remaining open issues

The biggest open issue is how to notify multiple nodes that a change has occurred and that the resource bundle cache should be cleared.

One other minor issue is the current code's reliance on a JPA repository.  In order to make this useable across a wide range of application architectures, I need to remove the dependencies.
