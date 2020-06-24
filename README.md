# helloSpringBoot

Welcome to the helloSpringBoot wiki!
## 서혁규 

file:///Users/seohyeokgyu/Desktop/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202020-06-24%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%204.12.24.png

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
