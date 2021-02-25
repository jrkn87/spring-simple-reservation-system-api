package pl.jrkn87.reservationsystem;

public class ResponseEntityCustomMessage {
    public final static String UPDATE = "Record updated";
    public final static String DELETE = "Record deleted";
    public final static String NOT_DELETE = "Record has not been deleted";
    public final static String CREATE = "A new record has been created";
    public static final Object NOT_EXIST = "The record with the specified id does not exist";
    public static final Object EXIST = "Record found";
}
