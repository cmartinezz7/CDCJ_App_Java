package es.santander.branchlocator;

class BLFilter {
    private transient int code;
    private transient int color;
    private String filter_type;
    private transient int image;
    private transient boolean isPopular;
    private transient boolean isSelected;
    private String name;
    private String request_name;

    public BLFilter() {
        this.code = -1;
        this.isPopular = false;
    }

    public BLFilter(String name2) {
        this(name2, (String) null, (String) null, -1, false, -1, false);
    }

    public BLFilter(String name2, String request_name2, String filter_type2, int image2, boolean isSelected2, int code2, boolean isPopular2) {
        this.code = -1;
        this.isPopular = false;
        this.name = name2;
        this.request_name = request_name2;
        this.filter_type = filter_type2;
        this.image = image2;
        this.isSelected = isSelected2;
        this.code = code2;
        this.isPopular = isPopular2;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BLFilter)) {
            return false;
        }
        if (getCode() == ((BLFilter) o).getCode()) {
            return true;
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getRequest_name() {
        return this.request_name;
    }

    public void setRequest_name(String request_name2) {
        this.request_name = request_name2;
    }

    public int getImage() {
        return this.image;
    }

    public void setImage(int image2) {
        this.image = image2;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }

    public String getFilter_type() {
        return this.filter_type;
    }

    public void setFilter_type(String filter_type2) {
        this.filter_type = filter_type2;
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int color2) {
        this.color = color2;
    }

    public int getCode() {
        return this.code;
    }

    public boolean isPopular() {
        return this.isPopular;
    }
}
