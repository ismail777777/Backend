package pack;

import javax.persistence.*;

@Entity
public class Login {

	// on identifie un login par l'adresse mail associée
	@Id
	private String email;
	private String mdp;
	private int id;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
}
