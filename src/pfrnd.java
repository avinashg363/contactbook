


import java.io.Serializable;


public class pfrnd extends acq implements Serializable{
	 private String cmn_p_int;
	 //(100 chars max)
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
	public String getcpi() {
		return cmn_p_int;
	}
	public void setcpi(String cmn_p_int) {
		this.cmn_p_int = cmn_p_int;
	}

}

