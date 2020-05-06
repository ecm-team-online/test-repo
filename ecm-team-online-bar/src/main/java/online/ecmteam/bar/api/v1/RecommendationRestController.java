package online.ecmteam.bar.api.v1;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import online.ecmteam.bar.domain.RecommendedBar;
import online.ecmteam.bar.domain.Restaurant;
import online.ecmteam.bar.service.GrunaviService;
import online.ecmteam.bar.service.RestaurantService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/recommendations")
public class RecommendationRestController {

	@Autowired
	GrunaviService recommendationService;
	@Autowired
	RestaurantService restaurantService;
	
	private Random random = new Random();
	
	/**
	 * お勧めのバーを返す
	 */
	@GetMapping
	RecommendedBar getRecommendedBar(){
		
		List<Restaurant> list = restaurantService.findAll();
		int randomValue = random.nextInt(list.size());
		
		// 乱数でおすすめのレストランを決定
		Restaurant restaurant = list.get(randomValue);

		// 決定したレストランのぐるなびIDをGrunaviServiceサービスの渡す
		return recommendationService.findOne(restaurant.getGurunaviTenpoId());
	}
}
