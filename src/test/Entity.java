public class Entity {

    private ShardingId id;
    private String property;

    public Entity(){ }

    public Entity(ShardingId id, String property){
        this.id = id;
        this.property = property;
    }

    public ShardingId getId(){
        return id;
    }

    public void setId(ShardingId id){
        this.id = id;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
