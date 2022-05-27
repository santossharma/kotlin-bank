package com.sant.bank.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created by santoshsharma on 25 May, 2022
 */

@Entity
class Transaction (
    val accountIdentifier: String,
    val amount: Double,
    val description: String = "",
) {

    @Id
    @GeneratedValue
    var id: UUID? = null
        private set
    val date: Date = Date()

}
