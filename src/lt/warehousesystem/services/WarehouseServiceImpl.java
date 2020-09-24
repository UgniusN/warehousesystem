package lt.warehousesystem.services;

import lt.warehousesystem.models.Warehouse.WarehouseItem;
import java.util.List;
import java.util.stream.Collectors;

public class WarehouseServiceImpl implements WarehouseService{

    public List<WarehouseItem> filterRequiredQuantity(int quantity, List<WarehouseItem> itemList) {
        List<WarehouseItem> filteredItems = itemList.stream().filter(item -> item.getQuantity() < quantity).collect(Collectors.toList());
        return filteredItems;
    }
}