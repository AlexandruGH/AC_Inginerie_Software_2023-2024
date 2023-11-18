package database;

public class DatabaseConnectionFactory {
    private static final String SCHEMA = "library";
    private static final String TEST_SCHEMA = "test_library";

    public static JDBConnectionWrapper getConnectionWrapper(boolean test){
        if(test){
            return new JDBConnectionWrapper(TEST_SCHEMA);
        }else{
            return new JDBConnectionWrapper(SCHEMA);
        }
    }
}
