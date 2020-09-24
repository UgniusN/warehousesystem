package lt.warehousesystem.services;

import lt.warehousesystem.models.Warehouse.WarehouseItem;
import java.util.List;

public interface WarehouseService {

    List<WarehouseItem> filterRequiredQuantity(int quantity, List<WarehouseItem> itemList);

}