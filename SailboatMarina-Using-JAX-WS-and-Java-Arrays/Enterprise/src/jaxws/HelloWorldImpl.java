package jaxws;

import javax.jws.WebService;

import com.sun.xml.internal.ws.util.StringUtils;  


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebService(endpointInterface="jaxws.HelloWorld")  
public class HelloWorldImpl implements HelloWorld{  
  
 private Connection conn;
private Statement stmt;
private ResultSet rs;
public String data[][]=new String[30][9];
private int count;
public HelloWorldImpl()
{
	data[0][0]="1";
	 data[0][1]="Catalina";
	 data[0][2]="1996";
	 data[0][3]="165";
	 data[0][4]="Paid";
	 data[0][5]="Outboard";
	 data[0][6]="A21";
	 data[0][7]="John";
	 data[0][8]="Smith";
	 
	 data[1][0]="2";
	 data[1][1]="Morgan";
	 data[1][2]="1996";
	 data[1][3]="165";
	 data[1][4]="Paid";
	 data[1][5]="Inboard";
	 data[1][6]="B21";
	 data[1][7]="John";
	 data[1][8]="Smith";
	 
	 data[2][0]="3";
	 data[2][1]="Hunter";
	 data[2][2]="1996";
	 data[2][3]="165";
	 data[2][4]="Paid";
	 data[2][5]="None";
	 data[2][6]="A22";
	 data[2][7]="Jacob";
	 data[2][8]="Smith";

	 data[3][0]="4";
	 data[3][1]="Catalina";
	 data[3][2]="1998";
	 data[3][3]="170";
	 data[3][4]="Unpaid";
	 data[3][5]="Outboard";
	 data[3][6]="B22";
	 data[3][7]="John";
	 data[3][8]="Smith";
	 count=4;
}
public String helloWorld(String name) { 
	 String Output="";
	 boolean insert=true;
	 
	 
	 boolean flag[]=new boolean[30];
	 System.out.println(name);
	 
	 String[] parts = name.split("[|]");
	 for(int i=0;i<parts.length;i++){
			 System.out.println(parts[i]);
			 if(parts[i].equals("Empty"))
				 insert=false;
	 }
	 if(insert==true){
		 for(int j=0;j<9;j++){
			 data[count][j]=parts[j];
		 }
		 count++;
		 System.out.println(count);
		 Output="success";
	 }
	 else
	 {
	 for(int i=0;i<count;i++){
		 flag[i]=true;	 
		 for(int j=0;j<9;j++){
			 if(!parts[j].equals("Empty"))
			 {
				 if(!parts[j].toLowerCase().equals(data[i][j].toLowerCase()))
				 {
					 flag[i]=false;
				 }
			 }
		 }		 
	}
	for(int i=0;i<count;i++){
		if(flag[i]==true)
		{
			 for(int j=0;j<9;j++){
				 Output+=data[i][j]+" ";
			 }
			 Output+="|";
			 System.out.println();
		}
	}
	 }		 
	 return Output;  
 }  
  
}  