# Demo

Java springboot and oauth2 for demo test.
## Installation

Use the maven to install.

```sh

mvn spring-boot:run -P dev

```

## Usage
```
endpoint : localhost:9999
```
```bash
Register Account -> [POST] [domain]/api/register 

curl -X POST \
  http://localhost:9999/api/register \
  -d '{
	"username" : "0123456789",
	"password" : "test",
	"salary" : 60000
}'

```

```bash
Get token for access account -> [POST] [domain]/oauth/token 

curl -X POST \
  http://localhost:9999/oauth/token \
  -H 'Authorization: Basic dHJ1c3RlZGNsaWVudDp0cnVzdGVkc2VjcmV0' \
  -d 'grant_type=password&username=0123456789&password=test'

```

```bash
Get account -> [GET] [domain]/api/account 

  curl -X GET \
  http://localhost:9999/api/account \
  -H 'Authorization: bearer [token]'
```




