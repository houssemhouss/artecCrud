
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

import pi.Entities.User;
import pi.Entities.Role;
import pi.Services.ServiceUser;

/**
 *
 * @author Mohamed
 */
public class pi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //User u =new User("houssem", "hosni",Role.artiste);
        User u1 = new User("yassmine", "2563", Role.client);
        User u2 = new User("houcem", "12456", Role.admin);

        ServiceUser su = new ServiceUser();
        //sp.add(u);
        su.add(u1);
        //su.add(u2);
        //System.out.println(su.affciher());

        User user = new User();
        user.setId(29);
        user.setUsername("salma");
        user.setPassword("96@aaa");
        user.setRole(Role.admin);

        Boolean result = su.modifier(user);
        if (result) {
            System.out.println("User modified successfully.");
        } else {
            System.out.println("Failed to modify user.");
        }

        User userToDelete = new User();
        userToDelete.setId(5);
        boolean success = su.supprimer(userToDelete);
        if (success) {
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("Failed to delete user.");
        }
    }
}
