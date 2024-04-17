package com.blackpink.common.base;

public class BaseVo {

	/* private String seq; */
	
//	paging
	private int thisPage = 1;				// 현재 페이지
	private int rowNumToShow = 5;			// 화면에 보여줄 데이터 줄 갯수
	private int pageNumToShow = 5;			// 화면에 보여줄 페이징 번호 갯수
//
	private int rowNumToShowPd = 9;			// 화면에 보여줄 데이터 줄 갯수
	private int pageNumToShowPd = 5;		// 화면에 보여줄 페이징 번호 갯수
//
	private int totalRows;					// 전체 데이터 갯수
	private int totalPages;					// 전체 페이지 번호
	private int startPage;					// 시작 페이지 번호
	private int endPage;					// 마지막 페이지 번호
	
	private int startRnumForOracle = 1;		// 쿼리 시작 row
	private int endRnumForOracle;			// 쿼리 끝 row
	private Integer RNUM;
	
	private int startRnumForMysql = 0;		// 쿼리 시작 row
	
	
	public void setParamsPaging(int totalRows) {
		
//		setThisPage(3);

		setTotalRows(totalRows);

		if (getTotalRows() == 0) {
			setTotalPages(1);
		} else {
			setTotalPages(getTotalRows() / getRowNumToShow());
		}

		if (getTotalRows() % getRowNumToShow() > 0) {
			setTotalPages(getTotalPages() + 1);
		}

		if (getTotalPages() < getThisPage()) {
			setThisPage(getTotalPages());
		}
		
		setStartPage(((getThisPage() - 1) / getPageNumToShow()) * getPageNumToShow() + 1);

		setEndPage(getStartPage() + getPageNumToShow() - 1);

		if (getEndPage() > getTotalPages()) {
			setEndPage(getTotalPages());
		}
		
		setEndRnumForOracle((getRowNumToShow() * getThisPage()));
		setStartRnumForOracle((getEndRnumForOracle() - getRowNumToShow()) + 1);
		if (getStartRnumForOracle() < 1) setStartRnumForOracle(1);
		
		if (thisPage == 1) {
			setStartRnumForMysql(0);
		} else {
			setStartRnumForMysql((getRowNumToShow() * (getThisPage()-1)));
		}
		
	}
	
public void setPdParamsPaging(int totalRows) {
		
//		setThisPage(3);

		setTotalRows(totalRows);

		if (getTotalRows() == 0) {
			setTotalPages(1);
		} else {
			setTotalPages(getTotalRows() / getRowNumToShowPd());
		}

		if (getTotalRows() % getRowNumToShowPd() > 0) {
			setTotalPages(getTotalPages() + 1);
		}

		if (getTotalPages() < getThisPage()) {
			setThisPage(getTotalPages());
		}
		
		setStartPage(((getThisPage() - 1) / getPageNumToShowPd()) * getPageNumToShowPd() + 1);

		setEndPage(getStartPage() + getPageNumToShowPd() - 1);

		if (getEndPage() > getTotalPages()) {
			setEndPage(getTotalPages());
		}
		
		setEndRnumForOracle((getRowNumToShowPd() * getThisPage()));
		setStartRnumForOracle((getEndRnumForOracle() - getRowNumToShowPd()) + 1);
		if (getStartRnumForOracle() < 1) setStartRnumForOracle(1);
		
		if (thisPage == 1) {
			setStartRnumForMysql(0);
		} else {
			setStartRnumForMysql((getRowNumToShowPd() * (getThisPage()-1)));
		}
		
	}
	
public int getThisPage() {
		return thisPage;
	}

	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
	}

	public int getRowNumToShow() {
		return rowNumToShow;
	}

	public void setRowNumToShow(int rowNumToShow) {
		this.rowNumToShow = rowNumToShow;
	}

	public int getPageNumToShow() {
		return pageNumToShow;
	}

	public void setPageNumToShow(int pageNumToShow) {
		this.pageNumToShow = pageNumToShow;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartRnumForOracle() {
		return startRnumForOracle;
	}

	public void setStartRnumForOracle(int startRnumForOracle) {
		this.startRnumForOracle = startRnumForOracle;
	}

	public int getEndRnumForOracle() {
		return endRnumForOracle;
	}

	public void setEndRnumForOracle(int endRnumForOracle) {
		this.endRnumForOracle = endRnumForOracle;
	}

	public Integer getRNUM() {
		return RNUM;
	}

	public void setRNUM(Integer rNUM) {
		RNUM = rNUM;
	}

	public int getStartRnumForMysql() {
		return startRnumForMysql;
	}

	public void setStartRnumForMysql(int startRnumForMysql) {
		this.startRnumForMysql = startRnumForMysql;
	}

	public int getRowNumToShowPd() {
		return rowNumToShowPd;
	}

	public void setRowNumToShowPd(int rowNumToShowPd) {
		this.rowNumToShowPd = rowNumToShowPd;
	}

	public int getPageNumToShowPd() {
		return pageNumToShowPd;
	}

	public void setPageNumToShowPd(int pageNumToShowPd) {
		this.pageNumToShowPd = pageNumToShowPd;
	}

	//	paging end	
	
}
