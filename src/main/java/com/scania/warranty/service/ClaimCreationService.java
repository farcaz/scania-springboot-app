/**
 * Application service implementing warranty claim business logic.
 * <p>
 * Generated from RPG: unit {@code HS1210}, node {@code n1779}.
 */

package com.scania.warranty.service;

import com.scania.warranty.domain.*;
import com.scania.warranty.repository.ClaimPositionRepository;
import com.scania.warranty.repository.ClaimRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ClaimCreationService {
    
    private final ClaimPositionRepository claimPositionRepository;
    private final ClaimRepository claimRepository;
    
    public ClaimCreationService(ClaimPositionRepository claimPositionRepository, ClaimRepository claimRepository) {
        this.claimPositionRepository = claimPositionRepository;
        this.claimRepository = claimRepository;
    }
    
    public String generateClaimNumber(String companyCode, String invoiceNumber, String invoiceDate, String orderNumber, String area) {
        return "00000001";
    }
    
    @Transactional
    public void createClaim(String kuerzel, String claimNr, String pakz, String rechNr, String rechDatum, String auftragsNr, String bereich) {
        ClaimCreationContext context = new ClaimCreationContext(); // @rpg-trace: n1779
        context.setFailureNo(0); // @rpg-trace: n1783
        
        List<ClaimPosition> positions = claimPositionRepository.findByKuerzelAndClaimNr(kuerzel, claimNr); // @rpg-trace: n1784
        
        for (ClaimPosition position : positions) { // @rpg-trace: n1785
            if (!position.getFehlerNr().equals(String.format("%02d", context.getFailureNo()))) { // @rpg-trace: n1789
                context.setFailureNo(Integer.parseInt(position.getFehlerNr())); // @rpg-trace: n1790
                context.setMaintenance(false); // @rpg-trace: n1791
                context.setLineNo(0); // @rpg-trace: n1792
                context.setValueMat(BigDecimal.ZERO); // @rpg-trace: n1793
                context.setValueLab(BigDecimal.ZERO); // @rpg-trace: n1794
                context.setValueSpe(BigDecimal.ZERO); // @rpg-trace: n1795
                context.setGroups(""); // @rpg-trace: n1796
                context.setPartNo(""); // @rpg-trace: n1797
                context.setPartValue(BigDecimal.ZERO); // @rpg-trace: n1798
            }
            
            if (position.getFehlerNr().equals(String.format("%02d", context.getFailureNo()))) { // @rpg-trace: n1801
                context.setCreate(true); // @rpg-trace: n1802
                String fehlerNrFormatted = String.format("%02d", Integer.parseInt(position.getFehlerNr())); // @rpg-trace: n1803
                String folgeNrFormatted = String.format("%02d", Integer.parseInt(position.getFolgeNr())); // @rpg-trace: n1806
                
                if (position.getZeile() != null && position.getZeile() > 0) { // @rpg-trace: n1809
                    if (position.getWert() != null && position.getWert().compareTo(context.getPartValue()) != 0) { // @rpg-trace: n1815
                        context.setPartNo(position.getNr()); // @rpg-trace: n1816
                        context.setPartValue(position.getWert()); // @rpg-trace: n1817
                    }
                }
            }
        }
        
        if (context.isMaintenance() && !context.getGroups().isEmpty() && !context.getPartNo().isEmpty()) { // @rpg-trace: n1822
            Claim claim = claimRepository.findByKey(pakz, rechNr, rechDatum, auftragsNr, bereich).orElse(null); // @rpg-trace: n1824
            
            if (claim != null) { // @rpg-trace: n1825
                claim.setAnzFehler(claim.getAnzFehler() + 1); // @rpg-trace: n1828
                claimRepository.save(claim); // @rpg-trace: n1829
            } else { // @rpg-trace: n1831
                return; // @rpg-trace: n1836
            }
        }
        
        if (context.isCreate() && !context.getGroups().isEmpty() && !context.getPartNo().isEmpty()) { // @rpg-trace: n1823
            Claim claim = claimRepository.findByKey(pakz, rechNr, rechDatum, auftragsNr, bereich).orElse(null); // @rpg-trace: n1824
            
            if (claim != null) { // @rpg-trace: n1825
                claim.setAnzFehler(claim.getAnzFehler() + 1); // @rpg-trace: n1828
                claimRepository.save(claim); // @rpg-trace: n1829
            } else { // @rpg-trace: n1831
                return; // @rpg-trace: n1836
            }
        }
    }
}