

import java.io.Serializable;
import java.util.Date;

public class relatives extends acq implements Serializable {
	 private Date bday;
	 private Date ldate;
	public Date getBday() {
		return bday;
	}
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
	public void setBday(Date birthday) {
		this.bday = birthday;
	}
	public Date getLdate() {
		return ldate;
	}
	public void setLdate(Date ldate) {
		this.ldate = ldate;
	}

}
