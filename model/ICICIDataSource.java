package org.manipal.oops.proj.trade.model;

import org.manipal.oops.proj.trade.loader.conf.DoNothingColumnHandler;
import org.manipal.oops.proj.trade.loader.conf.StringColumnHandler;
import org.manipal.oops.proj.trade.loader.conf.TransactionDateColumnHandler;

public class ICICIDataSource extends DataSource {

    public ICICIDataSource(String id, String name, String recordSplittingPattern) {
        super(id, name, recordSplittingPattern);
    }

    @Override
    protected void setColumnHandlers() {
        int columnIndex = 0;
        this.columnHandlers.add( new TransactionDateColumnHandler("tradeDate", columnIndex++, "Trade Date", "dd-MMM-yyyy") ) ;

        this.columnHandlers.add( new StringColumnHandler("scriptCode", columnIndex++, "Script Code") ) ;
        
        this.columnHandlers.add( new DoNothingColumnHandler( columnIndex++, "Action") ) ;
        this.columnHandlers.add( new DoNothingColumnHandler( columnIndex++, "Qty") ) ;
        this.columnHandlers.add( new DoNothingColumnHandler( columnIndex++, "Price") ) ;
        this.columnHandlers.add( new DoNothingColumnHandler( columnIndex++, "Trade Value") ) ;
        
        this.columnHandlers.add( new DoNothingColumnHandler( columnIndex++, "Order Ref.") ) ;
        this.columnHandlers.add( new DoNothingColumnHandler( columnIndex++, "Settlement") ) ;
        this.columnHandlers.add( new DoNothingColumnHandler( columnIndex++, "Segment") ) ;
        this.columnHandlers.add( new DoNothingColumnHandler( columnIndex++, "DP Id - Client DP Id") ) ;
        
        this.columnHandlers.add( new DoNothingColumnHandler( columnIndex++, "Exchange") ) ;
        this.columnHandlers.add( new DoNothingColumnHandler( columnIndex++, "STT") ) ;
        this.columnHandlers.add( new DoNothingColumnHandler( columnIndex++, "Transaction and SEBI Turnover charges") ) ;
        this.columnHandlers.add( new DoNothingColumnHandler( columnIndex++, "Stamp Duty") ) ;
        
        this.columnHandlers.add( new DoNothingColumnHandler( columnIndex++, "Brokerage + Service Tax") ) ;
        this.columnHandlers.add( new DoNothingColumnHandler( columnIndex++, "Brokerage incl. taxes") ) ;  
        
    }

}
