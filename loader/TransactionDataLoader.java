package org.manipal.oops.proj.trade.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.manipal.oops.proj.trade.loader.conf.ColumnHandler;
import org.manipal.oops.proj.trade.model.DataSource;
import org.manipal.oops.proj.trade.model.TransactionEntry;

public class TransactionDataLoader {
    
    protected LoadContext context ;
    
    protected Path filePath ;
    
    public TransactionDataLoader(LoadContext context, Path filePath) {
        super();
        this.context = context;
        this.filePath = filePath;
    }

    public ArrayList<TransactionEntry> load() throws IOException, DataLoadException, DataProcessingException {
        
        DataSource ds = this.context.getDataSource();
        int skipFirstLines = ds.getSkipFirstLines();
        String recordSplittingPattern = ds.getRecordSplittingPattern();
        
        ArrayList<ColumnHandler> columnHandlers = ds.getColumnHandlers();
        int columnHandlerCount = columnHandlers.size();
        
        ArrayList<TransactionEntry> transactionList = new ArrayList<>();
        
        try( BufferedReader br = Files.newBufferedReader( this.filePath) ){
            
            int skippedLineCount = 0;
            String line = "" ;
            
            while( skippedLineCount < skipFirstLines && line != null ) {
                line = br.readLine();
                skippedLineCount++;
            }
            
            line = br.readLine();
            
            while( line != null ) {
                
                TransactionEntry tr = new TransactionEntry( context );
                String[] columnData = line.split(recordSplittingPattern);
                
                if( columnHandlerCount < columnData.length ) {
                    throw new DataLoadException( "ColumnHandler count should not be less than data column count " + line );
                }
                
                for (int i = 0; i < columnData.length; i++) {
                    ColumnHandler handler = columnHandlers.get(i);
                    handler.handle( tr, columnData[i]);
                }
                
                transactionList.add(tr);
                
                line = br.readLine();
            }
        }
        return transactionList;
    }
}
