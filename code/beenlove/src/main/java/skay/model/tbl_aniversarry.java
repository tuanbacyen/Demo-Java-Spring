package skay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_aniversarry")
public class tbl_aniversarry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer aniversarryid;

	private String coupleid;
	private String name;
	private String detail;
	private String date;
	private String urlimage;

	public tbl_aniversarry() {
		super();
	}

	public tbl_aniversarry(Integer aniversarryid, String coupleid, String name, String detail, String date,
			String urlimage) {
		super();
		this.aniversarryid = aniversarryid;
		this.coupleid = coupleid;
		this.name = name;
		this.detail = detail;
		this.date = date;
		this.urlimage = urlimage;
	}

	public tbl_aniversarry(String coupleid, String name, String detail, String date, String urlimage) {
		super();
		this.aniversarryid = null;
		this.coupleid = coupleid;
		this.name = name;
		this.detail = detail;
		this.date = date;
		this.urlimage = urlimage;
	}

	public Integer getAniversarryid() {
		return aniversarryid;
	}

	public void setAniversarryid(Integer aniversarryid) {
		this.aniversarryid = aniversarryid;
	}

	public String getCoupleid() {
		return coupleid;
	}

	public void setCoupleid(String coupleid) {
		this.coupleid = coupleid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUrlimage() {
		return urlimage;
	}

	public void setUrlimage(String urlimage) {
		this.urlimage = urlimage;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
