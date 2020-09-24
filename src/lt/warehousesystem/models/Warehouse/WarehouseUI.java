package lt.warehousesystem.models.Warehouse;

import lt.warehousesystem.models.UIFormatter;

import java.util.Scanner;
import java.util.logging.Logger;

public class WarehouseUI {

    private Warehouse warehouse;
    private final Scanner scanner = new Scanner(System.in);
    private UIFormatter uiFormatter = new UIFormatter();
    Logger logger = Logger.getLogger(WarehouseUI.class.getName());

    public WarehouseUI(Warehouse warehouse) {
        this.warehouse = warehouse;
        showUI();
    }

    void showUI() {
        int action;
        int min;
        String date;
        while(true) {
            action = 0;
            System.out.println("Select action:" +
                    "\n1. Check lacking item quantities" +
                    "\n2. Check items, who have already expired, or will expire soon");
            try {
                action = scanner.nextInt();
            }
            catch (java.util.InputMismatchException e) {
                System.out.println("**** ERROR: WRONG INPUT FORMAT. INPUT INTEGERS IN ORDER TO SELECT ACTION");
                scanner.nextLine();
            }
            finally {
                switch (action) {
                    case 1:
                        min = 0;
                        System.out.println("Please enter the minimum item quantity");
                        try {
                        min = scanner.nextInt();
                        }
                        catch (java.util.InputMismatchException e) {
                            System.out.println("**** ERROR: WRONG INPUT FORMAT. INPUT INTEGERS IN ORDER TO RETRIEVE DATA");
                        }
                        finally {
                            uiFormatter.formLackingItemHeader();
                            uiFormatter.formLackingItemsTable(warehouse.getLackingItems(min));
                        }
                        break;
                    case 2:
                        System.out.println("Please enter the date o item quantity");
                        scanner.nextLine();
                        date = scanner.nextLine();
                        for(WarehouseItem item : warehouse.getExpiredOrSoonExpiredItems(date)) {
                            System.out.println(item);
                        }
                        break;
                    case 0:
                        break;
                }
            }
        }
    }
}