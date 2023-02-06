package azam.islamic_app;

public class AmolList_Info {
    String amol_Number;
    String amol_name;


    public AmolList_Info() {
    }

    public AmolList_Info(String amol_Number, String amol_name) {
        this.amol_Number = amol_Number;
        this.amol_name = amol_name;
    }

    public String getAmol_Number() {
        return amol_Number;
    }

    public void setAmol_Number(String amol_Number) {
        this.amol_Number = amol_Number;
    }

    public String getAmol_name() {
        return amol_name;
    }

    public void setAmol_name(String amol_name) {
        this.amol_name = amol_name;
    }
}
