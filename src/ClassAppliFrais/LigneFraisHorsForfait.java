package ClassAppliFrais;

import javafx.beans.property.SimpleFloatProperty;

import java.sql.Date;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.StringConverter;

public class LigneFraisHorsForfait {
	private IntegerProperty id;
	private Visiteur idVisiteur;
	private IntegerProperty mois;
	private StringProperty libelle;
	private ObjectProperty <Date> date;
	private FloatProperty montant;
	
public LigneFraisHorsForfait(Visiteur idVisiteur) {
	this.id = new SimpleIntegerProperty();
	this.idVisiteur=idVisiteur;
	this.mois = new SimpleIntegerProperty();
	this.libelle = new SimpleStringProperty();
	this.date = new SimpleObjectProperty <Date>();
	this.montant = new SimpleFloatProperty();
}

public IntegerProperty getIdPro() {
	return id;
}

public void setIdPro(IntegerProperty id) {
	this.id = id;
}

public Visiteur getIdVisiteur() {
	return idVisiteur;
}

public void setIdVisiteur(Visiteur idVisiteur) {
	this.idVisiteur = idVisiteur;
}

public StringProperty getLibellePro() {
	return libelle;
}

public void setLibellePro(StringProperty libelle) {
	this.libelle = libelle;
}

public IntegerProperty getMoisPro() {
	return mois;
}

public void setMoisPro(IntegerProperty mois) {
	this.mois = mois;
}

public ObjectProperty<Date> getDatePro() {
	return date;
}

public void setDatePro(ObjectProperty<Date> date) {
	this.date = date;
}

public FloatProperty getMontantPro() {
	return montant;
}

public void setMontantPro(FloatProperty montant) {
	this.montant = montant;
}

public int getId(){
	return id.get();
}

public void setId(int LigneFraisHorsForfait) {
	this.id.set(LigneFraisHorsForfait);
}

public int getMois() {
	return mois.get();
}

public void setMois(int mois) {
	this.mois.set(mois);
}

public String getLibelle() {
	return libelle.get();
}

public void setLibelle(String libelle) {
	this.libelle.set(libelle);
}

public Date getDate() {
	return date.get();
}

public void setDate(Date date) {
	this.date.set(date);
}

public float getMontant() {
	return montant.get();
}

public void setMontant(float montant) {
	this.montant.set(montant);
}
//mois , libelle , date , montant
}
