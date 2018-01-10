# OALTL

## Dependencies

* Maven
* Java (>= 1.8)

## Run

Running 

```bash
mvn generate-sources clean
```

will generate the necessary java files out of the antlr4 grammar.

After that just run the Run.java file

## Tests

To run the provided tests just run maven like this

```bash
mvn test
```

This will run the provided tests and checks for failures.

## Package

To package the application into a runnable jar run maven with

```bash
mvn package
```

The runnable jar will be in the directory *target/* as OALTL-X.X.X.jar