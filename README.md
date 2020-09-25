# Warehouse System V1

# #Features

* Check lacking item quantities
* Check items, who have already expired, or will expire soon

![DEMO](/demo.png)

About the system:
* System requires to have a correct .csv file in the same directory as the warehousesystem.jar
* You can set the .csv file title in the program.properties file in the parameter "storage_file"
* The program will require to restart if the program does not have the required files


How to start the program:
* Run the warehouseapplication.jar file in the "runnable" folder with a command "java -jar warehouseapplication.jar"

* How to use the program: 

You can select the option inputing an integer from 1-3.

* If you select to "Check lacking item quantities", then the program will require you to input an integer of the max item quantity.

* If you select an option "Check items, who have already expired, or will expire soon", then you will need to input an expiry date in format (yyyy-mm-dd).
After that, you will need to input an integer of additional days to the expiry date in order to show the soon expired items. The program then will print the items that match the date plus the additional dates.
