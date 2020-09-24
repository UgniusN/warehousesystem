package lt.warehousesystem.models.Warehouse;

import lt.warehousesystem.services.WarehouseService;
import lt.warehousesystem.services.WarehouseServiceImpl;
import lt.warehousesystem.services.WarehouseStorageService;
import lt.warehousesystem.services.WarehouseStorageServiceImpl;
import java.util.List;

public class Warehouse {

    private WarehouseService warehouseService = new WarehouseServiceImpl();
    private WarehouseStorageService warehouseStorageService = new WarehouseStorageServiceImpl();

    public List<WarehouseItem> getLackingItems(int atleastAmount) {
        return warehouseService.filterRequiredQuantity(atleastAmount,warehouseStorageService.getAllItemsFromWarehouse());
    }

    public List<WarehouseItem> getFilteredItems() {
        return warehouseStorageService.addDuplicates();
    }

    public List<WarehouseItem> getExpiredOrSoonExpiredItems(String date) {
        return warehouseStorageService.getExpiredOrSoonExpiredItems(date,2);
    }
}