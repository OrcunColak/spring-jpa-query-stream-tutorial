# Read me

The original idea is from  
https://medium.com/spring-boot/spring-data-jpa-handling-large-data-sets-with-streaming-adf1082b6cdc

Another alternative is using JdbcTemplate. This uses JDBC Cursor with ResultSetExtractor
The original idea is from  
https://medium.com/@tuteja_lovish/spring-boot-handling-a-rest-endpoint-that-queries-more-data-than-memory-can-hold-ae1efbfd92e5  
```java
jdbcTemplate.query(
    "SELECT * FROM users",
    new ResultSetExtractor<Void>() {
        @Override
        public Void extractData(ResultSet rs) throws SQLException {
            while (rs.next()) {
                // stream row by row
            }
            return null;
        }
    });
```
