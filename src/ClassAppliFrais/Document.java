package ClassAppliFrais;

import java.time.LocalDate;

import javafx.beans.InvalidationListener;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.util.StringConverter;



public class Document {
	
	private IntegerProperty idJustificatif;
	private FraisForfait idFraisForfait;
	private StringProperty path;
	private Visiteur idVisiteur;
	private StringProperty NomJustificatif;
	private FloatProperty MontantJustificatif;

	public Document(Visiteur idVisiteur) {
		
		this.idJustificatif = new SimpleIntegerProperty();
		this.idFraisForfait = idFraisForfait ;
		this.path = new SimpleStringProperty();
		this.idVisiteur = idVisiteur;
		this.NomJustificatif = new SimpleStringProperty();
		this.MontantJustificatif = new SimpleFloatProperty();
	}	
		
			

	
	public IntegerProperty getIdJustificatifPro() {
		return idJustificatif;
	}
	
	public void setIdJustificatifPro(IntegerProperty idJustificatif) {
		this.idJustificatif = idJustificatif;
		
	}
	public StringProperty getPathPro() {
		return path;
	}

	public void setPathPro(SimpleStringProperty path) {
		this.path = path;
	}	

	public StringProperty getNomJustificatifPro() {
		return NomJustificatif;
	}


	public void setNomJustificatifPro(StringProperty NomJustificatif) {
		this.NomJustificatif = NomJustificatif;
	}
		
	public FloatProperty getMontantJustificatifPro() {
		return MontantJustificatif;
	}


	public void setMontantJustificatifPro(FloatProperty montantJustificatif) {
		MontantJustificatif = montantJustificatif;
	}
	
		//------------------------------------------------------------------------------------------
	
	public int getIdJustificatf() {
		return idJustificatif.get();
	}

	public void setIdJustificatif(int idJustificatif) {
		this.idJustificatif.set(idJustificatif);
	}
	
	public String getPath() {
		return path.get();
	}
	
	public void setPath (String path) {
		this.path.set(path);
	}
	
	public String getNomJustificatif() {
		return NomJustificatif.get();
	}


	public void setNomJustificatif(String NomJustificatif) {
		this.NomJustificatif.set(NomJustificatif);
	}
	
	public float getMontantJustificatif() {
		return MontantJustificatif.get();
	}
	
	public void setMontantJustificatif(float MontantJustificatif) {
		this.MontantJustificatif.set(MontantJustificatif);
	}
	
		
	//-------------------------------------------------------------------------------------------------	
		
		
	
	public Visiteur getIdVisiteur() {
		return idVisiteur;
	}
	public void setIdVisiteur(Visiteur idVisiteur) {
		this.idVisiteur = idVisiteur;
	}
	
	public FraisForfait getIdFraisForfait() {
		return idFraisForfait;
	}
	public void setIdFraisForfait(FraisForfait idFraisForfait) {
		this.idFraisForfait = idFraisForfait;
		
	}




	@Override
	public String toString() {
		return "Document [idJustificatif=" + idJustificatif + ", idFraisForfait=" + idFraisForfait + ", path=" + path
				+ ", idVisiteur=" + idVisiteur + ", NomJustificatif=" + NomJustificatif + ", MontantJustificatif="
				+ MontantJustificatif + "]";
	}
	
	
}