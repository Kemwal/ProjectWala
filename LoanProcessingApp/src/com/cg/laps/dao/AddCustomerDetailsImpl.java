package com.cg.laps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cg.laps.dto.CustomerDetails;

public class AddCustomerDetailsImpl implements AddCustomerDetails{
	Connection con;
	
	public AddCustomerDetailsImpl()
	{
		con=DBUtil.getConnect();
	}
	@Override
	public int addCustomerDetails(CustomerDetails customerDTO) {
		String sql="INSERT into users VALUES(?,?,?,?)";
		PreparedStatement pst=null;
		ResultSet result=null;
		boolean flag=false;
		int billId=0;
		try {
			pst=con.prepareStatement(sql);
			con.setAutoCommit(false);
			pst.setInt(1, customerDTO.getApplicationId());
			pst.setString(2, customerDTO.getApplicantName());
			pst.setDate(3, customerDTO.getDob());
			pst.setString(4, customerDTO.getMaritalStatus());
			pst.setLong(5, customerDTO.getPhoneNumber());
			pst.setLong(6, customerDTO.getMobileNumber());
			pst.setInt(7, customerDTO.getCountOfDepandants());
			pst.setString(8, customerDTO.getEmailId());
			result=pst.executeQuery();
			if(result!=null){
					flag=true;
			}
			con.commit();
	}

	
}
