package model.goods.stationery;

public enum PaperType {
    FIBERGLASS("Fiber glass"),PLAINPAPAER("Plain paper"),OILPAPER("oil paper"),STRAWPAPER("strow paper");
    private String type;

    public String getType() {
        return type;
    }

    private PaperType(String type) {
        this.type = type;
    }
}
