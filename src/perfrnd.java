

import java.io.Serializable;
import java.util.Date;

public class perfrnd extends acq implements Serializable{
     private String context;//100 chars max
	
	 private Date date;// in which acquainted
	 private String spec_events;// that need to be noted (100 chars max)
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getSpec_events() {
		return spec_events;
	}
	public void setSpec_events(String spec_events) {
		this.spec_events = spec_events;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
}

