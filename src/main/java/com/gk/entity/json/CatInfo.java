package com.gk.entity.json;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by pc on 2017/1/13.
 */
@Entity
@Table(name = "cat_info", schema = "gk_json_manage", catalog = "gk_json_manage")
public class CatInfo {
    private Long id;
    private Long parentId;
    private String name;
    private Long createUserId;
    private Timestamp createTime;
    private boolean share;
    private boolean isDel;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "parentId", nullable = true)
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "createUserId", nullable = false)
    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    @Basic
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "share", nullable = false)
    public boolean isShare() {
        return share;
    }

    public void setShare(boolean share) {
        this.share = share;
    }

    @Basic
    @Column(name = "isDel", nullable = false)
    public boolean isDel() {
        return isDel;
    }

    public void setDel(boolean del) {
        isDel = del;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CatInfo catInfo = (CatInfo) o;

        if (id != catInfo.id) return false;
        if (createUserId != catInfo.createUserId) return false;
        if (share != catInfo.share) return false;
        if (isDel != catInfo.isDel) return false;
        if (parentId != null ? !parentId.equals(catInfo.parentId) : catInfo.parentId != null) return false;
        if (name != null ? !name.equals(catInfo.name) : catInfo.name != null) return false;
        if (createTime != null ? !createTime.equals(catInfo.createTime) : catInfo.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (createUserId ^ (createUserId >>> 32));
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (share ? 1 : 0);
        result = 31 * result + (isDel ? 1 : 0);
        return result;
    }
}
