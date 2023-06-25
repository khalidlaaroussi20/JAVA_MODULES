package ex04;


public class UserArrayList implements UserList {

    private final int DEFAULT_SIZE = 10;
    private int _size;
    private User[] users;

    UserArrayList() {
        users = new User[DEFAULT_SIZE];
        _size = 0;
    }
    public void addUser(User user) {
        resizUsersArray();
        users[_size++] = user;
    }

    public User getUserById(int id) throws UserNotFoundException {
        for (int i = 0; i < _size; i++) {
            if (users[i].getIdentifier() == id) {
                return users[i];
            }
        }
        throw  new UserNotFoundException();
    }

    public User getUserByIndex(int index) {
        if (index < 0 || index >= _size)
            throw  new ArrayIndexOutOfBoundsException();
        return users[index];
    }

    public int count() {
        return _size;
    }


    private void resizUsersArray() {
        if (_size == users.length) {
            int newSize = _size + _size / 2;
            User[] newArray = new User[newSize];

            // Copy elements from the original array to the new array
            System.arraycopy(users, 0, newArray, 0, Math.min(users.length, newSize));

            // Assign the new array to the attribute
            users = newArray;
        }
    }
}
