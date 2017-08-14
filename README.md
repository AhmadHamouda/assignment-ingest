# ICEYE Assignments - Ingest
Java web application provide a REST API to list assignments for users and also for specific user.
It also provide Ingest API to convert text to image. 
The web application should invoke an external service to gather a super set of the
https://jsonplaceholder.typicode.com/posts


## Business assumption covered by exist code:

1) 3rd party API is return well format.
2) If search for certain user not exist in the 3rd party response or result in general no data, return error message with response not found.
3) Other 3rd party Errors out of our scope.
4) No cash happen in the application.
5) Code not cover remove scenarios for images as no bossiness clear about any criteria.
6) Images save in sub folders based on date.
7) Order from 3rd party is reversed as required.

## Provided API:

1) Get assignments which return all assignments
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8060/iceye/assignments/'
```
2) Get user assignments which return all user assignments
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8060/iceye/assignments/21321'
```
3) Post text to ingest to convert it to image and return image url
```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: text/plain' -d 'Hello' 'http://localhost:8060/iceye/images/'
```
4) Get Image
```
curl -X GET --header 'Accept: image/jpeg' 'http://localhost:8060/iceye/image/?imageURl=%2Fhome%2Fahmad%2F2017-08-14%2F035b60a7-7c89-4d3e-b25a-3a67fadd8949.jpeg'
```
Or Just submit returned URl from 3 in the browser

**System solution:**

1) Get List of all assignments.
2) Reverse order of returned assignments
3) Can search for individual user using his ID
4) Convert text to image
5) Save image on system path
6) Restore save images

**Swagger UI:**
```
localhost:8060/swagger-ui.html
```
provide easy way to test for development


**Future Add**

1) Use media server or just apache to save and restore images on media server not deepen on application it self.
2) Can make users and validation periods to saved images according to account type.
3) Add Spring security for handling accounts.
4) Deploy in docker container.

## Development requirement:

1) JDK 8

## Deployment requirement:

**Executable Jar contain embedded server**

1.1) JRE 8

## Deployment

**Executable Jar contain embedded server**

1.1)change properties file [file next jar (application.properties)] data for image base path folder
```
images.base.path=/home/
```
Make sure images.base.path is allowed to write on it

1.2) run war through command

```java -jar assignment-ingest-1.0.0.jar```

## Logging

1) Log file create next to jar.


## Testing

1) Access swagger 
```
localhost:8060/swagger-ui.html
```

2) In case of test get Image incase of use swagger please remove the first part from response of post method
```
http://localhost:8060/iceye/image/?imageURl=
```
and pass the rest

3) Test from browser Just past the link as its in the browser

4) Test done on linux environment [preferred] also on windows
