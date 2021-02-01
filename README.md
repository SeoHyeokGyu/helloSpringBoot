
# Spring Boot를 활용하여 Product에 대한 CRUD 메소드를 제공하는 REST API를 구현하라.

## 서혁규 

## 조건
* Database 이름: helloProductDB

* Product Table 이름: productTable

* data.sql를 이용하여 미리 10개 이상의 Product 생성

* Spring Security 기능은 사용하지 않음

* Postman을 활용하여 API 요청 및 응답 메시지를 보일 것



***
### Main URL
 http://localhost:9090/api/v1/ 

### API method 

[ProductController.java](https://github.com/SeoHyeokGyu/helloSpringBoot/blob/master/src/main/java/kr/ac/hansung/cse/controller/ProductController.java)

* Create/Add(POST) create new product: http://localhost:9090/api/v1/products
<pre><code>	@PostMapping(value = "/products")
	public ResponseEntity<Product> postProduct(@RequestBody Product product) {
		try {
			Product _product = repository.save(new Product( product.getName(), product.getCategory(), product.getPrice(), product.getManufacturer(), product.getUnitInStock() , product.getDescription() ));
			return new ResponseEntity<>( _product, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
</pre></code>
![7](https://github.com/SeoHyeokGyu/helloSpringBoot/blob/master/src/main/resources/screenshot/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-06-24%20%EC%98%A4%ED%9B%84%206.16.32.png)
* Retrieve/Get (GET) Get full list of products: http://localhost:9090/api/v1/products
<pre><code> 	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllCustomers() {
		List<Product> products = new ArrayList<>();
		try {
			repository.findAll().forEach(products::add);
// 조회한다. 
			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
 </pre></code>
![4](https://github.com/SeoHyeokGyu/helloSpringBoot/blob/master/src/main/resources/screenshot/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-06-24%20%EC%98%A4%ED%9B%84%203.21.33.png)
* Get details of products with id=N: http://localhost:9090/api/v1/products/{id} 
<pre><code>	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
		Optional<Product> productData = repository.findById(id);

		if (productData.isPresent()) {
			return new ResponseEntity<>(productData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}</pre></code>

![5](https://github.com/SeoHyeokGyu/helloSpringBoot/blob/master/src/main/resources/screenshot/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-06-24%20%EC%98%A4%ED%9B%84%203.23.32.png)
* Fetch all products of a category: http://localhost:9090/api/v1/products/category/{category}
<pre><code>	@GetMapping(value = "products/category/{category}")
	public ResponseEntity<List<Product>> findAllByCategory(@PathVariable String category) {
		try {
			List<Product> products = repository.findAllByCategory(category);

			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}</pre></code>

![6](https://github.com/SeoHyeokGyu/helloSpringBoot/blob/master/src/main/resources/screenshot/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-06-24%20%EC%98%A4%ED%9B%84%204.08.17.png)
- Update (PUT): modify values of product with id=N:  http://localhost:9090/api/v1/products/{id}

<pre><code>@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
		Optional<Product> productData = repository.findById(id);

		if (productData.isPresent()) {
			Product _product = productData.get();
			_product.setName(product.getName());
			_product.setCategory(product.getCategory());
			_product.setPrice(product.getPrice());
			_product.setManufacturer(product.getManufacturer());
			_product.setUnitInStock(product.getUnitInStock());
			_product.setDescription(product.getDescription());

			return new ResponseEntity<>(repository.save(_product), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}</pre></code>

![8](https://github.com/SeoHyeokGyu/helloSpringBoot/blob/master/src/main/resources/screenshot/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-06-24%20%EC%98%A4%ED%9B%84%206.16.45.png)
- Delete (DELETE): delete product with id=N: http://localhost:9090/api/v1/products/{id}
<pre><code>	@DeleteMapping("/products/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") int id) {
		try {
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}</pre></code>

![9](https://github.com/SeoHyeokGyu/helloSpringBoot/blob/master/src/main/resources/screenshot/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-06-24%20%EC%98%A4%ED%9B%84%207.20.08.png)
***

### Spring Boot의 actuator를 활용하여 Products REST API에 대한 URL Mapping 정보를 캡쳐해서 보여라.
![1](https://github.com/SeoHyeokGyu/helloSpringBoot/blob/master/src/main/resources/screenshot/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-06-24%20%EC%98%A4%ED%9B%84%203.01.19.png)
![2](https://github.com/SeoHyeokGyu/helloSpringBoot/blob/master/src/main/resources/screenshot/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-06-24%20%EC%98%A4%ED%9B%84%203.01.48.png)
![3](https://github.com/SeoHyeokGyu/helloSpringBoot/blob/master/src/main/resources/screenshot/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-06-24%20%EC%98%A4%ED%9B%84%203.01.57.png)
