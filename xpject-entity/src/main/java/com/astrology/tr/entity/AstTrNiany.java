package com.astrology.tr.entity;

import java.io.Serializable;

import com.astrology.BaseVo;

/**
 * @author 
 */
public class AstTrNiany extends BaseVo implements Serializable {
    private Integer id;

    private Integer userid;

    /**
     * 年份
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
     * 健康
     */
    private String cy4;

    /**
     * 情感(分男女)
     */
    private String cy5;

    /**
     * 健康（女）
     */
    private String cy6;

    /**
     * 木星经过星座
     */
    private String xy1;

    /**
     * 土星经过星座
     */
    private String xy2;

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

    public String getCy6() {
        return cy6;
    }

    public void setCy6(String cy6) {
        this.cy6 = cy6;
    }

    public String getXy1() {
        return xy1;
    }

    public void setXy1(String xy1) {
        this.xy1 = xy1;
    }

    public String getXy2() {
        return xy2;
    }

    public void setXy2(String xy2) {
        this.xy2 = xy2;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}