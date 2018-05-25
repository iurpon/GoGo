package ru.firstproject;

public class AuthorizedUser {
    private AuthorizedUser() {
    }

    private static int id;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        AuthorizedUser.id = id;
    }
}
