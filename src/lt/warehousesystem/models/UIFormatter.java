package lt.warehousesystem.models;

import lt.warehousesystem.models.Warehouse.WarehouseItem;

import java.util.List;

public class UIFormatter {

    public void formLackingItemHeader() {
        System.out.println("|------------------------------------------------------|");
        System.out.println("|                   Lacking items                      |");
        System.out.println("|------------------------------------------------------|");
        System.out.printf("|%10s| %20s| %8s| %10s| %n","Title","Code", "Quantity","Date");
        System.out.println("|------------------------------------------------------|");
    }

    public void formLackingItemsTable(List<WarehouseItem> warehouseItemList) {
        for(WarehouseItem item: warehouseItemList) {
            System.out.printf("|%10s| %20s| %8d| %10s| %n",item.getTitle(),item.getCode(),item.getQuantity(),item.getDate());
            System.out.println("|----------|---------------------|---------|-----------|");
        }
    }
}
