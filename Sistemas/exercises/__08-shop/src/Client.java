import java.time.LocalDateTime;
import java.util.Hashtable;

public class Client extends User {
    // Data
    public double money;
    private Hashtable<String, Object> info;
    private LocalDateTime logDate;

    public Client(String name, String password) {
        super(name, password);
        this.logDate = LocalDateTime.now();
        info = new Hashtable<String, Object>();
    }

    public Hashtable<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Hashtable<String, Object> info) {

        if (info == null)
            this.info.clear();

        this.info = info;
    }

    public LocalDateTime getLogDate() {
        return logDate;
    }

}
