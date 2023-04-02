package model.goods.digitalgoods;

public enum CpuModel {
    SINGLECORE("Single-core CPU"),DUALCORECPU("Dual-core CPU"),QUADCORECPU("Quad-core CPU"),HEXACOREPROCESSORS("Hexa Core processors"),OCTACOREPROCESSORS("Octa-core processors"),DECACOREPROCESSORS("Deca-core processor");
private String model;

    public String getModel() {
        return model;
    }

    private CpuModel(String model) {
        this.model = model;
    }
}
