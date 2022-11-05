import java.sql.*;
import java.util.Scanner;

public class Recipe {
    public static void main(String[] args)
    {

        int choice;
        String name,des,pb,incr,cat;

        Scanner sc=new Scanner(System.in);
        while (true)
        {
            System.out.println("Select an option");
            System.out.println("1. Add recipe");
            System.out.println("2. view all recipes");
            System.out.println("3. search a recipe");
            System.out.println("4. update recipe");
            System.out.println("5. Delete recipe");
            System.out.println("6.Exit");

            choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter the recipe name");
                    name=sc.next();
                    System.out.println("Enter the description of recipe");
                    des=sc.next();
                    System.out.println("Enter the chef name");
                    pb=sc.next();
                    System.out.println("Enter the incrediants");
                    incr=sc.next();
                    System.out.println("Enter the category");
                    cat=sc.next();
                    System.out.println("Data added successfully");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb","root","");
                        //Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb","root","");
                        String sql="INSERT INTO `recipes`(`title`, `description`, `preparedby`, `incrediants`, `category`) VALUES (?,?,?,?,?)";
                        PreparedStatement stmt=con.prepareStatement(sql);
                        stmt.setString(1,name);
                        stmt.setString(2,des);
                        stmt.setString(3,pb);
                        stmt.setString(4,incr);
                        stmt.setString(5,cat);
                        stmt.executeUpdate();
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);}
                    break;
                case 2:
                    System.out.println("view all recipes selected");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb","root","");
                        String sql="SELECT `title`, `description`, `preparedby`, `incrediants`, `category` FROM `recipes`";
                        Statement stmt=con.createStatement();
                        ResultSet rs=stmt.executeQuery(sql);
                        while (rs.next())
                        {
                            String getName=rs.getString("title");
                            String getDes=rs.getString("description");
                            String getPb=rs.getString("preparedby");
                            String getIncr=rs.getString("incrediants");
                            String getCat=rs.getString("category");
                            System.out.println("Recipe Name     : "+getName);
                            System.out.println("Description     : "+getDes);
                            System.out.println("Chef Name       : "+getPb);
                            System.out.println("Incrediants     : "+getIncr);
                            System.out.println("Category        : "+getCat+"\n");


                    }
                    }catch (Exception e){
                        System.out.println(e);}

                    break;
                case 3:
                    System.out.println("Enter the recipe name for seaching ");
                    String na=sc.next();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb", "root", "");
                        String sql = "SELECT `title`, `description`, `preparedby`, `incrediants`, `category` FROM `recipes` WHERE `title`='"+na+"'";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            String getName = rs.getString("title");
                            String getDes = rs.getString("description");
                            String getPb = rs.getString("preparedby");
                            String getIncr = rs.getString("incrediants");
                            String getCat = rs.getString("category");
                            System.out.println("Recipe Name     : " + getName);
                            System.out.println("Description     : " + getDes);
                            System.out.println("Chef Name       : " + getPb);
                            System.out.println("Incrediants     : " + getIncr);
                            System.out.println("Category        : " + getCat + "\n");

                        }
                    }
                        catch (Exception e)
                    {
                        System.out.println(e);
                    }

                    break;
                case 4:
                    System.out.println("update recipe selected");
                    System.out.println("Enter the recipe name");
                     String nam=sc.next();
                    System.out.println("Enter the description of recipe to be updated");
                    des=sc.next();
                    System.out.println("Enter the chef name to be updated");
                    pb=sc.next();
                    System.out.println("Enter the incrediants to be updated");
                    incr=sc.next();
                    System.out.println("Enter the category to be updated");
                    cat=sc.next();

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb", "root", "");
                        String sql = "UPDATE `recipes` SET `description`='"+des+"',`preparedby`='"+pb+"',`incrediants`='"+incr+"',`category`='"+cat+"' WHERE `title`='"+nam+"'";
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("updated successfully");
                    }
                    catch (Exception e){
                        System.out.println(e);}

                    break;
                case 5:
                    System.out.println("Delete a recipe selected");
                    System.out.println("Enter the recipe name that you want to delete");
                    String nam1=sc.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb","root","");
                        String sql="DELETE FROM `recipes` WHERE `title`='"+nam1+"'";
                        Statement stmt=con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("deleted successfully");

                    }
                    catch (Exception e){
                        System.out.println(e);}


                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Enter correct choice");
            }

        }
    }
}
