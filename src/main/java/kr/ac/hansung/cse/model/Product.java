package kr.ac.hansung.cse.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

@Table(name="productTable")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -567117648902464025L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id", nullable= false, updatable= false)
	private int id;

	private String name;

	private String category;
	
	private int price;

	private String manufacturer;

	private int unitInStock;

	private String description;
	
}
