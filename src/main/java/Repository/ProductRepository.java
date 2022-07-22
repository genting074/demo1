package Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Dto.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {

}

