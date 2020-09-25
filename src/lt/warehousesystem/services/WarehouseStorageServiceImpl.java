package lt.warehousesystem.services;

import lt.warehousesystem.models.Warehouse.WarehouseItem;
import lt.warehousesystem.models.Warehouse.WarehouseStorage;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

public class WarehouseStorageServiceImpl implements WarehouseStorageService {

    private WarehouseStorage warehouseStorage = new WarehouseStorage();
    private DateService dateService = new DateServiceImpl();

    public WarehouseStorageServiceImpl() {
        warehouseStorage.loadStorage();
        sortItemsByTitle(addDuplicates());
    }

    public List<WarehouseItem> addDuplicates() {
        List<WarehouseItem> originalList = warehouseStorage.getAllItemsFromStorage();
        for(int i = 0; i< originalList.size(); i++) {
            for(int j = i+1; j<originalList.size(); j++) {
                if (originalList.get(i).equals(originalList.get(j))) {
                    originalList.get(j).setQuantity(originalList.get(i).getQuantity() + originalList.get(j).getQuantity());
                    originalList.remove(i);
                }
            }
        }
        return originalList.stream().sorted(Comparator.comparing(WarehouseItem::getTitle)).collect(Collectors.toList());
    }

    public void sortItemsByTitle(List<WarehouseItem> updatedList) {
        List<WarehouseItem> sortedItemList = updatedList.stream().sorted(Comparator.comparing(WarehouseItem::getTitle)).collect(Collectors.toList());
        warehouseStorage.updateStorage(sortedItemList);
    }

    public List<WarehouseItem> getAllItemsFromWarehouse() {
        return warehouseStorage.getAllItemsFromStorage();
    }

    public List<WarehouseItem> getExpiredOrSoonExpiredItems(String dateUntilInput, int amountOfDaysUntilExpiration) throws ParseException {
        List<WarehouseItem> expiredOrSoonExpired = new ArrayList<>();
            for (WarehouseItem item : warehouseStorage.getAllItemsFromStorage()) {
                if (dateService.getFormatedDate(item.getDate()).before(dateService.addToDate(amountOfDaysUntilExpiration + 1, dateService.getFormatedDate(dateUntilInput)))) {
                    expiredOrSoonExpired.add(item);
                }
            }
        return expiredOrSoonExpired;
    }
}