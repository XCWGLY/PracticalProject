import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DeptDao1 {
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

            

        return depts;
    }
}