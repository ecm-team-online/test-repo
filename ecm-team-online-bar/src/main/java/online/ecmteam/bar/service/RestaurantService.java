package online.ecmteam.bar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.ecmteam.bar.domain.Restaurant;
import online.ecmteam.bar.repository.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	RestaurantRepository restaurantRepository;
	
	/**
	 * 全件数取得
	 */
	public List<Restaurant> findAll(){
		return restaurantRepository.findAll();
	}
	
	/**
	 * IDにより一件のみ取得
	 */
	public Optional<Restaurant> findOne(Integer id) {
		return restaurantRepository.findById(id);
	}

	/**
	 * データ追加
	 */	
	public Restaurant create(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	/**
	 * データ更新
	 */	
	public Restaurant update(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	/**
	 * データ削除
	 */	
	public void delete(Integer id) {
		restaurantRepository.deleteById(id);
	}
}
