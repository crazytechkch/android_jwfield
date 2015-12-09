package co.crazytech.jwfield.terrsurvey;

/**
 * Created by eric on 11/27/2015.
 */
public class Terrsurvey {
    private String houseNo, street1, street2;
    private boolean en,zh,nh,ia,ml,xx;

    public boolean isMl() {
        return ml;
    }

    public void setMl(boolean ml) {
        this.ml = ml;
    }


    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public boolean isEn() {
        return en;
    }

    public void setEn(boolean en) {
        this.en = en;
    }

    public boolean isZh() {
        return zh;
    }

    public void setZh(boolean zh) {
        this.zh = zh;
    }

    public boolean isNh() {
        return nh;
    }

    public void setNh(boolean nh) {
        this.nh = nh;
    }

    public boolean isIa() {
        return ia;
    }

    public void setIa(boolean ia) {
        this.ia = ia;
    }

    public boolean isXx() {
        return xx;
    }

    public void setXx(boolean xx) {
        this.xx = xx;
    }
}
