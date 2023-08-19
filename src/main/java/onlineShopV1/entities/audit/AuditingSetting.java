package onlineShopV1.entities.audit;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class AuditingSetting {

    @PrePersist //@persist is meant, do this block method code when INSERT DATA
    @PostPersist //@persist is meant, do this block method code when INSERT DATA
    public void setDataCreateTime(AuditingRegister auditableEntity) {
        auditableEntity.setCreateAt(LocalDateTime.now());
        auditableEntity.setUpdateAt(LocalDateTime.now());
    }

    @PreUpdate //@update is meant, do this block method code when UPDATE DATA
    @PostUpdate //@update is meant, do this block method code when UPDATE DATA
    public void setDataUpdateTime(AuditingRegister auditableEntity) {
        auditableEntity.setUpdateAt(LocalDateTime.now());
    }
}
