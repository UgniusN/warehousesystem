package lt.warehousesystem.models;

import lt.warehousesystem.models.Warehouse.WarehouseItem;
import java.util.List;

public class UIFormatter {

    public void formLackingItemHeader() {
        System.out.println("|------------------------------------------------------|");
        System.out.println("|                   Lacking items                      |");
    }

    public void formExpiredOrSoonExpiredHeader() {
        System.out.println("|------------------------------------------------------|");
        System.out.println("|            Expired or soon expired items             |");
    }

    public void formTable(List<WarehouseItem> warehouseItemList) {
        System.out.println("|------------------------------------------------------|");
        System.out.printf("|%10s| %20s| %8s| %10s| %n","Title","Code", "Quantity","Date");
        System.out.println("|------------------------------------------------------|");
        for(WarehouseItem item: warehouseItemList) {
            System.out.printf("|%10s| %20s| %8d| %10s| %n",item.getTitle(),item.getCode(),item.getQuantity(),item.getDate());
            System.out.println("|----------|---------------------|---------|-----------|");
        }
    }

    public void formSelection() {
        System.out.println("Select action:");
        System.out.println("1. Check lacking item quantities");
        System.out.println("2. Check items, who have already expired, or will expire soon");
        System.out.println("3. Quit");
    }
}