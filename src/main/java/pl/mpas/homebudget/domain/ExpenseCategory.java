package pl.mpas.homebudget.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Expense_Category")
public class ExpenseCategory {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime creationDateTime = LocalDateTime.now();

    private String categoryName;

    private boolean deleted;

    public ExpenseCategory() {
    }

    public ExpenseCategory(LocalDateTime creationDateTime, String categoryName, boolean deleted) {
        this.creationDateTime = creationDateTime;
        this.categoryName = categoryName;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "ExpenseCategoryService{" +
                "id=" + id +
                ", creationDateTime=" + creationDateTime +
                ", categoryName='" + categoryName + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
