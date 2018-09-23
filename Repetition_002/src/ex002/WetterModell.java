package ex002;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author franz
 */
public class WetterModell extends AbstractListModel
{
    private ArrayList<WetterWert> werte = new ArrayList<>();
    
    @Override
    public int getSize() 
    {
        return werte.size();    
    }

    @Override
    public Object getElementAt(int index)
    {
        return werte.get(index);
    }
    
}
