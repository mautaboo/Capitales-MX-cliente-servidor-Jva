import java.io.Serializable;

public class Respuestas implements Serializable{

    private String respuno;
    private String respdos;
    private String resptres;
    private String respcuatro;
    private String respcinco;
  
    public  Respuestas(String respuno, String respdos, String resptres, String respcuatro, String respcinco){
        this.respuno = respuno;
        this.respdos = respdos;
        this.resptres = resptres;
        this.respcuatro = respcuatro;
        this.respcinco = respcinco;
       
    }

    public String getRespuno() {
        return respuno;
    }

    public String getRespdos() {
        return respdos;
    }

    public String getResptres() {
        return resptres;
    }
 
    public String getRespcuatro() {
        return respcuatro;
    }

    public String getRespcinco() {
        return respcinco;
    }

}
