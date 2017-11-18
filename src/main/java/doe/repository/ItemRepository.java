package doe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import doe.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
