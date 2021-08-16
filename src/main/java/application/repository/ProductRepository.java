package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findById(long id);
}
