package online.ecmteam.bar.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

	private static final long serialVersionUID = 5804856814654684591L;

	/**
	 * Restaurantsマスターテーブルの主キー。自動採号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 店の名前
	 */
	private String restaurantName;
	
	/**
	 * ぐるなびAPIの店舗ID
	 */
	@Column(nullable = false, unique = true)
	private String gurunaviTenpoId;
}
