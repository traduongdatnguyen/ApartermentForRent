import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import java.awt.SystemColor;

public class QuanLy extends JFrame {

    private JPanel contentPane;
    private JTextField ID;
    private JTextField fullname;
    private JTextField gender;
    private JTextField age;
    private JTextField numberPhone;
    private JTable BANG_2;
    private JTextField Gioi_tinh;
    private JTextField maPhong;
    private JTextField tang;
    private JTextField mota;
    private JTextField giaphong;

//hien thi danh sach phong va tt khach hang
    public ArrayList<Customer>customerList() {
        ArrayList<Customer> customersList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlythuenha", "root", "");
            String sql = "SELECT `customer`.*, `room`.* FROM customer JOIN room ON customer.MaP = room.MaP";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Customer customer;
            while (rs.next()){
                customer = new Customer(rs.getInt("MaKH"),rs.getString("fullname"),rs.getString("gender"),rs.getString("phone_number"),rs.getInt("age"),rs.getInt("MaP"),rs.getString("tang"),rs.getString("mota"),rs.getString("tinhTrang"),rs.getDouble("gia"));
                customersList.add(customer);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return customersList;
    }
    public void show_customer(){
        ArrayList<Customer>list = customerList();
        System.out.println(list);
        DefaultTableModel model = (DefaultTableModel)BANG_2.getModel();
        model.setRowCount(1);
        Object[] row = new Object[10];
        for(int i = 0;i<list.size();i++){
            row[0]= list.get(i).getId();
            row[1]= list.get(i).getFullname();
            row[2]= list.get(i).getGender();
            row[3]= list.get(i).getPhoneNumber();
            row[4]= list.get(i).getAge();
            row[5]= list.get(i).getmaP();
            row[6]= list.get(i).getTang();
            row[7]= list.get(i).getMoTa();
            row[8]= list.get(i).getTinhTrang();
            row[9]= list.get(i).getGia();
            model.addRow(row);
        }
    }
//hien thi phong
    public ArrayList<Room>roomList() {
        ArrayList<Room>roomList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlythuenha", "root", "");
            String sql = "SELECT * FROM `room`";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Room room;
            while (rs.next()){
                room = new Room(rs.getInt("MaP"),rs.getString("tang"),rs.getString("mota"),rs.getString("tinhTrang"),rs.getDouble("gia"));
                roomList.add(room);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return roomList;
    }
    public void show_room(){
        ArrayList<Room>list = roomList();
        System.out.println(list);
        DefaultTableModel model = (DefaultTableModel)BANG_2.getModel();
        model.setRowCount(1);
        Object[] row = new Object[10];
        for(int i = 0;i<list.size();i++){
            row[5]= list.get(i).getMaP();
            row[6]= list.get(i).getTang();
            row[7]= list.get(i).getMoTa();
            row[8]= list.get(i).getTinhTrang();
            row[9]= list.get(i).getGia();
            model.addRow(row);
        }
    }
//timkiemkhach
    public ArrayList<Customer>searchList() {
        ArrayList<Customer>searchList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlythuenha", "root", "");
            String sql = "SELECT `customer`.*,`room`.* FROM `customer` JOIN `room`on `customer`.`MaP`=`room`.`MaP` WHERE `fullname` LIKE '%" + fullname.getText() +"%'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Customer ctm = new Customer();

            Customer search;
            while (rs.next()){
                search = new Customer(rs.getInt("MaKH"),rs.getString("fullname"),rs.getString("gender"),rs.getString("phone_number"),rs.getInt("age"),rs.getInt("MaP"),rs.getString("tang"),rs.getString("mota"),rs.getString("tinhTrang"),rs.getDouble("gia"));
                searchList.add(search);
                System.out.println(search);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return searchList;
    }
//hien thi danh sach tiem kiem
    public void show_search(){
        ArrayList<Customer>list = searchList();
        DefaultTableModel model = (DefaultTableModel)BANG_2.getModel();
        model.setRowCount(1);
        Object[] row = new Object[10];
        for(int i = 0;i<list.size();i++){
            row[0]= list.get(i).getId();
            row[1]= list.get(i).getFullname();
            row[2]= list.get(i).getGender();
            row[3]= list.get(i).getPhoneNumber();
            row[4]= list.get(i).getAge();
            row[5]= list.get(i).getmaP();
            row[6]= list.get(i).getTang();
            row[7]= list.get(i).getMoTa();
            row[8]= list.get(i).getTinhTrang();
            row[9]= list.get(i).getGia();
            model.addRow(row);
        }
    }
//main
    public static void main(String[] args) {
        try {
            QuanLy frame = new QuanLy();
            frame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public QuanLy() {


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1070, 582);
        contentPane = new JPanel();
        contentPane.setToolTipText("Kh\u00E1ch");
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel BANG = new JPanel();
        BANG.setForeground(new Color(255, 255, 255));
        BANG.setBackground(SystemColor.menu);
        BANG.setBounds(0, 0, 1056, 229);
        BANG.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PH\u00D2NG V\u00C0 TH\u00D4NG TIN KH\u00C1CH H\u00C0NG", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50, 205, 50)));
        BANG.setToolTipText("");
        contentPane.add(BANG);
        BANG.setLayout(null);

        
        
        JLabel lbFullname = new JLabel("T\u00EAn Kh\u00E1ch H\u00E0ng :");
        lbFullname.setFont(new Font("Dialog", Font.PLAIN, 17));
        lbFullname.setBackground(Color.BLACK);
        lbFullname.setBounds(10, 33, 159, 27);
        BANG.add(lbFullname);
        fullname = new JTextField();
        fullname.setFont(new Font("Dialog", Font.PLAIN, 17));
        fullname.setBounds(145, 33, 252, 27);
        BANG.add(fullname);


        JLabel GioiTinh = new JLabel("Gi\u1EDBi T\u00EDnh :");
        GioiTinh.setFont(new Font("Dialog", Font.PLAIN, 17));
        GioiTinh.setBackground(Color.BLACK);
        GioiTinh.setBounds(10, 80, 99, 27);
        BANG.add(GioiTinh);
        gender = new JTextField();
        gender.setFont(new Font("Dialog", Font.PLAIN, 17));
        gender.setColumns(10);
        gender.setBounds(119, 76, 136, 27);
        BANG.add(gender);

        
        JLabel Tuoi = new JLabel("Tu\u1ED5i :");
        Tuoi.setFont(new Font("Dialog", Font.PLAIN, 17));
        Tuoi.setBackground(Color.BLACK);
        Tuoi.setBounds(10, 118, 99, 27);
        BANG.add(Tuoi);
        age = new JTextField();
        age.setFont(new Font("Dialog", Font.PLAIN, 17));
        age.setColumns(10);
        age.setBounds(119, 114, 296, 27);
        BANG.add(age);

        
        
        JLabel lblNumberphone = new JLabel("Number Phone :");
        lblNumberphone.setFont(new Font("Dialog", Font.PLAIN, 17));
        lblNumberphone.setBackground(Color.BLACK);
        lblNumberphone.setBounds(10, 154, 141, 27);
        BANG.add(lblNumberphone);
        numberPhone = new JTextField();
        numberPhone.setFont(new Font("Dialog", Font.PLAIN, 17));
        numberPhone.setColumns(10);
        numberPhone.setBounds(145, 157, 280, 27);
        BANG.add(numberPhone);
        
        
        
        JLabel lblRoom = new JLabel("M\u00E3 Ph\u00F2ng :");
        lblRoom.setFont(new Font("Dialog", Font.PLAIN, 17));
        lblRoom.setBounds(528, 33, 99, 27);
        BANG.add(lblRoom); 
        maPhong = new JTextField();
        maPhong.setFont(new Font("Dialog", Font.PLAIN, 17));
        maPhong.setBounds(637, 36, 270, 27);
        BANG.add(maPhong);
        maPhong.setColumns(10);

        
        
        JLabel lblFloor = new JLabel("T\u1EA7ng :");
        lblFloor.setFont(new Font("Dialog", Font.PLAIN, 17));
        lblFloor.setBounds(528, 154, 99, 27);
        BANG.add(lblFloor);
        tang = new JTextField();
        tang.setFont(new Font("Dialog", Font.PLAIN, 17));
        tang.setColumns(10);
        tang.setBounds(638, 157, 182, 27);
        BANG.add(tang);

        
        
        JLabel moTa = new JLabel("M\u00F4 T\u1EA3 :");
        moTa.setFont(new Font("Dialog", Font.PLAIN, 17));
        moTa.setBounds(533, 76, 80, 27);
        BANG.add(moTa);
        mota = new JTextField();
        mota.setFont(new Font("Dialog", Font.PLAIN, 17));
        mota.setColumns(10);
        mota.setBounds(637, 79, 265, 27);
        BANG.add(mota);

        

        JLabel giaPhong = new JLabel("Gi\u00E1 Ph\u00F2ng :\r\n");
        giaPhong.setFont(new Font("Dialog", Font.PLAIN, 17));
        giaPhong.setBounds(528, 118, 108, 27);
        BANG.add(giaPhong);
        giaphong = new JTextField();
        giaphong.setFont(new Font("Dialog", Font.PLAIN, 17));
        giaphong.setColumns(10);
        giaphong.setBounds(637, 121, 265, 27);
        BANG.add(giaphong);

//nut tiem kiem
        JButton btnSearch = new JButton("T\u00CCM KI\u1EBEM");
        btnSearch.setForeground(Color.BLACK);
        btnSearch.setFont(new Font("", Font.PLAIN, 15));
        btnSearch.setBounds(0, 204, 109, 25);
        BANG.add(btnSearch);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                	show_search();
                }
                catch(Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        
        
//hien thi danh sach khac hang
        JButton btnDisplay = new JButton("DANH S\u00C1CH");
        btnDisplay.setForeground(Color.BLACK);
        btnDisplay.setFont(new Font("", Font.PLAIN, 15));
        btnDisplay.setBounds(725, 204, 190, 25);
        BANG.add(btnDisplay);
        btnDisplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    show_customer();
                }
                catch(Exception ex) {
                    System.out.println(ex);
                }
            }
        });

// nut save (them phong)
        JButton btnSave = new JButton("THU\u00CA PH\u00D2NG");
        btnSave.setForeground(Color.BLACK);
        btnSave.setFont(new Font("", Font.PLAIN, 15));
        btnSave.setBounds(250, 204, 146, 25);
        BANG.add(btnSave);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Connection connection = null;
                PreparedStatement statement = null;
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlythuenha", "root", "");
                    String sql = "insert into customer(`fullname`,`gender`,`phone_number`,`age`,`MaP`) values(?, ?, ?, ?, ?)";
                    statement = connection.prepareCall(sql);
                    Customer ctm = new Customer();
                    ctm.setFullname(fullname.getText());
                    ctm.setGender(gender.getText());
                    ctm.setPhoneNumber(numberPhone.getText());
                    ctm.setAge(Integer.parseInt(age.getText()));
                    ctm.setmaP(Integer.parseInt(maPhong.getText()));

                    statement.setString(1,ctm.getFullname());
                    statement.setString(2,ctm.getGender());
                   
                    statement.setString(3,ctm.getPhoneNumber());
                    statement.setInt(4,ctm.getAge());
                    statement.setDouble(5,ctm.getmaP());

                    statement.execute();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        });
        
        //nut danh sach phong
        JButton danhSach = new JButton("DANH S\u00C1CH PH\u00D2NG");
        danhSach.setForeground(Color.BLACK);
        danhSach.setFont(new Font("", Font.PLAIN, 15));
        danhSach.setBounds(538, 204, 190, 25);
        BANG.add(danhSach);
        danhSach.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    show_room();
                }
                catch(Exception ex) {
                    System.out.println(ex);
                }
            }
        });

 //nut chinh sua
        JButton btnUpdate = new JButton("CH\u1EC8NH S\u1EECA");
        btnUpdate.setForeground(Color.BLACK);
        btnUpdate.setFont(new Font("", Font.PLAIN, 15));
        btnUpdate.setBounds(106, 204, 148, 25);
        BANG.add(btnUpdate);
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                Connection connection = null;
                PreparedStatement statement = null;
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlythuenha", "root", "");
                    System.out.println(connection);
                    String sql = "UPDATE `customer` SET `fullname`= ?,`gender`=?,`age`=?,`phone_number`=? WHERE `MaP`=?";
                    statement = connection.prepareCall(sql);
                    Customer ctm = new Customer();
                    ctm.setFullname(fullname.getText());
                    ctm.setGender(gender.getText());
                    ctm.setAge(Integer.parseInt(age.getText()));
                    ctm.setPhoneNumber(numberPhone.getText());
                    ctm.setmaP(Integer.parseInt(maPhong.getText()));

                    statement.setString(1,ctm.getFullname());
                    statement.setString(2,ctm.getGender());
                    statement.setInt(3,ctm.getAge());
                    statement.setString(4,ctm.getPhoneNumber());
                    statement.setInt(5,ctm.getmaP());


                    statement.execute();
                } catch (SQLException ex) {
                    System.out.println(ex);

                }
            }
        });

//nut huy phong (xoa)
        JButton btnHuyphong = new JButton("H\u1EE6Y PH\u00D2NG");
        btnHuyphong.setForeground(Color.BLACK);
        btnHuyphong.setFont(new Font("", Font.PLAIN, 15));
        btnHuyphong.setBounds(392, 204, 149, 25);
        BANG.add(btnHuyphong);
        btnHuyphong.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Connection connection = null;
                PreparedStatement statement = null;
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlythuenha", "root", "");
                    System.out.println(connection);
                    String sql = "DELETE FROM `customer` WHERE `MaP` =? ";
                    statement = connection.prepareCall(sql);
                    Customer ctm = new Customer();
                    ctm.setmaP(Integer.parseInt(maPhong.getText()));

                    statement.setInt(1, ctm.getmaP());
                    statement.execute();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        });

       
//nút thoát
        JButton btnClose = new JButton("CLOSE");
        btnClose.setForeground(Color.BLACK);
        btnClose.setFont(new Font("", Font.PLAIN, 15));
        btnClose.setBounds(910, 204, 146, 25);
        BANG.add(btnClose);
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });


        BANG_2 = new JTable();
        BANG_2.setBackground(SystemColor.menu);
        BANG_2.setFont(new Font("", Font.PLAIN, 15));
        BANG_2.setBounds(0, 250, 1070, 415);
        BANG_2.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"ID", "T\u00EAn Kh\u00E1ch H\u00E0ng", "Gi\u1EDBi T\u00EDnh", "S\u0110T", "Tu\u1ED5i", "M\u00E3 Ph\u00F2ng", "T\u1EA7ng", "M\u00F4 T\u1EA3", "T\u00ECnh Tr\u1EA1ng", "GI\u00C1"},
        	},
        	new String[] {
        		"ID", "T\u00EAn Kh\u00E1ch H\u00E0ng", "Gi\u1EDBi T\u00EDnh", "S\u0110T", "Tu\u1ED5i", "M\u00E3 Ph\u00F2ng", "T\u1EA7ng", "M\u00F4 T\u1EA3", "T\u00ECnh Tr\u1EA1ng", "GI\u00C1"
        	}
        ));
        BANG_2.getColumnModel().getColumn(0).setPreferredWidth(33);
        BANG_2.getColumnModel().getColumn(0).setMaxWidth(20000000);
        BANG_2.getColumnModel().getColumn(1).setPreferredWidth(108);
        BANG_2.getColumnModel().getColumn(3).setPreferredWidth(80);
        BANG_2.getColumnModel().getColumn(4).setPreferredWidth(52);
        BANG_2.getColumnModel().getColumn(6).setPreferredWidth(57);
        contentPane.add(BANG_2);
    }
}
