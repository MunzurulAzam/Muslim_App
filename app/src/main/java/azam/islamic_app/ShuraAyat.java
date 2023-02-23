package azam.islamic_app;

public class ShuraAyat {

    String arbi;
    String ortho;
    String tottho;
    String ucharon;

    public ShuraAyat() {
    }

    public ShuraAyat(String arbi, String ortho, String tottho, String ucharon) {
        this.arbi = arbi;
        this.ortho = ortho;
        this.tottho = tottho;
        this.ucharon = ucharon;
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

    public String getTottho() {
        return tottho;
    }

    public void setTottho(String tottho) {
        this.tottho = tottho;
    }

    public String getUcharon() {
        return ucharon;
    }

    public void setUcharon(String ucharon) {
        this.ucharon = ucharon;
    }
}
