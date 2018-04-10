package com.astrology.na.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class AstUserInfo implements Serializable {
    private Integer id;

    /**
     * 档案ID
     */
    private Integer userid;

    /**
     * 太阳星座
     */
    private String star;

    /**
     * 月亮星座
     */
    private String moon;
    
    /////业务
    private Integer uid;
    
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

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getMoon() {
        return moon;
    }

    public void setMoon(String moon) {
        this.moon = moon;
    }

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}
}