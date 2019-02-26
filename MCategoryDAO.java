package com.internousdev.magenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.internousdev.magenda.dto.MCategoryDTO;
import com.internousdev.magenda.util.DBConnector;

public class MCategoryDAO {
	public List<MCategoryDTO> getMCategoryList() throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();
		List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();
		String sql = "select * from m_category";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				MCategoryDTO mCategoryDTO = new MCategoryDTO();
				mCategoryDTO.setId(resultSet.getInt("id"));
				mCategoryDTO.setCategoryId(resultSet.getInt("category_id"));
				mCategoryDTO.setCategoryName(resultSet.getString("category_name"));
				mCategoryDTO.setCategoryDescription(resultSet.getString("category_description"));
				mCategoryDTO.setRegistDate(resultSet.getDate("regist_date"));
				mCategoryDTO.setUpdateDate(resultSet.getDate("update_date"));
				mCategoryDTOList.add(mCategoryDTO);
			}
			Iterator<MCategoryDTO> iterator = mCategoryDTOList.iterator();
			if(!(iterator.hasNext())) {
				mCategoryDTOList = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			con.close();

		}
		return mCategoryDTOList;
	}

}
