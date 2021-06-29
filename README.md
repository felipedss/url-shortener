## URL Shortener

### How this works

When one object is saved in database, this generates an id (unique identification). This id will be used to convert in
base 62. I used that approach to avoid conflict in short url generated; This way the short url generated will never be
conflicted with another

## Alghoritm

This alghoritm works converting numbers from base 10 to base 62. Base 10 are digits [0-9], and base 62 are
digits [0-9][a-z][A-Z].

This meant, that, a number in base 10 with four digits would be tha same as number in base 62 with 2 digits.

### How base 62 works

```java
while(number>0){
    remainder=number%62;
    number=number/62;
}
```

### How to use

+ With docker and docker-compose

```sh
$ git clone https://github.com/felipedss/url-shortener.git
$ cd url-shortener
$ docker-compose up
```
+ Without docker

```shell
$ git clone https://github.com/felipedss/url-shortener.git
```

Open project in your favorite editor and change application.yml file to point to your database

```shell
cd url-shortener
mvn spring-boot:run
```
Open localhost:8080/swagger-ui.html to see endpoints.


