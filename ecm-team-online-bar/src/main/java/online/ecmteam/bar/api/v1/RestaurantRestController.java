package online.ecmteam.bar.api.v1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import online.ecmteam.bar.domain.Restaurant;
import online.ecmteam.bar.service.RestaurantService;

@RestController
@RequestMapping("api/v1/restaurants")
public class RestaurantRestController {

	@Autowired
	RestaurantService restaurantService;
	
	/**
	 * レストラン全件取得
	 */
	@GetMapping
	List<Restaurant> getRestaurants(){
		List<Restaurant> restaurants = restaurantService.findAll();
		return restaurants;
	}
	
	/**
	 * レストラン1件取得
	 */
	@GetMapping(path = "{id}")
	Optional<Restaurant> getRestaurant(@PathVariable Integer id) {
		Optional<Restaurant> restaurant = restaurantService.findOne(id);
		return restaurant;
	}
}
