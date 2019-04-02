package ClassAppliFrais;


import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Lignefraisforfait {
	private Visiteur idVisiteur;
	private StringProperty mois;
	private FraisForfait idFraisForfait;
	private IntegerProperty quantite;
	private FloatProperty Montant;

public Lignefraisforfait(Visiteur idVisiteur,FraisForfait idFraisForfait){
	this.idVisiteur=idVisiteur ;
	this.mois = new SimpleStringProperty();
	this.idFraisForfait=idFraisForfait;
	this.quantite = new SimpleIntegerProperty();
	this.Montant = new SimpleFloatProperty();
}

public Visiteur getIdVisiteur(){
	return idVisiteur;
}

public void setIdVisiteur(Visiteur idVisiteur){
	this.idVisiteur=idVisiteur;
}

public StringProperty getMoisPro(){
	return mois;
}

public void setMoisPro(StringProperty mois){
	this.mois=mois;
}

public FraisForfait getIdFraisForfait (){
	return idFraisForfait;
}

public void setIdFraisForfait (FraisForfait idFraisForfait) {
	this.idFraisForfait=idFraisForfait;
}

public IntegerProperty getQuantitePro() {
	return quantite;
}

public void setQuantitePro(IntegerProperty quantite) {
	this.quantite = quantite;
}

public FloatProperty getMontantPro() {
	return Montant;
}

public void setMontantPro(FloatProperty Montant) {
	this.Montant = Montant;
}

//------fin des pro

public String getMois() {
	return mois.get();
}

public void setMois(String mois) {
	this.mois.set(mois);
}

public int getQuantite() {
	return quantite.get();
}
public void setQuantite(int quantite) {
	this.quantite.set(quantite);
}

public Float getMontant() {
	return Montant.get();
}

public void setMontant(Float Montant) {
	this.Montant.set(Montant);
}

}