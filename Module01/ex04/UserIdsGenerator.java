package ex04;

public class UserIdsGenerator {

    private static volatile UserIdsGenerator instance = null;
    private int id;

    private UserIdsGenerator() {
        id = 0;
    }

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            synchronized (UserIdsGenerator.class) {
                if (instance == null) {
                    instance = new UserIdsGenerator();
                }
            }
        }
        return instance;
    }

    public int generateId() {
        return (++id);
    }
}
