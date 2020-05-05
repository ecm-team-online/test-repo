package online.ecmteam.bar.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restaurants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant implements Serializable {

	/**
	 * Restaurantsマスターテーブルの主キー。自動採号
	 */
	@Id
	@GeneratedValue
	private Integer id;

	/**
	 * 店の名前
	 */
	@Column(nullable = false)
	private String restaurantName;
	
	/**
	 * ぐるなびAPIの店舗ID
	 */
	@Column(nullable = false, unique = true)
	private String gurunavitenpoId;
}
