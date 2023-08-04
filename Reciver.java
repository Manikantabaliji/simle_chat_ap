/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapplication;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author balij
 */
public class Reciver implements ActionListener{
    JTextField chatFeild;
    static JPanel chat;
    static Box vertical=Box.createVerticalBox();
    static DataOutputStream dout;
    static JFrame f;

    
    Reciver(){
        f.setLayout(null); 
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0,0,450,70);
        p1.setLayout(null);
        f.add(p1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2=i1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5,20,25,25);
        p1.add(back);
        back.addMouseListener(new MouseAdapter() {
            
        public void mouseClicked(MouseEvent ae){
            System.exit(0);
        }
            
        });
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
        Image i5=i4.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i6= new ImageIcon(i5);
        JLabel profile = new JLabel(i6);
        profile.setBounds(40,10,50,50);
        p1.add(profile);

        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8=i7.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i9= new ImageIcon(i8);
        JLabel video = new JLabel(i9);
        video.setBounds(300,20,30,30);
        p1.add(video);

        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i11=i10.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i12= new ImageIcon(i11);
        JLabel call = new JLabel(i12);
        call.setBounds(350,20,30,30);
        p1.add(call);


        ImageIcon i14=new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i15=i14.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i16= new ImageIcon(i15);
        JLabel more = new JLabel(i16);
        more.setBounds(410,25,10,25);
        p1.add(more);

        JLabel name=new JLabel("OHM");
        name.setForeground(Color.white);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        name.setBounds(100,20,350,30);
        p1.add(name);

        JLabel active=new JLabel("online");
        active.setForeground(Color.white);
        active.setBounds(110,40,80,30);
        p1.add(active);

        chat=new JPanel();
        chat.setBounds(0,71,450,580);
        chat.setLayout(null);
        f.add(chat);

        chatFeild=new JTextField();
        chatFeild.setBounds(0,651,350,50);
        chatFeild.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        f.add(chatFeild);

        JButton send=new JButton("Send");
        send.setBounds(351,651,100,50);
        send.setForeground(Color.white);
        send.setBackground(new Color(7,94,84));
        send.setFont(new Font("SAN_SERIF",Font.BOLD,16));
        send.addActionListener(this);
        f.add(send);




        f.setSize(450,700);
        f.setLocation(200,50);
        f.getContentPane().setBackground(Color.WHITE);
        f.setUndecorated(true);
        f.setVisible(true);
        
    
    }

    public void actionPerformed(ActionEvent ae){
        String out=chatFeild.getText();
        JPanel msg=formatLabel(out);
        chat.setLayout(new BorderLayout());


        JPanel right = new JPanel(new BorderLayout());
        right.add(msg,BorderLayout.LINE_END);
        vertical.add(right);
        vertical.add(Box.createVerticalStrut(15));
        chat.add(vertical,BorderLayout.PAGE_START);
        chatFeild.setText("");
        try {
            dout.writeUTF(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        f.repaint();
        f.validate();
        f.invalidate();



    }

    public static JPanel formatLabel(String out){

        JPanel panel= new JPanel();
        panel.setLayout((new BoxLayout(panel, BoxLayout.Y_AXIS)));

        JLabel output=new JLabel(out);
        output.setFont(new Font("Tahoma",Font.PLAIN,16));
        output.setBackground(Color.green);
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15,15,15,50));
        panel.add(output);
        Calendar cal= Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
        JLabel time=new JLabel();
        time.setText(sdf.format(cal.getTime()));
        panel.add(time);
        return panel;
    }
    
    
    
    public static void main(String[] args){
    
        new Reciver();

        try {
            Socket s=new Socket("127.0.0.1",6001);
            DataInputStream din=new DataInputStream(s.getInputStream());
            dout=new DataOutputStream(s.getOutputStream());
            while(true){

                chat.setLayout(new BorderLayout());
                String msg =din.readUTF();
                JPanel panel=formatLabel(msg);
                JPanel left=new JPanel(new BorderLayout());
                left.add(panel,BorderLayout.LINE_START);
                vertical.add(left);
                vertical.add(Box.createVerticalStrut(15));
                chat.add(vertical,BorderLayout.LINE_START);
                f.repaint();
                f.validate();
                f.invalidate();

            }

        } catch (Exception e) {
            e.printStackTrace();
              
        }
    }
    
}