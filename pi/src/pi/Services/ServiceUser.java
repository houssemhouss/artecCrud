/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.Entities.Role;
import pi.Entities.User;
import pi.Utils.MyDB;

/**
 *
 * @author Mohamed
 */
public class ServiceUser implements IService<User> {

    Connection cnx;
    Statement stm;

    public ServiceUser() {
        cnx = MyDB.getInstance().getCnx();

    }

    @Override
    public void add(User t) {
        try {
            String qry = "INSERT INTO `user`( `username`, `password`, `role`) VALUES ('" + t.getUsername() + "','" + t.getPassword() + "','" + t.getRole() + "')";
            stm = cnx.createStatement();

            stm.executeUpdate(qry);
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }

    }

    @Override
    public List<User> affciher() {
        List<User> users = new ArrayList();
        try {
            String qry = "SELECT * FROM `user`";
            stm = cnx.createStatement();

            ResultSet rs = stm.executeQuery(qry);

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id_user"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(Role.valueOf(rs.getString("role")));

                users.add(user);
            }
            return users;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return users;

    }

    @Override
    public Boolean modifier(User user) {
        try {
            String qry = "UPDATE user SET id_user='" + user.getId() + "', username='" + user.getUsername() + "', password='" + user.getPassword() + "', role='" + user.getRole() + "' WHERE id_user='" + user.getId() + "'";
            stm = cnx.createStatement();
            stm.executeUpdate(qry);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Boolean supprimer(User user) {

        try {
            String qry = "DELETE FROM user WHERE `id_user`='" + user.getId() + "'";
            stm = cnx.createStatement();
            stm.executeUpdate(qry);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
