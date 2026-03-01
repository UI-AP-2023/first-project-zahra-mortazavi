package model.goods.vehicles;

public enum BikeType {
    MOUNNTAINBIKE("mountain bike"),CITYBIKE("city bike"),HYBRIDEBIKE("hybride bike"),ROADBIKE("road bike");
   private String type;

    public String getType() {
        return type;
    }

    private BikeType(String type) {
        this.type = type;
    }
}
