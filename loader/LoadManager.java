package org.manipal.oops.proj.trade.loader;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.manipal.oops.proj.trade.model.DataSource;
import org.manipal.oops.proj.trade.model.ICICIDataSource;
import org.manipal.oops.proj.trade.model.TransactionEntry;
import org.manipal.oops.proj.trade.model.User;

public class LoadManager {
    
    protected static final User[] users = new User[] { new User("Pragya Kapoor", "pragya") };
    
    protected static final List<User> userList  = Arrays.asList(users );
    
    protected static final DataSource[] dataSourceArray= new DataSource[] { 
            new ICICIDataSource("ICICID", "ICICI Direct", "\t") 
            } ;
    
    protected static final List<DataSource> dataSourceList = Arrays.asList(dataSourceArray );
    
    private static final HashMap<String, User> userHashMap = new HashMap<>();
    private static final HashMap<String, DataSource> dataSourceHashMap = new HashMap<>();
    
    {  //Static block to initialize use and data source maps
        
        for (User user : users) {
            userHashMap.put( user.getUserId(), user );
        }
        
        for (DataSource dataSource : dataSourceArray) {
            dataSourceHashMap.put( dataSource.getId(), dataSource );
        }
        
    }
    
    public static List<User> getUserList(){
        return userList;
    }
    
    public static List<DataSource> getDataSourceList() {
        return dataSourceList;
    }

    public static void load( String userId, String dsId, Path dataFilePath ) {
        User user = userHashMap.get(userId);
        DataSource dataSource = dataSourceHashMap.get(dsId);
        
        LoadContext contect = new LoadContext(dataSource, user);
        
        TransactionDataLoader loader = new TransactionDataLoader(context, dataFilePath);
        
        try {
            
            ArrayList<TransactionEntry> transactionList = loader.load();
            for (TransactionEntry transactionEntry : transactionList) {
                System.out.println( transactionEntry  );
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
    
    public static void main(String[] args) {
        LoadManager lm = new LoadManager();
        
        Path filePath = Paths.get("E:/Data/Personal/accounts/DMAT/ICICI-New/FY_2022_2023/tb_pragya_2022_2023.xls");
        load( "pragya", "ICICID", filePath );
    }
}
