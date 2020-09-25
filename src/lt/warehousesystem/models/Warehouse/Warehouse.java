package lt.warehousesystem.models.Warehouse;

import lt.warehousesystem.services.WarehouseService;
import lt.warehousesystem.services.WarehouseServiceImpl;
import lt.warehousesystem.services.WarehouseStorageService;
import lt.warehousesystem.services.WarehouseStorageServiceImpl;

import java.text.ParseException;
import java.util.List;

public class Warehouse {

    private final WarehouseService warehouseService = new WarehouseServiceImpl();
    private final WarehouseStorageService warehouseStorageService = new WarehouseStorageServiceImpl();

    public List<WarehouseItem> getLackingItems(int atleastAmount) {
        return warehouseService.filterRequiredQuantity(atleastAmount,warehouseStorageService.getAllItemsFromWarehouse());
    }

    public List<WarehouseItem> getExpiredOrSoonExpiredItems(String date, int amountOfDays) throws ParseException {
        return warehouseStorageService.getExpiredOrSoonExpiredItems(date,amountOfDays);
    }
}