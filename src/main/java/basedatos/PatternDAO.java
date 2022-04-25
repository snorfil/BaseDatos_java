package basedatos;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PatternDAO {
    protected String host;
    protected String usr;
    protected String pass;

    protected PatternDAO() {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("propiedades.properties"));
            this.host = p.getProperty("host");
            this.usr = p.getProperty("usr");
            this.pass = p.getProperty("pass");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
