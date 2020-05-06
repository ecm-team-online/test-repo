package online.ecmteam.bar.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendedBar implements Serializable {

	private static final long serialVersionUID = 4293373829188980378L;

	/**
	 * ぐるなびAPIの店舗ID
	 */
	private String id;
	
	/**
	 * 店の名前
	 */
	private String name;
	
	/**
	 * お店の電話番号
	 */
	private String tel;
	
	/**
	 * お店の住所
	 */
	private String address;
	
	/**
	 * 営業時間
	 */
	private String opentime;
	
	/**
	 * URL
	 */
	private String url;
	
	/**
	 * イメージURL
	 */
	private String imageurl;
	
}
