package online.ecmteam.bar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import online.ecmteam.bar.domain.Restaurant;
import online.ecmteam.bar.repository.RestaurantRepository;

@SpringBootApplication
public class EcmTeamOnlineBarApplication implements CommandLineRunner{

	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Override
	public void run(String... strings) throws Exception{
		
		restaurantRepository.save(new Restaurant(null, "べらべら1号店", "001"));
		restaurantRepository.save(new Restaurant(null, "べらべら2号店", "002"));
		restaurantRepository.save(new Restaurant(null, "べらべら3号店", "003"));
		restaurantRepository.save(new Restaurant(null, "べらべら4号店", "004"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EcmTeamOnlineBarApplication.class, args);
	}

}
