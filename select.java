
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class select {
    public List<Dept> query(String name,String book){
        List<Dept> depts=new ArrayList<>();
        Connection connection=DBConnection.getConnection();// 获取连接
        Statement statement=null;
        ResultSet set=null;
        try {
            statement =connection.createStatement(); //通过连接获取 statement 对象
            String selectStr=" ";
            if (name!=null&&!name.equals("")){
                selectStr="select * from readbook where name like '%"+name+"%'";
            }else if (book!=null&&!book.equals("")) {
                selectStr = "select * from readbook where book like '%" + book + "'";
            }
            else {
                selectStr="select * from readbook";
            }

            set= statement.executeQuery(selectStr);

            while (set.next()){   //遍历 resultSet
                Dept dept=new Dept();
                dept.setId(set.getInt("id"));
                dept.setName(set.getString("name"));
                dept.setBook(set.getString("book"));
                depts.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("更新失败");
        }finally {
            if (set!=null){
                try {
                    set.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement!=null){
                try {
                    statement.close();  //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close(); //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return depts;
    }
}
