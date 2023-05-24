package pack;
import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.*;
import javax.ws.rs.*;
import org.w3c.dom.Entity;
import javax.persistence.*;
@Singleton
@Path("/")
public class Facade {
    @PersistenceContext    
    private EntityManager em ;

    public Facade() {
    	/*Produit p1 = new Produit("HP Chromebook 14B", 699.00, "Ordinateur portable ...");
    	Produit p2 = new Produit("HP Laptop 14", 699.00, "Ordinateur portable ...");
    	Produit p3 = new Produit("HP Ordinateur Portable 15S", 449.00, "Ordinateur portable ...");
    	Produit p4 = new Produit("Surface Pro 7+", 929.00, "Ordinateur portable ...");
    	Produit p5 = new Produit("Apple Macbook Pro 15\" Retina", 699.00, "Ordinateur portable ...");
    	Produit p6 = new Produit("Dell Inspiron 15", 699.00, "Ordinateur portable ...");
    	Produit p7 = new Produit("Lenovo Legion 5", 799.00, "Ordinateur portable ...");
    	em.persist(p1);
    	em.persist(p2);
    	em.persist(p3);
    	em.persist(p4);
    	em.persist(p5);
    	em.persist(p6);
    	em.persist(p7);*/
    }

    @POST
    @Path("/AjouterPersonne")
    @Consumes({"application/json"})
    public void ajouterPersonne(Personne p) {
        em.persist(p);
    }

    @GET
    @Path("/GetPersonneId/{nom}/{prenom}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Collection<Personne> GetPersonneId(@PathParam("nom") String nom, @PathParam("prenom") String prenom) {
    	return em.createQuery("select personne from Personne personne where personne.nom='"+nom+"' and personne.prenom='"+prenom+"'",Personne.class).setMaxResults(1).getResultList();
    }

    @POST
    @Path("/AjouterLogin")
    @Consumes({"application/json"})
    public void AjouterLogin(Login login) {
    	em.persist(login);
    }

    // méthode de vérification des données de login
    @GET
    @Path("/Login/{e}/{m}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Boolean verifierLogin(@PathParam("e") String email, @PathParam("m") String mdp) {
    	return em.createQuery("select l from Login l where l.email = '"+email+"' and l.mdp = '"+mdp+"'", Login.class).getResultList().size()!=0;
    }

    /*@GET
    @Path("/ListerPersonne")
    @Produces({"application/json"})
    public Collection<Personne> listerPersonnes(){
        TypedQuery<Personne> req= em.createQuery("select p from  Personne p",Personne.class);
        return req.getResultList();
    } 

    /*
    public Personne listerPersonne(int id){
        Personne p = em.find(Personne.class,id);
        return p;
    }*/

    // lister les produits ajoutés au panier d'un utilisateur
    /*@GET
    @Path("/ListerProduits/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Collection<Produit> listerProduits(@PathParam("id") int idPersonne){
        Personne p = em.find(Personne.class,idPersonne);
        return p.getPanier().getProduits();
    }

    // ajouter un produit au panier
   /** @POST
    @Path("/AjouterProduit/{id}/{idp}")
    @Produces({"application/json"})
    public void ajouterProduit(@PathParam("id") int id, @PathParam("idp") int idprod){
    	Personne personne = em.find(Personne.class,id);
    	personne.getPanier().ajouterProduit(idprod);
        em.persist(personne);
    }

    // supprimer un produit du panier
    @DELETE
    @Path("/SupprimerProduit/{id}/{p}")
    @Produces({"application/json"})
    public void supprimerProduit(@PathParam("id") int id,@PathParam("p") Produit prod) {
    	Personne personne = em.find(Personne.class, id);
    	personne.getPanier().supprimerProduit(prod);
    	em.persist(personne);
    }*/

    // modifier les données (login) d'un utilisateur
    /*@POST
    @Path("/ModifierPersonne/{id}/{nom}/{prenom}/{email}/{pswd}")
    @Produces({"application/json"})
    public void modifierPersonne(@PathParam("id") int id, @PathParam("nom") String nom, @PathParam("prenom") String Prenom, @PathParam("email") String nouveauMail, @PathParam("pswd") String nouveauPassword) {
    	Personne p = em.find(Personne.class, id);
    	p.setNom(nom);
    	p.setPrenom(Prenom);
    	p.setMail(nouveauMail);
    	p.setPassword(nouveauPassword);
    }

    /*/
    /*public Collection<Produit> filtrerProduits() {
    	return em.createQuery("from Produit",Produit.class).getResultList();
    }

    @GET
    @Path("/Login/{f}/{p}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Collection<Produit> filtrerProduits(@PathParam("f") String filtre, @PathParam("p") String valeur) {
        if (filtre.equals("prix")) {
            return em.createQuery("from Produit where prix < " + valeur, Produit.class).getResultList();
        } else if (filtre.equals("marque")) {
            return em.createQuery("from Produit where marque = " + valeur, Produit.class).getResultList();
        } else if (filtre.equals("type")) {
            return em.createQuery("from Produit where type = " + valeur, Produit.class).getResultList();
        } else {
        	return em.createQuery("from Produit where modele = " + valeur, Produit.class).getResultList();
        }


    }*/
}