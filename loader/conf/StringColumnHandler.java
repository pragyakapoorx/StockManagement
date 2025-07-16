package org.manipal.oops.proj.trade.loader.conf;

import java.lang.reflect.Field;

import org.manipal.oops.proj.trade.loader.DataProcessingException;
import org.manipal.oops.proj.trade.model.TransactionEntry;

public class StringColumnHandler extends ColumnHandler {

    public StringColumnHandler(String targetField, int columnIndex, String displayName) {
        super(targetField, columnIndex, displayName);
    }

    @Override
    protected void setValue(TransactionEntry entry, String val) throws DataProcessingException {
        try {
            
            Field namedField = this.getNamedField(entry);
            namedField.set(entry, val );
            
        } catch (NoSuchFieldException ex) {
            handleNoSuchMethodException(ex);
        } catch (SecurityException ex) {
            handleSecurityException(ex);
        } catch (IllegalArgumentException ex) {
            handleIllegalArgumentException(ex);
        } catch (IllegalAccessException ex) {
            handleIllegalArgumentException(ex);
        }

    }

}
