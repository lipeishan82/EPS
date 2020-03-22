package view;
/*
 *  FileName: Main_user.java
 *  师生信息填写界面
 *  @author Lipeishan，ZhangQin
 *  @Date  2020.03.19
 */
import java.sql.Connection;

import javax.swing.JOptionPane;

import java.util.Calendar;

import java.util.Date;

import java.util.Timer;


import dao.UserDao;
import fuction.TimeTrigger;
import pojo.User;
import util.Dbutil;
import util.FloatUtil;
import util.IntUtil;
import util.StringUtil;

public class Main_user extends javax.swing.JFrame {
	// id
	private javax.swing.JTextField userIDTxt;
	// 姓名
	private javax.swing.JTextField userNameTxt;
	// 性别
	private javax.swing.JTextField userSexTxt;
	// 省份
	private javax.swing.JTextField userProTxt;
	// 城市
	private javax.swing.JTextField userCityTxt;
	// 温度
	private javax.swing.JTextField userTemperatureTxt;
	// 是否疑似
	private javax.swing.JTextField userSymptom;
	// 是否确诊
	private javax.swing.JTextField userCheck;

	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JButton jb_reset;
	private javax.swing.JButton jb_add;

	Dbutil dbUtil = new Dbutil();
	UserDao userDao = new UserDao();

	public Main_user() {
		initComponents();
		// this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		
	}

	/*
	 * 页面设置
	 */
	private void initComponents() {
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		userIDTxt = new javax.swing.JTextField();
		userNameTxt = new javax.swing.JTextField();
		userSexTxt = new javax.swing.JTextField();
		userProTxt = new javax.swing.JTextField();
		userCityTxt = new javax.swing.JTextField();
		userTemperatureTxt = new javax.swing.JTextField();
		userSymptom = new javax.swing.JTextField();
		userCheck = new javax.swing.JTextField();
		jb_add = new javax.swing.JButton();
		jb_reset = new javax.swing.JButton();

		setTitle("防疫信息添加");

		jLabel1.setText("学号/工号");

		jLabel2.setText("  姓名      ");

		jLabel3.setText("所在省份");

		jLabel4.setText("所在城市 ");

		jLabel5.setText("  性别      ");

		jLabel6.setText("当日体温 ");

		jLabel7.setText("是否疑似");

		jLabel8.setText("是否确诊");

		jb_add.setText("确认");
		/*
		 * 添加确认监听
		 */
		jb_add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_addActionPerformed(evt);
			}
		});

		jb_reset.setText("重置");
		jb_reset.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_resetActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(41, 41, 41)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(jLabel1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(userIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(60, 60, 60).addComponent(jLabel2)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
										userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
										javax.swing.GroupLayout.PREFERRED_SIZE))

						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(layout.createSequentialGroup().addComponent(jLabel3)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(userProTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(jb_add))
								.addGap(60, 60, 60)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addComponent(jLabel4)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(userCityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(jb_reset)))

						.addGroup(layout.createSequentialGroup().addComponent(jLabel5)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(userSexTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(60, 60, 60).addComponent(jLabel6)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(userTemperatureTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addComponent(jLabel7)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(userSymptom, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(60, 60, 60).addComponent(jLabel8)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(userCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(44, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(46, 46, 46)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(jLabel2)
								.addComponent(userIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(jLabel4)
								.addComponent(userProTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(userCityTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5).addComponent(jLabel6)
								.addComponent(userSexTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(userTemperatureTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel7).addComponent(jLabel8)
								.addComponent(userSymptom, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(userCheck, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(5, 5, 5)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jb_reset).addComponent(jb_add))
						.addGap(20, 20, 20)));

		pack();

	}

	/*
	 * 添加信息
	 */
	private void jb_addActionPerformed(java.awt.event.ActionEvent evt) {
		String userName = this.userNameTxt.getText();
		String userId = this.userIDTxt.getText();
		String userSex = this.userSexTxt.getText();
		String userTemperature = this.userTemperatureTxt.getText();
		String userPro = this.userProTxt.getText();
		String userCity = this.userCityTxt.getText();
		String userSympotom = this.userSymptom.getText();
		String userCheck = this.userCheck.getText();
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(this, "姓名不能为空!");
			return;
		}
		if (IntUtil.isEmpty(Integer.parseInt(userId))) {
			JOptionPane.showMessageDialog(this, "工号/学号不能为空!");
			return;
		}
		if (StringUtil.isEmpty(userSex)) {
			JOptionPane.showMessageDialog(this, "性别不能为空!");
			return;
		}
		if (FloatUtil.isEmpty(Float.parseFloat(userTemperature))) {
			JOptionPane.showMessageDialog(this, "当日体温不能为空!");
			return;
		}
		if (StringUtil.isEmpty(userPro)) {
			JOptionPane.showMessageDialog(this, "所在省份不能为空!");
			return;
		}
		if (StringUtil.isEmpty(userCity)) {
			JOptionPane.showMessageDialog(this, "所在城市不能为空!");
			return;
		}

		if (StringUtil.isEmpty(userSympotom)) {
			JOptionPane.showMessageDialog(this, "疑似情况不能为空!");
			return;
		}
		if (StringUtil.isEmpty(userCheck)) {
			JOptionPane.showMessageDialog(this, "确诊情况不能为空!");
			return;
		}
		java.util.Date curDate = new java.util.Date();
		java.sql.Date date = new java.sql.Date(curDate.getTime());

		User user = new User(Integer.parseInt(userId), userName, userSex, Float.parseFloat(userTemperature), userPro,
				userCity, userSympotom, userCheck, date);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = userDao.userAdd(con, user);
			if (n == 1) {
				JOptionPane.showMessageDialog(this, "添加成功!");
				this.resetValue();
			} else {
				JOptionPane.showMessageDialog(this, "添加失败!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "添加失败!");
		}

	}

	/*
	 * 重置
	 */
	private void jb_resetActionPerformed(java.awt.event.ActionEvent evt) {
		this.resetValue();
	}

	/*
	 * 重置清空
	 */
	private void resetValue() {
		this.userIDTxt.setText("");
		this.userNameTxt.setText("");
		this.userSexTxt.setText("");
		this.userTemperatureTxt.setText("");
		this.userProTxt.setText("");
		this.userCityTxt.setText("");
		this.userSymptom.setText("");
		this.userCheck.setText("");
	}
	private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;

	private static final long TEST_SEC = 15 * 1000;
	
	public void timeTig() {

		// 使用默认时区和语言环境获得一个日历

		Calendar calendar = Calendar.getInstance();

		// 设置时间

		calendar.set(Calendar.HOUR_OF_DAY, 9);// 小时

		calendar.set(Calendar.MINUTE, 55);// 分钟

		calendar.set(Calendar.SECOND, 0);// 秒

		// 第一次执行任务的时间

		Date time = calendar.getTime();

		// 如果第一次执行任务的时间早于当前时间，那么第一次执行任务的时间推迟一天

		if (time.before(new Date())) {

			time = addDay(time, 1);

		}

		//System.out.println("启动时间:" + time);

		// 启动计划

		Timer timer = new Timer();

		timer.schedule(new TimeTrigger(), time, PERIOD_DAY);

		//System.out.println("当前时间:" + new Date());

	}

 

	// 增加一天

	public Date addDay(Date date, int num) {
		JOptionPane.showMessageDialog(null,"错过打卡时间!");

		Calendar startDT = Calendar.getInstance();

		startDT.setTime(date);

		startDT.add(Calendar.DAY_OF_MONTH, num);

		return startDT.getTime();

	}

 

	// 增加一分钟

	public Date addMinute(Date date, int num) {

		System.out.println("增加一分钟");

		Calendar startDT = Calendar.getInstance();

		startDT.setTime(date);

		startDT.add(Calendar.MINUTE, num);

		return startDT.getTime();

	}

 
	/*
	public static void main(String[] args) {
		new Main_user().setVisible(true);
		new Main_user().timeTig();	
		}
	 
*/
}
