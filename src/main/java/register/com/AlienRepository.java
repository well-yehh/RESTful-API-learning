package register.com;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class AlienRepository {

    Connection con = null;
    public AlienRepository(){
        String user = "postgres";
        String pass = "March429April";
        String url = "jdbc:postgresql://localhost:5432/REST_Api_alien";
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url,user,pass);
        }catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Alien> getAliens(){
        List<Alien> aliens = new ArrayList<>();
        String sql = "SELECT* FROM alien";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Alien a = new Alien();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setPoint(rs.getInt(3));

                aliens.add(a);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return aliens;
    }

    public Alien getAlien(int id){
        String sql = "SELECT* FROM alien WHERE id = "+id;
        Alien a = new Alien();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){

                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setPoint(rs.getInt(3));


            }
        }catch(Exception e){
            e.printStackTrace();
        } return a;

    }


    public void create(Alien a1) {
        String sql = "insert into alien(id,name,point) values(?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,a1.getId());
            st.setString(2,a1.getName());
            st.setInt(3,a1.getPoint());
            int row_effected = st.executeUpdate();
            System.out.println("Row effected = "+row_effected);

            st.close();
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
