package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User findUser = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                findUser = user;
                break;
            }
        }
        if (findUser == null) {
            throw new UserNotFoundException("User not found");
        }
        return findUser;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean validate = true;
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User isn't valid");
        }
        return validate;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


