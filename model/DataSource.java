package org.manipal.oops.proj.trade.model;

import java.util.ArrayList;

import org.manipal.oops.proj.trade.loader.conf.ColumnHandler;

public abstract class DataSource {
    
    protected String id ;
    
    protected String name ;
    
    protected String recordSplittingPattern ;
    
    protected ArrayList<ColumnHandler> columnHandlers ;
    protected int skipFirstLines ; //Number of lines to be skipped from the file

    public DataSource(String id, String name, String recordSplittingPattern) {
        super();
        this.id = id;
        this.name = name;
        this.columnHandlers = new ArrayList<>();
        this.recordSplittingPattern = recordSplittingPattern;
        this.initialize();
    }

    private void initialize() {
        this.setColumnHandlers();
        this.setNumOfLinesToBeSkipped();
    }

    protected void setNumOfLinesToBeSkipped() {
        this.skipFirstLines = 1;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    protected abstract void setColumnHandlers();

    public ArrayList<ColumnHandler> getColumnHandlers() {
        return columnHandlers;
    }

    public int getSkipFirstLines() {
        return skipFirstLines;
    }

    public String getRecordSplittingPattern() {
        return recordSplittingPattern;
    }

    @Override
    public String toString() {
        return String.format("DateSource [id=%s, name=%s]", id, name);
    }
    
}
