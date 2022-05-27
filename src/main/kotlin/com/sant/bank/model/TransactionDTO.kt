package com.sant.bank.model

import com.sant.bank.entity.Transaction

/**
 * Created by santoshsharma on 25 May, 2022
 */

class TransactionDTO (
    val targetAccount: String,
    val value: Double,
    val description: String = ""
)

fun TransactionDTO.convertToEntityModel() = Transaction(
    accountIdentifier = this.targetAccount,
    amount = this.value,
    description = this.description
)

