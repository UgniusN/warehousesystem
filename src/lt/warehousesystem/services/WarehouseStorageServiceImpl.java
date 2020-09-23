package lt.warehousesystem.services;

import lt.warehousesystem.models.Warehouse.WarehouseItem;
import lt.warehousesystem.models.Warehouse.WarehouseStorage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WarehouseStorageServiceImpl implements WarehouseStorageService {

    private WarehouseStorage warehouseStorage = new WarehouseStorage();

    public WarehouseStorageServiceImpl() throws IOException {
        warehouseStorage.loadStorage();
        sortItemsByTitle(addDuplicates());
    }

    public List<WarehouseItem> addDuplicates() {
        warehouseStorage.loadStorage();
        List<WarehouseItem> originalList = warehouseStorage.getAllItemsFromStorage();
        for(int i = 0; i< originalList.size(); i++) {
            for(int j = i+1; j<originalList.size(); j++) {
                if (originalList.get(i).equals(originalList.get(j))) {
                    originalList.get(j).setQuantity(originalList.get(i).getQuantity() + originalList.get(j).getQuantity());
                    originalList.remove(i);
                }
            }
        }
        List<WarehouseItem> sc = originalList.stream().sorted(Comparator.comparing(WarehouseItem::getTitle)).collect(Collectors.toList());
        return sc;
//                Collectors.summingInt((WarehouseItem::getQuantity)));
    }

    public void sortItemsByTitle(List<WarehouseItem> updatedList) {
        List<WarehouseItem> sortedItemList = updatedList.stream().sorted(Comparator.comparing(WarehouseItem::getTitle)).collect(Collectors.toList());
        warehouseStorage.updateStorage(sortedItemList);
    }

    public List<WarehouseItem> getAllItemsFromWarehouse() {
        return warehouseStorage.getAllItemsFromStorage();
    }
}