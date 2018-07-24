package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class RepairRecord implements Serializable {
    private Long id;

    private String tradeNo;

    private String orderNo;

    private Long uid;

    private Long masterChildId;

    private String contact;

    private String contactMobile;

    private Integer problemTypeId;

    private String address;

    private String content;

    private String atta;

    private Integer remimd;

    private Date remimdTime;

    private Integer score;

    private String scoreContent;

    private Date scoreTime;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private Integer communityId;

    private Integer type;

    private Integer formType;

    private String outReason;

    private String labourFee;

    private String materialFee;

    private Integer serviceCategory;

    private Integer urgencyLevel;

    private Integer qualityType;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getMasterChildId() {
        return masterChildId;
    }

    public void setMasterChildId(Long masterChildId) {
        this.masterChildId = masterChildId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public Integer getProblemTypeId() {
        return problemTypeId;
    }

    public void setProblemTypeId(Integer problemTypeId) {
        this.problemTypeId = problemTypeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAtta() {
        return atta;
    }

    public void setAtta(String atta) {
        this.atta = atta;
    }

    public Integer getRemimd() {
        return remimd;
    }

    public void setRemimd(Integer remimd) {
        this.remimd = remimd;
    }

    public Date getRemimdTime() {
        return remimdTime;
    }

    public void setRemimdTime(Date remimdTime) {
        this.remimdTime = remimdTime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getScoreContent() {
        return scoreContent;
    }

    public void setScoreContent(String scoreContent) {
        this.scoreContent = scoreContent;
    }

    public Date getScoreTime() {
        return scoreTime;
    }

    public void setScoreTime(Date scoreTime) {
        this.scoreTime = scoreTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFormType() {
        return formType;
    }

    public void setFormType(Integer formType) {
        this.formType = formType;
    }

    public String getOutReason() {
        return outReason;
    }

    public void setOutReason(String outReason) {
        this.outReason = outReason;
    }

    public String getLabourFee() {
        return labourFee;
    }

    public void setLabourFee(String labourFee) {
        this.labourFee = labourFee;
    }

    public String getMaterialFee() {
        return materialFee;
    }

    public void setMaterialFee(String materialFee) {
        this.materialFee = materialFee;
    }

    public Integer getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(Integer serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public Integer getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(Integer urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public Integer getQualityType() {
        return qualityType;
    }

    public void setQualityType(Integer qualityType) {
        this.qualityType = qualityType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", uid=").append(uid);
        sb.append(", masterChildId=").append(masterChildId);
        sb.append(", contact=").append(contact);
        sb.append(", contactMobile=").append(contactMobile);
        sb.append(", problemTypeId=").append(problemTypeId);
        sb.append(", address=").append(address);
        sb.append(", content=").append(content);
        sb.append(", atta=").append(atta);
        sb.append(", remimd=").append(remimd);
        sb.append(", remimdTime=").append(remimdTime);
        sb.append(", score=").append(score);
        sb.append(", scoreContent=").append(scoreContent);
        sb.append(", scoreTime=").append(scoreTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", communityId=").append(communityId);
        sb.append(", type=").append(type);
        sb.append(", formType=").append(formType);
        sb.append(", outReason=").append(outReason);
        sb.append(", labourFee=").append(labourFee);
        sb.append(", materialFee=").append(materialFee);
        sb.append(", serviceCategory=").append(serviceCategory);
        sb.append(", urgencyLevel=").append(urgencyLevel);
        sb.append(", qualityType=").append(qualityType);
        sb.append("]");
        return sb.toString();
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
        RepairRecord other = (RepairRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTradeNo() == null ? other.getTradeNo() == null : this.getTradeNo().equals(other.getTradeNo()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getMasterChildId() == null ? other.getMasterChildId() == null : this.getMasterChildId().equals(other.getMasterChildId()))
            && (this.getContact() == null ? other.getContact() == null : this.getContact().equals(other.getContact()))
            && (this.getContactMobile() == null ? other.getContactMobile() == null : this.getContactMobile().equals(other.getContactMobile()))
            && (this.getProblemTypeId() == null ? other.getProblemTypeId() == null : this.getProblemTypeId().equals(other.getProblemTypeId()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getAtta() == null ? other.getAtta() == null : this.getAtta().equals(other.getAtta()))
            && (this.getRemimd() == null ? other.getRemimd() == null : this.getRemimd().equals(other.getRemimd()))
            && (this.getRemimdTime() == null ? other.getRemimdTime() == null : this.getRemimdTime().equals(other.getRemimdTime()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getScoreContent() == null ? other.getScoreContent() == null : this.getScoreContent().equals(other.getScoreContent()))
            && (this.getScoreTime() == null ? other.getScoreTime() == null : this.getScoreTime().equals(other.getScoreTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getFormType() == null ? other.getFormType() == null : this.getFormType().equals(other.getFormType()))
            && (this.getOutReason() == null ? other.getOutReason() == null : this.getOutReason().equals(other.getOutReason()))
            && (this.getLabourFee() == null ? other.getLabourFee() == null : this.getLabourFee().equals(other.getLabourFee()))
            && (this.getMaterialFee() == null ? other.getMaterialFee() == null : this.getMaterialFee().equals(other.getMaterialFee()))
            && (this.getServiceCategory() == null ? other.getServiceCategory() == null : this.getServiceCategory().equals(other.getServiceCategory()))
            && (this.getUrgencyLevel() == null ? other.getUrgencyLevel() == null : this.getUrgencyLevel().equals(other.getUrgencyLevel()))
            && (this.getQualityType() == null ? other.getQualityType() == null : this.getQualityType().equals(other.getQualityType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTradeNo() == null) ? 0 : getTradeNo().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getMasterChildId() == null) ? 0 : getMasterChildId().hashCode());
        result = prime * result + ((getContact() == null) ? 0 : getContact().hashCode());
        result = prime * result + ((getContactMobile() == null) ? 0 : getContactMobile().hashCode());
        result = prime * result + ((getProblemTypeId() == null) ? 0 : getProblemTypeId().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getAtta() == null) ? 0 : getAtta().hashCode());
        result = prime * result + ((getRemimd() == null) ? 0 : getRemimd().hashCode());
        result = prime * result + ((getRemimdTime() == null) ? 0 : getRemimdTime().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getScoreContent() == null) ? 0 : getScoreContent().hashCode());
        result = prime * result + ((getScoreTime() == null) ? 0 : getScoreTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getFormType() == null) ? 0 : getFormType().hashCode());
        result = prime * result + ((getOutReason() == null) ? 0 : getOutReason().hashCode());
        result = prime * result + ((getLabourFee() == null) ? 0 : getLabourFee().hashCode());
        result = prime * result + ((getMaterialFee() == null) ? 0 : getMaterialFee().hashCode());
        result = prime * result + ((getServiceCategory() == null) ? 0 : getServiceCategory().hashCode());
        result = prime * result + ((getUrgencyLevel() == null) ? 0 : getUrgencyLevel().hashCode());
        result = prime * result + ((getQualityType() == null) ? 0 : getQualityType().hashCode());
        return result;
    }
}