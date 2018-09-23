package ex002;

import java.util.Date;

/**
 *
 * @author franz
 */
public class WetterWert 
{
    private int temperatur;
    private int luftfeuchtigkeit;
    private Date zeitpunkt;

    public WetterWert(int temperatur, int luftfeuchtigkeit, Date zeitpunkt) {
        this.temperatur = temperatur;
        this.luftfeuchtigkeit = luftfeuchtigkeit;
        this.zeitpunkt = zeitpunkt;
    }

    public int getTemperatur() {
        return temperatur;
    }

    public void setTemperatur(int temperatur) {
        this.temperatur = temperatur;
    }

    public int getLuftfeuchtigkeit() {
        return luftfeuchtigkeit;
    }

    public void setLuftfeuchtigkeit(int luftfeuchtigkeit) {
        this.luftfeuchtigkeit = luftfeuchtigkeit;
    }

    public Date getZeitpunkt() {
        return zeitpunkt;
    }

    public void setZeitpunkt(Date zeitpunkt) {
        this.zeitpunkt = zeitpunkt;
    }
    
    
    
}
