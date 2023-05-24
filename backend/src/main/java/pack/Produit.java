package pack;
import java.awt.Image;

import javax.persistence.*;
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private double prix;
    private String description;
    //private Image img;
    public Produit() {
    }
    public Produit(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public Produit(String nom, double prix, String description) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        //this.img = img;
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}*/
    
   
}    

