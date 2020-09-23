package lt.warehousesystem.services;

import lt.warehousesystem.models.Warehouse.WarehouseItem;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public interface WarehouseStorageService {

    List<WarehouseItem> addDuplicates();

    public void sortItemsByTitle(List<WarehouseItem> updatedList);

    public List<WarehouseItem> getAllItemsFromWarehouse();
}