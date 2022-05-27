package com.sant.bank.controller

import com.sant.bank.model.TransactionDTO
import com.sant.bank.model.TransactionDetailDTO
import com.sant.bank.model.convertToEntityModel
import com.sant.bank.model.convertToTransactionDetailDTO
import com.sant.bank.repository.TransactionRepository
import org.springframework.web.bind.annotation.*

/**
 * Created by santoshsharma on 25 May, 2022
 */

@RestController
@RequestMapping("/transfer")
class TransferController(val transactionRepository: TransactionRepository) {

    @PostMapping("/new")
    fun newTransfer(@RequestBody transactionDTO: TransactionDTO) {
        println("Saved.")
        transactionRepository.save(transactionDTO.convertToEntityModel())
    }

    @GetMapping("/all")
    fun getAllTransfers(): List<TransactionDetailDTO> {

        return transactionRepository.findAll().map { it.convertToTransactionDetailDTO() }
    }
}