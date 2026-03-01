package model.goods;

public enum GoodsCategoryModel {
    DIGITALGOODS("digital goods"),STATIONERY("stationery"),VEHICLES("vehicles"),EDIBLE("edible");
    private String Category;

   public String getCategory() {
        return Category;
    }

    private GoodsCategoryModel(String category) {
        Category = category;
    }
}
