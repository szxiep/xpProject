package com.cxc.entity.user;

import java.io.Serializable;
import java.util.Date;

import com.cxc.annotation.ReturnParam;

/**
 * 用户档案表
 * @author 
 */
public class UArchives implements Serializable {
	
	@ReturnParam
    private Integer id;

    /**
     * 用户id
     */
	@ReturnParam
    private Integer uid;

    /**
     * 姓名
     */
	@ReturnParam
    private String name;

    /**
     * 性别(0：男，1:女)
     */
	@ReturnParam
    private Integer sex;

    /**
     * 出生时间（阳历）(输入时间)
     */
	@ReturnParam
    private Date datetime;
	@ReturnParam
	private String datetimeString;

    /**
     * 省
     */
	@ReturnParam
    private String province;

    /**
     * 市
     */
	@ReturnParam
    private String city;

    /**
     * 县
     */
	@ReturnParam
    private String county;

    /**
     * 是否在夏令时时间，1：是，2不是
     */
	@ReturnParam
    private Integer saving;

    /**
     * 分组id
     */
	@ReturnParam
    private Integer gid;

    /**
     * 录入时间
     */
	@ReturnParam
    private Date inputdate;

    /**
     * 备注
     */
	@ReturnParam
    private String remarks;
    
    /**
     * 八字排盘id
     */
	@ReturnParam
    private Integer baziid;
	
	
	/***
	 * 占星排盘id
	 */
	@ReturnParam
	private Integer astrologyid;
	
	/***
	 * 删除类型：0：存在，1：假删除
	 */
	@ReturnParam
	private Integer bdelete;
	
	 @ReturnParam
	 private String lunar;//农历时间（输出时间）
	 @ReturnParam
	private String star;//太阳星座
	@ReturnParam
	private String moon;//月亮星座
	@ReturnParam
	private String zodiac;//12生肖
	@ReturnParam
	private String daymain;//日主(干支对应五行)
	
	
    public Integer getBdelete() {
		return bdelete;
	}

	public void setBdelete(Integer bdelete) {
		this.bdelete = bdelete;
	}

	private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Integer getSaving() {
        return saving;
    }

    public void setSaving(Integer saving) {
        this.saving = saving;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    public Integer getAstrologyid() {
		return astrologyid;
	}

	public void setAstrologyid(Integer astrologyid) {
		this.astrologyid = astrologyid;
	}

	public Integer getBaziid() {
		return baziid;
	}

	public void setBaziid(Integer baziid) {
		this.baziid = baziid;
	}
	
	

	public String getDatetimeString() {
		return datetimeString;
	}

	public void setDatetimeString(String datetimeString) {
		this.datetimeString = datetimeString;
	}
	
	

	public String getLunar() {
		return lunar;
	}

	public void setLunar(String lunar) {
		this.lunar = lunar;
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

	public String getZodiac() {
		return zodiac;
	}

	public void setZodiac(String zodiac) {
		this.zodiac = zodiac;
	}

	public String getDaymain() {
		return daymain;
	}

	public void setDaymain(String daymain) {
		this.daymain = daymain;
	}

	@Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UArchives other = (UArchives) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getDatetime() == null ? other.getDatetime() == null : this.getDatetime().equals(other.getDatetime()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getCounty() == null ? other.getCounty() == null : this.getCounty().equals(other.getCounty()))
            && (this.getSaving() == null ? other.getSaving() == null : this.getSaving().equals(other.getSaving()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getInputdate() == null ? other.getInputdate() == null : this.getInputdate().equals(other.getInputdate()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getDatetime() == null) ? 0 : getDatetime().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getCounty() == null) ? 0 : getCounty().hashCode());
        result = prime * result + ((getSaving() == null) ? 0 : getSaving().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getInputdate() == null) ? 0 : getInputdate().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uid=").append(uid);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", datetime=").append(datetime);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", county=").append(county);
        sb.append(", saving=").append(saving);
        sb.append(", gid=").append(gid);
        sb.append(", inputdate=").append(inputdate);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}