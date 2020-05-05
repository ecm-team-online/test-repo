package online.ecmteam.bar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import online.ecmteam.bar.domain.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{
	
}
