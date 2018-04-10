package com.astrology.tr.entity;

import java.io.Serializable;
import java.util.Date;

import com.astrology.BaseVo;

/**
 * @author 
 */
public class AstNewfullmoon extends BaseVo implements Serializable {
    private Integer id;

    private Integer type;

    /**
     * 新月
     */
    private String newmoon;

    /**
     * 满月
     */
    private String fullmoon;

    /**
     * 新月所在星座
     */
    private String newmsg;

    /**
     * 满月所在星座
     */
    private String fullmsg;

    /**
     * 当前新月太阳星座
     */
    private String sunsign;

    /**
     * 多久进入下一个星座
     */
    private String nextxz;

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

    public String getNewmoon() {
        return newmoon;
    }

    public void setNewmoon(String newmoon) {
        this.newmoon = newmoon;
    }

    public String getFullmoon() {
        return fullmoon;
    }

    public void setFullmoon(String fullmoon) {
        this.fullmoon = fullmoon;
    }

    public String getNewmsg() {
        return newmsg;
    }

    public void setNewmsg(String newmsg) {
        this.newmsg = newmsg;
    }

    public String getFullmsg() {
        return fullmsg;
    }

    public void setFullmsg(String fullmsg) {
        this.fullmsg = fullmsg;
    }

    public String getSunsign() {
        return sunsign;
    }

    public void setSunsign(String sunsign) {
        this.sunsign = sunsign;
    }

    public String getNextxz() {
        return nextxz;
    }

    public void setNextxz(String nextxz) {
        this.nextxz = nextxz;
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
        AstNewfullmoon other = (AstNewfullmoon) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getNewmoon() == null ? other.getNewmoon() == null : this.getNewmoon().equals(other.getNewmoon()))
            && (this.getFullmoon() == null ? other.getFullmoon() == null : this.getFullmoon().equals(other.getFullmoon()))
            && (this.getNewmsg() == null ? other.getNewmsg() == null : this.getNewmsg().equals(other.getNewmsg()))
            && (this.getFullmsg() == null ? other.getFullmsg() == null : this.getFullmsg().equals(other.getFullmsg()))
            && (this.getSunsign() == null ? other.getSunsign() == null : this.getSunsign().equals(other.getSunsign()))
            && (this.getNextxz() == null ? other.getNextxz() == null : this.getNextxz().equals(other.getNextxz()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getNewmoon() == null) ? 0 : getNewmoon().hashCode());
        result = prime * result + ((getFullmoon() == null) ? 0 : getFullmoon().hashCode());
        result = prime * result + ((getNewmsg() == null) ? 0 : getNewmsg().hashCode());
        result = prime * result + ((getFullmsg() == null) ? 0 : getFullmsg().hashCode());
        result = prime * result + ((getSunsign() == null) ? 0 : getSunsign().hashCode());
        result = prime * result + ((getNextxz() == null) ? 0 : getNextxz().hashCode());
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
        sb.append(", newmoon=").append(newmoon);
        sb.append(", fullmoon=").append(fullmoon);
        sb.append(", newmsg=").append(newmsg);
        sb.append(", fullmsg=").append(fullmsg);
        sb.append(", sunsign=").append(sunsign);
        sb.append(", nextxz=").append(nextxz);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}