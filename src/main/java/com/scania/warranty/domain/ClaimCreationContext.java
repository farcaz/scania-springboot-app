/**
 * Domain entity or value object for the warranty claims model.
 * <p>
 * Generated from RPG: unit {@code HS1210}, node {@code n1779}.
 */

package com.scania.warranty.domain;

import java.math.BigDecimal;

public class ClaimCreationContext {
    
    private Integer failureNo; // @rpg-trace: n1783
    private boolean create; // @rpg-trace: n1833
    private boolean maintenance; // @rpg-trace: n1791
    private String groups; // @rpg-trace: n1796
    private String partNo; // @rpg-trace: n1797
    private BigDecimal partValue; // @rpg-trace: n1798
    private String text; // @rpg-trace: schema
    private Integer lineNo; // @rpg-trace: n1792
    private BigDecimal valueMat; // @rpg-trace: n1793
    private BigDecimal valueLab; // @rpg-trace: n1794
    private BigDecimal valueSpe; // @rpg-trace: n1795
    
    public ClaimCreationContext() {
        this.failureNo = 0; // @rpg-trace: n1783
        this.create = false; // @rpg-trace: n1833
        this.maintenance = false; // @rpg-trace: n1791
        this.groups = ""; // @rpg-trace: n1796
        this.partNo = ""; // @rpg-trace: n1797
        this.partValue = BigDecimal.ZERO; // @rpg-trace: n1798
        this.text = ""; // @rpg-trace: schema
        this.lineNo = 0; // @rpg-trace: n1792
        this.valueMat = BigDecimal.ZERO; // @rpg-trace: n1793
        this.valueLab = BigDecimal.ZERO; // @rpg-trace: n1794
        this.valueSpe = BigDecimal.ZERO; // @rpg-trace: n1795
    }
    
    public Integer getFailureNo() {
        return failureNo;
    }
    
    public void setFailureNo(Integer failureNo) {
        this.failureNo = failureNo;
    }
    
    public boolean isCreate() {
        return create;
    }
    
    public void setCreate(boolean create) {
        this.create = create;
    }
    
    public boolean isMaintenance() {
        return maintenance;
    }
    
    public void setMaintenance(boolean maintenance) {
        this.maintenance = maintenance;
    }
    
    public String getGroups() {
        return groups;
    }
    
    public void setGroups(String groups) {
        this.groups = groups;
    }
    
    public String getPartNo() {
        return partNo;
    }
    
    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }
    
    public BigDecimal getPartValue() {
        return partValue;
    }
    
    public void setPartValue(BigDecimal partValue) {
        this.partValue = partValue;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public Integer getLineNo() {
        return lineNo;
    }
    
    public void setLineNo(Integer lineNo) {
        this.lineNo = lineNo;
    }
    
    public BigDecimal getValueMat() {
        return valueMat;
    }
    
    public void setValueMat(BigDecimal valueMat) {
        this.valueMat = valueMat;
    }
    
    public BigDecimal getValueLab() {
        return valueLab;
    }
    
    public void setValueLab(BigDecimal valueLab) {
        this.valueLab = valueLab;
    }
    
    public BigDecimal getValueSpe() {
        return valueSpe;
    }
    
    public void setValueSpe(BigDecimal valueSpe) {
        this.valueSpe = valueSpe;
    }
}