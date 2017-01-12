package jaxws;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jaxws.HelloWorld;  
import jaxws.HelloWorldImplService;

  
public class JAXWSClient extends JFrame{  
	JButton myButton;
	static HelloWorld helloWorld;
	JLabel Label2[]=new JLabel[30];
	
	public JAXWSClient() {
		// TODO Auto-generated constructor stub
		
		super("Sailboat Management");
		setLayout(null);
		int x=100;
		int i;
		JLabel Label  = new JLabel("Hello! Welcome to the Sailboat management application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Label.setBounds(350, 0, 500, 50);	
		add(Label);
		JLabel []Label1=new JLabel[30];
		JTextField []Text1= new JTextField[30];
		
		for(i=0;i<9;i++){
			Label1[i]=new JLabel(" ");
			Text1[i]=new JTextField();
			Label1[i].setBounds(i*x+10,100,100,50);
			Text1[i].setBounds(i*x+10,150,100,50);
			add(Label1[i]);
			add(Text1[i]);
		}
		
		Label1[0].setText("No");
		Label1[1].setText("Type");
		Label1[2].setText("Year");
		Label1[3].setText("Length");
		Label1[4].setText("Paid?");
		Label1[5].setText("Motor");
		Label1[6].setText("Slip assign");
		Label1[7].setText("First");
		Label1[8].setText("Last");
		myButton= new JButton("Submit");
		myButton.setBounds(i*x+10,150,100,50);
		add(myButton);
		JLabel Label3  = new JLabel("No Type Year Length Paid? Motor SlipAssign Fname Lname");
		Label3.setBounds(0, 200, 500, 50);	
		add(Label3);
		for(int j=0;j<30;j++){
			Label2[j]=new JLabel("");
			Label2[j].setText("");
			Label2[j].setBounds(0, 240+j*50, 1400, 50);	
			add(Label2[j]);
		}
		myButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String Input="";
				for(int i=0;i<30;i++){
					Label2[i].setText("");
				}
				for(int i=0;i<9;i++){
					 if(Text1[i].getText().toString().trim().equals(""))
					 {
						 Input+="Empty"+"|";
					 }
					 else
					Input+=Text1[i].getText().toString().trim()+"|";		
				}
				String part[]=helloWorld.helloWorld(Input).split("[|]");
				for(int i=0;i<part.length;i++){
					Label2[i].setText(part[i]); 
				}
			}
		});
		
		
		pack();
		setVisible(true);
	}
    /** 
     * @author Akash 
     */  
    public static void main(String[] args) {  
        JAXWSClient jclient=new JAXWSClient();
        jclient.setSize(1400,900);
        HelloWorldImplService helloWorldService = new HelloWorldImplService();  
        helloWorld = helloWorldService.getHelloWorldImplPort();  
        
        //System.out.println(helloWorld.helloWorld("Akash"));  
    }  
}  
