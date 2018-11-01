package dto;

public class AdDto {

    private String pictureUrl;
    private String inAppJumpUrl;
    private String outAppJumpUrl;
    private long number;

    public AdDto(){}

    public AdDto(String pictureUrl, String inAppJumpUrl, String outAppJumpUrl) {
        this.pictureUrl = pictureUrl;
        this.inAppJumpUrl = inAppJumpUrl;
        this.outAppJumpUrl = outAppJumpUrl;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getInAppJumpUrl() {
        return inAppJumpUrl;
    }

    public void setInAppJumpUrl(String inAppJumpUrl) {
        this.inAppJumpUrl = inAppJumpUrl;
    }

    public String getOutAppJumpUrl() {
        return outAppJumpUrl;
    }

    public void setOutAppJumpUrl(String outAppJumpUrl) {
        this.outAppJumpUrl = outAppJumpUrl;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
