package online.ecmteam.bar.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import online.ecmteam.bar.domain.RecommendedBar;

@Service
public class GrunaviService {
	
	private final String grunaviKey = "cb212892e96a2e8ad5310500005588ff";

	public RecommendedBar findOne(String gurunaviTenpoId) {
		
		String url = "https://api.gnavi.co.jp/RestSearchAPI/v3/?keyid=" + grunaviKey + "&id=" +gurunaviTenpoId;
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder().url(url).build();
		Call call = client.newCall(request);
		Response response = null;
        RecommendedBar bar = new RecommendedBar();
		try {
			response = call.execute();
			if ( response.code() == 429 ) {
				bar.setName("一日の上限を超えたため、ぐるなびAPIからデータが取得できませんでした。");
			} else {
		        ObjectMapper mapper = new ObjectMapper();
		        JsonNode node;
				node = (mapper.readTree(response.body().string())).get("rest").get(0);			 
				bar.setId(node.get("id").asText());
				bar.setName(node.get("name").asText());
				bar.setOpentime(node.get("opentime").asText());
				bar.setTel(node.get("tel").asText());
				bar.setAddress(node.get("address").asText());
				bar.setUrl(node.get("url").asText());
				bar.setImageurl(node.get("image_url").get("shop_image1").asText());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bar;
	}
}
