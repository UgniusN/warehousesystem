package lt.warehousesystem;

import lt.warehousesystem.models.Warehouse.Warehouse;
import lt.warehousesystem.models.Warehouse.WarehouseUI;

public class Main {

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        WarehouseUI warehouseUI = new WarehouseUI(warehouse);
    }
}