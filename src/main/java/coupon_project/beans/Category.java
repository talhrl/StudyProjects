package coupon_project.beans;

public enum Category {

    Food,
    Electricity,
    Restaurant,
    Vacation,
    Fashion;

    public final int categoryID = ordinal() + 1;
}