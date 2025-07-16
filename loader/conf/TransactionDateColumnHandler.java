package org.manipal.oops.proj.trade.loader.conf;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.manipal.oops.proj.trade.loader.DataProcessingException;
import org.manipal.oops.proj.trade.model.TransactionEntry;

public class TransactionDateColumnHandler extends ColumnHandler {

    protected String datePattern ;

    public TransactionDateColumnHandler(String targetField, int columnIndex, String displayName, String datePattern) {
        super(targetField, columnIndex, displayName);
        this.datePattern  = datePattern;
    }

    @Override
    protected void setValue(TransactionEntry entry, String val) throws DataProcessingException {
        SimpleDateFormat fmt = new SimpleDateFormat(datePattern) ;
        
        try {
            
            Date transactionDate = fmt.parse(val);
            Field namedField = this.getNamedField(entry);
            namedField.set(entry, transactionDate);
            
        } catch (ParseException ex) {
            ex.printStackTrace();
            throw new DataProcessingException("Invalidate date " + val  + " format should be " + this.datePattern , ex);
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
