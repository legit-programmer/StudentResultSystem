import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


class Student{
    Scanner sc = new Scanner(System.in);
    String name="hi", dept;
    static int count = 0;
    String roll;

    void getDetails(){
        System.out.println("Enter student name, department and roll no.: ");
        name = sc.nextLine();
        dept = sc.nextLine();
        roll = sc.nextLine();
    }
}

class Result extends Student{
    int m1, m2, m3;
    float per;
    char grade;

    
    void layGrade(){
        per = ((m1+m2+m3)*100)/300;
        
        if(per>75){
            grade = 'A';
        }
        else if(per>60 && per<75){
            grade = 'B';
        }
        else if(per>45 && per<60){
            grade = 'C';
        }
        else{
            grade = 'F';
        }
    }
}

class mainGUI{    
    
    Result st[] = new Result[10];
    // initializing using constructor  
    void initRun() {  
   
        JFrame f=new JFrame("Student Result System");//creating instance of JFrame  
       

        JLabel mainHead = new JLabel("Student Result System");
        mainHead.setBounds(f.getWidth()/2+250, 100, 500, 30); 
        mainHead.setFont(new Font("Arial", Font.PLAIN, 30)); //Creating an Arial Font Style with size 30 


        JButton chk=new JButton("Check Result");  
        JButton newr=new JButton("New");  
        chk.setBounds(800/2-250,620,150,30);  
        newr.setBounds(800/2,620,95,30);  

        DefaultListModel<String> listmod = new DefaultListModel<>(); 
        for(int i=0;i<10;i++){
            try{
                listmod.addElement(st[i].name + ","+st[i].roll);
            }
            catch(NullPointerException e){
                System.out.println();
            }
        }
        JList<String> list1 = new JList<>(listmod);  
        list1.setBounds(800/2-250,800/2-200, 500,400);  
        list1.setFont(new Font("Arial", Font.PLAIN, 25));
        
        newr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                f.setVisible(false);
                addSt();
            }
        });
        
        chk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                f.setVisible(false);
                checkResult(list1.getSelectedIndex());
            }
        });

        f.add(chk);        
        f.add(newr);
        f.add(mainHead);
        f.add(list1);
                  
        f.setSize(800,800);//400 width and 500 height  
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible 
      
    }    

    void addSt(){
        JFrame f = new JFrame("Add Details");
        f.setSize(800, 800);
        f.setVisible(true);
        f.setLayout(null);

        Font f11= new Font("Arial", Font.PLAIN, 15); 

        JLabel mainHead = new JLabel("Add Student Details");
        JLabel rollLabel = new JLabel("Roll no.: ");
        JLabel nameLabel = new JLabel("Name: ");
        JLabel Dept = new JLabel("Department: ");
        JLabel m1L = new JLabel("Marks 1");
        JLabel m2L = new JLabel("Marks 2");
        JLabel m3L = new JLabel("Marks 3");

        JTextField rolltf = new JTextField();
        JTextField depttf = new JTextField();
        JTextField nametf = new JTextField();
        JTextField m1 = new JTextField();
        JTextField m2 = new JTextField();
        JTextField m3 = new JTextField();
        JButton addd = new JButton("Add Data");


        mainHead.setBounds(f.getWidth()/2-175, 100, 500, 30);
        nameLabel.setBounds(200,250,50,50 );
        Dept.setBounds(200,300,100,50);
        rollLabel.setBounds(200, 350, 100, 50);
        nametf.setBounds(300,250,200,40);
        depttf.setBounds(300,300,200,40);
        rolltf.setBounds(300,350,50,40);
        m1L.setBounds(200, 450,75,50);
        m2L.setBounds(275, 450,75,50);
        m3L.setBounds(275+75, 450,75,50);
        m1.setBounds(200, 500, 50, 40);
        m2.setBounds(275, 500, 50,40);
        m3.setBounds(275+75, 500, 50, 40);
        addd.setBounds(275, 600, 100, 50);
      
        
        
        mainHead.setFont(new Font("Arial", Font.PLAIN, 30));
        nameLabel.setFont(f11);
        rollLabel.setFont(f11);
        Dept.setFont(f11);
        m1L.setFont(f11);
        m2L.setFont(f11);
        m3L.setFont(f11);

        f.add(m1L);
        f.add(m2L);
        f.add(m3L);
        f.add(rolltf);
        f.add(Dept);
        f.add(nameLabel);
        f.add(mainHead);
        f.add(nametf);
        f.add(depttf);
        f.add(rollLabel);
        f.add(m1);
        f.add(m2);
        f.add(m3);
        f.add(addd);

        addd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                getAllData(nametf, depttf, rolltf, m1, m2, m3);
                f.setVisible(false);
                initRun();
            }
        });

    }

    void getAllData(JTextField name, JTextField dept, JTextField roll, JTextField m1, JTextField m2, JTextField m3){
        st[Result.count] = new Result();
        st[Result.count].name = name.getText();
        st[Result.count].dept = dept.getText();
        st[Result.count].roll = roll.getText();
        st[Result.count].m1 = Integer.parseInt(m1.getText());
        st[Result.count].m2 = Integer.parseInt(m2.getText());
        st[Result.count].m3 = Integer.parseInt(m3.getText());
        Result.count++;
        
    }

    void checkResult(int index){
        

        JFrame f = new JFrame("Result");
        JButton back = new JButton("Back");
        Font f11= new Font("Arial", Font.PLAIN, 30); 
        f.setSize(800, 800);
        f.setVisible(true);
        f.setLayout(null);
        // JLabel resHead = new JLabel("Result");
        
        st[index].layGrade();
        // System.out.println(st[index].per);
        String data[][] = {{"Name", st[index].name},
                            {"Roll No.", st[index].roll},
                            {"Marks 1",String.valueOf(st[index].m1) },
                            {"Marks 2",String.valueOf(st[index].m2) },
                            {"Marks 3",String.valueOf(st[index].m3) },
                            {"Percentage",String.valueOf(st[index].per)},
                            {"Grade",String.valueOf(st[index].grade) }};
        String columns[] = {
            "Attribute","Value"
        };
        // resHead.setBounds(50, 50, 100, 100);
        JTable tbl = new JTable(data,columns);
        tbl.setBounds(70, 50, 600, 530);
        tbl.setFont(f11);
        tbl.setRowHeight(75);
        back.setBounds(70, 600, 70, 70);
        f.add(back);
        f.add(tbl);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                f.setVisible(false);
                initRun();
            }
        });
    }
}   

class main{
    public static void main(String[] args){
        // AWTExample1 f = new AWTExample1();    
        new mainGUI().initRun();

    }
}