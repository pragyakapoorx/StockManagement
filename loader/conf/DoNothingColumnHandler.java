package org.manipal.oops.proj.trade.loader.conf;

import org.manipal.oops.proj.trade.loader.DataProcessingException;
import org.manipal.oops.proj.trade.model.TransactionEntry;

public class DoNothingColumnHandler extends ColumnHandler {

    public DoNothingColumnHandler( int columnIndex, String displayName ) {
        super(null, columnIndex, displayName);
    }

    @Override
    protected void setValue(TransactionEntry entry, String val) throws DataProcessingException {
        //Do nothing
    }

}
