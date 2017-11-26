package skay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_garelly")
public class tbl_garelly {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer garellyid;

	private String coupleid;
	private Integer aniversarryid;
	private String urlimage;

	public tbl_garelly() {
		super();
	}

	public tbl_garelly(Integer garellyid, String coupleid, Integer aniversarryid, String urlimage) {
		super();
		this.garellyid = garellyid;
		this.coupleid = coupleid;
		this.aniversarryid = aniversarryid;
		this.urlimage = urlimage;
	}
	
	public tbl_garelly(tbl_garelly g) {
		super();
		this.garellyid = g.garellyid;
		this.coupleid = g.coupleid;
		this.aniversarryid = g.aniversarryid;
		this.urlimage = "http://192.168.2.49:8080/resources/images/" + g.urlimage;
	}

	public tbl_garelly(String coupleid, Integer aniversarryid, String urlimage) {
		super();
		this.coupleid = coupleid;
		this.aniversarryid = aniversarryid;
		this.urlimage = urlimage;
	}

	public Integer getGarellyid() {
		return garellyid;
	}

	public void setGarellyid(Integer garellyid) {
		this.garellyid = garellyid;
	}

	public String getCoupleid() {
		return coupleid;
	}

	public void setCoupleid(String coupleid) {
		this.coupleid = coupleid;
	}

	public Integer getAniversarryid() {
		return aniversarryid;
	}

	public void setAniversarryid(Integer aniversarryid) {
		this.aniversarryid = aniversarryid;
	}

	public String getUrlimage() {
		return urlimage;
	}

	public void setUrlimage(String urlimage) {
		this.urlimage = urlimage;
	}
}
