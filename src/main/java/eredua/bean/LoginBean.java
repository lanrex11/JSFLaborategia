package eredua.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.primefaces.event.SelectEvent;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.inject.Named;

@Named("login")
@ApplicationScoped // Saio osorako sortu.

//RequestScope --> HTTP eskaera egitean objetua sortu: kaixo.xhtml jarrita nabigatzailetik eskera, login egitean ez.
//Application --> Mantendu beste nabigatzailebatetik ere.
//Erroreak daudenean ez da ezer gordetzen.
//AJAX --> Idatzi bitartean mezuak agertzea --> Asinkronoa
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	// hemen gorde bistako input-ak casteatuta
	private String izena;
	private String pasahitza;
	private Date data;
	private ErabiltzailearenMota mota;
	private static List<ErabiltzailearenMota> motak;

	public LoginBean() {
		motak = new ArrayList<ErabiltzailearenMota>();
		motak.add(new ErabiltzailearenMota(1, "ikaslea"));
		motak.add(new ErabiltzailearenMota(2, "irakaslea"));

	}

	public ErabiltzailearenMota getMota() {
		return mota;
	}

	public void setMota(ErabiltzailearenMota mota) {
		this.mota = mota;
		System.out.println("Erabiltzailearen mota: " + mota.getKodea() + "/" + mota.getErabMota());
	}

	public List<ErabiltzailearenMota> getMotak() {
		return motak;
	}

	public void setMotak(List<ErabiltzailearenMota> motak) {
		this.motak = motak;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public String egiaztatu() {
		if (izena.length() != pasahitza.length()) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Errorea: izenaren eta pasahitzaren luzera desberdinak dira."));
			return null;
		}

		if (izena.equals("pirata"))
			return "error";
		else
			return "ok";
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void onDateSelect(SelectEvent event) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data aukeratua: " + event.getObject()));
	}

	public static ErabiltzailearenMota getObject(String mota) {
		for (ErabiltzailearenMota m : motak) {
			if (mota.equals(m.getErabMota()))
				return m;
		}
		return null;
	}
}