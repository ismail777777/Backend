package pack;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Produit> produits;
    
    public Panier() {
        produits = new ArrayList<>();
    }
    
    /*public void ajouterProduit(int idprod) {
        produits.add(idprod);
    }
    */
    public void supprimerProduit(Produit product) {
        produits.remove(product);
    }
    
    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Produit product : produits) {
            totalPrice += product.getPrix();
        }
        return totalPrice;
    }

    // getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}   
}



