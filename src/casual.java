

import java.io.Serializable;
import java.util.Date;

public class casual extends acq implements Serializable{
	 private Date when;//met
	 private String where;
	 // (100 chars max) 
	 private String circum;// (100 chars max) met
	 private String any;// other useful information (100 chars max
	 public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMob() {
			return mob;
		}
		public void setMob(String mob) {
			this.mob = mob;
		}
		public String getE_mail() {
			return e_mail;
		}
		public void setE_mail(String e_mail) {
			this.e_mail = e_mail;
		}
	public Date getWhen() {
		return when;
	}
	public void setWhen(Date when) {
		this.when = when;
	}
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	public String getCircum() {
		return circum;
	}
	public void setCircum(String circum) {
		this.circum = circum;
	}
	public String getAny() {
		return any;
	}
	public void setAny(String any) {
		this.any = any;
	}
}

