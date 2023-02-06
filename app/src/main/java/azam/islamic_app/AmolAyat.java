package azam.islamic_app;

public class AmolAyat {

    String arbi;
    String ortho;
    String ucharon;
    String tottho;

    public AmolAyat() {
    }

    public AmolAyat(String arbi, String ortho, String ucharon, String tottho) {
        this.arbi = arbi;
        this.ortho = ortho;
        this.ucharon = ucharon;
        this.tottho = tottho;
    }

    public String getArbi() {
        return arbi;
    }

    public void setArbi(String arbi) {
        this.arbi = arbi;
    }

    public String getOrtho() {
        return ortho;
    }

    public void setOrtho(String ortho) {
        this.ortho = ortho;
    }

    public String getUcharon() {
        return ucharon;
    }

    public void setUcharon(String ucharon) {
        this.ucharon = ucharon;
    }

    public String getTottho() {
        return tottho;
    }

    public void setTottho(String tottho) {
        this.tottho = tottho;
    }
}
