package skay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_coverimage")
public class tbl_coverimage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "coverimage_id")
	private Integer coverimageid;

	@Column(name = "coverimage_name")
	private String coverimagename;

	@Column(name = "coverimage_url")
	private String coverimageurl;
	
	@Column(name = "coverimage_type")
	private Integer coverimagetype;

	public tbl_coverimage() {
		super();
	}

	public tbl_coverimage(Integer coverimageid, String coverimagename, String coverimageurl, Integer coverimagetype) {
		super();
		this.coverimageid = coverimageid;
		this.coverimagename = coverimagename;
		this.coverimageurl = coverimageurl;
		this.coverimagetype = coverimagetype;
	}

	public Integer getCoverimageid() {
		return coverimageid;
	}

	public void setCoverimageid(Integer coverimageid) {
		this.coverimageid = coverimageid;
	}

	public String getCoverimagename() {
		return coverimagename;
	}

	public void setCoverimagename(String coverimagename) {
		this.coverimagename = coverimagename;
	}

	public String getCoverimageurl() {
		return coverimageurl;
	}

	public void setCoverimageurl(String coverimageurl) {
		this.coverimageurl = coverimageurl;
	}

	public Integer getCoverimagetype() {
		return coverimagetype;
	}

	public void setCoverimagetype(Integer coverimagetype) {
		this.coverimagetype = coverimagetype;
	}

	

}
