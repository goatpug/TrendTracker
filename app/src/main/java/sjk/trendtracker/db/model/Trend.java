package sjk.trendtracker.db.model;

public class Trend {

    private int id;
    private String name;

    public Trend() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
