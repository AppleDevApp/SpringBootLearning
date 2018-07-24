package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ParkingSettingConfig implements Serializable {
    private Integer codeId;

    private Integer apiMode;

    private Integer openShare;

    private BigDecimal sharePrice;

    private Long shareFreeDuration;

    private Integer status;

    private BigDecimal qrcodePrice;

    private Long qrcodeFreeDuration;

    private BigDecimal qrcodeDayAmount;

    private static final long serialVersionUID = 1L;

    public Integer getCodeId() {
        return codeId;
    }

    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }

    public Integer getApiMode() {
        return apiMode;
    }

    public void setApiMode(Integer apiMode) {
        this.apiMode = apiMode;
    }

    public Integer getOpenShare() {
        return openShare;
    }

    public void setOpenShare(Integer openShare) {
        this.openShare = openShare;
    }

    public BigDecimal getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(BigDecimal sharePrice) {
        this.sharePrice = sharePrice;
    }

    public Long getShareFreeDuration() {
        return shareFreeDuration;
    }

    public void setShareFreeDuration(Long shareFreeDuration) {
        this.shareFreeDuration = shareFreeDuration;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getQrcodePrice() {
        return qrcodePrice;
    }

    public void setQrcodePrice(BigDecimal qrcodePrice) {
        this.qrcodePrice = qrcodePrice;
    }

    public Long getQrcodeFreeDuration() {
        return qrcodeFreeDuration;
    }

    public void setQrcodeFreeDuration(Long qrcodeFreeDuration) {
        this.qrcodeFreeDuration = qrcodeFreeDuration;
    }

    public BigDecimal getQrcodeDayAmount() {
        return qrcodeDayAmount;
    }

    public void setQrcodeDayAmount(BigDecimal qrcodeDayAmount) {
        this.qrcodeDayAmount = qrcodeDayAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", codeId=").append(codeId);
        sb.append(", apiMode=").append(apiMode);
        sb.append(", openShare=").append(openShare);
        sb.append(", sharePrice=").append(sharePrice);
        sb.append(", shareFreeDuration=").append(shareFreeDuration);
        sb.append(", status=").append(status);
        sb.append(", qrcodePrice=").append(qrcodePrice);
        sb.append(", qrcodeFreeDuration=").append(qrcodeFreeDuration);
        sb.append(", qrcodeDayAmount=").append(qrcodeDayAmount);
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
        ParkingSettingConfig other = (ParkingSettingConfig) that;
        return (this.getCodeId() == null ? other.getCodeId() == null : this.getCodeId().equals(other.getCodeId()))
            && (this.getApiMode() == null ? other.getApiMode() == null : this.getApiMode().equals(other.getApiMode()))
            && (this.getOpenShare() == null ? other.getOpenShare() == null : this.getOpenShare().equals(other.getOpenShare()))
            && (this.getSharePrice() == null ? other.getSharePrice() == null : this.getSharePrice().equals(other.getSharePrice()))
            && (this.getShareFreeDuration() == null ? other.getShareFreeDuration() == null : this.getShareFreeDuration().equals(other.getShareFreeDuration()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getQrcodePrice() == null ? other.getQrcodePrice() == null : this.getQrcodePrice().equals(other.getQrcodePrice()))
            && (this.getQrcodeFreeDuration() == null ? other.getQrcodeFreeDuration() == null : this.getQrcodeFreeDuration().equals(other.getQrcodeFreeDuration()))
            && (this.getQrcodeDayAmount() == null ? other.getQrcodeDayAmount() == null : this.getQrcodeDayAmount().equals(other.getQrcodeDayAmount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCodeId() == null) ? 0 : getCodeId().hashCode());
        result = prime * result + ((getApiMode() == null) ? 0 : getApiMode().hashCode());
        result = prime * result + ((getOpenShare() == null) ? 0 : getOpenShare().hashCode());
        result = prime * result + ((getSharePrice() == null) ? 0 : getSharePrice().hashCode());
        result = prime * result + ((getShareFreeDuration() == null) ? 0 : getShareFreeDuration().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getQrcodePrice() == null) ? 0 : getQrcodePrice().hashCode());
        result = prime * result + ((getQrcodeFreeDuration() == null) ? 0 : getQrcodeFreeDuration().hashCode());
        result = prime * result + ((getQrcodeDayAmount() == null) ? 0 : getQrcodeDayAmount().hashCode());
        return result;
    }
}