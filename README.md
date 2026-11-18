# Tourist Records API — Spring Boot

A Spring Boot REST API that retrieves all tourist records only when a valid Bearer token is supplied.

## Requirements
- Java 17+
- Maven 3.6+ (or use the Maven support in Spring Tool Suite)

## Import into Spring Tool Suite (STS)
1. Extract the ZIP file.
2. Open STS.
3. Select **File → Import → Maven → Existing Maven Projects**.
4. Browse to the extracted `tourist-records-api` folder.
5. Select `pom.xml`, then **Finish**.
6. Wait for Maven dependencies to download.
7. Open `TouristRecordsApiApplication.java` and choose **Run As → Spring Boot App**.

## Fetch all tourist records
- Method: `GET`
- URL: `http://localhost:8080/api/tourists`
- Header: `Authorization: Bearer tourist-demo-token-123`

Example curl:
```bash
curl -i http://localhost:8080/api/tourists \
  -H "Authorization: Bearer tourist-demo-token-123"
```

Expected success: `200 OK` with a JSON array of tourist records.

Missing or invalid token: `401 Unauthorized`.

## Token configuration
The demo token is configured in `application.properties`:
```properties
app.security.api-token=${TOURIST_API_TOKEN:tourist-demo-token-123}
```
For local testing, the fallback demo token works. For a different token, set the `TOURIST_API_TOKEN` environment variable before starting the application. Do not commit real tokens to source control.

**Note:** This sample uses a fixed configured Bearer API token for simple token validation. It is not JWT authentication and does not issue tokens.

## Database
By default, the project uses an in-memory H2 database and inserts three sample tourist records at startup. Data is reset when the application stops.

To use MySQL instead:
1. Add the MySQL Connector/J dependency to `pom.xml`.
2. Comment out the H2 datasource settings in `application.properties`.
3. Uncomment and configure the MySQL settings.
4. Create a database named `touristdb`.

## API summary
| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/tourists` | Fetch all tourist records (Bearer token required) |
