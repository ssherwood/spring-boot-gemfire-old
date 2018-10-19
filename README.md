Steps:

# 1 - Spring Initializr

- Go to https://start.spring.io/
- Change the Artifact to "item-catalog"
- Select: web, acutator, devtools, jpa, h2, cache, lombok
- Click Generate
- Find the download, unzip and move to your workspace/repo folder

# 2 - Import into IntelliJ

- Select the maven pom.xml and import
- Wait...
- Update the application.properties
  - management.endpoints.web.exposure.include=*
  - management.endpoint.health.show-details=always
  - spring.datasource.platform=h2
  - spring.jpa.show-sql=true
- Select "run" to verify the app is running
- Hit the actuator
  - http :8080/actuator/health

# 3 - Create a traditional JPA Entity + Repository + Controller

- Create a package "items"
- Create a class Item
  - Add fields id, upc, name, size, lastModified
  - Add Lombok - @Data, @NoArgs, @Entity and @Id (plus strategy Identity)
- Create a class ItemRepository
  - extends JpaRepository<Item, Long>
  - add method Optional<Item> getByUpc
- Create a class ItemController
  - add @RestController
  - add @GetRequest accepting UPC (not id)
    - throw custom exception
    - @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The resource requested does not exist")
- Add data.sql
- Restart the application
- Test the endpoint
  - http :8080/items/013764027053

# 4 - Introduce Spring @Cacheable

- Add the @Cacheable annotation to the get method
- Add a println to demonstrate the cache miss
- Restart and test the endpoint
  - Perform a get to show the cash miss
  - Use gfsh to demonstrated that the value is in the region
  - Perform a second get to now show its getting the value from cache
  
