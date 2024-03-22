package es.santander.branchlocator;

class BLFilterItem {
    private final BLFilterType BLFilterType;
    private final BLFilter filter;
    private String filterTitle = "";
    private int titleId = -1;

    public BLFilterItem(BLFilter filter2, BLFilterType BLFilterType2, String filterTitle2, int titleId2) {
        this.filter = filter2;
        this.BLFilterType = BLFilterType2;
        this.filterTitle = filterTitle2;
        this.titleId = titleId2;
    }

    public BLFilterItem(BLFilter filter2, BLFilterType BLFilterType2) {
        this.filter = filter2;
        this.BLFilterType = BLFilterType2;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BLFilterItem)) {
            return false;
        }
        BLFilterItem that = (BLFilterItem) o;
        if (getTitleId() != that.getTitleId() || !getFilter().equals(that.getFilter())) {
            return false;
        }
        return true;
    }

    public BLFilter getFilter() {
        return this.filter;
    }

    public BLFilterType getBLFilterType() {
        return this.BLFilterType;
    }

    public String getFilterTitle() {
        return this.filterTitle;
    }

    public int getBLFilterCode() {
        BLFilter bLFilter = this.filter;
        if (bLFilter != null) {
            return bLFilter.getCode();
        }
        return -1;
    }

    public int getTitleId() {
        return this.titleId;
    }

    public String toString() {
        return "FilterItem{filter=" + this.filter + ", filterType=" + this.BLFilterType + ", filtetTitle='" + this.filterTitle + '\'' + '}';
    }
}
