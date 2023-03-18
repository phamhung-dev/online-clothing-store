package com.main.online_clothing_store.models;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.main.online_clothing_store.models.composite_primary_keys.CartItemId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart_items")
public class CartItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CartItemId id;

    @Column(nullable = false, name = "quantity")
    @Min(value = 0, message = "The quantity must be positive")
    private Integer quantity;
    
    @Column(nullable = false, name = "created_at")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date created_at;

    @Column(nullable = false, name = "modified_at")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date modified_at;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("product_inventory_id")
    private ProductInventory product_inventory;
}
