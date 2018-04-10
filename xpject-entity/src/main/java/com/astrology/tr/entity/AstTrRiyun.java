package com.astrology.tr.entity;

import java.io.Serializable;

import com.astrology.BaseVo;

/**
 * @author 
 */
public class AstTrRiyun extends BaseVo implements Serializable {
    private Integer id;

    /**
     * 年月日(yyyyMMdd)
     */
    private Integer time;

    private Integer userid;

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
     * 休闲
     */
    private String cy4;

    /**
     * 健康
     */
    private String cy5;

    /**
     * 情感（男女）
     */
    private String cy6;

    /**
     * 太阳星座度数
     */
    private String xy1;

    /**
     * 月亮星座度数
     */
    private String xy2;

    /**
     * 财运(新满月)
     */
    private String yy1;

    /**
     * 情感(新满月)
     */
    private String yy2;

    /**
     * 事业(新满月)
     */
    private String yy3;

    /**
     * 休闲(新满月)
     */
    private String yy4;

    /**
     * 健康(新满月)
     */
    private String yy5;

    /**
     * 情感男女(新满月)
     */
    private String yy6;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 星曜等关系集合json
     */
    private String nexusdata;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public String getYy1() {
        return yy1;
    }

    public void setYy1(String yy1) {
        this.yy1 = yy1;
    }

    public String getYy2() {
        return yy2;
    }

    public void setYy2(String yy2) {
        this.yy2 = yy2;
    }

    public String getYy3() {
        return yy3;
    }

    public void setYy3(String yy3) {
        this.yy3 = yy3;
    }

    public String getYy4() {
        return yy4;
    }

    public void setYy4(String yy4) {
        this.yy4 = yy4;
    }

    public String getYy5() {
        return yy5;
    }

    public void setYy5(String yy5) {
        this.yy5 = yy5;
    }

    public String getYy6() {
        return yy6;
    }

    public void setYy6(String yy6) {
        this.yy6 = yy6;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNexusdata() {
        return nexusdata;
    }

    public void setNexusdata(String nexusdata) {
        this.nexusdata = nexusdata;
    }
}