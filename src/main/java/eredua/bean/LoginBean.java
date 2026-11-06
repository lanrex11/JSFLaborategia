package eredua.bean;

import java.io.Serializable;
import java.util.Date;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("login")
@SessionScoped // Saio osorako sortu.
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

	public LoginBean() {
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
}