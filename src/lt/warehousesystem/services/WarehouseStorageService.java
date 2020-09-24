package lt.warehousesystem.services;

import lt.warehousesystem.models.Warehouse.WarehouseItem;
import java.util.List;

public interface WarehouseStorageService {

    List<WarehouseItem> addDuplicates();

    void sortItemsByTitle(List<WarehouseItem> updatedList);

    List<WarehouseItem> getAllItemsFromWarehouse();

    List<WarehouseItem> getExpiredOrSoonExpiredItems(String dateUntilInput, int amountOfDaysUntilExpiration);
}