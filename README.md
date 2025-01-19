
# Spotify Codechallenge

This is an API that searches for tracks through the ISRC using the Spotify API, below are the requirements to start the service.


## Requirements

- Postgresql 15
- Java 17
- SpringBoot 3.4.1


## Entities
#### Track
- ISRC
- Name
- Artist Name
- Album Name
- Explicit
- Playback Seconds
- Cover


## How to start it

### Postgresql

first we must install postgresql, download it and install it, here the download link:https://www.enterprisedb.com/downloads/postgres-postgresql-downloads

Open the psql command console and execute the following commands:

```bash
  1 - psql -U <usuario>
  2 - CREATE DATABASE spotify;
  3 - \i /ruta/db.sql
```

at this point the database should be created.

### API

Open your springboot project with your favorite IDE and we must install the dependencies:

```bash
  mvn install
```

If you are using eclipse, netbeans or intelliJ, I recommend you to use the springboot plugins, you only need to run the application.


## API Reference

Once the project has been executed without errors, you can access http://localhost:8080/swagger-ui/index.html, the requested credentials are:

username: spotify

password: 1234

#### Get all items

```http
POST /codechallenge/createTrack
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `isrc` | `string` | **Required**. it will create a Track. Examples: "USMC18620546", "GBUM71029604" |

#### Get item

```http
  GET /codechallenge/getTrackMetadata
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `isrc`      | `string` | **Required**. it will get the track in the DB. |