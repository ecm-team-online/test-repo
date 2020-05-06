package online.ecmteam.bar.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
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
		try {
			response = call.execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResponseBody body = response.body();
		

        ObjectMapper mapper = new ObjectMapper();
        RecommendedBar bar = new RecommendedBar();
        JsonNode node;
		try {
			node = (mapper.readTree(response.body().string())).get("rest").get(0);			 
			 bar.setId(node.get("id").toString());
			 bar.setName(node.get("name").toString());
			 bar.setOpentime(node.get("opentime").toString());
			 bar.setTel(node.get("tel").toString());
			 bar.setAddress(node.get("address").toString());
			 bar.setUrl(node.get("url").toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bar;
	}
	

}
