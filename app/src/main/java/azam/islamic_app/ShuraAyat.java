package azam.islamic_app;

public class ShuraAyat {
    String arabic;
    String uccharon;
    String banglameaning;


    public ShuraAyat() {
    }

    public ShuraAyat(String arabic, String uccharon, String banglameaning) {
        this.arabic = arabic;
        this.uccharon = uccharon;
        this.banglameaning = banglameaning;
    }

    public String getArabic() {
        return arabic;
    }

    public void setArabic(String arabic) {
        this.arabic = arabic;
    }

    public String getUccharon() {
        return uccharon;
    }

    public void setUccharon(String uccharon) {
        this.uccharon = uccharon;
    }

    public String getBanglameaning() {
        return banglameaning;
    }

    public void setBanglameaning(String banglameaning) {
        this.banglameaning = banglameaning;
    }
}
