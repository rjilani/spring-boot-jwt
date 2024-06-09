## How to compile

`mvn clean package`

## How to run
`mvn spring-boot:run`



## How to get jwt token
http://localhost:8080/authenticate

json body 

{
"username":"user1",
"password":"password"
}

![Screenshot](authenticate.PNG)

## How to call service

http://localhost:8080/hello

pass bearer token with the jwt string returns by the call above


![Screenshot](getwithbearertoken.PNG)


## how to do it with curl

## Returns the bearer token

``` curl -X POST http://localhost:8080/authenticate -H 'Content-Type: application/json' -d '{ "username":"user1", "password":"password"}'  ```

## use the returned bearer token returned by call above in Authorization header to call the endpoint protected by JWT
``` curl -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTcxNzg5NTExMCwiaWF0IjoxNzE3ODk0OTkwfQ.6NZfcDRqRm-QQSzWBkAqiNIQFI0bDz4neDG1ytgtXP4QiT1Y72nQsDQoHBS7U1T1dgHTMTO1xdbVCojIAOTkng" http://localhost:8080/hello ```
