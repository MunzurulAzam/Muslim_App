package azam.islamic_app;

public class ZikirErList {
    String zikir_name;
    String zikir_Number;


    public ZikirErList() {
    }

    public ZikirErList(String zikir_name, String zikir_Number) {
        this.zikir_name = zikir_name;
        this.zikir_Number = zikir_Number;
    }

    public String getZikir_name() {
        return zikir_name;
    }

    public void setZikir_name(String zikir_name) {
        this.zikir_name = zikir_name;
    }

    public String getZikir_Number() {
        return zikir_Number;
    }

    public void setZikir_Number(String zikir_Number) {
        this.zikir_Number = zikir_Number;
    }
}
