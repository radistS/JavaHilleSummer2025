package com.hilllel.cw_08.enumer;

public class UserStatusRun {
    public static void main(String[] args) {
        User u = new User("test@email.com");

        System.out.println(u);

        u.setStatus(UserStatus.ACTIVE);

        System.out.println(u);
//
//        System.out.println(u.isActive());
//
//        u.setActive(isActive(u));
//        System.out.println(isActive(u));
//
//        setActiveStatus(u);
//
//        System.out.println(u);


        try{
            u.setStatus(UserStatus.valueOf("ALEX"));}
        catch (IllegalArgumentException exception){
            u.setStatus(UserStatus.DEFAULT);
        }
        System.out.println(u);

    }

    public static void setActiveStatus(User user) {
        if (UserStatus.ACTIVE.equals(user.getStatus())) {
            user.setActive(true);
        }
        System.out.println(user.isActive());
    }

    public static boolean isActive(User user) {
        return UserStatus.ACTIVE.equals(user.getStatus()); // null -> isActive == false
    }
}
