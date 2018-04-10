package com.astrology.tr.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.astrology.BaseVo;

/**
 * @author 
 */
public class AstTrRulebranchcopy extends BaseVo implements Serializable {
    private Integer id;

    /**
     * 关联tr规则表
     */
    private Integer ruleid;

    /**
     * 文案类型id
     */
    private Integer typeid;

    /**
     * 标题
     */
    private String title;

    /**
     * 二级标题
     */
    private String titles;

    /**
     * 有利内容
     */
    private String content;

    /**
     * 不利内容
     */
    private String disadcontent;

    /**
     * 有利分值
     */
    private Integer score;

    /**
     * 不利分值
     */
    private Integer score1;

    /**
     * 有利系数
     */
    private BigDecimal ratio;

    /**
     * 不利系数
     */
    private BigDecimal ratio1;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 等同于(过滤)
     */
    private String filtercopyid;

    /**
     * 状态是否删除0存在
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRuleid() {
        return ruleid;
    }

    public void setRuleid(Integer ruleid) {
        this.ruleid = ruleid;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDisadcontent() {
        return disadcontent;
    }

    public void setDisadcontent(String disadcontent) {
        this.disadcontent = disadcontent;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScore1() {
        return score1;
    }

    public void setScore1(Integer score1) {
        this.score1 = score1;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    public BigDecimal getRatio1() {
        return ratio1;
    }

    public void setRatio1(BigDecimal ratio1) {
        this.ratio1 = ratio1;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
        AstTrRulebranchcopy other = (AstTrRulebranchcopy) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRuleid() == null ? other.getRuleid() == null : this.getRuleid().equals(other.getRuleid()))
            && (this.getTypeid() == null ? other.getTypeid() == null : this.getTypeid().equals(other.getTypeid()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTitles() == null ? other.getTitles() == null : this.getTitles().equals(other.getTitles()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getDisadcontent() == null ? other.getDisadcontent() == null : this.getDisadcontent().equals(other.getDisadcontent()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getScore1() == null ? other.getScore1() == null : this.getScore1().equals(other.getScore1()))
            && (this.getRatio() == null ? other.getRatio() == null : this.getRatio().equals(other.getRatio()))
            && (this.getRatio1() == null ? other.getRatio1() == null : this.getRatio1().equals(other.getRatio1()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getFiltercopyid() == null ? other.getFiltercopyid() == null : this.getFiltercopyid().equals(other.getFiltercopyid()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRuleid() == null) ? 0 : getRuleid().hashCode());
        result = prime * result + ((getTypeid() == null) ? 0 : getTypeid().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTitles() == null) ? 0 : getTitles().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getDisadcontent() == null) ? 0 : getDisadcontent().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getScore1() == null) ? 0 : getScore1().hashCode());
        result = prime * result + ((getRatio() == null) ? 0 : getRatio().hashCode());
        result = prime * result + ((getRatio1() == null) ? 0 : getRatio1().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
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
        sb.append(", ruleid=").append(ruleid);
        sb.append(", typeid=").append(typeid);
        sb.append(", title=").append(title);
        sb.append(", titles=").append(titles);
        sb.append(", content=").append(content);
        sb.append(", disadcontent=").append(disadcontent);
        sb.append(", score=").append(score);
        sb.append(", score1=").append(score1);
        sb.append(", ratio=").append(ratio);
        sb.append(", ratio1=").append(ratio1);
        sb.append(", sort=").append(sort);
        sb.append(", filtercopyid=").append(filtercopyid);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}