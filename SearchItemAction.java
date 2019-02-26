package com.internousdev.magenda.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.magenda.dao.ProductInfoDAO;
import com.internousdev.magenda.dto.ProductInfoDTO;
import com.internousdev.magenda.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class SearchItemAction extends ActionSupport implements SessionAware{

	private String categoryId;
	private String keywords;
	private String tempKeywords;
	private List<String> keywordsErrorMessageList = new ArrayList<String>();
	private List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
	private Map<String, Object> session;

	public String execute() throws SQLException {

		if(!session.containsKey("mCategoryDTOList")){
			return "timeout";
		}

		String result = ERROR;

		session.remove("keywordsErrorMessageList");
		InputChecker inputChecker = new InputChecker();

		if (StringUtils.isBlank(keywords)){
			tempKeywords = "";
		}else{
			tempKeywords = keywords.replaceAll("　", " ").replaceAll("\\s{2,}", " ");
		}
		if(!(tempKeywords.equals(""))){
			keywordsErrorMessageList = inputChecker.doCheck("検索ワード", keywords, 0, 50, true, true, true, true, false, true, false, true, true);
			Iterator<String> iterator = keywordsErrorMessageList.iterator();
			if(iterator.hasNext()) {
				session.put("keywordsErrorMessageList", keywordsErrorMessageList);
				return SUCCESS;
			}
		}

		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		switch (categoryId) {
			case "1":
				productInfoDTOList = productInfoDAO.getProductInfoListAll(tempKeywords.split(" "));
				result = SUCCESS;
				break;

			default:
				productInfoDTOList = productInfoDAO.getProductInfoListByKeywords(tempKeywords.split(" "), categoryId);
				result = SUCCESS;
				break;
		}
		Iterator<ProductInfoDTO> iterator = productInfoDTOList.iterator();
		if(!(iterator.hasNext())) {
			productInfoDTOList = null;
		}
		session.put("productInfoDTOList", productInfoDTOList);
		return result;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public List<ProductInfoDTO> getProductInfoDTOList() {
		return productInfoDTOList;
	}
	public void setProductInfoDTOList(List<ProductInfoDTO> productInfoDTOList) {
		this.productInfoDTOList = productInfoDTOList;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
