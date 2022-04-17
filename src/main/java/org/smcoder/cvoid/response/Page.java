package org.smcoder.cvoid.response;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable {

    private int pageNo;

    private int pageSize;

    private long total;
    private List rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public Page(long total, List rows) {
        super();
        this.total = total;
        this.rows = rows;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
