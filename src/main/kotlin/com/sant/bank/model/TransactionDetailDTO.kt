package com.sant.bank.model

import com.sant.bank.entity.Transaction
import java.util.*

/**
 * Created by santoshsharma on 25 May, 2022
 */

class TransactionDetailDTO (
    val targetAccount: String,
    val value: Double,
    val description: String,
    val transactionDate: Date,
    val id: String
)

fun Transaction.convertToTransactionDetailDTO() = TransactionDetailDTO(
    targetAccount = this.accountIdentifier,
    value= this.amount,
    description = this.description,
    transactionDate = this.date,
    id= this.id.toString()
)