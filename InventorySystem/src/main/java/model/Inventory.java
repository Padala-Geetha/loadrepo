package model;

public class Inventory {

    private String partNumber;
    private String serialNumber;
    private Integer inventoryQty;
    private Integer availableQty;
    private Integer allocatedQty;

    public Inventory(String partNumber, String serialNumber, Integer inventoryQty, Integer availableQty, Integer allocatedQty) {
        this.partNumber = partNumber;
        this.serialNumber = serialNumber;
        this.inventoryQty = inventoryQty;
        this.availableQty = availableQty;
        this.allocatedQty = allocatedQty;
    }

    public Inventory() {
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getInventoryQty() {
        return inventoryQty;
    }

    public void setInventoryQty(Integer inventoryQty) {
        this.inventoryQty = inventoryQty;
    }

    public Integer getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(Integer availableQty) {
        this.availableQty = availableQty;
    }

    public Integer getAllocatedQty() {
        return allocatedQty;
    }

    public void setAllocatedQty(Integer allocatedQty) {
        this.allocatedQty = allocatedQty;
    }
}
