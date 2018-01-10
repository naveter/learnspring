package JavaEEWeb;

import JavaEEWeb.dbitems.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {

//    public static UserAccount findUser(Connection conn, //
//                                       String userName, String password) throws SQLException {
//
//        String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a " //
//                + " where a.User_Name = ? and a.password= ?";
//
//        PreparedStatement pstm = conn.prepareStatement(sql);
//        pstm.setString(1, userName);
//        pstm.setString(2, password);
//        ResultSet rs = pstm.executeQuery();
//
//        if (rs.next()) {
//            String gender = rs.getString("Gender");
//            UserAccount user = new UserAccount();
//            user.setUserName(userName);
//            user.setPassword(password);
//            user.setGender(gender);
//            return user;
//        }
//        return null;
//    }

    public static List<Category> queryCategories(Connection conn) throws SQLException {
        String sql = "Select c.id, c.name from Category c ";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        List<Category> list = new ArrayList<Category>();
        while (rs.next()) {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            Category product = new Category();
            product.setId(id);
            product.setName(name);
            list.add(product);
        }
        return list;
    }

}
