import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BankDao
{
	static Connection getConnection() throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","abc123");
		return con;
	}
	static int addCustomer(Bank b)throws ClassNotFoundException,SQLException
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("INSERT INTO bank(name,balance,DOB,gender,"
				+ "account,services,address,identity,addProof,ms)VALUES(?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1,b.getName());
		ps.setString(2,b.getOpAmt());
		ps.setString(3,b.getDob());
		ps.setString(4,b.getGender());
		ps.setString(5,b.getTypAcc());
		ps.setString(6,b.getSerReq());
		ps.setString(7,b.getAdd());
		ps.setString(8,b.getIdProof());
		ps.setString(9,b.getAddProof());
		ps.setString(10,b.getMs());
		int a=ps.executeUpdate();
		return a;
	}
	static int Withdraw(Bank b)throws ClassNotFoundException,SQLException
	{
		Connection con=getConnection();
		Statement st=con.createStatement();
		int c=st.executeUpdate("UPDATE bank SET balance='"+b.getOpAmt()+"' WHERE accNo='"+b.getAccNo()+"'");
		return c;
	}
	public static int delete(Bank b) throws ClassNotFoundException,SQLException
	{
		// TODO Auto-generated method stub
		Connection con=getConnection();
		Statement st=con.createStatement();
		int c=st.executeUpdate("DELETE from bank WHERE accNo = "+b.getAccNo()+"");
		return c;
	}
	static int UpdateCustomer(Bank b)throws ClassNotFoundException,SQLException
	{
		Connection con=getConnection();
		Statement st=con.createStatement();
		int c=st.executeUpdate("UPDATE bank SET name='"+b.getName()+"',balance='"+b.getOpAmt()+"',DOB='"+b.getDob()+"'"
				+ ",gender='"+b.getGender()+"',"+ "account='"+b.typAcc+"',services='"+b.getSerReq()+"',"
						+ "address='"+b.getAdd()+"',identity='"+b.getIdProof()+"',addProof='"+b.getAddProof()+"'"
								+ ",ms='"+b.getMs()+"' WHERE accNo = '"+b.getAccNo()+"'");
		return c;
	}
}
