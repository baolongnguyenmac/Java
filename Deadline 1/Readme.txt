---- Student management ----

features:
    Add student (name, code, mark, directory of picture, address, note)
    update
    delete
    print out list student
    sort by mark
    import from csv
    export to csv

Build:
javac *.java
jar -cfm baolong.jar build.mf *.class *.java
java -jar bailing.jar