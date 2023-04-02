package model.goods.digitalgoods;

public enum FlashMemoryType {
    USBA("USB-A"),USBB("USB-B"),MICROUSB("Micro USB"),MINIUSB ("Mini USB"),USBC("USB-C");
    private String type;

    public String getType() {
        return type;
    }

    private FlashMemoryType(String type){
        this.type=type;
    }
}
