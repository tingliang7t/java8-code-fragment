package vo;

import java.util.List;

public class ConfigVo {

    private long id;
    private String name;
    private ResourceVo resource;
    private List<ActionVo> actions;
    private String comment;

    public ConfigVo(){}

    public ConfigVo(long id, String name, ResourceVo resource, List<ActionVo> actions, String comment) {
        this.id = id;
        this.name = name;
        this.resource = resource;
        this.actions = actions;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ResourceVo getResource() {
        return resource;
    }

    public void setResource(ResourceVo resource) {
        this.resource = resource;
    }

    public List<ActionVo> getActions() {
        return actions;
    }

    public void setActions(List<ActionVo> actions) {
        this.actions = actions;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
