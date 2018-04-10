package com.astrology.tr.entity;

import java.io.Serializable;

import com.astrology.BaseVo;

/**
 * @author 
 */
public class AstTrMoon extends BaseVo implements Serializable {
    private Integer id;

    /**
     * 0:对外盘1对内盘
     */
    private Integer type;

    /**
     * 新满月(新=0,满=1,新满=2)
     */
    private Integer moontype;

    /**
     * tr星曜（月）
     */
    private Integer r1;

    /**
     * 星曜
     */
    private Integer r2;

    /**
     * 相位
     */
    private String r3;

    /**
     * 宫位
     */
    private Integer r4;

    /**
     * 星座
     */
    private Integer r5;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMoontype() {
        return moontype;
    }

    public void setMoontype(Integer moontype) {
        this.moontype = moontype;
    }

    public Integer getR1() {
        return r1;
    }

    public void setR1(Integer r1) {
        this.r1 = r1;
    }

    public Integer getR2() {
        return r2;
    }

    public void setR2(Integer r2) {
        this.r2 = r2;
    }

    public String getR3() {
        return r3;
    }

    public void setR3(String r3) {
        this.r3 = r3;
    }

    public Integer getR4() {
        return r4;
    }

    public void setR4(Integer r4) {
        this.r4 = r4;
    }

    public Integer getR5() {
        return r5;
    }

    public void setR5(Integer r5) {
        this.r5 = r5;
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
        AstTrMoon other = (AstTrMoon) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getMoontype() == null ? other.getMoontype() == null : this.getMoontype().equals(other.getMoontype()))
            && (this.getR1() == null ? other.getR1() == null : this.getR1().equals(other.getR1()))
            && (this.getR2() == null ? other.getR2() == null : this.getR2().equals(other.getR2()))
            && (this.getR3() == null ? other.getR3() == null : this.getR3().equals(other.getR3()))
            && (this.getR4() == null ? other.getR4() == null : this.getR4().equals(other.getR4()))
            && (this.getR5() == null ? other.getR5() == null : this.getR5().equals(other.getR5()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getMoontype() == null) ? 0 : getMoontype().hashCode());
        result = prime * result + ((getR1() == null) ? 0 : getR1().hashCode());
        result = prime * result + ((getR2() == null) ? 0 : getR2().hashCode());
        result = prime * result + ((getR3() == null) ? 0 : getR3().hashCode());
        result = prime * result + ((getR4() == null) ? 0 : getR4().hashCode());
        result = prime * result + ((getR5() == null) ? 0 : getR5().hashCode());
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
        sb.append(", moontype=").append(moontype);
        sb.append(", r1=").append(r1);
        sb.append(", r2=").append(r2);
        sb.append(", r3=").append(r3);
        sb.append(", r4=").append(r4);
        sb.append(", r5=").append(r5);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}