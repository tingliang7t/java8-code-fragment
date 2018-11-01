package vo;

import java.util.List;

public class PositionConfigVo {

    private long id;
    private String name;
    private Integer groupId;
    private List<ConfigVo> configs;

    public PositionConfigVo() {}

    public PositionConfigVo(long id, String name, Integer groupId, List<ConfigVo> configs) {
        this.id = id;
        this.name = name;
        this.groupId = groupId;
        this.configs = configs;
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

    public List<ConfigVo> getConfigs() {
        return configs;
    }

    public void setConfigs(List<ConfigVo> configs) {
        this.configs = configs;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}


