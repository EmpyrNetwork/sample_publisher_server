# Empyr Publisher Sample

This project demonstrates a sample publisher backend implemented using Spring Boot and JPA. It has endpoints that support user registration and login, oauth access tokens, card signup and venue search. This project is required for the accompanying sample front-end to run properly.

## Running Locally

Run `npm install` to install the dependencies and `npm start` to run the app locally. Navigate to `http://localhost:4200/` to view the app. The app will automatically reload if you change any of the source files. The app also needs to be configured to use the accompanying API server.

## Configuration

The following environment variables need to be set:

```html
MOGL_API_KEY - the Empyr API key in the test environment
MOGL_API_SECRET - the Empyr API secret in the test environment
```

The project also requires a database (ex. Mysql). The database configuration can be found in the <b>src/main/resources/application.properties</b> file

## OAuth Access Tokens
The endpoint for requesting access tokens is implemented using the empyr_java client library. The code can be found in the <b>src/main/java/com/empyr/api/consumer/service/OAuthServiceImpl.java</b> file.

## Signup with Card

The signupWithCard API call is found in the <b>src/main/java/com/empyr/api/consumer/service/SignupWithCardServiceImpl.java</b> file.

## Hosted Fields Signup

The Hosted Fields implementation can be found in the <b>src/main/java/com/empyr/api/consumer/controllers/HostedFieldsSignupController.java</b> file.

## Venue Search

The venue search API call is found in the <b>src/main/java/com/empyr/api/consumer/service/VenueSearchServiceImpl.java</b> file.