public class RecommendProductDto {

    private Long itemId;
    private String pictureUrl;

    public RecommendProductDto(){}

    public RecommendProductDto( Long itemId, String pictureUrl) {
        this.itemId = itemId;
        this.pictureUrl = pictureUrl;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
