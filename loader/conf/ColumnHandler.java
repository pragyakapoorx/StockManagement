package org.manipal.oops.proj.trade.loader.conf;

import java.lang.reflect.Field;

import org.manipal.oops.proj.trade.loader.DataProcessingException;
import org.manipal.oops.proj.trade.model.TransactionEntry;
import org.manipal.oops.proj.trade.util.StringUtil;

public abstract class ColumnHandler {
    
    protected String targetField ;
    
    protected int columnIndex ;
    
    protected String displayName ;

    public ColumnHandler(String targetField, int columnIndex, String displayName) {
        super();
        this.targetField = targetField ;
        this.columnIndex = columnIndex;
        this.displayName = displayName;
    }
    
    public void handle(TransactionEntry entry, String val ) throws DataProcessingException {
        String sanitizedValue = sanitize( val );
        setValue( entry, sanitizedValue );
    }

    protected abstract void setValue(TransactionEntry entry, String val) throws DataProcessingException;
    
    protected Field getNamedField( TransactionEntry entry ) throws NoSuchFieldException, SecurityException {
        Field namedField = entry.getClass().getDeclaredField( this.targetField );
        namedField.setAccessible(true);
        //namedField.set(entry, namedField);
        return namedField;
    }

    protected String sanitize(String val) {
        if( StringUtil.isEmpty(val)) {
            return null ;
        } else {
            return val.trim();
        }
    }
    
    
    protected void handleIllegalArgumentException(IllegalAccessException ex) throws DataProcessingException {
        ex.printStackTrace();
        throw new DataProcessingException(ex);
    }

    protected void handleIllegalArgumentException(IllegalArgumentException ex) throws DataProcessingException {
        ex.printStackTrace();
        throw new DataProcessingException(ex);
    }

    protected void handleSecurityException(SecurityException ex) throws DataProcessingException {
        ex.printStackTrace();
        throw new DataProcessingException(ex);
    }

    protected void handleNoSuchMethodException(NoSuchFieldException ex) throws DataProcessingException {
        ex.printStackTrace();
        throw new DataProcessingException("Invalidate field " + targetField , ex);
    }
}
