package onlineShopV1.entities.audit;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@MappedSuperclass
@EntityListeners(AuditingSetting.class)
public class Auditing implements AuditingRegister {
    @Column(name = "create_at")
    private LocalDateTime createAt;


    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @Override
    public void setCreateAt(LocalDateTime localDateTime) {
        this.createAt = localDateTime;
    }

    @Override
    public void setUpdateAt(LocalDateTime localDateTime) {
        this.updateAt = localDateTime;
    }
}
