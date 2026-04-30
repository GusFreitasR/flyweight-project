# Flyweight Project

Simple Java example demonstrating the Flyweight design pattern (a small demo named "galaxia").

Project layout
```
flyweight-project/
  src/flyweight/galaxia/
    Estrela.java
    FabricaEstrelas.java
    Galaxia.java
    TipoEstrela.java
```

About
 - This repository contains a minimal implementation of the Flyweight pattern using star (estrela) types in a galaxy.
 - Source files are plain Java under `src/`.

Build (compile)
You can compile the sources with the JDK. From the project root run:

```bash
mkdir -p out
javac -d out $(find src -name "*.java")
```

Notes on running
 - There is no predefined `main` class in this repository. After compiling, you can create a small runner class (for example `Main.java`) that uses the classes in `src/flyweight/galaxia` and then run it:

```bash
# compile + run example (after adding Main.java that contains a main method)
javac -d out $(find src -name "*.java")
java -cp out your.package.Main
```

Tips
 - If you use an IDE (IntelliJ IDEA is common for this project), open the project as a Java project and let the IDE manage compilation and running.
 - If you'd like, I can add a small `Main` demo class that builds a galaxy and prints output — tell me and I'll add it.

License
 - No license specified.

