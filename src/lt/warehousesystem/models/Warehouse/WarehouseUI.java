package lt.warehousesystem.models.Warehouse;

import lt.warehousesystem.models.Errors;
import lt.warehousesystem.models.UIFormatter;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class WarehouseUI {

    private final Warehouse warehouse;
    private final Scanner scanner = new Scanner(System.in);
    private final UIFormatter uiFormatter = new UIFormatter();

    public WarehouseUI(Warehouse warehouse) {
        this.warehouse = warehouse;
        showUI();
    }

    void showUI() {
        int action;
        int min;
        String date;
        boolean active = true;
        int expirationAdditionalDays;
        System.out.println("Welcome to Warehouse system V1");
        while(active) {
            uiFormatter.formSelection();
            try {
                action = scanner.nextInt();
                switch (action) {
                    case 1:
                        min = 4;
                        System.out.println("Please enter the maximum item quantity");
                        try {
                            min = scanner.nextInt();
                            uiFormatter.formLackingItemHeader();
                            uiFormatter.formTable(warehouse.getLackingItems(min));
                        }
                        catch (java.util.InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println(Errors.WRONG_INPUT_FORMAT_INTEGER);
                        }
                        finally {
                            break;
                        }
                    case 2:
                        System.out.println("Please enter the date of expiration (Format: yyyy-mm-dd)");
                        try {
                            scanner.nextLine();
                            date = scanner.nextLine();
                            System.out.println("Please enter aditional expiry days");
                            try {
                                expirationAdditionalDays = scanner.nextInt();
                                List<WarehouseItem> expiredOrSoonExpiredItems = warehouse.getExpiredOrSoonExpiredItems(date, expirationAdditionalDays);
                                uiFormatter.formExpiredOrSoonExpiredHeader();
                                uiFormatter.formTable(expiredOrSoonExpiredItems);
                            } catch (ParseException e) {
                                scanner.nextLine();
                                System.out.println(Errors.WRONG_DATE_FORMAT);
                            }

                        } catch (java.util.InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println(Errors.WRONG_INPUT_FORMAT_DAYCOUNT);
                        }
                        break;
                    case 0:
                        break;
                    case 3:
                        active=false;
                        break;
                    default:
                        System.out.println(Errors.WRONG_SELECTION);
                        break;
                }
            }
            catch (java.util.InputMismatchException e) {
                scanner.nextLine();
                System.out.println(Errors.WRONG_INPUT_FORMAT_INTEGER);
            }
        }
    }
}