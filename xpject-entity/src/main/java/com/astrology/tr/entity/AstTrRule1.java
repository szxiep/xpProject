package com.astrology.tr.entity;

import java.io.Serializable;

import com.astrology.BaseVo;

/**
 * @author 
 */
public class AstTrRule1 extends BaseVo implements Serializable {
    private Integer id;

    /**
     * 规则文案类型
     */
    private Integer type;

    /**
     * TR星曜
     */
    private Integer rule1;

    /**
     * (整宫)宫头
     */
    private Integer rule2;

    /**
     * (分宫)宫头
     */
    private Integer rule3;

    /**
     * 司掌宫位
     */
    private String rule4;

    /**
     * 发生的相位
     */
    private String rule5;

    /**
     * 本命星曜
     */
    private Integer rule6;

    /**
     * 守护宫位
     */
    private Integer rule7;

    /**
     * TR星所在宫位
     */
    private Integer rule8;

    /**
     * 等同于
     */
    private String filtercopyid;

    /**
     * 状态
     */
    private Integer status;

    private Integer ef;
    
    private static final long serialVersionUID = 1L;

    public Integer getEf() {
		return ef;
	}

	public void setEf(Integer ef) {
		this.ef = ef;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRule1() {
        return rule1;
    }

    public void setRule1(Integer rule1) {
        this.rule1 = rule1;
    }

    public Integer getRule2() {
        return rule2;
    }

    public void setRule2(Integer rule2) {
        this.rule2 = rule2;
    }

    public Integer getRule3() {
        return rule3;
    }

    public void setRule3(Integer rule3) {
        this.rule3 = rule3;
    }

    public String getRule4() {
        return rule4;
    }

    public void setRule4(String rule4) {
        this.rule4 = rule4;
    }

    public String getRule5() {
        return rule5;
    }

    public void setRule5(String rule5) {
        this.rule5 = rule5;
    }

    public Integer getRule6() {
        return rule6;
    }

    public void setRule6(Integer rule6) {
        this.rule6 = rule6;
    }

    public Integer getRule7() {
        return rule7;
    }

    public void setRule7(Integer rule7) {
        this.rule7 = rule7;
    }

    public Integer getRule8() {
        return rule8;
    }

    public void setRule8(Integer rule8) {
        this.rule8 = rule8;
    }

    public String getFiltercopyid() {
        return filtercopyid;
    }

    public void setFiltercopyid(String filtercopyid) {
        this.filtercopyid = filtercopyid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        AstTrRule1 other = (AstTrRule1) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getRule1() == null ? other.getRule1() == null : this.getRule1().equals(other.getRule1()))
            && (this.getRule2() == null ? other.getRule2() == null : this.getRule2().equals(other.getRule2()))
            && (this.getRule3() == null ? other.getRule3() == null : this.getRule3().equals(other.getRule3()))
            && (this.getRule4() == null ? other.getRule4() == null : this.getRule4().equals(other.getRule4()))
            && (this.getRule5() == null ? other.getRule5() == null : this.getRule5().equals(other.getRule5()))
            && (this.getRule6() == null ? other.getRule6() == null : this.getRule6().equals(other.getRule6()))
            && (this.getRule7() == null ? other.getRule7() == null : this.getRule7().equals(other.getRule7()))
            && (this.getRule8() == null ? other.getRule8() == null : this.getRule8().equals(other.getRule8()))
            && (this.getFiltercopyid() == null ? other.getFiltercopyid() == null : this.getFiltercopyid().equals(other.getFiltercopyid()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getRule1() == null) ? 0 : getRule1().hashCode());
        result = prime * result + ((getRule2() == null) ? 0 : getRule2().hashCode());
        result = prime * result + ((getRule3() == null) ? 0 : getRule3().hashCode());
        result = prime * result + ((getRule4() == null) ? 0 : getRule4().hashCode());
        result = prime * result + ((getRule5() == null) ? 0 : getRule5().hashCode());
        result = prime * result + ((getRule6() == null) ? 0 : getRule6().hashCode());
        result = prime * result + ((getRule7() == null) ? 0 : getRule7().hashCode());
        result = prime * result + ((getRule8() == null) ? 0 : getRule8().hashCode());
        result = prime * result + ((getFiltercopyid() == null) ? 0 : getFiltercopyid().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", rule1=").append(rule1);
        sb.append(", rule2=").append(rule2);
        sb.append(", rule3=").append(rule3);
        sb.append(", rule4=").append(rule4);
        sb.append(", rule5=").append(rule5);
        sb.append(", rule6=").append(rule6);
        sb.append(", rule7=").append(rule7);
        sb.append(", rule8=").append(rule8);
        sb.append(", filtercopyid=").append(filtercopyid);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}