package Utilities;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.io.File;

public class ExcelUtils {

    private static Fillo fillo;
    private static Connection connection;
    public static Recordset recordset;
    private static String filename = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"outputData.xlsx";


    private static void openExcelConnection() throws FilloException {
        fillo=new Fillo();
        connection=fillo.getConnection(filename);

    }

    public static void openExcelSheet() throws FilloException {
        openExcelConnection();
    }

    public static String SelectCell (String Query, String Field) throws FilloException {

        connection = fillo.getConnection(filename);
        recordset = connection.executeQuery(Query);
        recordset.moveNext();
        String CellValue = recordset.getField(Field);
        /*int count = 0;
        while (recordset.next()) {
            System.out.println(recordset.getField("Username"));
            count++;
        }
        System.out.println(count);*/
        System.out.println(CellValue);
        return CellValue;
    }

    public static void selectQuery(String strQuery) throws FilloException {
        //String column, String table, String searchValue
        //openExcelConnection();
        recordset = connection.executeQuery(strQuery);
        recordset.moveNext();
    }

    public static void insertQuery(String strQuery) throws FilloException {
        //openExcelConnection();
        connection.executeUpdate(strQuery);
        //recordset=connection.executeQuery(selectStrQuery);
        /*        for (int i=0; i<7; i++)
        {
            recordset.next();
        }
        System.out.println(recordset.getField(0).value());*/
    }

    public static void updateQuery(String strQuery) throws FilloException {
        //openExcelConnection();
        connection.executeUpdate(strQuery);
        //recordset=connection.executeQuery(selectStrQuery);
/*        for (int i=0; i<7; i++)
        {
            recordset.next();
        }
        System.out.println(recordset.getField(0).value());*/
    }

    public static void deleteTable(String tableName) throws FilloException {
        //openExcelConnection();
        connection.deleteTable(tableName);
    }

    public static void deleteRow(String strQuery) throws FilloException {
        //openExcelConnection();
        connection.executeUpdate(strQuery);
    }

    public static void createTable(String tableName, String[] columnNames) throws FilloException {
        //openExcelConnection();
        connection.createTable(tableName, columnNames);
    }

    public static void CloseExcelSheet()
    {
        recordset.close();
        connection.close();
    }
}
