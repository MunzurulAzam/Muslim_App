package azam.islamic_app;

public class ZikirAyat {

    String arbi;
    String ortho;
    String ucharon;

    public ZikirAyat() {
    }

    public ZikirAyat(String arbi, String ortho, String ucharon) {
        this.arbi = arbi;
        this.ortho = ortho;
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

    public String getUcharon() {
        return ucharon;
    }

    public void setUcharon(String ucharon) {
        this.ucharon = ucharon;
    }
}
