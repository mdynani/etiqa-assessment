<ol>
  <li>Create database</li>
  <li>Tomcat Server will run on port 9090 and configured with ddl-auto=update
    <ul>
    <li>linux</li> 
      
      * Navigate into etiqa-assessment
      * chmod +x mvnw
      * ./mvnw spring-boot:run
      
      
  <li>windows</li>

      * Navigate into etiqa-assessment
      * mvnw.cmd spring-boot:run
      
      
  </ul>
  </li>
  <li>Import init_data.sql</li>
  <li>Swagger UI accessible at http://localhost:9090/swagger-ui/index.html or open http://localhost:9090/, there is link to swagger ui.</li>
</ol>
