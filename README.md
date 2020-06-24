# helloSpringBoot

Welcome to the helloSpringBoot wiki!
## 서혁규 


 Database 이름: helloProductDB-학번, 예) helloProductDB-191111 

 Product Table 이름: productTable

 data.sql를 이용하여 미리 10개 이상의 Product 생성

 Spring Security 기능은 사용하지 않음

 Postman을 활용하여 API 요청 및 응답 메시지를 보일 것

***

1) Main URL: http://localhost:9090/api/v1/ 
2) API method

- Create/Add(POST): create new product
 POST http://localhost:9090/api/v1/products

- Retrieve/Get (GET): 
 Get full list of products: http://localhost: 9090/api/v1/products

 Get details of products with id=N: http://localhost:9090/api/v1/products/{id} 

 Fetch all products of a category: http://localhost:9090/api/v1/products/category/{category}

- Update (PUT): modify values of product with id=N 
 PUT http://localhost:9090/api/v1/products/{id}

- Delete (DELETE): delete product with id=N
 DELETE http://localhost:9090/api/v1/products/{id}

***

Spring Boot의 actuator를 활용하여 Products REST API에 대한 URL Mapping 정보를 캡쳐해서 보여라.
