package ClassAppliFrais;

import java.sql.Date;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.util.StringConverter;


public class FicheFrais implements ObservableList<FicheFrais> {
	private Visiteur idVisiteur;
	private StringProperty mois;
	private IntegerProperty nbJustificatifs;
	private LigneFraisHorsForfait montantValide;
	private ObjectProperty <Date> dateModif;
	private Etat idEtat;
	
public FicheFrais (Visiteur idVisiteur,LigneFraisHorsForfait montantValide,Etat idEtat) {	
	this.idVisiteur=idVisiteur;
	this.mois = new SimpleStringProperty();
	this.nbJustificatifs = new SimpleIntegerProperty();
	this.montantValide=montantValide;
	this.dateModif = new SimpleObjectProperty <Date>();
	this.idEtat=idEtat;
	
	
}


public StringProperty getMoisPro() {
	return mois;
}

public void setMoisPro(StringProperty mois) {
	this.mois = mois;
}

public IntegerProperty getNbJustificatifsPro() {
	return nbJustificatifs;
}

public void setNbJustificatifsPro(IntegerProperty nbJustificatifs) {
	this.nbJustificatifs = nbJustificatifs;
}

public ObjectProperty<Date> getDateModifPro() {
	return dateModif;
}

public void setDateModifPro(ObjectProperty<Date> dateModif) {
	this.dateModif = dateModif;
}

public LigneFraisHorsForfait getMontantValide() {
	return montantValide;
}

public void setMontantValide(LigneFraisHorsForfait montantValide) {
	this.montantValide = montantValide;
}

public Etat getIdEtat() {
	return idEtat;
}

public void setIdEtat(Etat idEtat) {
	this.idEtat = idEtat;
}

public String getMois() {
	return mois.get();
}

public void setMois(String mois) {
	this.mois.set(mois);
}

public int getNbJustificatifs(){
	return nbJustificatifs.get();
	
}

public void setNbJustificatifs(int nbJustificatifs) {
	this.nbJustificatifs.set(nbJustificatifs);
}

public Visiteur getIdVisiteur() {
	return idVisiteur;
}

public void setIdVisiteur(Visiteur idVisiteur) {
	this.idVisiteur = idVisiteur;
}

public Date getDateModif() {
	return dateModif.get();
}

public void setDateModif(Date dateModif2) {
	this.dateModif.set(dateModif2);
}


public void setIdVisiteur(int idVisiteur2) {
	// TODO Auto-generated method stub
	
}


@Override
public boolean add(FicheFrais arg0) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public void add(int arg0, FicheFrais arg1) {
	// TODO Auto-generated method stub
	
}


@Override
public boolean addAll(Collection<? extends FicheFrais> arg0) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean addAll(int arg0, Collection<? extends FicheFrais> arg1) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public void clear() {
	// TODO Auto-generated method stub
	
}


@Override
public boolean contains(Object arg0) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean containsAll(Collection<?> arg0) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public FicheFrais get(int arg0) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public int indexOf(Object arg0) {
	// TODO Auto-generated method stub
	return 0;
}


@Override
public boolean isEmpty() {
	// TODO Auto-generated method stub
	return false;
}


@Override
public Iterator<FicheFrais> iterator() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public int lastIndexOf(Object arg0) {
	// TODO Auto-generated method stub
	return 0;
}


@Override
public ListIterator<FicheFrais> listIterator() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public ListIterator<FicheFrais> listIterator(int arg0) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public boolean remove(Object arg0) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public FicheFrais remove(int arg0) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public boolean removeAll(Collection<?> arg0) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean retainAll(Collection<?> arg0) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public FicheFrais set(int arg0, FicheFrais arg1) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public int size() {
	// TODO Auto-generated method stub
	return 0;
}


@Override
public List<FicheFrais> subList(int arg0, int arg1) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public Object[] toArray() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public <T> T[] toArray(T[] arg0) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void addListener(InvalidationListener arg0) {
	// TODO Auto-generated method stub
	
}


@Override
public void removeListener(InvalidationListener arg0) {
	// TODO Auto-generated method stub
	
}


@Override
public boolean addAll(FicheFrais... arg0) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public void addListener(ListChangeListener<? super FicheFrais> arg0) {
	// TODO Auto-generated method stub
	
}


@Override
public void remove(int arg0, int arg1) {
	// TODO Auto-generated method stub
	
}


@Override
public String toString() {
	return "FicheFrais [idVisiteur=" + idVisiteur + ", mois=" + mois + ", nbJustificatifs=" + nbJustificatifs
			+ ", montantValide=" + montantValide + ", dateModif=" + dateModif + ", idEtat=" + idEtat + "]";
}


@Override
public boolean removeAll(FicheFrais... arg0) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public void removeListener(ListChangeListener<? super FicheFrais> arg0) {
	// TODO Auto-generated method stub
	
}


@Override
public boolean retainAll(FicheFrais... arg0) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean setAll(FicheFrais... arg0) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean setAll(Collection<? extends FicheFrais> arg0) {
	// TODO Auto-generated method stub
	return false;
}
}