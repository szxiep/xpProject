package com.astrology.tr.entity;

import java.io.Serializable;

import com.astrology.BaseVo;

/**
 * @author 
 */
public class AstTrMony extends BaseVo implements Serializable {
    private Integer id;

    private Integer userid;

    /**
     * 月份
     */
    private Integer time;

    /**
     * 财运
     */
    private String cy1;

    /**
     * 情感
     */
    private String cy2;

    /**
     * 事业
     */
    private String cy3;

    /**
     * 出行
     */
    private String cy4;

    /**
     * 健康
     */
    private String cy5;

    /**
     * 财运(图表)
     */
    private String ct1;

    /**
     * 情感(图表)
     */
    private String ct2;

    /**
     * 事业(图表)
     */
    private String ct3;

    /**
     * 出行(图表)
     */
    private String ct4;

    /**
     * 健康(图表)
     */
    private String ct5;
    
    //重要日期index
    private String xy1;
    /**
     * 状态
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public String getCy1() {
        return cy1;
    }

    public void setCy1(String cy1) {
        this.cy1 = cy1;
    }

    public String getCy2() {
        return cy2;
    }

    public void setCy2(String cy2) {
        this.cy2 = cy2;
    }

    public String getCy3() {
        return cy3;
    }

    public void setCy3(String cy3) {
        this.cy3 = cy3;
    }

    public String getCy4() {
        return cy4;
    }

    public void setCy4(String cy4) {
        this.cy4 = cy4;
    }

    public String getCy5() {
        return cy5;
    }

    public void setCy5(String cy5) {
        this.cy5 = cy5;
    }

    public String getCt1() {
		return ct1;
	}

	public void setCt1(String ct1) {
		this.ct1 = ct1;
	}

	public String getCt2() {
		return ct2;
	}

	public void setCt2(String ct2) {
		this.ct2 = ct2;
	}

	public String getCt3() {
		return ct3;
	}

	public void setCt3(String ct3) {
		this.ct3 = ct3;
	}

	public String getCt4() {
		return ct4;
	}

	public void setCt4(String ct4) {
		this.ct4 = ct4;
	}

	public String getCt5() {
		return ct5;
	}

	public void setCt5(String ct5) {
		this.ct5 = ct5;
	}

	public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	public String getXy1() {
		return xy1;
	}

	public void setXy1(String xy1) {
		this.xy1 = xy1;
	}
}