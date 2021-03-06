# This file will explain how to start the application for generate the key file with the configuration file : 


0. For lunch help command with jar file you need to make this : 

You need to use -h or --help : 

```bash
java -jar -Dlog4j.configuration=conf.properties SecurityToolBox.jar -h
```
1. You need to create your own configuration file like this : 

```bash
# Root logger option
log4j.rootLogger=DEBUG, stdout, file

# Redirect log messages to console
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n

# Redirect log messages to a log file, support file rolling.
log4j.appender.file=org.apache.log4j.RollingFileAppender
log4j.appender.file.File={HERE YOU NEED TO SPECIFIE YOUR LOG FILE WITH THE PATH}
log4j.appender.file.MaxFileSize=5MB
log4j.appender.file.MaxBackupIndex=10
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
```
2. You need to create your path : 

For example : 

```
log4j.appender.file.File=/var/securityToolBox.log
```

4. When you start the application you need to specifie your configuration path for the JVM :

for relative path : 
For this you need to use the ***-Dlog4j.configuration={your configuration file path}***

for absolute path : 
you need to add ***file*** in the JVM like this : 
***-Dlog4j.configuration=file:{your configuration file path}***

5. For start the application : 

IF it's relative path (for load in the class path) : 

```bash
java -jar -Dlog4j.configuration=conf.properties SecurityToolBox.jar
```

IF it's the absolute path : 

```bash
java -jar -Dlog4j.configuration=file:conf.properties SecurityToolBox.jar
```


6. After you need to insert your password and secret key in the prompt.

For information if the password or the secret key is empty, this will generate an Exception. 

