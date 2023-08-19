package onlineShopV1.entities.audit;

import java.time.LocalDateTime;

public interface AuditingRegister {
    public abstract void setCreateAt(LocalDateTime localDateTime);
    public abstract void setUpdateAt(LocalDateTime localDateTime);
}
