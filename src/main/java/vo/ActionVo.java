package vo;

public class ActionVo {

    private long id;
    private int type;
    private String value;

    public ActionVo() {}

    public ActionVo(long id, int type, String value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
