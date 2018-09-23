package ex002;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.AbstractListModel;
import javax.swing.JFileChooser;

/**
 *
 * @author franz
 */
public class WetterModell extends AbstractListModel
{
    private ArrayList<WetterWert> werte = new ArrayList<>();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM - HH:mm:ss");
    
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

    public void saveDataTxt() throws IOException 
    {
        JFileChooser chooser = new JFileChooser("C:\\Exercise_Repetition_002\\Repetition_002\\src\\data");
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            for (WetterWert w : werte) {
                bw.write("" + w.getTemperatur());
                bw.write(';');
                bw.write("" + w.getLuftfeuchtigkeit());
                bw.write(';');
                bw.write("" + sdf.format(w.getZeitpunkt()));
                bw.newLine();
            }
            bw.close();
        }
    }

    public void loadDataTxt() throws FileNotFoundException, IOException, ParseException 
    {
        werte.clear();
        JFileChooser chooser = new JFileChooser("C:\\Exercise_Repetition_002\\Repetition_002\\src\\data");
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) {
                String[] str = line.split(";");
                WetterWert w = new WetterWert(Integer.parseInt(str[0]), Integer.parseInt(str[1]), sdf.parse(str[2]));
                werte.add(w);
            }

        }
        fireContentsChanged(werte, 0, werte.size() - 1);
    }

    public void addWerte(WetterWert w) {
        werte.add(w);
        super.fireContentsChanged(werte, 0, werte.size() - 1);
    }
    
}
