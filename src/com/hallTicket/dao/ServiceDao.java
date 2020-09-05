package com.hallTicket.dao;

import java.awt.Robot;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hallTicket.factory.ConnectionFactory;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

public class ServiceDao implements TeacherService, SubjectServices, StudentService, LoginService, ResetPassword, HallticketOperation {
	Connection con=null;
	Statement st=null;
	
	public ServiceDao() {
		super();
		
		try {
			con=new ConnectionFactory().getCon();
			st=con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean addTeacher(Teacher t) {
		boolean added=false;
		try {
			int RowCount=st.executeUpdate("insert into Teacher values('"+t.getUname()+"','"+t.getFname()+"','"+t.getSname()+"','"+t.getPassword()+"','"+t.getMobile()+"','"+t.getEmail()+"','"+t.getBirthdate()+"','"+t.getMasterkey()+"')");
			if(RowCount>0) 
				added=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return added;
	}

	@Override
	public boolean searchTeacher(String uname) {
		boolean found=false;
		try {
			ResultSet rs=st.executeQuery("select * from Teacher where binary username='"+uname+"'");
			if(rs.next())
				found=true;
			else {
				rs=st.executeQuery("select * from student where binary username='"+uname+"'");
				if(rs.next()) 
					found=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return found;
	}

	@Override
	public boolean masterkey(String key) {
		boolean validKey=false;
		final String[] fiveDigitKeys= {"BicnY","bcekU","4MC7D","rb4uL","gc4F1","RCg3U","4UtBW","CtNMz","53Lqd","uoyDS"};
		final String[] tenDigitKeys= {"P6otYL099RWQ4IM","93M54r4VvRQgoGS","5TDp3lDhk89Pn7M","CHcz3gFJOR6mLB7","9xgynpVr6IX34aa","ljpGXbAxIgdNORw","M7tB89OfgtkYl10","SPYOxUtneWK694w","QxCxAeeNB7mkp89","yLBsuwDTzFoh27m"}; 
		if(key.length()<10) {
		for(String oneKey1:fiveDigitKeys)
			if(key.equals(oneKey1)) 
			validKey=true;
		}
		else for(String oneKey2:tenDigitKeys)
				if(key.equals(oneKey2))
					validKey=true;
		return validKey;
	}

	@Override
	public boolean addSubjectDetails(Subject s) {
		boolean added=false;
			try {
				String SemSub[]=s.getSemesterSubject();
				System.out.println(s.getYear());
				int RowCount=st.executeUpdate("insert into HallticketDetails values('"+s.getDepartment()+"','"+s.getYear()+"','"+SemSub[0]+"','"+SemSub[1]+"','"+SemSub[2]+"','"+SemSub[3]+"','"+SemSub[4]+"','"+SemSub[5]+"','"+SemSub[6]+"','"+SemSub[7]+"','"+SemSub[8]+"','"+SemSub[9]+"','"+SemSub[10]+"')");
				if(RowCount>0) 
					added=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return added;
	}

	@Override
	public boolean updateSubjectDetails(Subject s) {
		
		return false;
	}

	@Override
	public boolean SearchDepartment(String Department) {
		boolean found=false;
		try {
			ResultSet rs=st.executeQuery("select * from HallticketDetails where binary Department_Name='"+Department+"'");
			if(rs.next())
				found=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return found;
	}

	@Override
	public boolean DeleteDepartment(Subject s) {
		
		return false;
	}

	@Override
	public boolean addStudentDetails(Student s) {
		boolean added=false;
		String username,fname,sname,password,mobile,email,rollno,birthdate,Department_name,year,semester,seatno,status;
		username=s.getUname();fname=s.getFname();sname=s.getSname();password=s.getPassword();mobile=s.getMobile();
		email=s.getEmail();rollno=s.getRollno();birthdate=s.getBirthdate();Department_name=s.getDepartment(); year=s.getYear();
		semester=s.getSemester();seatno=s.getSeatno();status=s.getStatus();
		try {
			int RowCount=st.executeUpdate("insert into student values('"+username+"','"+fname+"','"+sname+"','"+password+"','"+mobile+"','"+email+"','"+rollno+"','"+birthdate+"','"+Department_name+"','"+year+"','"+semester+"','"+seatno+"','"+status+"')"); 
			if(RowCount>0) added=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return added;
	}

	@Override
	public boolean searchStudent(String uname) {
		boolean found=false;
		try {
			ResultSet rs=st.executeQuery("select * from student where binary username='"+uname+"'");
			if(rs.next()) 
				found=true;
			else {
				rs=st.executeQuery("select * from Teacher where binary username='"+uname+"'");
				if(rs.next())
					found=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return found;
	}

	@Override
	public boolean updateStudent(Student s) {
		boolean updated=false;
		
		return updated;
	}

	@Override
	public String LoginCheck(String username, String password) {
		String loginStatus="InvalidLogin";
		try {
			ResultSet Login=st.executeQuery("select * from Teacher where binary username='"+username+"' AND binary password='"+password+"'");
			if(Login.next()) 
				loginStatus="TeacherLogin";
			else {
				Login=st.executeQuery("select * from Student where binary username='"+username+"' AND binary password='"+password+"'");
				if(Login.next()) 
					loginStatus="StudentLogin";		
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return loginStatus;
	}

	@Override
	public String StudentName(String username) {
		String name="";
		try {
			ResultSet rs=st.executeQuery("select * from student where binary username='"+username+"'");
			if(rs.next()) {
				name=name+rs.getString("fname")+" "+rs.getString("surname");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}

	@Override
	public Student StudentDetails(String username) {
		Student student=null;
		try {
			ResultSet rs=st.executeQuery("select * from student where binary username='"+username+"'");
			if(rs.next()) {
				student=new Student();
				student.setUname(username);
				student.setFname(rs.getString(2));
				student.setSname(rs.getString(3));
				student.setPassword(rs.getString(4));
				student.setMobile(rs.getString(5));
				student.setEmail(rs.getString(6));
				student.setRollno(rs.getString(7));
				student.setBirthdate(rs.getString(8));
				student.setDepartment(rs.getString(9));
				student.setYear(rs.getString(10));
				student.setSemester(rs.getString(11));
				student.setSeatno(rs.getString(12));
				student.setStatus(rs.getString(13));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return student;
	}

	@Override
	public boolean UpdateStudentDetails(Student s) {
		boolean studentupdated=false;
		String username,fname,sname,password,mobile,email,rollno,birthdate,Department_name,year,semester,seatno,Status;
		username=s.getUname();fname=s.getFname();sname=s.getSname();password=s.getPassword();mobile=s.getMobile();
		email=s.getEmail();rollno=s.getRollno();birthdate=s.getBirthdate();Department_name=s.getDepartment(); year=s.getYear();
		semester=s.getSemester();seatno=s.getSeatno();Status=s.getStatus();
		try {
			int Rowcount=st.executeUpdate("update student set fname='"+fname+"',surname='"+sname+"',password='"+password+"',mobile='"+mobile+"',email='"+email+"',rollno='"+rollno+"',birthdate='"+birthdate+"',Department_name='"+Department_name+"',year='"+year+"',semester='"+semester+"',seatno='"+seatno+"',status='"+Status+"' where binary username='"+username+"'");
			if(Rowcount>0) 
				studentupdated=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return studentupdated;
	}

	@Override
	public String userType(String username) {
		String ClientType="NotFound";
		try {
			ResultSet Login=st.executeQuery("select * from Teacher where binary username='"+username+"' ");
			if(Login.next()) 
				ClientType="Teacher";
			else {
				Login=st.executeQuery("select * from Student where binary username='"+username+"'");
				if(Login.next()) 
					ClientType="Student";		
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return ClientType;
	}

	@Override
	public boolean ValidStudentDetails(String uname, String date, String key) {
		boolean validstudent=false;
		ResultSet valid;
		try {
			valid = st.executeQuery("select * from Student where binary username='"+uname+"' AND ( binary birthdate='"+date+"' AND binary rollno='"+key+"')");
			if(valid.next()) 
				validstudent=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return validstudent;
	}

	@Override
	public boolean updatePassword(String uname, String pass1, String usertype) {
			boolean passwordUpdated=false;
			try {
				int rowCount=st.executeUpdate("update "+usertype+" set password='"+pass1+"' where binary username='"+uname+"'");
				if(rowCount>0) 
					passwordUpdated=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return passwordUpdated;
	}

	@Override
	public boolean ValidTeacherDetails(String uname, String date) {
		boolean validTeacher=false;
		ResultSet valid;
		try {
			valid = st.executeQuery("select * from Teacher where binary username='"+uname+"' AND binary birthdate='"+date+"'");
			if(valid.next()) 
				validTeacher=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return validTeacher;
	}

	@Override
	public Teacher TeacherDetails(String uname) {
		Teacher tcr=null;
		try {
			ResultSet rs=st.executeQuery("select * from Teacher where username='"+uname+"'");
			if(rs.next()) {
				tcr=new Teacher();
				tcr.setUname(uname);
				tcr.setFname(rs.getString(2));
				tcr.setSname(rs.getString(3));
				tcr.setPassword(rs.getString(4));
				tcr.setMobile(rs.getString(5));
				tcr.setEmail(rs.getString(6));
				tcr.setBirthdate(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tcr;
	}

	@Override
	public boolean UpdateTeacherDetails(Teacher t) {
		boolean teacherUpdated=false;
		System.out.println(t.getUname());
		try {
			int rowCount=st.executeUpdate("update teacher set fname='"+t.getFname()+"',surname='"+t.getSname()+"', email='"+t.getEmail()+"',mobile='"+t.getMobile()+"',birthdate='"+t.getBirthdate()+"' where binary username='"+t.getUname()+"'");
			if(rowCount>0)
				teacherUpdated=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacherUpdated;
	}

	@Override
	public int ApproveStudent(String[] username) {
		int approvedStudent=0;
		
		try {
			int RowCount=0;
			for(String user:username) {
				char firstchar = 0;
				String initial="";
				int count=-1;
				String end="";
				boolean notdone=true;
			ResultSet rs=st.executeQuery("select department_name from student where username='"+user+"'");
			if(rs.next()) 
				firstchar=rs.getString(1).charAt(0);
			initial=firstchar+"-";
			rs=st.executeQuery("select count(*) as count from student where seatno not like '---' ");
			if(rs.next()) 
				count=rs.getInt("count")+1;
			while(count>0 && notdone) {
				end=String.format("%04d",count);
				rs=st.executeQuery("select * from student where seatno='"+initial+end+"'");
				if(rs.next()) {
					count--;
				}	
				else {
					RowCount=st.executeUpdate("update student set status='Approved',seatno='"+initial+end+"' where binary username='"+user+"'");
					if(RowCount>0) 
						approvedStudent+=1;
					notdone=false;
				}
				
			}	
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return approvedStudent;
	}

	@Override
	public int DisapprovedStudent(String[] username) {
		int disApprovedStudent=0;
		try {int RowCount=0;
			for(String user:username) {
			RowCount=st.executeUpdate("update student set status='Disapproved', seatno='---' where binary username='"+user+"'");
			if(RowCount>0) disApprovedStudent=1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return disApprovedStudent;
	}

	@Override
	public boolean searchHallticket(String department, String year, String semester) {
		boolean HallticketFound=false;
			try {
				ResultSet rs=st.executeQuery("select * from HallticketDetails where department_name='"+department+"' AND (Year='"+year+"' AND Semester='"+semester+"')");
				if(rs.next()) HallticketFound=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return HallticketFound;
	}

	@Override
	public boolean addhallticket(String department, String year, String semester, String[] subject, String[] theory,
			String[] practical, String[] oral) {
			boolean added=false;
			
			int RowCount=0;
			int count=subject.length;
			int total=subject.length;
			
			try {
				if(!searchHallticket(department, year, semester)) {
				while(count>0) {
				count--;
				RowCount+=st.executeUpdate("insert into hallticketdetails values('"+department+"','"+year+"','"+semester+"','"+subject[count]+"','"+theory[count]+"','"+practical[count]+"','"+oral[count]+"')");
				
				}
				if(RowCount==total) added=true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return added;
	}

	@Override
	public boolean updatehallticket(String department, String year, String semester, String[] subject, String[] theory,
			String[] practical, String[] oral) {
		boolean added=false;
		int insertedrows=0;
		int count=subject.length;
		int deletedrows=0;
		
		try {
			con.setAutoCommit(false);
			deletedrows=st.executeUpdate("delete from hallticketdetails where department_name='"+department+"' AND (year='"+year+"' AND semester='"+semester+"')");
			if(!searchHallticket(department, year, semester)) {
				while(count>0) {
				count--;
				insertedrows+=st.executeUpdate("insert into hallticketdetails values('"+department+"','"+year+"','"+semester+"','"+subject[count]+"','"+theory[count]+"','"+practical[count]+"','"+oral[count]+"')");
				}
				if(insertedrows==deletedrows) { 
					con.commit();
					added=true;
				}
				else 
				con.rollback();
			}
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return added;
}

	@Override
	public boolean deleteHallticket(String department, String year, String semester) {
		boolean deleted=false;
			try {
				int RowCount=st.executeUpdate("delete from hallticketdetails where department_name='"+department+"'AND (year='"+year+"' AND semester='"+semester+"')");
				if(RowCount>0) {
					deleted=true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return deleted;
	}

	@Override
	public String HallticketAvailability(Student std) {
		String AvalabilityStatus="";
		try {
			boolean department = false,year=false,semester=false;
			ResultSet rs=st.executeQuery("select * from hallticketdetails where department_name='"+std.getDepartment()+"'");
			if(rs.next())
				department=true;
			rs=st.executeQuery("select * from hallticketdetails where department_name='"+std.getDepartment()+"' AND year='"+std.getYear()+"'");
			if(rs.next())
				year=true;
			rs=st.executeQuery("select * from hallticketdetails where department_name='"+std.getDepartment()+"' AND (year='"+std.getYear()+"' AND semester='"+std.getSemester()+"' )");
			if(rs.next())
				semester=true;
			if(!std.getStatus().equals("Approved"))
				AvalabilityStatus="NotApproved";
			else if(!department)
				AvalabilityStatus="NoDepartment";
			else if(!year)
				AvalabilityStatus="NoYear";
			else if(!semester)
				AvalabilityStatus="NoSemester";
			else 
				AvalabilityStatus="HallTicketAvailable";
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return AvalabilityStatus;
	}

}
