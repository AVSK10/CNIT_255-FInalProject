# CNIT 255 Final Project: Board Game Library

Java OOP pair project by Aryan Kondapalli and Lakulish Saini.

## Milestone 2

The Milestone 2 deliverable is a console-based Java model layer with:
- `Game.java` for the entity and validation
- `GameRepository.java` for the CRUD interface
- `InMemoryGameRepository.java` for in-memory storage
- `Main.java` for demonstrating create, read, update, and delete

The Swing view/controller will be added for Milestone 3 and persistent storage for Milestone 4.

## Build and run

Once the Milestone 2 source files are added:

```sh
javac -d out boardgamelibrary/model/*.java boardgamelibrary/Main.java
java -cp out boardgamelibrary.Main
```

Both project partners should review changes and record their actual contributions and permitted AI assistance in their course logs.
