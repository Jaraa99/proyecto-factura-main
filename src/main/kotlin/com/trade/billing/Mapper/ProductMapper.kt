package com.trade.billing.mapper

import com.trade.billing.dto.ProductDto
import com.trade.billing.model.Product

object ProductMapper {
    fun mapToDto(product: Product): ProductDto{
        return ProductDto(
            product.id,
            "${product.description} ${product.brand}"
        )
    }
}