package org.manipal.oops.proj.trade.loader;

import org.manipal.oops.proj.trade.model.DataSource;
import org.manipal.oops.proj.trade.model.User;

public class LoadContext {
    
    protected DataSource ds ;
    
    protected User user ;

    public LoadContext(DataSource ds, User user) {
        super();
        this.ds = ds;
        this.user = user;
    }

    public DataSource getDataSource() {
        return ds;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LoadContext [ds=");
        builder.append(ds.getId());
        builder.append(", user=");
        builder.append(user.getUserId());
        builder.append("]");
        return builder.toString();
    }
    
    
}
