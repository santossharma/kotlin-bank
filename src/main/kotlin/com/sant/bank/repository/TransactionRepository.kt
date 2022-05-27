package com.sant.bank.repository

import com.sant.bank.entity.Transaction
import org.springframework.data.repository.CrudRepository
import java.util.*

/**
 * Created by santoshsharma on 25 May, 2022
 */

interface TransactionRepository: CrudRepository<Transaction, UUID>