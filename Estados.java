import java.io.Serializable;

public class Estados implements Serializable{

    private String estuno;
    private String estdos;
    private String esttres;
    private String estcuatro;
    private String estcinco;
  
    public Estados(String estuno, String estdos, String esttres, String estcuatro, String estcinco){
        this.estuno = estuno;
        this.estdos = estdos;
        this.esttres = esttres;
        this.estcuatro = estcuatro;
        this.estcinco = estcinco;
       
    }

    public String getEstuno() {
        return estuno;
    }

    public String getEstdos() {
        return estdos;
    }

    public String getEsttres() {
        return esttres;
    }
 
    public String getEstcuatro() {
        return estcuatro;
    }

    public String getEstcinco() {
        return estcinco;
    }

}
