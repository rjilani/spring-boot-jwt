## How to get jwt token
http://localhost:8080/authenticate

json body 

{
"username":"javainuse",
"password":"password"
}

![Screenshot](authenticate.PNG)

## How to call service

http://localhost:8080/hello

pass bearer token with the jwt string returns by the call above


![Screenshot](getwithbearertoken.PNG)