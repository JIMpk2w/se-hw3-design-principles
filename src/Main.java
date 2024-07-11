/*
 * Name: Pakawat Panklang
 * Student ID: 6510450763
 */
public class Main {
    public static void main(String[] args) {
        User user = new User("Steve", "steven.q@gmail.com", 20);

        UserList userList = new UserList();
        userList.addUser(user);

        System.out.println("Name: " + userList.getUsers().get(0).getName() +
                "\nEmail: " + userList.getUsers().get(0).getEmail() +
                "\nAge: " + userList.getUsers().get(0).getAge() + "\n");



        User user2 = new User("da faet", "242q62@gmail.com", 20);
        userList.addUser(user2);
    }
}